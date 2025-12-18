package dsa.merge_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] a = new int[s];
        for (int i = 0; i < s; i++) {
            int t = sc.nextInt();
            a[i] = t;
        }
        System.out.println(Arrays.toString(a));
        mergeSort(a, 0, s - 1);
        System.out.println(Arrays.toString(a));
        sc.close();
    }

    static public void mergeSort(int arr[], int l, int r) {
        if (l>=r) return;
        int m = (l + r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        
        merge(arr, l, m, r);
    }
    
    static public void merge(int arr[], int l, int m, int r) {
        // System.out.println("start : " + l + " " + m + " " + r);

        // for (int k = l; k<=r; k++) {
        //     System.out.print(arr[k] + " ");
        // }
        // System.out.println();
        int left = l;
        int right = m+1;
        List<Integer> temp = new ArrayList<>();
        while (left <=m && right <= r) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            } 
        }
        
        while(left<=m) {
            temp.add(arr[left++]);
        }
        
        while(right<=r) {
            temp.add(arr[right++]);
        }
        
        for (int k = l; k<=r; k++) {
            arr[k] = temp.get(k - l);
        }
        // System.out.println("end : " + l + " " + m + " " + r + " " + temp.toString());
        // for (int k = l; k<=r; k++) {
        //     System.out.print(arr[k] + " ");
        // }
        // System.out.println();
        // System.out.println("-----");
    }
}
