package dsa.count_digits;

import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/count-digits5716/1

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
