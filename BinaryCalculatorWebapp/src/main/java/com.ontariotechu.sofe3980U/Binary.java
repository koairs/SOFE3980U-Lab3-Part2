package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number = "0";

	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0";
			return;
		}

		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0";
				return;
			}
		}

		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') break;
		}

		this.number = (beg == number.length()) ? "0" : number.substring(beg);

		if (this.number.isEmpty()) this.number = "0";
	}

	public String getValue() {
		return this.number;
	}

	/* ADDITION */
	public static Binary add(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		int carry = 0;
		String num3 = "";

		while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
			int sum = carry;
			if (ind1 >= 0) sum += (num1.number.charAt(ind1--) == '1') ? 1 : 0;
			if (ind2 >= 0) sum += (num2.number.charAt(ind2--) == '1') ? 1 : 0;

			carry = sum / 2;
			num3 = ((sum % 2 == 0) ? "0" : "1") + num3;
		}
		return new Binary(num3);
	}

	/* MULTIPLICATION */
	public static Binary multiply(Binary num1, Binary num2) {
		int a = Integer.parseInt(num1.number, 2);
		int b = Integer.parseInt(num2.number, 2);
		return new Binary(Integer.toBinaryString(a * b));
	}

	/* BITWISE AND */
	public static Binary and(Binary num1, Binary num2) {
		int a = Integer.parseInt(num1.number, 2);
		int b = Integer.parseInt(num2.number, 2);
		return new Binary(Integer.toBinaryString(a & b));
	}

	/* BITWISE OR (|) */
	public static Binary or(Binary num1, Binary num2) {
		int a = Integer.parseInt(num1.number, 2);
		int b = Integer.parseInt(num2.number, 2);
		return new Binary(Integer.toBinaryString(a | b));
	}
}
