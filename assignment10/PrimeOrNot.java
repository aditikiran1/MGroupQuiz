package assignment10;

import java.util.Scanner;

public class PrimeOrNot {

	public static boolean decidePrime(int n) {

		if (n == 0 || n == 1)
			return false;

		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		if (decidePrime(num))
			System.out.println("Number is prime");
		else
			System.out.println("Number is not prime");
		sc.close();
	}
}