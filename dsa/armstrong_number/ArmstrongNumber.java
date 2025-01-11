package dsa.armstrong_number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Problem statement
 * You are given an integer 'n'. Return 'true' if 'n' is an Armstrong number,
 * and 'false' otherwise.
 * 
 * 
 * An Armstrong number is a number (with 'k' digits) such that the sum of its
 * digits raised to 'kth' power is equal to the number itself. For example, 371
 * is an Armstrong number because 3^3 + 7^3 + 1^3 = 371.
 * 
 * Detailed explanation ( Input/output format, Notes, Images )
 * Sample Input 1 :
 * 1
 * 
 * 
 * Sample Output 1 :
 * true
 * 
 * 
 * Explanation of Sample Input 1 :
 * 1 is an Armstrong number as, 1^1 = 1.
 * 
 * 
 * Sample Input 2 :
 * 103
 * 
 * 
 * Sample Output 2 :
 * false
 * 
 * 
 * Sample Input 3 :
 * 1634
 * 
 * 
 * Sample Output 3 :
 * true
 * 
 * 
 * Explanation of Sample Input 3 :
 * 1634 is an Armstrong number, as 1^4 + 6^4 + 3^4 + 4^4 = 1634
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            String a = sc.next();
            System.out.println(checkIfArmstrongNumber(a));
        }
        sc.close();
    }

    private static boolean checkIfArmstrongNumber(String a) {
        int finalNumber = Integer.parseInt(a);
        if (finalNumber == 1) {
            return true;
        }
        List<Integer> numbers = Arrays.asList(a.split("")).stream().map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());
        // System.out.println(numbers.toString());
        Collections.sort(numbers, Collections.reverseOrder());
        // System.out.println(numbers.toString());

        int highestNumber = numbers.get(0);
        int maxPower = 1;

        while (true) {
            if (highestNumber == 1) {
                break;
            }
            if (Math.pow(highestNumber, maxPower) > finalNumber) {
                break;
            } else {
                maxPower++;
            }
        }

        // System.out.println("maxPower "+maxPower);

        for (int i = maxPower; i >= 1; i--) {
            int sum = 0;
            for (int number : numbers) {
                sum += Math.pow(number, i);
            }
            if (sum == finalNumber) {
                return true;
            }
        }

        return false;
    }
}
