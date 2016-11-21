package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;

import java.util.Arrays;
import java.util.Objects;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray array) {
        super(array);
        compare();


    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public String operationDescription() {
        return "Comparing items";
    }

    @Override
    public int size() {
        return array.size();
    }
    private String[] castToString(Object[] array){
        int i = 0;
        String[] answer = new String[array.length];
        while (i< array.length){
            answer[i] = ((Student) array[i]).getSurname() + " " + ((Student) array[i]).getName();
            i++;
        }
        return answer;
    }



    private SmartArray compare() {
        Object[] temparr = new Object[array.size()];
        int i = 0;
        for (int index_o1 = 0; index_o1 < array.size(); index_o1++) {
            for (int index_o2 = index_o1; index_o2 < array.size(); index_o2++) {
                if (!(array.toArray()[index_o1] instanceof Boolean) && !(array.toArray()[index_o2] instanceof Boolean)) {
                    Student o1 = (Student) array.toArray()[index_o1];
                    Student o2 = (Student) array.toArray()[index_o2];
                    if (!(Objects.equals((o1).getName(), (o2).getName())
                            && Objects.equals((o1).getSurname(), (o2).getSurname()))) {
                        temparr[i] = o1;
                        i++;
                        break;
                    }
                }
            }
        }
        Object[] f = Arrays.copyOfRange(temparr, 0, i);
        Arrays.sort(f);
        array = new BaseArray(castToString(f));
        return array;
    }
}
