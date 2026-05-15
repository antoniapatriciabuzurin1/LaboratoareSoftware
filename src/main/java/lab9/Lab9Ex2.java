package lab9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab9Ex2 {
    public static void main(String[] args) {
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));
        System.out.println("Lista initiala: " + cuvinte);

        List<String> cuvinteFiltrate = cuvinte.stream()
                .filter(cuvant -> cuvant.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("Cuvinte cu lungime >= 5: " +  cuvinteFiltrate);
        System.out.println("Numar cuvinte gasite : " +  cuvinteFiltrate.size());

        List<String> cuvinteOrdonate = cuvinteFiltrate.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Cuvinte ordonate : " +  cuvinteOrdonate);

        cuvinte.stream()
                .filter(cuvant -> cuvant.startsWith("p"))
                .findFirst()
                .ifPresent(cuvant -> System.out.println("Cuvant care incepe cu p: " + cuvant));
    }
}
