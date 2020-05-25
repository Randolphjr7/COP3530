package com.company;
/**************************************************************
 Purpose/Description: finds if a number is in an NxN matrix. If the target > matrix[row][column] then row--
                      if the target < matrix[row][column] then column++, we traverse the NxN array this way
                      to search for number
 Author’s Panther ID: 3022407
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/

public class Problem2b {


    public static boolean searchMatrix(int[][] matrix, int target) {



        int matrixRow    = matrix.length -1;
        int matrixColumn = matrix[0].length -1;

        int row     = matrixRow; // initializes to 3
        int column  = 0;

        /*
        if the target > matrix[row][column] then row--
        if the target < matrix[row][column] then column++,
        we traverse the NxN array this way
        to search for number
        */

        while(row >= 0 &&  column <= matrixColumn) {

            //System.out.println("row is: " + row + " column is: " + column);

            if(target == matrix[row][column]) {
                System.out.println("Target Number:  " + target + " was found");
                return true;
            }
            else if(target < matrix[row][column]) {
                //System.out.println("target: " + target + " < " + matrix[row][column]);
                column++;
            }

            else if(target > matrix[row][column]) {
                //System.out.println("target: " + target + " > " + matrix[row][column]);
                row--;
            }

        }

        System.out.println("\nTarget Number:  " + target +  " was not Found\n");
        return false;
    }


    public static void main(String[] args) {

        int[][] matrix = {
                {26, 22, 17, 10},
                {19, 16, 12, 7 },
                {12, 10, 7,  4 },
                {5 , 4 , 2,  1 }
        };


        int target = 1, target2 = 26, target3 = 22, target4 = 2, target5 = 16, target6 = 3;

        System.out.println("\nStart: ");
        searchMatrix(matrix, target);
        searchMatrix(matrix, target2);
        searchMatrix(matrix, target3);
        searchMatrix(matrix, target4);
        searchMatrix(matrix, target5);
        searchMatrix(matrix, target6);
        System.out.println("\nEnd: ");



    }
}
