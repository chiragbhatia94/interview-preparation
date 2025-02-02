package dsa.missing_number;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Missing Number:
 * https://leetcode.com/problems/missing-number/description/
 * 
 * # [268. Missing Number](https://leetcode.com/problems/missing-number/description/)
 * 
 * Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.
 * 
 * **Example 1:** 
 * 
 * <div class="example-block">
 * Input: nums = [3,0,1]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * `n = 3` since there are 3 numbers, so all numbers are in the range `[0,3]`. 2 is the missing number in the range since it does not appear in `nums`.
 * 
 * **Example 2:** 
 * 
 * <div class="example-block">
 * Input: nums = [0,1]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * `n = 2` since there are 2 numbers, so all numbers are in the range `[0,2]`. 2 is the missing number in the range since it does not appear in `nums`.
 * 
 * **Example 3:** 
 * 
 * <div class="example-block">
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * 
 * Output: 8
 * 
 * Explanation:
 * 
 * `n = 9` since there are 9 numbers, so all numbers are in the range `[0,9]`. 8 is the missing number in the range since it does not appear in `nums`.
 * 
 * <div class="simple-translate-system-theme" id="simple-translate">
 * 
 * <div class="simple-translate-button isShow" style="background-image: url(&quot;moz-extension://8a9ffb6b-7e69-4e93-aae1-436a1448eff6/icons/512.png&quot;); height: 22px; width: 22px; top: 318px; left: 36px;">
 * 
 * <div class="simple-translate-panel" style="width: 300px; height: 200px; top: 0px; left: 0px; font-size: 13px;">
 * <div class="simple-translate-result-wrapper" style="overflow: hidden;">
 * <div class="simple-translate-move" draggable="true">
 * 
 * <div class="simple-translate-result-contents">
 * <p class="simple-translate-result" dir="auto">
 * 
 * <p class="simple-translate-candidate" dir="auto">
 * 
 * **Constraints:** 
 * 
 * - `n == nums.length`
 * - `1 <= n <= 10^4`
 * - `0 <= nums[i] <= n`
 * - All the numbers of `nums` are **unique** .
 * 
 * **Follow up:**  Could you implement a solution using only `O(1)` extra space complexity and `O(n)` runtime complexity?
 */
public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] a = new int[s];
        for (int i = 0; i < s; i++) {
            int t = sc.nextInt();
            a[i] = t;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(missingNumber(a));
        sc.close();
    }

    static int missingNumber(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int sumOfSeries = 0;
        if (len % 2 == 0) {
            sumOfSeries = (len / 2) * (len + 1);
        } else {
            sumOfSeries = len * ((len + 1) / 2);
        }
        return sumOfSeries - sum;
    }
}
