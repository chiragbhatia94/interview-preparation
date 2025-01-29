package dsa.reverse_number;

import java.util.Scanner;

/**
 * URL: 
 * https://leetcode.com/problems/reverse-integer/
 * https://leetcode.com/problems/palindrome-number/
 * 
 * # [7. Reverse Integer](https://leetcode.com/problems/reverse-integer/description/)
 * 
 * Given a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.
 * 
 * **Assume the environment does not allow you to store 64-bit integers (signed or unsigned).** 
 * 
 * **Example 1:** 
 * 
 * ```
 * Input: x = 123
 * Output: 321
 * ```
 * 
 * **Example 2:** 
 * 
 * ```
 * Input: x = -123
 * Output: -321
 * ```
 * 
 * **Example 3:** 
 * 
 * ```
 * Input: x = 120
 * Output: 21
 * ```
 * 
 * **Constraints:** 
 * 
 * - `-2^31 <= x <= 2^31 - 1`
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
