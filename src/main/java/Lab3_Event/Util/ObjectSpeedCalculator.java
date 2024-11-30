package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedOperation;
import Lab3_Event.Model.MovingObjectOperation;

import javax.enterprise.event.Observes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectSpeedCalculator {

    // Метод для обработки события и расчёта скорости каждого объекта
    public void calculateSpeeds(@Observes @AddedOperation List<MovingObjectOperation> operations) {
        Map<String, Double> objectSpeeds = new HashMap<>();

        for (MovingObjectOperation operation : operations) {
            String objectName = operation.getMovingObject().getName();
            double delayInHours = operation.getDelayInHours();
            double distance = operation.getDistance(); // Используем расстояние, переданное в операции

            if (delayInHours > 0) {
                double speed = distance / delayInHours; // Скорость = расстояние / время
                objectSpeeds.put(objectName, speed);
            }
        }

        // Печать рассчитанных скоростей
        objectSpeeds.forEach((objectName, speed) ->
                System.out.println("Скорость объекта " + objectName + ": " + speed + " км/ч")
        );
    }
}
