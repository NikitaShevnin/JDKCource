package Less5.cw;

public class DeadlockExample {
    private static class ObjectA {}
    private static class ObjectB {}

    public static void main(String[] args) {
        // Создание объектов ObjectA и ObjectB
        ObjectA objectA = new ObjectA();
        ObjectB objectB = new ObjectB();

        // Первый поток
        Thread thread1 = new Thread(() -> {
            synchronized(objectA) {
                System.out.println("Thread 1 acquired lock on ObjectA");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(objectB) {
                    System.out.println("Thread 1 acquired lock on ObjectB");
                    // Критическая секция для ObjectA и ObjectB
                }
            }
        });

        // Второй поток
        Thread thread2 = new Thread(() -> {
            synchronized(objectB) {
                System.out.println("Thread 2 acquired lock on ObjectB");
                synchronized(objectA) {
                    System.out.println("Thread 2 acquired lock on ObjectA");
                    // Критическая секция для ObjectA и ObjectB
                }
            }
        });

        // Запуск потоков
        thread1.start();
        thread2.start();
    }
}
