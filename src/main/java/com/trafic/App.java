package com.trafic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CrossroadController controller = new CrossroadController();

        VehicleTrafficLight vehicleLight1 = new VehicleTrafficLight(1);
        VehicleTrafficLight vehicleLight2 = new VehicleTrafficLight(2);
        PedestrianTrafficLight pedestrianLight1 = new PedestrianTrafficLight(3);

        controller.addTrafficLight(vehicleLight1);
        controller.addTrafficLight(vehicleLight2);
        controller.addTrafficLight(pedestrianLight1);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Показать состояния светофоров");
            System.out.println("2. Увеличить очередь");
            System.out.println("3. Уменьшить очередь");
            System.out.println("4, Запуск управления");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (TrafficLight light : controller.getTrafficLights()) {
                        System.out.println("ID: " + light.getId() +
                            ", State: " + light.getState() +
                            ", Queue: " + light.getQueueSize());
                    }
                    break;
                case 2:
                    System.out.print("Введите ID светофора: ");
                    int idIncrease = scanner.nextInt();
                    System.out.print("Введите размер увеличения: ");
                    int deltaIncrease = scanner.nextInt();
                    TrafficLight lightToIncrease = controller.getTrafficLightById(idIncrease);
                    if (lightToIncrease != null) {
                        lightToIncrease.updateQueueSize(deltaIncrease);
                        System.out.println("Очередь увеличена.");
                    } else {
                        System.out.println("Светофор с таким ID не найден.");
                    }
                    break;
                case 3:
                    System.out.print("Введите ID светофора: ");
                    int idDecrease = scanner.nextInt();
                    System.out.print("Введите размер уменьшения: ");
                    int deltaDecrease = scanner.nextInt();
                    TrafficLight lightToDecrease = controller.getTrafficLightById(idDecrease);
                    if (lightToDecrease != null) {
                        lightToDecrease.updateQueueSize(-deltaDecrease);
                        System.out.println("Очередь уменьшена.");
                    } else {
                        System.out.println("Светофор с таким ID не найден.");
                    }
                    break;
                case 4:
                    System.out.println("Запуск управления");
                    controller.controlTraffic();
                case 5:
                    System.out.println("Завершение работы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод.");
            }
        }
    }
}
