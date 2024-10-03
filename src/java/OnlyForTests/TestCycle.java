package OnlyForTests;

import org.apache.spark.HashPartitioner;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;
import scala.Tuple3;
import scala.Tuple4;
import scala.Tuple5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static OnlyForTests.ElementPojo.convertRowInThis;
import static OnlyForTests.TestDataGenerator.static_test_data;
import static OnlyForTests.TestDataGenerator.test_data;

public class TestCycle {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .config("spark.master", "local")
                .appName("java.LogAnalyzer").getOrCreate();

        JavaPairRDD<String, Row> pairRDD = spark.createDataFrame(static_test_data(), ElementPojo.class).javaRDD()
                .mapToPair(x -> new Tuple2<String, Row>(x.getAs("cli_key"), x))
                .partitionBy(new HashPartitioner(5));


        pairRDD.mapPartitions(new FlatMapFunction<Iterator<Tuple2<String, Row>>, Tuple5>() {
                    @Override
                    public Iterator<Tuple5> call(Iterator<Tuple2<String, Row>> tuple2Iterator) throws Exception {
                        return calculate(tuple2Iterator);
                    }
                }).collect().forEach(System.out::println);

    }

    public static Iterator<Tuple5> calculate(Iterator<Tuple2<String, Row>> data) {
        long start = System.currentTimeMillis();
        List<ElementPojo> input = new ArrayList<>();
        List<Tuple5> result = new ArrayList<>();
        while (data.hasNext()) {
            input.add(convertRowInThis(data.next()._2));
        }

        Comparator<ElementPojo> comparator = Comparator.comparing(x -> x.getCli_key());
        comparator = comparator.thenComparing(Comparator.comparing(x -> x.getOptn())).reversed();
        input.sort(comparator);

        int ind = 0;
        int count = 0;
        int step = 0;
        int diff = 0;
        boolean next_cli = false;
        boolean next = false;

        Double[] test_bal30 = new Double[30];
        int mega_test_value = 0;
        int mega_test_value_temp = 0;
        for (ElementPojo elem : input) {
            step = 30;
            ind = count;
            count += 1;

            String cli = elem.getCli_key();
            LocalDate optn = elem.getOptn();
            double balance = elem.getBalance();

            if (mega_test_value < 30) {
//                mega_test_value = (int) Math.abs(ChronoUnit.DAYS.between(LocalDate.now().minusDays(1), optn));
                mega_test_value = (int) Math.abs(ChronoUnit.DAYS.between(LocalDate.parse("2024-02-17", DateTimeFormatter.ofPattern("yyyy-MM-dd")), optn)) + 1;
                mega_test_value = mega_test_value <= 30 ? mega_test_value : 30;
                for (int x = mega_test_value_temp; x < mega_test_value; x++) {
                    test_bal30[x] = balance;
//                    System.out.println(String.format("INC: %s, DATE_OF_BALANCE: %s, BALANCE: %s, mega_test_value: %s", x, LocalDate.parse("2024-02-17", DateTimeFormatter.ofPattern("yyyy-MM-dd")).minusDays(x), test_bal30[x], mega_test_value));
                }
                mega_test_value_temp = mega_test_value;
            }

            if (ind != 0) {
                if (!input.get(ind - 1).getCli_key().equals(cli)) {
                    test_bal30 = new Double[30];
                    mega_test_value = 0;
                    mega_test_value_temp = 0;
                    diff = 0;
                    next = false;
                } else {
                    diff = (int) Math.abs(ChronoUnit.DAYS.between(input.get(ind - 1).getOptn(), optn)) - 1;
                    step -= diff;
                    step = step < 0 ? 0 : step;
                }
            }

            if (next) continue;

            do {

                for (int i = ind; i < input.size(); i++) {

                    String temp_cli = input.get(i).getCli_key();
                    LocalDate temp_optn = input.get(i).getOptn();
                    double temp_balance = input.get(i).getBalance();

                    if (!cli.equals(temp_cli)) break;

                    if (ChronoUnit.DAYS.between(temp_optn, optn) >= step) {
//                        System.out.println(String.format("=============DAYS BETW:%s==========step:%s====ind:%s==i:%s==diff:%s=================", ChronoUnit.DAYS.between(temp_optn, optn), step, ind, i, diff));
//                        System.out.println(String.format("1optn: %s, 2optn: %s", optn.plusDays(30-step), optn.minusDays(step)));
//                        System.out.println(String.format("cli: %s, optn: %s, balance: %s", cli, optn, balance));
//                        System.out.println(String.format("tempcli: %s, tempoptn: %s, tempbalance: %s", temp_cli, temp_optn, temp_balance));

                        int percent = (int) ((balance / temp_balance) * 100);
                        if (percent < 80) {
                            next = true;
                            result.add(new Tuple5<>(cli, optn, balance, percent, optn.plusDays(30-step)));

                            System.out.println(String.format("=============DAYS BETW:%s==========step:%s====ind:%s==i:%s==diff:%s=================", ChronoUnit.DAYS.between(temp_optn, optn), step, ind, i, diff));
                            System.out.println(String.format("1optn: %s, 2optn: %s", optn.plusDays(30-step), optn.minusDays(step)));
                            System.out.println(String.format("cli: %s, optn: %s, balance: %s", cli, optn, balance));
                            System.out.println(String.format("tempcli: %s, tempoptn: %s, tempbalance: %s", temp_cli, temp_optn, temp_balance));
                            System.out.println(String.format("-----------------------cli: %s, perc: %s, unstable_date: %s---------------------------", cli, percent, optn.plusDays(30-step)));
                        }
                        break;
                    }

                }
                step++;
                diff--;
                if (next) break;
            } while (diff >= 0);

        }
//        System.out.println(String.format("====================WORK TIME: %s. Total rows: %s===================", System.currentTimeMillis() - start, ind));
        return result.iterator();
    }
}
