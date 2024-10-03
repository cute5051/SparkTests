package OnlyForTests;

import org.apache.spark.sql.Row;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class ElementPojo implements Serializable {

    private String cli_key;
    private String key;
    private LocalDate optn;
    private double balance;

    public ElementPojo(String cli_key, String key, LocalDate optn, Double balance) {
        this.cli_key = cli_key;
        this.key = key;
        this.optn = optn;
        this.balance = balance;
    }

    public String getCli_key() {
        return cli_key;
    }

    public void setCli_key(String cli_key) {
        this.cli_key = cli_key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LocalDate getOptn() {
        return optn;
    }

    public void setOptn(LocalDate optn) {
        this.optn = optn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static ElementPojo convertRowInThis(Row row) {
        String cli = row.getAs("cli_key");
        String key = row.getAs("key");
        Date optn = row.getAs("optn");
        Double balance = (Double) row.getAs("balance");
        return new ElementPojo(cli, key, optn.toLocalDate(), balance);
    }

//    @Override
//    public String toString() {
//        return "test.add(new ElementPojo(" +
//                "\"" + cli_key + '\"' +
//                ", \"" + key + '\"' +
//                ", LocalDate.parse(\"" + optn + "\", DateTimeFormatter.ofPattern(\"yyyy-MM-dd\"))" +
//                ", " + balance +
//                "));";
//    }


    @Override
    public String toString() {
        return "{" +
                "cli_key='" + cli_key + '\'' +
                ", key='" + key + '\'' +
                ", optn=" + optn +
                ", balance=" + balance +
                '}';
    }
}
