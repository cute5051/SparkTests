package OnlyForTests;

import org.threeten.extra.Days;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import static OnlyForTests.TestDataGenerator.static_test_data;
import static OnlyForTests.TestDataGenerator.test_data;

public class TestCycle {

    public static void main(String[] args) {
        TestCycle tc = new TestCycle();
        tc.calculate(static_test_data());
    }

    public void calculate(List<ElementPojo> input) {
        Comparator<ElementPojo> comparator = Comparator.comparing(person -> person.getCli_key());
        comparator = comparator.thenComparing(Comparator.comparing(person -> person.getOptn())).reversed();
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
                    System.out.println(String.format("INC: %s, DATE_OF_BALANCE: %s, BALANCE: %s, mega_test_value: %s", x, LocalDate.parse("2024-02-17", DateTimeFormatter.ofPattern("yyyy-MM-dd")).minusDays(x), test_bal30[x], mega_test_value));
                }
                mega_test_value_temp = mega_test_value;
            }

            if (ind != 0) {
                if (!input.get(ind - 1).getCli_key().equals(cli)) {
                    test_bal30 = new Double[30];
                    mega_test_value = 0;
                    mega_test_value_temp = 0;
                    next = false;
                } else {
                    diff = (int) Math.abs(ChronoUnit.DAYS.between(input.get(ind - 1).getOptn(), optn)) - 2;
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
                        System.out.println(String.format("=============DAYS BETW:%s==========step:%s====ind:%s==i:%s==diff:%s=================", ChronoUnit.DAYS.between(temp_optn, optn), step, ind, i, diff));
                        System.out.println(String.format("1optn: %s, 2optn: %s", optn.plusDays(30-step), optn.minusDays(step)));
                        System.out.println(String.format("cli: %s, optn: %s, balance: %s", cli, optn, balance));
                        System.out.println(String.format("tempcli: %s, tempoptn: %s, tempbalance: %s", temp_cli, temp_optn, temp_balance));

                        int percent = (int) ((balance / temp_balance) * 100);
                        if (percent < 80) {
                            next = true;
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
    }
}
