package dsa.sum_of_divisors;

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
public class SumOfDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < s; i++) {
            int a = sc.nextInt();
            List<Integer> divisors = findAllDivisors(a);
            // System.out.println(i + " divisors : " + divisors);
            for (int divisor : divisors) {
                sum += divisor;
            }
        }
        System.out.println("Sum of divisors: " + sum);
        sc.close();
    }

    // private static List<Integer> findAllDivisors(int a) {
    // List<Integer> divisors = new ArrayList<>();
    // for (int i = 1; i <= a / 2; i++) {
    // if (a % i == 0) {
    // divisors.add(i);
    // }
    // }
    // divisors.add(a);
    // return divisors;
    // }

    private static List<Integer> findAllDivisors(int a) {
        Set<Integer> divisors = new HashSet<>();
        // divisors.add(1);
        // divisors.add(a);
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                divisors.add(i);
                divisors.add(a / i);
            }
        }
        return List.copyOf(divisors);
    }
}
