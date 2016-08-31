package com.first_time;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int a = in.nextInt();
        	int b = in.nextInt();
        	
        	System.out.println(in.nextLine());
        	System.out.println(a + b);
        }
    }
}
