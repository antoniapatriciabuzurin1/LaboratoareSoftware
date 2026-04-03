package lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        NewIntCalculator intCalc = new NewIntCalculator(10);
        int resInt = (Integer) intCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("Rezultat Integer: " + resInt);

        DoubleCalculator doubleCalc = new DoubleCalculator(10);
        double resDouble = (Double) doubleCalc.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("rezultat Double: " + resDouble);
    }
}
