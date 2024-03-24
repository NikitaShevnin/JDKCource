package Less3.hw;

/**
 *TODO Задание 1. Написать класс Калькулятор (необобщенный), который содержит обобщенные
 *     статические методы: sum(), multiply(), divide(), subtract(). Параметры этих методов –
 *     два числа разного типа, над которыми должна быть произведена операция. Методы должны
 *     возвращать результат своей работы.
 */

public class Calculator {

    public static <T extends Number, U extends Number> double sum(T a, U b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T a, U b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T a, U b) {
        if (b.doubleValue() != 0) {
            return a.doubleValue() / b.doubleValue();
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public static <T extends Number, U extends Number> double subtract(T a, U b) {
        return a.doubleValue() - b.doubleValue();
    }

    /**
     * Возвращаемый тип у всех методов - double, чтобы обеспечить возможность работы с
     * числами разных типов. Если переданные числа, например, int и double, результат будет
     * возвращен в виде double.
     * @param args
     */
    public static void main(String[] args) {

        int num1 = 5;
        double num2 = 2.5;

        double resultSum = Calculator.sum(num1, num2); // Сложение
        System.out.println("Результат сложения: " + resultSum);

        double resultMultiply = Calculator.multiply(num1, num2); // Умножение
        System.out.println("Результат умножения: " + resultMultiply);

        double resultDivide = Calculator.divide(num1, num2); // Деление
        System.out.println("Результат деления: " + resultDivide);

        double resultSubtract = Calculator.subtract(num1, num2); // Вычитание
        System.out.println("Результат вычитания: " + resultSubtract);
    }
}

