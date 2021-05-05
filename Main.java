package com.susilo.martinus;

import java.util.ArrayList;

public class Main {
    /**
     * Different strategy/method to run the sieve of Eratosthenes
     *
     * @author Martinus Susilo
     * @Date 02/05/2021
     */

    public static void main(String[] args) {
        calculateSieveOfEratos(25);
    }

    /**
     * Print all the prime numbers until the given number "upperLimit" ("upperLimit" is included).
     * Definition of Prime number: a number that is GREATER than 1 that is NOT a product of two smaller natural number (it can only divisible by itself and one)
     *
     * Input parameter: upperLimit of prime number
     * Output: An array of prime numbers
     *
     * Many methods being tested to see which one is effective. See for loop in step 3b below.
     */
    public static void calculateSieveOfEratos(int upperLimit) {//access modifier public, keyword static because it muss n

        // 1. Declare an array of boolean with the name of apaPrima and allocate its memory for upperLimit elements (The size is "upperLimit" variables)
        // Each variable of bilPrima ist either true or false. The element with true value denotes prime number.
        boolean[] bilPrima = new boolean[upperLimit];

        bilPrima[0] = false; //Direct initialization = Number 1 (Index c=0) is not a prime number

        //2. Initiate the elements from Index 1 (Number = Index+1) to Index <upperLimit (Number = upperLimit-1) and set them to true (assume them as Prime number).
        for (int Index = 1; Index < upperLimit; Index++) {
            bilPrima[Index] = true;
        }

        //3. Check every Number (starting from Number=2 until Number=upperLimit) if they prime number
        for (int Number = 2; Number <= upperLimit; Number++) {

            //3a. if (bilPrima[Index-1] == true) {
            if (bilPrima[Number - 1]) { //if the number (Index+1) is prime number (if it has not been "crossed off" / the value=true)
                System.out.println(Number); //print out the prime number

                //3b. All the subsequent multiples of Number will be "crossed off" / set to false
                // for loop algorithm:
                //1st statement: testNumber = 2*Number -> executed one time/Set before the loop start;
                //2nd Statement: Condition for executing the code block:
                //-Number=2 -> testNumber=4(2*2),6(4+2),8(6+2),10(8+2)....
                //-Number=3 -> testNumber=6(2*3),9(6+3)...
                //-Number=5 -> testNumber=10(2*5)...
                //...
                //3rd Statement: testNumber = testNumber+Number -> executed (every time) after the code block has been executed
                //for (int testNumber = 2 * Number; testNumber <= upperLimit; testNumber++) {
                for (int testNumber = 2*Number; testNumber <= upperLimit; testNumber += Number) { //CONS: There are many numbers "crossed off" multiple times, for example 6,12,18,24...
                //for (int testNumber = Number*Number; testNumber <= upperLimit; testNumber += Number) { //PROS: More efficient (6 not checked multiple times, but still for 12,18...)
                    //System.out.println(testNumber);//test
                    bilPrima[testNumber - 1] = false;
                }
                //System.out.println(" ");//test
            }
        }
    }

}
