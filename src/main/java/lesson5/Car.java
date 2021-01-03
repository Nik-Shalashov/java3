package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }


    public Car(int speed) {
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }



    public static void prepare(Car car, CyclicBarrier cb, CountDownLatch cdlStartRace) {
        try {
            System.out.println(car.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(car.name + " готов");
            cb.await();
            cdlStartRace.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startRace(Car car, Race race, CountDownLatch cdlFinishRace, CountDownLatch cdlWinner) {
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(car);
        }
        cdlFinishRace.countDown();
        cdlWinner.countDown();
    }




}
