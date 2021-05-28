package lesson2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    private static final int DATA_LENGTH = 100000;

    public static void main(String[] args) {
        testSort("sortBubble");
        testSort("sortSelect");
        testSort("sortInsert");
    }

    private static void testSort(String methodName)  {
        ArrayImpl<Integer> arr = new ArrayImpl<>();
        for (int i = 0; i < DATA_LENGTH; i++) {
            arr.add((int) (Math.random() * DATA_LENGTH));
        }
        long t = System.currentTimeMillis();
        try {
            Method method = arr.getClass().getDeclaredMethod(methodName);
            method.invoke(arr);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        t = System.currentTimeMillis() - t;
        System.out.printf("Method %s - %sms%n", methodName, t);
    }
}
