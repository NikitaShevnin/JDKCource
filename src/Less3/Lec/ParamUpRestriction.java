package Less3.Lec;

public class ParamUpRestriction<T extends Number> {
    private T value;

    public ParamUpRestriction(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public double squareValue() {
        double doubleValue = value.doubleValue();
        return doubleValue * doubleValue;
    }

    public static void main(String[] args) {
        ParamUpRestriction<Integer> integerObj = new ParamUpRestriction<>(5);
        System.out.println("Integer object value: " + integerObj.getValue());
        System.out.println("Square of integer object value: " + integerObj.squareValue());

        ParamUpRestriction<Double> doubleObj = new ParamUpRestriction<>(2.5);
        System.out.println("Double object value: " + doubleObj.getValue());
        System.out.println("Square of double object value: " + doubleObj.squareValue());
    }
}

