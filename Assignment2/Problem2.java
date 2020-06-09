/**************************************************************
 Purpose/Description: Find the most common integer; if it appears more than half
                      of the time in array return the index
 Author’s Panther ID: 3022407
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
import java.util.Stack;

public class Problem2 {
    /*
    Given an array A of n integers, a leader element of the array A is the element that
    appears more than half of the time in A. Using one stack, implement in Java an O(n)
    running time complexity method

    static int leader(int[] A);

    to find a leader element and return the index (any) of the leader in A. The program
    must returns -1 if no leader element exists.
    */
    public static void main(String[] args) {

        int[] a = {23, 23, 67, 23, 67, 23, 45};
        int[] b = {23, 24, 67, 23, 67, 23, 45};
        int[] c = {23, 24, 67, 23, 67, 23, 45, 23, 23};


        int example1 = leader(a);
        int example2 = leader(b);
        int example3 = leader(c);

        System.out.println("\nIf no Leader Element is found -1 will be returned");
        System.out.println("Leader Element for Array a is at INDEX: " + example1);
        System.out.println("Leader Element for Array b is at INDEX: " + example2);
        System.out.println("Leader Element for Array c is at INDEX: " + example3);
    }

    static int leader(int[] A) {


        if(A.length == 0) {
            return -1;
        }

        // Creating a Stack
        Stack<Integer> myStack = new Stack<>();

        int i = 0;
        while (i < A.length) {
            // if stack is empty push number to array
            if(myStack.empty()){
                myStack.push(A[i]);
            }
            else {
                // get the top
                int top = myStack.peek();
                // if they are different numbers
                if(top != A[i]){
                    // remove the top
                    myStack.pop();
                    // add the new number
                    myStack.push(A[i]);
                }
                else {
                    // they are the same numbers, so add
                    myStack.push(A[i]);
                }
            }
            i++;
        }

        // our leader number (the number that appears the most) is at the bottom of the stack
        int leaderNum = myStack.firstElement();
        int leaderNumCount = 0;
        int index = -1;

        // iterate through the array to get the number of times leaderNum appears
        for(int y = 0; y < A.length; y++) {
            if(leaderNum == A[y]) {
                leaderNumCount++;
                index = y;
            }
        }

        // leader number needs to be the number that appears more than half the time in the array
        // so we compute the half
        int half = A.length / 2;

        // if leaderNumCount appears more than half of the time in A then return any index
        // of the leaderNum in the array
        if(leaderNumCount > half) {
            return index;
        }

        // else no leader element found that appears more than half the time
        return -1;
    }
}
