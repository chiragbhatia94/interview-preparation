package dsa.count_digits;

import java.util.Scanner;

/**
 * Count Digits: https://www.geeksforgeeks.org/problems/count-digits5716/1
 * Given a positive integer n, count the number of digits in n that divide n evenly (i.e., without leaving a remainder). Return the total number of such digits.
 * 
 * A digit d of n divides n evenly if the remainder when n is divided by d is 0 (n % d == 0).
 * Digits of n should be checked individually. If a digit is 0, it should be ignored because division by 0 is undefined.
 * 
 * Examples :
 * 
 * Input: n = 12
 * Output: 2
 * Explanation: 1, 2 when both divide 12 leaves remainder 0.
 * Input: n = 2446
 * Output: 1
 * Explanation: Here among 2, 4, 6 only 2 divides 2446 evenly while 4 and 6 do not.
 * Input: n = 23
 * Output: 0
 * Explanation: 2 and 3, none of them divide 23 evenly.
 * Constraints:
 * 1<= n <=105
 */
public class CountDigitsSolution {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int s = sc.nextInt();
        for(int i = 0; i < s; i++) {
            int a = sc.nextInt();
            System.out.println(evenlyDivides(a));
        }
        sc.close();
    }

    static int evenlyDivides(int N){
        // code here
        int output = 0;
        int i = N;
        while (i > 0) {
            int remainder = i % 10;
            i = i/10;
            if (remainder != 0 && N%remainder == 0) {
                output++;
            }
        }
        return output;
    }
}
