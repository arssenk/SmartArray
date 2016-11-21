package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator function;
    private SmartArray finalArray;

    public SortDecorator(SmartArray array, MyComparator function) {
        super(array);
        this.function = function;
        finalArray = sort();
    }

    @Override
    public Object[] toArray() {
        return finalArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorting array";
    }

    @Override
    public int size() {
        return array.toArray().length;
    }

    private SmartArray sort() {
        Object temp;
        for (int i = 0; i < array.size() - 1; i++) {

            for (int j = 1; j < array.size() - i; j++) {
                if (function.compare(array.toArray()[j - 1], array.toArray()[j]) > 0) {
                    temp = array.toArray()[j - 1];
                    array.toArray()[j - 1] = array.toArray()[j];
                    array.toArray()[j] = temp;
                }
            }
        }
        return array;
    }
}

