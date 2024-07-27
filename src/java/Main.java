import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataTypes;

public class Main {
    static SparkSession spark;

    public static void setSparkSession() {
        spark = SparkSession.builder()
                .config("spark.master", "local")
                .appName("java.LogAnalyzer").getOrCreate();
    }

    public static SparkSession getSparkSession() {
        return spark;
    }

    public static void main(String[] args) throws InterruptedException {
        // Создание SparkSession
        setSparkSession();

        spark.sparkContext().addSparkListener(new LogCollector(getSparkSession()));

        // Преобразование списка в DataFrame
        Dataset<Row> df = spark.range(70_000_000).toDF("_id")
                .withColumn("_num",  functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .withColumn("_num1", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .withColumn("_num2", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .withColumn("_num3", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .withColumn("_num4", functions.rand().multiply(10000000).cast(DataTypes.IntegerType));
        System.out.println(df.count());

        Dataset<Row> df_2 = spark.range(10_000_000).toDF("id")
                .withColumn("num",  functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .withColumn("num1", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .withColumn("num2", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .withColumn("num3", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .withColumn("num4", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                .unionAll(spark.range(10_000_000).toDF("id")
                        .withColumn("num",  functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                        .withColumn("num1", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                        .withColumn("num2", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                        .withColumn("num3", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                        .withColumn("num4", functions.rand().multiply(10000000).cast(DataTypes.IntegerType)))
                .unionAll(spark.range(10_000_000).toDF("id")
                        .withColumn("num",  functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                        .withColumn("num1", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                        .withColumn("num2", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                        .withColumn("num3", functions.rand().multiply(10000000).cast(DataTypes.IntegerType))
                        .withColumn("num4", functions.rand().multiply(10000000).cast(DataTypes.IntegerType)));
        System.out.println(df_2.count());

        Dataset<Row> df_3 = df.join(df_2, df.col("_id").equalTo(df_2.col("id")))
                        .withColumn("diff_num", df.col("_num").minus(df_2.col("num")))
                        .withColumn("diff_num1", df.col("_num1").minus(df_2.col("num1")))
                        .withColumn("diff_num2", df.col("_num2").minus(df_2.col("num2")))
                        .withColumn("diff_num3", df.col("_num3").minus(df_2.col("num3")))
                        .withColumn("diff_num4", df.col("_num4").minus(df_2.col("num4")));

        df_3 = df_3
                .withColumn("window_test", functions.sum(df_3.col("diff_num")).over(Window.partitionBy(df_3.col("_id"))))
                .withColumn("window_test_1", functions.sum(df_3.col("diff_num1")).over(Window.partitionBy(df_3.col("_id"))))
                .withColumn("window_test_2", functions.sum(df_3.col("diff_num2")).over(Window.partitionBy(df_3.col("_id"))))
                .withColumn("window_test_3", functions.sum(df_3.col("diff_num3")).over(Window.partitionBy(df_3.col("_id"))))
                .withColumn("window_test_4", functions.sum(df_3.col("diff_num4")).over(Window.partitionBy(df_3.col("_id"))));

        df_3 = df_3.withColumn("rn", functions.row_number().over(Window.partitionBy(df_3.col("_id")).orderBy(df_3.col("_id"))));

        df_3.show(100, false);

        spark.stop();
    }
}