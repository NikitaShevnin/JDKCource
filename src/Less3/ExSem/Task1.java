package Less3.ExSem;

/**
 * Задание 1
 *
 * Создать обобщенный класс с тремя параметрами (T, V, K).
 * Класс содержит три переменные типа (T, V, K),
 * конструктор, принимающий на вход параметры типа (T, V, K),
 * методы возвращающие значения трех переменных.
 *
 * Создать метод, выводящий на консоль имена классов для трех переменных класса.
 * Наложить ограничения на параметры типа:
 * T должен реализовать интерфейс Comparable,
 * V должен реализовать интерфейс DataInput и расширять класс InputStream,
 * K должен расширять класс Number.
 */

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;

class Task1 <T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T value1;
    private V value2;
    private K value3;

    public Task1 (T value1, V value2, K value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public T getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }

    public K getValue3() {
        return value3;
    }

    public void printClassNames() {
        System.out.println("Type of value1: " + value1.getClass().getSimpleName());
        System.out.println("Type of value2: " + value2.getClass().getSimpleName());
        System.out.println("Type of value3: " + value3.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Task1 <String, DataInputStream, Integer> ex1 =
                new Task1 ("text", new DataInputStream(System.in), 10);
    }
}


