package dsa.gcd_lcm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two integers a and b, write a function lcmAndGcd() to compute their LCM
 * and GCD. The function inputs two integers a and b and returns a list
 * containing their LCM and GCD.
 * 
 * Examples:
 * 
 * Input: a = 5 , b = 10
 * Output: [10, 5]
 * Explanation: LCM of 5 and 10 is 10, while their GCD is 5.
 * Input: a = 14 , b = 8
 * Output: [56, 2]
 * Explanation: LCM of 14 and 8 is 56, while their GCD is 2.
 * Input: a = 1 , b = 1
 * Output: [1, 1]
 * Explanation: LCM of 1 and 1 is 1, while their GCD is 1.
 * Expected Time Complexity: O(log(min(a, b))
 * Expected Auxiliary Space: O(1)
 * 
 * Constraints:
 * 1 <= a, b <= 10^9
 * 
 * Solution
 * GCD
 * Eucleadian Equation
 * GCD(a, b) = GCD(a-b, b) for all a>b
 * this can be converted to
 * GCD(a, b) = GCD(a%b, b) for all a>b
 * 
 * Also LCM(a, b) = (a * b)/GCD(a, b)
 */
public class GCDLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(Arrays.toString(lcmAndGcd(a, b)));
            // System.out.println(calcGCD(a, b));
            // System.out.println(calcLCM(a, b));
        }
        sc.close();
    }

    // static long calcGCD(long a, long b) {
    //     long reminder = 1;

    //     while (a != 0 && b != 0) {
    //         if (a > b) {
    //             reminder = a % b;
    //             a = reminder;
    //         } else {
    //             reminder = b % a;
    //             b = reminder;
    //         }
    //     }
    //     if (a == 0) {
    //         return b;
    //     } else {
    //         return a;
    //     }
    // }

    static long calcGCD(long a, long b) {
        while (true) {
            if (a > b) {
                a = a%b;
            } else {
                b = b%a;
            }
            if (a==0 || b==0) {
                break;
            }
        }
        return Math.max(a, b);
    }

    static long calcLCM(long a, long b) {
        return a * (b / calcGCD(a, b));
    }

    static Long[] lcmAndGcd(Long a, Long b) {
        long lcm = calcLCM(a, b);
        long gcd = calcGCD(a, b);
        return new Long[] { lcm, gcd };
    }

    static long calcGCDBruteForce(long a, long b) {
        if (a == 1 || b == 1) {
            return 1;
        }
        long min = Math.min(a, b);
        long currentGCD = 1;
        boolean bothEven = false;
        if (a % 2 == 0 && b % 2 == 0) {
            bothEven = true;
        }
        for (long i = 1; i <= min;) {
            // System.out.println("checking with i: " + i);
            if (a % i == 0 && b % i == 0) {
                currentGCD = i;
            }
            if (bothEven) {
                i++;
            } else {
                // always check with odd
                i += 2;
            }
            // System.out.println("next i: " + i);
        }
        return currentGCD;
    }

    static long calcLCMBruteForce2(long a, long b) {
        long greater = Math.max(a, b);
        long smallest = Math.min(a, b);
        for (long i = greater;; i += greater) {
            if (i % smallest == 0)
                return i;
        }
    }

    static long calcLCMBruteForce(long a, long b) {
        if (a == 1 || b == 1) {
            return Math.max(a, b);
        }
        long lcm = 1;
        while (true) {
            long gcd = calcGCD(a, b);
            // System.out.println("gcd("+a+", "+b+")="+ gcd);
            if (gcd == 1) {
                long max = Math.max(a, b);
                gcd = max;
            }
            // System.out.println("overridden gcd("+a+", "+b+")="+ gcd);
            lcm = gcd * lcm;
            // System.out.println("lcm="+lcm);
            if (a % gcd == 0) {
                a = a / gcd;
            }
            if (b % gcd == 0) {
                b = b / gcd;
            }
            if (a == 1 && b == 1) {
                break;
            }
        }
        return lcm;
    }
}
