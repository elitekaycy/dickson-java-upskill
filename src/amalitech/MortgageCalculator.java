package amalitech;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Building A Mortgage Calculator
 * Requirement Specs:
 * 1. Principal:100000
 * 2.Annual Interest Rates:4.2
 * 3. Period(Years):30
 * 4. Mortgage:$?
 * 5.
 */

public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR=12;
    private static final byte PERCENT=100;
    int principal;
    double annualInterestRate;
    byte years;


    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    private double calculateMortgage() {
        float monthlyInterest = this.getMonthlyInterest();
        int numberOfPayments = this.getNumberOfPayments();

        return this.principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public void displayMortgage() {
        double getMortgage = this.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(getMortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public float getMonthlyInterest() {
        return (float) (this.annualInterestRate / PERCENT / MONTHS_IN_YEAR);
    }
    public int getNumberOfPayments() {
        return this.years * MONTHS_IN_YEAR;
    }

    public static void main(String...args) {
        int principal;
        float annualInterestRate;
        byte years;
        Scanner scanner=new Scanner(System.in);

        while (true) {
            System.out.println("Principal:");
            try {
                principal = scanner.nextInt();
                if (principal < 1000 || principal >= 1_000_000) throw new MortgageException("Enter a value between 1000 and 10000000");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        while(true) {
            System.out.println("Annual Interest Rate:");
            try {
                annualInterestRate= (float) scanner.nextFloat();
                if(annualInterestRate < 0) throw new MortgageException("interest should be more than O");
                break;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.println("Period(Years):");
            try {
                years = scanner.nextByte();
                if (years < 0) throw new MortgageException("years should be more than 0");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        calculator.displayMortgage();
    }
}
