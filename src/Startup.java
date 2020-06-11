/*
 * NAME: Linghang Kong
 * PID: A16127732
 */

import java.util.Arrays;

/**
 * DSC30 PA1 Class Startup
 *
 * @author Linghang Kong
 * @since ${4/5/2020}
 */

public class Startup {
    /* Declare constants and magic numbers*/
    public static final int DOUBLE = 2;
    public static final int TRIPLE = 3;
    public static final String UPPERCASE =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * arrEvenOdd: if element in array is even, the
     * element at the same index is set to 'E',
     * else it is set to 'O'
     *
     * @param arr: integer array
     *
     * @return arr2: a char array with the corresponding "O" and "E" of arr
     *
     */
    public static char[] arrEvenOdd(int[] arr){
        //create a new char array same length as input arr
        char[] arr2 = new char[arr.length];

        for(int i=0; i<arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr2[i] = 'E';
            } else {
                arr2[i] = 'O';
            }
        }
        return arr2; //@return arr2
    }

    /**
     * Check if a string is a substring of another
     *
     * @param mainStr the string tested whether contains substring
     * @param subStr the string tested whether is a substring of mainStr
     * @return Boolean value. true if subStr is a substring of mainStr, false otherwise
     *
     */
    public static boolean isSubstring(String mainStr, String subStr){
        //@return a boolean of whether subStr is a substring of mainStr
        return mainStr.contains(subStr);
    }

    /**
     * Check if all digits in parameter are in the same row or column
     *
     * @param num integer
     *
     * @return true if digits in num are in the same row or column, false otherwise
     *
     */
    public static boolean numpadSRC(int num){
        //convert integer type num to string type
        String numstr = Integer.toString(num);

        //Create new arrays for storing boolean
        // result as 1 or 0 for rows and columns on numpad
        int[] initRow = {0,0,0};
        int[] initCol = {0,0,0};

        //check if numbers on the same row are in the string type num,
        //the numbers are string type, thus not magic numbers
        if (numstr.contains("1")||numstr.contains("2")||numstr.contains("3")){
            initRow[0] = 1;
        }
        if (numstr.contains("4")||numstr.contains("5")||numstr.contains("6")){
            initRow[1] = 1;
        }
        if (numstr.contains("7")||numstr.contains("8")||numstr.contains("9")){
            initRow[DOUBLE] = 1;
        }

        //sum up the result
        int rowSum = initRow[0]+initRow[1]+initRow[DOUBLE];


        //check if numbers on the same column are in the string type num,
        //the numbers are string type, thus not magic numbers
        if (numstr.contains("1")||numstr.contains("4")||numstr.contains("7")){
            initCol[0] = 1;
        }
        if (numstr.contains("2")||numstr.contains("5")||numstr.contains("8")){
            initCol[1] = 1;
        }
        if (numstr.contains("3")||numstr.contains("6")||numstr.contains("9")){
            initCol[DOUBLE] = 1;
        }
        //sum up the result
        int colSum = initCol[0]+initCol[1]+initCol[DOUBLE];


        // If all numbers are in the same row or column,
        // the sum of the result can only be 1,
        // otherwise they are in different rows or columns
        if (num == 0 || numstr.length() == 1 || rowSum == 1 || colSum == 1){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Create a set that is an integer array without duplicate elements and sorted
     *
     * @param arr integer array, unsorted, may contain duplicates
     *
     * @return an integer array without duplicate elements and sorted
     *
     */
    public static int[] createSet(int[] arr){

        //sort temp using bubble sort
        for (int k = 0; k < arr.length-1; k++)
        {
            for (int l = 0; l<arr.length-k-1; l++) {
                if (arr[l] > arr[l+1])
                {
                    int tempNum = arr[l];
                    arr[l] = arr[l+1];
                    arr[l+1] = tempNum;
                }
            }
        }
        int j = 0;
        if(arr.length == 0 || arr.length == 1){
            return arr;
        }
        int[] temp = new int[arr.length];
        for (int i=0; i<arr.length-1; i++){
            if(arr[i]!=arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[arr.length-1];
        int[] temp2 = new int[j];
        for (int i = 0; i<j; i++){
            temp2[i] = temp[i];
        }

        return temp2; // @return sorted array with unique element
    }

    /**
     * Check if a set is a subset of another
     *
     * @param set1 integer array, no duplicates and sorted
     * @param set2 integer array, no duplicates and sorted
     * @return true if set1 is a subset of set2, false otherwise
     *
     */
    public static boolean subsetChecker(int[] set1, int[] set2){
        int count = 0;

        //iterate over both set1 and set2 to compare each individual element
        for (int i = 0; i < set2.length; i++) {
            for (int j = 0; j < set1.length; j++) {
                if (set2[i] == set1[j]) {

                    //avoid including repeated elements
                    set2[i] = -1;

                    count++;
                    //stop
                    break;
                }
            }
        }

        //@return true or false after iteration is over
        if (count == set1.length){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * recursively using binary method to search for the index of given target
     *
     * @param arr integer array where the search is performed
     * @param left left bound of the search range
     * @param right right bound of the search range
     * @param target the target element needed to get the index of
     * @return the index of the target, -1 if left bound is greater than right bound
     *
     */
    public static int recursiveBinarySearch
    (int[] arr, int left, int right, int target){

        //check if right is greater than left, otherwise it is crossed, then return -1
        if (right >= left) {
            //find a middle point in the range
            int mid = left + (right - left) / DOUBLE;

            //@return the target index if the middle point is the target
            if (arr[mid] == target)
                return mid;

            //Move to the left if the middle point is greater than target
            if (arr[mid] > target)
                return recursiveBinarySearch(arr, left, mid - 1, target);

            //Move to the right if the middle point is less than target
            return recursiveBinarySearch(arr, mid + 1, right, target);
        }

        return -1;
    }

    /**
     * encrypt a string by applying atbash cipher
     *
     * @param s string that is going to be encrypted
     *
     * @return encrypted string s
     *
     */
    public static String encryptString(String s){
        String cryptd = "";
        //Create lower case alphabet from upper case alphabet
        String lowerCase = UPPERCASE.toLowerCase();
        for (int i=0; i<s.length(); i++){
            int j = 0;
            String singleChar = Character.toString(s.charAt(i));
            if(UPPERCASE.contains(singleChar)){
                cryptd += lowerCase.charAt(lowerCase.length()-1-lowerCase.indexOf(s.toLowerCase().charAt(i)));
            }else if (lowerCase.contains(singleChar)){
                cryptd += UPPERCASE.charAt(UPPERCASE.length()-1-UPPERCASE.indexOf(s.toUpperCase().charAt(i)));
            }else{
                cryptd+=s.charAt(i);
            }
        }
        return cryptd;

    }

    /**
     * print out a "joint" pattern using "*" symbol
     *
     * @param width the number of "*" in the middle row
     *
     * @return a string of the pattern
     *
     */
    public static String drawPattern(int width){
        //in the question, 1or2, 3or4 returns the same answer
        width = width + width%DOUBLE;

        //create empty string for the pattern
        String emptyStr = "";
        for (int i = 1; i<=width/DOUBLE; i++){
            for (int j = 1; j<=i; j++){
                //for the up left corner, including left half of the middle row and patterns above
                emptyStr += "*";
            }
            for (int k = i*DOUBLE; k<=width-1; k++){
                emptyStr += " ";
            }
            for (int l=1; l<=i; l++){
                //for the up right corner, including right half of the middle row and the patterns above
                emptyStr += "*";
            }

            //breakline
            emptyStr += "\n";
        }

        for (int a=1; a<=width/DOUBLE-1; a++){
            for (int b=width/DOUBLE-1; b>=a; b--){
                //for the down left corner below the middle row
                emptyStr += "*";
            }
            for (int c=1; c<=a*DOUBLE; c++){
                emptyStr += " ";
            }
            for (int d=width/DOUBLE-1; d>=a; d--){
                //for the down right corner below the middle row
                emptyStr += "*";
            }
            emptyStr += "\n";
        }
        return emptyStr; //@return the pattern in the form of a string
    }

    public static int[] runtimeAnswers(){
        return new int[]{
                1,1,3,2,1,2,3,1,2,1
        };
    }

    public static void main(String[] args){
        System.out.println(arrEvenOdd(new int[]{2,2,2}));
        System.out.println(arrEvenOdd(new int[]{1,2,3}));
        System.out.println(arrEvenOdd(new int[]{5,7,9}));

        System.out.println(isSubstring("Marina", "Ma"));
        System.out.println(isSubstring("Albert", "K"));
        System.out.println(isSubstring("ok", " "));

        System.out.println(numpadSRC(7140));
        System.out.println(numpadSRC(23042));
        System.out.println(numpadSRC(2));

        System.out.println(createSet(new int[]{1,5,3,5,3,5,5,4,2}));

        System.out.println(subsetChecker(new int[]{2,2,6}, new int[]{1,2,3,4,5,6}));
        System.out.println(subsetChecker(new int[]{1,2,3}, new int[]{1,2,3,4,5}));
        System.out.println(subsetChecker(new int[]{1,2,4}, new int[]{1,2,3,4,5}));

        System.out.println(recursiveBinarySearch(new int[]{1,2,3,4,5,6,7},0,6,4));
        System.out.println(recursiveBinarySearch(new int[]{1,2,3,4,5,6,7}, 4,3,2));
        System.out.println(recursiveBinarySearch(new int[]{1,2,3,4,5,6},2,5,3));

        System.out.println(encryptString("abcde"));
        System.out.println(encryptString("sSEJKg2!"));
        System.out.println(encryptString("!#&#^@%@*$"));

        System.out.println(drawPattern(3));
        System.out.println(drawPattern(4));
        System.out.println(drawPattern(5));

        int[] test1 = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(createSet(test1)));
        int[] test2 = new int[]{7,7,6,5,5,4,3,3,3,2,1};
        System.out.println(Arrays.toString(createSet(test2)));
        System.out.println(Arrays.toString(test2));
        int[] test3 = new int[]{1};
        System.out.println(Arrays.toString(createSet(test3)));
    }
}