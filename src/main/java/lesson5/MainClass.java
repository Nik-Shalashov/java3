package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        Semaphore smp = new Semaphore((CARS_COUNT) / 2);
        CountDownLatch cdlFinishRace = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlWinner = new CountDownLatch(1);
        CountDownLatch cdlStartRace = new CountDownLatch(CARS_COUNT);
        ExecutorService pool = Executors.newFixedThreadPool(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(smp), new Road(40));




        Car[] cars = new Car[CARS_COUNT];
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(20 + (int) (Math.random() * 10));
            final int k = i;

            pool.execute(() -> {

                Car.prepare(cars[k], cb, cdlStartRace);

                Car.startRace(cars[k], race, cdlFinishRace, cdlWinner);
            });


        }
        pool.shutdown();

        try {
            cdlStartRace.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            cdlWinner.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WINNER");

        try {
            cdlFinishRace.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

