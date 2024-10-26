package dsa.iowrapper_test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Output:");
        int s = sc.nextInt();
        System.out.println(s);
        for(int i = 0; i < s; i++) {
            int a = sc.nextInt();
            System.out.println(a);
        }
        sc.close();
    }
}
