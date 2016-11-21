package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private SmartArray filteredArray;
    private MyPredicate function;

    public FilterDecorator(SmartArray smartArray, MyPredicate function) {
        super(smartArray);
        this.function = function;
        this.filteredArray = filter();

    }


    @Override
    public Object[] toArray() {
        return filteredArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filtering by predicate";
    }

    @Override
    public int size() {
        return array.size();
    }

    private SmartArray filter() {
        Object[] answer = new Object[this.array.size()];
        int i = 0;
        for (Object item : this.array.toArray()) {
            if (function.test(item)) {
                answer[i] = item;
                i++;
            }
        }
        array = new BaseArray(Arrays.copyOfRange(answer, 0, i));
        return array;

    }
}
