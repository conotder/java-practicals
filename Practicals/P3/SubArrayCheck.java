package Practicals.P3;

import java.util.HashSet;

class subArrayCheckBasic {
    public static boolean hasZeroSubarray(int[] arr){

        // Picking the start number
        for(int start = 0; start < arr.length; start++){
            int currentSum = 0;

            // Adding next numbers
            for(int end = start; end < arr.length; end++){
                currentSum += arr[end];

                // check if sum equals 0
                if(currentSum == 0){
                    return true; // Found it!
                }
            }
        }
        return false; // checked every possibility and found nothing.
    }

}

public class SubArrayCheck {
    public static void main(String[] args) {

        int[] array1 = {4, 2, -3, 1, 6};
        int[] array2 = {1, 2, 3, 4, 0};

        subArrayCheckBasic subArrayCheck = new subArrayCheckBasic();
        boolean result = subArrayCheckBasic.hasZeroSubarray(array1);
        boolean result2 = subArrayCheckBasic.hasZeroSubarray(array2);


        System.out.println("Array1: " + result);
        System.out.println("Array2: " + result2);
    }
}
