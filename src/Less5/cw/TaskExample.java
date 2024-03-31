package Less5.cw;

/**
 * TODO: В рамках выполнения задачи необходимо:
 * Создайте два потока A и B.
 * Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
 * (true в состояние false и наоборот).
 * Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100
 * с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток A переключит
 * switcher в состояние false.
 * Условием завершения работы потоков является достижение отсчета нулевой отметки.
 */

public class TaskExample {
    private static volatile boolean switcher = true;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    switcher = !switcher;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                while (true) {
                    if (switcher) {
                        for (int i = 100; i >= 0; i--) {
                            System.out.println(i);
                            Thread.sleep(100);
                        }
                    } else {
                        Thread.sleep(100);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}

