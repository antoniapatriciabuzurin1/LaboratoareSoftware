package lab1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String alfabet = genereazaAlfabet();

        System.out.println(alfabet.toLowerCase());
        System.out.println(alfabet.toUpperCase());

        String[] secvente = construiesteArray(alfabet.toLowerCase());

        System.out.println("\nElementele array-ului sunt:");
        for (int i = 0; i < secvente.length; i++) {
            System.out.println("array[" + i + "] = " + secvente[i]);
        }
    }

    public static String genereazaAlfabet() {
        StringBuilder sb = new StringBuilder();

        for (char c = 'a'; c <= 'z'; c++) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static boolean esteVocala(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static String[] construiesteArray(String alfabet) {
        List<String> lista = new ArrayList<>();
        int start = -1;

        for (int i = 0; i < alfabet.length(); i++) {
            char curent = alfabet.charAt(i);

            if (esteVocala(curent)) {
                if (start != -1) {
                    lista.add(alfabet.substring(start, i));
                }
                start = i;
            }
        }

        if (start != -1) {
            lista.add(alfabet.substring(start));
        }

        return lista.toArray(new String[0]);
    }
}
