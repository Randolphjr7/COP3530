package com.company;
/**************************************************************
 Purpose/Description: finds the stability index of an array
 Author’s Panther ID: 3022407
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/

public class Problem1 {

    public static void stabilityIndex(int[] someArray) {

        System.out.println("\nSearch Start\n");
        int leftSum = 0,  rightSum = someArray[0];

        // Get the sum of array
        for(int i = 1; i < someArray.length; i++) {
            rightSum += someArray[i];
        }

        boolean indexFound = false;
        // Compare leftSum with rightSum
        for(int i = 0; i < someArray.length; i++) {

            rightSum -= someArray[i];

            // if they are equal we found our equilibrium index
            if(leftSum == rightSum) {
                indexFound = true;
                System.out.println("Stability Index Found At Position Index: " + i);
            }

            leftSum += someArray[i];
        }

        System.out.println("Index(s) Found: " + indexFound);
        System.out.println("\nSearch Complete \n\n");
    }



    public static void main(String[] args) {

        // test cases
        int[] array1 = new int[]{0,-3,5,-4,-2,3,1,0};
        int[] array2 = new int[]{-5,10,-3,5,0,7,1,-2,1};
        int[] array3 = new int[]{4,3,4};
        int[] array4 = new int[]{4,3,4,100};



        stabilityIndex(array1); // index at position 0, 3, 7
        stabilityIndex(array2); // index at position 3
        stabilityIndex(array3); // index at position 1
        stabilityIndex(array4); // no stability index



    }
}
