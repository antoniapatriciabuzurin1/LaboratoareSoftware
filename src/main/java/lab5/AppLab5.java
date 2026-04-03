package lab5;

public class AppLab5 {
    public static void main(String[] args) {
        IntCalculator calculator = new IntCalculator(10);
        int resultA = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("Rezultat IntCalculator: " + resultA);

        AdvancedCalculator advCalc = new AdvancedCalculator(10);
        int resultB = advCalc.divide(4).power(2).root(2).result();
        System.out.println("Rezultat AdvancedCalculator: " + resultB);
    }
}
