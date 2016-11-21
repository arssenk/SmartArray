package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

class SmartArrayApp {

    static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = t -> ((Integer) t) > 0;

        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);

        MyFunction func = t -> 2 * ((Integer) t);

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr);// Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp);// Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]
        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code

        SmartArray studentSmartArray = new BaseArray(students);
        MyPredicate checkPoint = t -> ((Student) t).getGPA() >= 4;
        MyFunction checkYear = t -> {
            if (((Student) t).getYear() == 2) {
                return t;
            } else {
                return false;
            }

        };

        studentSmartArray = new FilterDecorator(studentSmartArray, checkPoint);
        studentSmartArray = new MapDecorator(studentSmartArray, checkYear);
        studentSmartArray = new DistinctDecorator(studentSmartArray);
        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);


    }
}
