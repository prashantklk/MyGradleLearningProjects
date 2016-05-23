package com.math.expr.calc;

import java.util.Stack;

public class MathCalc {

	public static void main(String[] args) {
		String needTocalc = "( + 3 10 ( * 5 2 ) 10 ( - 6 3 ) )";
		int totalSum = 0;
		System.out.println("calculating : " + needTocalc);
		
		String[] strArray = needTocalc.split(" ");
		Stack<String> strStack = new Stack<String>();
		for (int i=0;i<strArray.length;i++) {
			if (strArray[i].equalsIgnoreCase(")")) {
				Stack<Integer> valuesStack = new Stack<Integer>();
				while (!strStack.empty()) {
					String str = strStack.pop();
					if (str.equalsIgnoreCase("*") || str.equalsIgnoreCase("+") || str.equalsIgnoreCase("-") || str.equalsIgnoreCase("/")) {
						totalSum = calculate(str.trim(), valuesStack);
						strStack.push(""+totalSum);
						break;
					} else if (!str.equalsIgnoreCase("(")){
						valuesStack.push(Integer.parseInt(str));
					}
				}
			} else {
				strStack.push(strArray[i].trim());
			}
		}
		System.out.println("SUM - " + totalSum);
	}
	
	public static int calculate(String op, Stack<Integer> values) {
		int total = 0;
		if (op.equalsIgnoreCase("*") || op.equalsIgnoreCase("-")) {
			total = values.pop();
		}
		while (!values.empty()) {
			if (op.equalsIgnoreCase("*")) {
				total = total * values.pop();
			} else if (op.equalsIgnoreCase("+")) {
				total = total + values.pop();
			} else if (op.equalsIgnoreCase("-")) {
				total = total - values.pop();
			} else if (op.equalsIgnoreCase("/")) {
				total = total / values.pop();
			}
		}
		return total;
	}
}
