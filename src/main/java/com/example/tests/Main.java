package com.example.tests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        System.out.println((int) ((f - 32) / (9 / 5.0)));
    }
}
