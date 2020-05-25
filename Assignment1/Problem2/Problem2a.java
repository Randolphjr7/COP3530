package com.company;
/**************************************************************
 Purpose/Description: finds the index of the peak/max number of an array
 Author’s Panther ID: 3022407
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
public class Problem2a {


    public static void findNumber(int[] someArray, int target, int left, int right) {

        System.out.println("\nSearch Start For Integer: " + target);
        boolean found;

        // get index of max/peak number of array
        int maxIndex = findMaxIndex(someArray, left, right);

        // check to see if target number is max
        if(someArray[maxIndex] == target) {
            found = true;
            System.out.println("Integer [" + target +"] was found in array: " + found);
            System.out.println("Number- " + target + " Found AT INDEX[" + maxIndex + "]");
            return;
        }

        // else search the left side
        found = leftBinarySearch(someArray, target, left, maxIndex - 1);

        if(!found) {
            // else search the right side
            found = rightBinarySearch(someArray, target, maxIndex + 1, right);
        }

        if(!found) {
            // we search left and right target number was not found
            System.out.println(found + ": INTEGER WAS NOT FOUND IN ARRAY");
        }
    }


    // Find the peak number and return the index of peak number
    public static int findMaxIndex(int[] someArray, int left, int right) {

        boolean foundMax = false;

        // divide and conquer search paradigm
        int maxIndex = left + (right - left) / 2;
        // if both left side & right side index values are less then the value of our maxIndex
        // then we found peak
        if(someArray[maxIndex - 1] < someArray[maxIndex] && someArray[maxIndex] > someArray[maxIndex + 1]) {
            foundMax = true;
            return maxIndex;
        }
        else if(someArray[maxIndex - 1] > someArray[maxIndex]){
            return findMaxIndex(someArray, left, maxIndex -1);
        }
        else {
            return findMaxIndex(someArray, maxIndex + 1, right);
        }

    }

    // Search the left side of the array
    public static boolean leftBinarySearch(int[] someArray, int target, int left, int right) {

        boolean found = false;
        int mid;

        //System.out.println("Left Binary Search");
        while(!found) {

            if(left > right) {
                return found;
            }

            // divide and conquer
            mid = left + ((right - left) / 2); // Prevent overflow

            if(someArray[mid] == target) {
                found = true;
                System.out.println("Integer [" + target + "] was found in array: " + found);
                System.out.println("Integer [" + target + "] was found at index: " + mid);
                return found;
            }

            // if our target is less than mid; we assign the right to be mid - 1 and divide again
            if(target < someArray[mid]){
                right = mid - 1;
            } else {
                // our target is more than; we assign the left to be mid + 1 and divide again
                left = mid + 1;
            }
        }

        return found;
    }

    // Search the right side of the array
    public static boolean rightBinarySearch(int[] someArray, int target, int left, int right) {

        boolean found = false;
        int mid;

        while(!found) {

            if(left > right) {
                return found;
            }

            // divide and conquer
            mid = left + ((right - left) / 2); // Prevent overflow

            if(someArray[mid] == target) {
                found = true;
                System.out.println("Integer [" + target + "] was found in array: " + found);
                System.out.println("Integer [" + target + "] was found at index: " + mid);
                return found;
            }
            // if our target is less than mid; we assign the right to be mid - 1 and divide again
            if(target < someArray[mid]){
                left = mid + 1;
            } else {
                // our target is more than; we assign the left to be mid + 1 and divide again
                right = mid - 1;
            }
        }

        return found;
    }

    


    public static void main(String[] args) {

        int[] monotonArray  = new int[]{1, 3, 4, 5, 7, 14, 11, 2, -4, -8};

        int left = 0, right = monotonArray.length - 1;
        // test numbers to look for
        int target1 = 4, target2 = 1, target3 = 2, target4 = -4, target5 = -8, target6 = 6, target7 = 0;


        findNumber(monotonArray, target1, left, right);
        findNumber(monotonArray, target2, left, right);
        findNumber(monotonArray, target3, left, right);
        findNumber(monotonArray, target4, left, right);
        findNumber(monotonArray, target5, left, right);
        findNumber(monotonArray, target6, left, right);
        findNumber(monotonArray, target7, left, right);
    }
}
