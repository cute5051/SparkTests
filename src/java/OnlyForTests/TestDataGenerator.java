package OnlyForTests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class TestDataGenerator {

    //  generate test data in List<ElementPojo>
    static List<ElementPojo> test_data() {
        List<ElementPojo> test = new ArrayList<>();

        GregorianCalendar gc = new GregorianCalendar();

//        cli_key, key, optn, balance
        for (int i = 0; i < 10000; i++) {
            int cli_key1 = (int) (Math.random() * 10000);
            int cli_key2 = (int) (Math.random() * 10000);
            String cli_key = cli_key1 + "|" + cli_key2;
            int key1 = (int) (Math.random() * 10000);
            int key2 = (int) (Math.random() * 10000);
            String key = key1 + "|" + key2;
            for (int j = 0; j < 1000; j++) {
                int yer = randBetween(2022, 2024);
                gc.set(gc.YEAR, yer);
                int dayyear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR) - 320);
                gc.set(gc.DAY_OF_YEAR, dayyear);
                LocalDate ld = LocalDate.of(gc.get(gc.YEAR), (gc.get(gc.MONTH) + 1), gc.get(gc.DAY_OF_MONTH));

                Double bal = Double.valueOf(randBetweend(1000, 100000));

                test.add(new ElementPojo(cli_key, key, ld, bal));
            }
        }

        return test;
    }
    static double randBetweend(int start, int end) {
        double res = start + (Math.random() * (end - start));
        return (double) ((int) (res * 100)) / 100;
    }
    static int randBetween(int start, int end) {
        return (int) (start + (Math.random() * (end - start)));
    }


    static  List<ElementPojo> static_test_data() {
        List<ElementPojo> test = new ArrayList<>();
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-08-11", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-02-11", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9476.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-29", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 792.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 4302.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 2133.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-25", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 818.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-11", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 6844.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-23", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9374.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9977.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-02-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7568.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-21", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 5697.00));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-02-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 2281.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7761.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-02-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 4045.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9888.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-14", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 2331.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-04", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 405.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1299.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 8809.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7764.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-02-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 6799.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7664.00));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-30", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 3858.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 8277.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-09", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9548.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9821.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 8641.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-18", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 4426.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1691.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1618.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9273.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 6892.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-28", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 3310.00));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-07", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 8378.00));
        return test;
    }

}
