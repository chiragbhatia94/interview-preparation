package dsa.freq_most_freq_element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * # [1838. Frequency of the Most Frequent
 * Element](https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/)
 * 
 * The **frequency** of an element is the number of times it occurs in an array.
 * 
 * You are given an integer array `nums` and an integer `k`. In one operation,
 * you can choose an index of `nums` and increment the element at that index by
 * `1`.
 * 
 * Return the **maximum possible frequency** of an element after performing **at
 * most** `k` operations.
 * 
 * **Example 1:**
 * 
 * ```
 * Input: nums = [1,2,4], k = 5
 * Output: 3**
 * Explanation:** Increment the first element three times and the second element
 * two times to make nums = [4,4,4].
 * 4 has a frequency of 3.```
 * 
 * **Example 2:**
 * 
 * ```
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a
 * frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a
 * frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a
 * frequency of 2.
 * ```
 * 
 * **Example 3:**
 * 
 * ```
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 * ```
 * 
 * **Constraints:**
 * 
 * - `1 <= nums.length <= 10^5`
 * - `1 <= nums[i] <= 10^5`
 * - `1 <= k <= 10^5`
 */
public class FrequencyOfMostFrequentElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] a = new int[s];
        for (int i = 0; i < s; i++) {
            int t = sc.nextInt();
            a[i] = t;
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(a));
        System.out.println(k);
        System.out.println(maxFrequency(a, k));
        sc.close();
    }

    static public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int a : nums) {
            int freq = freqMap.getOrDefault(a, 0);
            freqMap.put(a, ++freq);
        }

        int[] keys = freqMap.keySet().stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(keys);
        reverseArray(keys);
        System.out.println(Arrays.toString(keys));
        int highestFreqElement = keys[0];
        int highestFreq = 1;
        for (int i = 0; i < keys.length; i++) {
            int currentFreq = freqMap.get(keys[i]);
            int operationsLeft = k;
            for (int j = i + 1; j < keys.length; j++) {
                int key = keys[j];
                int diff = keys[i] - key;
                if (operationsLeft >= diff) {
                    int freq = freqMap.get(key);
                    // System.out.println("high cardinality key " + key);
                    // System.out.println("cardinality " + freq);
                    // System.out.println("diff " + diff);
                    // System.out.println("operationsLeft " + operationsLeft);
                    // System.out.println("currentFreq " + currentFreq);
                    int maxConversions = operationsLeft / diff;
                    if (freq > maxConversions) {
                        operationsLeft = operationsLeft % diff;
                        currentFreq += maxConversions;
                    } else {
                        operationsLeft -= freq * diff;
                        currentFreq += freq;
                    }
                    // System.out.println("currentFreq " + currentFreq);
                    // System.out.println("operationsLeft " + operationsLeft);
                } else {
                    break;
                }
            }
            if (currentFreq > highestFreq) {
                highestFreq = currentFreq;
                highestFreqElement = keys[i];
            }
        }
        // System.out.println(highestFreqElement);
        // System.out.println(highestFreq);
        return highestFreq;
    }

    static public void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
