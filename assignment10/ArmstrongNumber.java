package assignment10;

// sum of the cubes of digits is equal to the number itself

public class ArmstrongNumber {
	public static void main(String[] args) {
		int num = 153;
		int newNum = num;
		int digit;
		int sum = 0;
		while (num != 0) {
			digit = num % 10;
			sum = sum + digit * digit * digit;
			num = num / 10;
		}
		if (sum == newNum) {
			System.out.println("an armstrong number");
		} else {
			System.out.println("not an armstrong number");
		}
	}
}
