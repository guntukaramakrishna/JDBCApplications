package com.jdbc;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number");
		int a = sc.nextInt();
		System.out.println(a);
		sc.skip("\r\n");
		System.out.println("Enter value");
		String v = sc.nextLine();
		System.out.println(v);
	}
}
