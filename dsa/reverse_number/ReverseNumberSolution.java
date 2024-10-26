package dsa.reverse_number;

import java.util.Scanner;

/*
URL: 
https://leetcode.com/problems/reverse-integer/
https://leetcode.com/problems/palindrome-number/
*/

public class ReverseNumberSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            int a = sc.nextInt();
            System.out.print(a + " -> " + reverseNumber(a));
            System.out.println(" -> " + isPalindrome(a));
        }
        sc.close();
    }

    static int reverseNumber(int x) {
        // code here
        int output = 0;
        int i = x;
        while (i != 0) {
            int remainder = i % 10;
            if (output > Integer.MAX_VALUE / 10 || (output == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0;
            }
            if (output < Integer.MIN_VALUE / 10 || (output == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0;
            }
            
            output = (output * 10) + remainder;
            i = i / 10;
        }
        return output;
    }

    static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = reverseNumber(x);
        // System.out.print(" " +rev + " ");
        return rev == x;
    }
}
