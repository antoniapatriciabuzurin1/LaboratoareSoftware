package lab9;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab9Application {

    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numbers = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista initiala: " + numbers);

        int suma = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Suma elementelor: " + suma);

        int maxim = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
        int minim = numbers.stream()
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("Maxim :" + maxim);
        System.out.println("Minim :" + minim);

        List<Integer> filtered = numbers.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());

        System.out.println("Elementele intre 10 si 20: " + filtered);

        List<Double> doubleValues = numbers.stream()
                .map(n -> Double.valueOf(n))
                .collect(Collectors.toList());

        System.out.println("Lista Double: " + doubleValues);

        boolean exista12 = numbers.stream()
                .anyMatch(n -> n == 12);

        System.out.println("Lista contine 12?: " + exista12);
    }
}
