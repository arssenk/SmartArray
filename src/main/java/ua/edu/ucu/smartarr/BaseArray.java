package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] input;

    public BaseArray(Object[] t) {
        this.input = t;

    }

    @Override
    public Object[] toArray() {
        return input;
    }

    @Override
    public String operationDescription() {
        return "Having base array";
    }

    @Override
    public int size() {
        return input.length;
    }

}
