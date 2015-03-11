import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        Polynome polynome = new Polynome("x^3 + 17x^2 - 4");
        String result = polynome.toString();
        System.out.print(result);

    }

}