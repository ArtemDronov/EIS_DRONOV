package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedOperation;
import Lab3_Event.Model.MovingObjectOperation;

import javax.enterprise.event.Observes;
import java.util.List;

public class AverageSpeedCalculator {

    // Метод для обработки события и расчёта средней скорости всех объектов
    public void calculateAverageSpeed(@Observes @AddedOperation List<MovingObjectOperation> operations) {
        double totalDistance = 0.0;
        double totalTime = 0.0;

        for (MovingObjectOperation operation : operations) {
            double delayInHours = operation.getDelayInHours();
            double distance = operation.getDistance(); // Используем расстояние, переданное в операции

            totalDistance += distance;
            totalTime += delayInHours;
        }

        if (totalTime > 0) {
            double averageSpeed = totalDistance / totalTime; // Средняя скорость = общий путь / общее время
            System.out.println("Средняя скорость всех объектов: " + averageSpeed + " км/ч");
        } else {
            System.out.println("Средняя скорость всех объектов не рассчитана: общее время равно нулю.");
        }
    }
}
