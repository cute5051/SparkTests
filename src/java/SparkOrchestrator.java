import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.launcher.SparkLauncher;
import org.apache.spark.sql.SparkSession;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SparkOrchestrator {
    private static final String APP_NAME = "MyApp"; // Имя приложения

    private ExecutorService executorService;

    public SparkOrchestrator() {
        this.executorService = Executors.newCachedThreadPool();
    }

    public void startApplications(String... appNames) {
        for (String appName : appNames) {
            executorService.submit(new AppLauncher(appName));
        }
    }

    private class AppLauncher implements Callable<Void> {
        private final String appName;

        public AppLauncher(String appName) {
            this.appName = appName;
        }

        @Override
        public Void call() throws Exception {
            // Запуск приложения
            SparkLauncher launcher = new SparkLauncher()
                    .setAppResource("sss-1.0-SNAPSHOT.jar")
                    .setMainClass("com.example.Main")
                    .setMaster("local[*]");

            Process process = launcher.launch();
            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);

            return null;
        }
    }

    public static void main(String[] args) {
        SparkOrchestrator orchestrator = new SparkOrchestrator();
        orchestrator.startApplications("test", "test23");
    }
}