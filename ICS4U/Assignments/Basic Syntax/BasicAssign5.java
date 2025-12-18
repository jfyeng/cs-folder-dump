// BasicAssign4.java
// James
// given a product code, this program determines whether the code is valid or invalid,
// based on a set of rules concerning the structure and digits in the code.
 
// The rules:
// 1st part can contain only capital letters and 6 digits.
// 2nd part is all digits and = the product of the first 6 digits taken in groups of two from the left. 
// The 2 parts are separated by a single space. 

import java.util.Scanner;

class BasicAssign5 {
	public static void main(String[] owo) {
		Scanner kb = new Scanner(System.in);

		// INPUT
		String line = kb.nextLine();

		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // capital letter reference
		String p1dig = ""; // digits found in part 1
		String p2dig = ""; // digits found in part 2
		boolean hop = false; // determines whether we're at part 1 or 2
		boolean valid = true; // valid or invalid code

		// PARSING THE STRING
		for (char c : line.toCharArray()) {
			if (!valid) break;

			// part 1
			if (!hop) {
				boolean flag = false;
				// is it a letter?
				for (char letter : alpha.toCharArray()) {
					if (c == letter) flag = true;
				}
				// is it a digit??
				if (Character.isDigit(c)) {
					p1dig += c; flag = true;
				}
				// are we hopping to the second part???
				if (c == ' ') {
					hop = true; flag = true;
				}

				if (!flag) valid = false;
			}
			// not part 1
			else if (hop) {
				boolean flag = false;
				// if not digit, invalid
				if (Character.isDigit(c)) {
					p2dig += c; flag = true;
				}

				if (!flag) valid = false;
			}
		}

		// check numbers and see if they match up
		if (p1dig.length() != 6) valid = false; // make sure we have 6 digits
		else {
			if (p2dig.length() < 1) valid = false;
			else {
				// make sure it multiplies up
				int prod = Integer.parseInt(p1dig.substring(0,2)) * Integer.parseInt(p1dig.substring(2,4)) * Integer.parseInt(p1dig.substring(4,6));
				if (prod != Integer.parseInt(p2dig)) {
					valid = false;
				}
				// System.out.println(prod); // DEBUG
			}
		}

		// System.out.println(p1dig); // DEBUG
		// System.out.println(p2dig); // DEBUG

		// OUTPUT
		if (valid) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}
	}
}

// I'm a little worried that there's corner cases that this code will fail on...