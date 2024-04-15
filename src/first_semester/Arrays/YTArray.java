package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class YTArray {
    public static void main(String[] args) {

        // alter Weg mit Arrays (keine Liste)
        int[] primeNumbers = new int[3];
        primeNumbers[0] = 1;
        primeNumbers[1] = 2;
        primeNumbers[2] = 3;

        ArrayList<Integer> primeNumberList = new ArrayList<>();
        primeNumberList.add(2);
        primeNumberList.add(3);
        primeNumberList.add(5);

        System.out.println(primeNumberList);
        System.out.println(primeNumberList.get(2));

        for (Integer primeNumberList2 : primeNumberList) {
            System.out.println(primeNumberList2);
            primeNumberList2 = primeNumberList2 + 1;
            System.out.println(primeNumberList2);
        }

    }

    public static String findNeedle(Object[] haystack) {
        for (Object i : haystack) {
            if (i.equals("needle")) {
                return "found the needle at position " + i;
            }
        }
        return null;

    }
}
