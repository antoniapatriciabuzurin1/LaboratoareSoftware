package lab2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList();

        Random rand = new Random();
        for(int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11));
        }
        for(int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        for(Integer val : x) {
            if(y.contains(val)) {
                zSet.add(val);
            }
        }

        for(Integer val : x) {
            if(!y.contains(val)) {
                xMinusY.add(val);
            }
        }
        Collections.sort(xMinusY);

        for(Integer val : x) {
            if (val <= p && !xPlusYLimitedByP.contains(val)) {
                xPlusYLimitedByP.add(val);
            }
        }
        for(Integer val : y) {
            if (val <= p && !xPlusYLimitedByP.contains(val)) {
                xPlusYLimitedByP.add(val);
            }
        }
        Collections.sort(xPlusYLimitedByP);

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("xPlusY = " + xPlusY);
        System.out.println("zSet (comune) = " + zSet);
        System.out.println("xMinusY = " + xMinusY);
        System.out.println("xPlusYLimitedByP = " + xPlusYLimitedByP);
    }
}
