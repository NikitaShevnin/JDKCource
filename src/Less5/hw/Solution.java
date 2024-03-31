package Less5.hw;

/**
 * Изначально объявляется класс Solution, в котором создаются массивы философов и вилок.
 * Затем выполняется инициализация объектов-вилок в массиве forks. Далее создаются экземпляры
 * класса Philosopher и соответствующие им потоки. Каждый философ получает ссылки на левую и
 * правую вилку. Затем потоки философов запускаются.
 */
public class Solution {
    private static final int NUM_PHILOSOPHERS = 5;
    private static final int NUM_EATING_TIMES = 3;

    public static void main(String[] args) throws InterruptedException {
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        Object[] forks = new Object[NUM_PHILOSOPHERS];

        // Создание вилок
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Object();
        }

        // Создание философов и их запуск в отдельных потоках
        Thread[] threads = new Thread[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];

            philosophers[i] = new Philosopher(i + 1, leftFork, rightFork);
            threads[i] = new Thread(philosophers[i]);
            threads[i].start();
        }

        // Ожидание завершения всех потоков
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            threads[i].join();
        }

        System.out.println("Все философы поели.");
    }

    /**
     *    Внутренний класс Philosopher содержит:
     *
     *    - Поля:
     *    - id: уникальный идентификатор философа
     *    - leftFork: левая вилка
     *    - rightFork: правая вилка
     *    - eatingTimes: количество приемов пищи
     *    - Конструктор Philosopher(int id, Object leftFork, Object rightFork):
     *    инициализирует поля философа
     *
     *    - Методы:
     *    - run(): метод, который выполняется в потоке философа. Философ повторяет
     *    последовательность размышления и приема пищи до достижения трех приемов пищи.
     *    - think(): метод, представляющий размышления философа. Философ просто "размышляет"
     *    на случайное время.
     *    - eat(): метод, представляющий прием пищи философа. Философ пытается взять левую
     *    и правую вилку, и если получилось, начинает есть на случайное время.
     */
    private static class Philosopher implements Runnable {
        private final int id;
        private final Object leftFork;
        private final Object rightFork;
        private int eatingTimes;

        public Philosopher(int id, Object leftFork, Object rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
            this.eatingTimes = 0;
        }

        @Override
        public void run() {
            try {
                while (eatingTimes < NUM_EATING_TIMES) {
                    think();
                    eat();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        private void think() throws InterruptedException {
            System.out.println("Философ " + id + " сейчас погрузился в свои размышления");
            Thread.sleep((long) (Math.random() * 1000));
        }

        private void eat() throws InterruptedException {
            synchronized (leftFork) {
                System.out.println("Философ " + id + " взял левую вилку.");
                synchronized (rightFork) {
                    System.out.println("Философ " + id + " взял правую вилку.");
                    System.out.println("Философ " + id + " сейчас ест.");
                    eatingTimes++;
                    Thread.sleep((long) (Math.random() * 1000));
                }
                System.out.println("Философ " + id + " положил на место правую вилку");
            }
            System.out.println("Философ " + id + " положил на место левую вилку");
        }
    }
}
