package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar (int numberDay, int startingDay) {
        // Task1 //
        int day = 1;
        for (int i = 1; i <= startingDay + numberDay -1; i++) {
            if (i < startingDay) {
                System.out.print("   ");
            } else {
                if (day <= 9) {
                    System.out.print(" "+day+" ");
                } else {
                    System.out.print(day+" ");
                }
                day++;
                if (i % 7 == 0) {
                    System.out.println();
                }
            }
        }
    }

    public static long[] lcg(long seed){
        // Task2 //
        long m = (long) Math.pow(2,31);
        int a = 1103515245;
        int c = 12345;
        long[] pseudonumbers = new long [10];
        pseudonumbers[0] = (a * seed + c )%m;
        for (int i = 1; i < pseudonumbers.length; i++) {
            pseudonumbers[i] = (a * pseudonumbers[i -1] + c) % m;
        }
        return pseudonumbers;
    }
    public static void guessingGame(int numberToGuess){
        // Task 3 //
        Scanner scan = new Scanner(System.in);
        int count = 1;
        while (count <= 10){
            System.out.print("Guess number "+count+": ");
            int number = scan.nextInt();
            count ++;
            if (number == numberToGuess){
                System.out.println("You won wisenheimer!");
                return;
            }else if (count == 11 && number != numberToGuess) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            } else if (number < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
                continue;
            } else if (number > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
                continue;
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random ran = new Random();
        return ran.nextInt(100-1)+1;
    }

    public static boolean swapArrays(int [] array1, int [] array2){
        // Task 4//
        if (array1.length != array2.length){
            return false;
        }
        /** The following 4 lines of Code have been taken from the Internet|
         * https://www.delftstack.com/de/howto/java/array-swap-java/ last visit: 21.10.2022
         */
        for(int i = 0 ; i<array1.length;i++){
            array1[i] = array1[i] - array2[i];
            array2[i] = array1[i] + array2[i];
            array1[i] = GetAbsoluteValue(array1[i] - array2[i]);
        }
        return true;
    }
    public static int GetAbsoluteValue (int a){
        return Math.abs(a);
    }

    public static int checkDigit(int[] Prüfziffer) {
        //Task 6//
        int sum = 0;
        int Gewichtung = 2;
        int Modello;
        for (int i = 0; i < Prüfziffer.length; i++) {
            sum += Prüfziffer[i] * (i + Gewichtung);
        }
        Modello = sum % 11;
        int result = 11 - Modello;
        if (result == 11){
            return 5;
        } else if (result == 10) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }
}