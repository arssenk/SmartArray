package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
        map();
    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public String operationDescription() {
        return "Mapping decorator";
    }

    @Override
    public int size() {
        return array.toArray().length;
    }

    private SmartArray map() {
        for (int i = 0; i < array.size(); i++) {
            array.toArray()[i] = function.apply(array.toArray()[i]);
        }
        return array;
    }
}
