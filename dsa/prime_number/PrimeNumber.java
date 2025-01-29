package dsa.prime_number;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Check for Prime Number: https://www.geeksforgeeks.org/check-for-prime-number/
 * 
 * Input:  n = 10
 * Output: false
 * Explanation: 10 is divisible by 2 and 5 
 * 
 * Input:  n = 11
 * Output: true
 * Explanation: 11 is divisible by 1 and 11 only
 * 
 * Input:  n = 1
 * Output: false
 * Explanation: 1 is neither composite nor prime
 * 
 * Input:  n = 0
 * Output: false
 * Explanation: 0 is neither composite nor prime
 */
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            String a = sc.next();
            System.out.println(checkIfPrimeNumber(a));
        }
        sc.close();
    }

    private static boolean checkIfPrimeNumber(String a) {
        List<Integer> divisors = findAllDivisors(Integer.parseInt(a));
        System.out.println("divisors of " + a + " are "+ divisors.toString());
        if (divisors.size() == 2) {
            return true;
        }
        return false;
    }

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
