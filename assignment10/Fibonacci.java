package assignment10;

public class Fibonacci {

	static void fib(int n) {
		int f1 = 0;
		int f2 = 1;
		int fib = 0;
		for (int i = 1; i <= n; i++) {
			System.out.print(f1 + " ");
			fib = f1 + f2;
			f1 = f2;
			f2 = fib;
		}
	}

	public static void main(String[] args) {
		fib(10);
	}

}
