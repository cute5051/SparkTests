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

        int cli_key1 = (int) (Math.random() * 10000);
        int cli_key2 = (int) (Math.random() * 10000);
        String cli_key = cli_key1 + "|" + cli_key2;
        int key1 = (int) (Math.random() * 10000);
        int key2 = (int) (Math.random() * 10000);
        String key = key1 + "|" + key2;

        GregorianCalendar gc = new GregorianCalendar();

//        cli_key, key, optn, balance
        for (int i = 0; i < 11; i++) {
            int yer = randBetween(2024,2024);
            gc.set(gc.YEAR, yer);
            int dayyear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR) - 320);
            gc.set(gc.DAY_OF_YEAR, dayyear);
            LocalDate ld = LocalDate.of(gc.get(gc.YEAR), (gc.get(gc.MONTH)+1), gc.get(gc.DAY_OF_MONTH));

            Integer bal = Integer.valueOf(randBetween(100, 10000));

            test.add(new ElementPojo(cli_key, key, ld, bal));
        }

        return test;
    }
    static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }


    static  List<ElementPojo> static_test_data() {
        List<ElementPojo> test = new ArrayList<>();
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-02-11", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9476));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-29", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 792));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 4302));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 2133));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-25", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 818));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-11", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 6844));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-23", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9374));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9977));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-02-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7568));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-01-21", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 5697));
        test.add(new ElementPojo("9595|436", "2753|5437", LocalDate.parse("2024-02-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 2281));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7761));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-02-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 4045));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9888));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-14", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 2331));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-04", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 405));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1299));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 8809));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7764));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-02-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 6799));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7664));
        test.add(new ElementPojo("8437|4163", "9778|7022", LocalDate.parse("2024-01-30", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 3858));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 8277));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-09", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9548));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-13", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9821));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 8641));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-18", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 4426));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-08", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1691));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1618));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-24", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 9273));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 6892));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-01-28", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 3310));
        test.add(new ElementPojo("7476|8816", "4952|7020", LocalDate.parse("2024-02-07", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 8378));
        return test;
    }

}
