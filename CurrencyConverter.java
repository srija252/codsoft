import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to Currency Converter\n");
        System.out.println("1. INR");
        System.out.println("2. USD");
        System.out.println("3. EUR");

        System.out.print("\nChoose the currency you want to convert: ");
        int choice = sc.nextInt();

        System.out.print("\nEnter Amount: ");
        double amount = sc.nextDouble();

        switch (choice) {
            case 1:
                convertFromINR(amount);
                break;
            case 2:
                convertFromUSD(amount);
                break;
            case 3:
                convertFromEUR(amount);
                break;
            default:
                System.out.println("\nInvalid choice");
        }
        sc.close();
    }

    public static void convertFromINR(double amount) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nTo which currency do you want to convert? \n1. USD\n2. EUR\nChoose: ");
        int type = sc.nextInt();

        if (type == 1) {
            System.out.printf("\n%.2f INR is equal to %.2f USD", amount, amount / 82.86);
        } else if (type == 2) {
            System.out.printf("\n%.2f INR is equal to %.2f EUR", amount, amount / 90.13);
        } else {
            System.out.println("\nWrong Input!");
        }
        sc.close();
    }

    public static void convertFromUSD(double amount) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nTo which currency do you want to convert? \n1. INR\n2. EUR\nChoose: ");
        int type = sc.nextInt();

        if (type == 1) {
            System.out.printf("\n%.2f USD is equal to %.2f INR", amount, amount * 82.86);
        } else if (type == 2) {
            System.out.printf("\n%.2f USD is equal to %.2f EUR", amount, amount * 0.89);
        } else {
            System.out.println("\nWrong Input!");
        }
        sc.close();
    }

    public static void convertFromEUR(double amount) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nTo which currency do you want to convert? \n1. INR\n2. USD\nChoose: ");
        int type = sc.nextInt();

        if (type == 1) {
            System.out.printf("\n%.2f EUR is equal to %.2f INR", amount, amount * 90.13);
        } else if (type == 2) {
            System.out.printf("\n%.2f EUR is equal to %.2f USD", amount, amount * 1.12);
        } else {
            System.out.println("\nWrong Input!");
        }
        sc.close();
    }
}
