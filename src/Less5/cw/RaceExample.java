package Less5.cw;

import java.util.concurrent.CountDownLatch;

/**
 * В рамках выполнения задачи необходимо:
 * 3 бегуна должны прийти к старту гонки
 * Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
 * Программа должна отсчитать “На старт”, “Внимание”, “Марш”
 * Программа должна завершиться когда все участники закончат гонку.
 */

public class RaceExample {
    private static final CountDownLatch startLatch = new CountDownLatch(3);
    private static final CountDownLatch finishLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        Thread runner1 = new Thread(() -> {
            try {
                System.out.println("Бегун 1 пришел к старту");
                startLatch.countDown();
                startLatch.await();
                System.out.println("На старт!");
                Thread.sleep(1000);
                System.out.println("Внимание!");
                Thread.sleep(1000);
                System.out.println("Марш!");
                Thread.sleep(2000);
                System.out.println("Бегун 1 финишировал");
                finishLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread runner2 = new Thread(() -> {
            try {
                System.out.println("Бегун 2 пришел к старту");
                startLatch.countDown();
                startLatch.await();
                System.out.println("На старт!");
                Thread.sleep(1000);
                System.out.println("Внимание!");
                Thread.sleep(1000);
                System.out.println("Марш!");
                Thread.sleep(2000);
                System.out.println("Бегун 2 финишировал");
                finishLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread runner3 = new Thread(() -> {
            try {
                System.out.println("Бегун 3 пришел к старту");
                startLatch.countDown();
                startLatch.await();
                System.out.println("На старт!");
                Thread.sleep(1000);
                System.out.println("Внимание!");
                Thread.sleep(1000);
                System.out.println("Марш!");
                Thread.sleep(2000);
                System.out.println("Бегун 3 финишировал");
                finishLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        runner1.start();
        runner2.start();
        runner3.start();

        finishLatch.await();
        System.out.println("Гонка завершена");
    }
}
