package dsa.encode_decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Sum of all divisors: https://www.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1
 * 
 * Problem statement
 * Given a positive integer n, The task is to find the value of Σi F(i) where i is from 1 to n and function F(i) is defined as the sum of all divisors of i.
 * 
 * Examples:
 * 
 * Input: n = 4
 * Output: 15
 * Explanation:
 * F(1) = 1
 * F(2) = 1 + 2 = 3
 * F(3) = 1 + 3 = 4
 * F(4) = 1 + 2 + 4 = 7
 * So, F(1) + F(2) + F(3) + F(4)
 *     = 1 + 3 + 4 + 7 = 15
 * Input: n = 5
 * Output: 21
 * Explanation:
 * F(1) = 1
 * F(2) = 1 + 2 = 3
 * F(3) = 1 + 3 = 4
 * F(4) = 1 + 2 + 4 = 7
 * F(5) = 1 + 5 = 6
 * So,  F(1) + F(2) + F(3) + F(4) + F(5)
 *     = 1 + 3 + 4 + 7 + 6 = 21
 * Input: n = 1
 * Output: 1
 * Explanation:
 * F(1) = 1
 * So,  F(1) = 1 
 * Constraints:
 * 1 <= n <= 105
 */
public class EncodeDecode {
    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome("0P");
        System.out.println("isPalindrome: " + isPalindrome);
        // Scanner sc = new Scanner(System.in);
        // // int s = sc.nextInt();
        // List<String> inputList = new ArrayList<>();
        // for (int i = 0; i < s; i++) {
        //     String a = sc.next();
        //     inputList.add(a);
        // }
        // inputList.add("");
        // System.out.println("input: " + inputList);
        // String encodedString = encode(inputList);
        // System.out.println("encoded: " + encodedString);
        // List<String> decodedList = decode(encodedString);
        // System.out.println("decoded: " + decodedList);
        // sc.close();
    }

    public static String encode(List<String> strs) {
        String encodedStr = "";
        for (String str: strs) {
            encodedStr = encodedStr + "#" + str.length() + "#" + str;
        }
        return encodedStr;
    }

    public static List<String> decode(String str) {
        System.out.println("output -> " + ",".split(",").length); 
        System.out.println(str);
        if (str.equals("")) {
            return new ArrayList<>();
        }
        String[] output =  str.split("#\\d+#", -1);
        System.out.println("output: " + Arrays.toString(output));
        List<String> decodedList = new ArrayList<>(Arrays.asList(output));
        System.out.println(decodedList.getClass().getName());
        System.out.println(decodedList);
        if (decodedList.size() == 0) {
            return decodedList;
        }
        decodedList.remove(0);
        return decodedList;
    }

    public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int size = str.length();
        int left = 0;
        int right = size - 1;
        while(left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
