package dsa.min_jumps;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Minimum Jumps:
 * https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
 * 
 * You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.
 * 
 * For example:
 * 
 * If arr[i] = 3, you can jump 1 step, 2 steps, or 3 steps forward from position i.
 * If arr[i] = 0, you cannot jump forward from that position.
 * Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.
 * 
 * Note:  Return -1 if you can't reach the end of the array.
 * 
 * Examples : 
 * 
 * Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
 * Output: 3 
 * Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. 
 * Input: arr = [1, 4, 3, 2, 6, 7]
 * Output: 2 
 * Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
 * Input: arr = [0, 10, 20]
 * Output: -1
 * Explanation: We cannot go anywhere from the 1st element.
 * Constraints:
 * 2 ≤ arr.size() ≤ 106
 * 0 ≤ arr[i] ≤ 105
 */
public class MinJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] a = new int[s];
        for (int i = 0; i < s; i++) {
            int t = sc.nextInt();
            a[i] = t;
        }
        System.out.println(minJumps(a));
        sc.close();
    }

    static int minJumps(int[] arr) {
        System.out.println(Arrays.toString(arr));
        // return checkJumpsToEnd(arr);
        return checkJumpsToEnd(arr, arr.length);
        // return checkJumpsToEnd(0, arr, 0);
    }
    /**
     * Greedy algo, might no return min jumps
     * @param arr array
     * @return jumps to reach by greedy way
     */
    static int checkJumpsToEnd(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        int maxReachable = 0;
        int jump = 0;
        for (int i = 0; i<n; i++) {
            if (i > maxReachable) {
                return -1;
            }
            if (maxReachable > n - 1) {
                break;
            }
            if (arr[i] + i > maxReachable) {
                maxReachable = arr[i] + i;
                System.out.println(MessageFormat.format("Jumping from {0} with value {1} and max reachable {2}", i, arr[i], maxReachable));
                jump++;
            }
        }

        return jump;
    }

    /**
     * Most optimal solution as it goes through each element and 
     * checks if from here I can jump further than the prev max
     * @param arr array
     * @param n length of array
     * @return min jumps
     */
    static int checkJumpsToEnd(int[] arr, int n) {
        if (n == 1) {
            return 0;
        }

        int ladder = arr[0];
        int steps = arr[0];
        int jump = 1;
        for (int i = 1; i < n; i++) {
            if (steps <= 0)
                return -1;
            if (i + arr[i] > ladder)
                ladder = i + arr[i];
            steps--;
            if (steps == 0 && i != n - 1) {
                jump++;
                // steps = ladder - i;
                steps = arr[i];
            }
        }

        return jump;
    }

    /**
     * Its a recursive solution complexity o(n^n)
     * @param position current position
     * @param arr array
     * @param currentJump current jump
     * @return jumps
     */
    static int checkJumpsToEnd(int position, int[] arr, int currentJump) {
        // System.out.println(String.format("checkJumpsToEnd args %d %d", position,
        // currentJump));
        if (position >= arr.length - 1) {
            return currentJump;
        }
        if (arr[position] == 0) {
            return -1;
        }
        int value = arr[position];
        // from 1 to value I can jump from this position

        int finalOutput = -1;
        for (int i = 1; i <= value; i++) {
            int output = checkJumpsToEnd(position + i, arr, currentJump + 1);
            // System.out.println(String.format("output %d", output));
            if (output != -1 && (finalOutput == -1 || finalOutput > output)) {
                finalOutput = output;
            }
        }
        return finalOutput;
    }
}
