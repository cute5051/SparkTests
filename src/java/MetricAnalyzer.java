package java;

import org.apache.spark.scheduler.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MetricAnalyzer extends SparkListener {
    private final Map<String, Double> metrics = new ConcurrentHashMap<>();

    public MetricAnalyzer() {
        // Инициализация пустого словаря для хранения метрик
    }

    @Override
    public void onApplicationEnd(SparkListenerApplicationEnd appEnd) {
        // Анализ собранных метрик и генерация рекомендаций
        generateRecommendations();
    }

    private void generateRecommendations() {
        // Логика для анализа метрик и генерации рекомендаций
    }

    // Метод для обработки события начала стадии
    @Override
    public void onStageSubmitted(SparkListenerStageSubmitted stageSubmitted) {
        super.onStageSubmitted(stageSubmitted);
        // Здесь можно добавить логику для сбора метрик, связанных со стадией
    }

    // Метод для обработки события завершения стадии
    @Override
    public void onStageCompleted(SparkListenerStageCompleted stageCompleted) {
        super.onStageCompleted(stageCompleted);
        // Здесь можно добавить логику для сбора метрик, связанных с завершением стадии
//        for (Tuple2<String, Long> metric : stageCompleted.metrics()) {
//            metrics.put(metric._1, metric._2);
//        }
    }

    // Методы для обработки событий начала и конца задачи
    @Override
    public void onTaskStart(SparkListenerTaskStart taskStart) {
        super.onTaskStart(taskStart);
        // Анализ метрик для задачи
//        metrics.put(taskStart.stageId() + "_" + taskStart.taskInfo().index(), taskStart.);
        // Вывод плана запроса
        System.out.println("План запроса для задачи " + taskStart.stageId() + "-" + taskStart.taskInfo().index());
        System.out.println(taskStart.taskInfo());
    }

    @Override
    public void onTaskGettingResult(SparkListenerTaskGettingResult taskGettingResult) {
        // Здесь можно добавить логику для анализа метрик завершения задачи
    }

    private void analyzeTasks() {
        List<String> tasksWithHighExecutionTime = new ArrayList<>();
        for (String taskId : metrics.keySet()) {
            if (metrics.get(taskId) > 1000) {
                tasksWithHighExecutionTime.add(taskId);
            }
        }

        if (!tasksWithHighExecutionTime.isEmpty()) {
            System.out.println("Рекомендация: Оптимизируйте логику задач " + tasksWithHighExecutionTime);
        }
    }

    private void analyzeTaskMetrics(String taskId) {
        double rows = metrics.getOrDefault(taskId + "_rows", 0.0);
        double spillBytes = metrics.getOrDefault(taskId + "_spill_bytes", 0.0);
        double gcTimeMs = metrics.getOrDefault(taskId + "_gc_time_ms", 0.0);
        double executionTimeMs = metrics.get(taskId);

        if (rows > 1000000 || spillBytes > 1000000000 || gcTimeMs > 1000 || executionTimeMs > 10000) {
            System.out.println("Задача " + taskId + ": " + rows + " строк, " + spillBytes + " байт spill, " + gcTimeMs + " ms gc, " + executionTimeMs + " ms выполнение");
            System.out.println("Рекомендация: Оптимизируйте логику задачи " + taskId);
        }
    }
}