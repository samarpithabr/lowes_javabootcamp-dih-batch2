package com.lamda;

import java.util.function.BiFunction;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//BiFunction<Integer, Integer,Integer> add=(a,b)->a+b;
//BiFunction<Integer, Integer, Integer> sub=(a,b)->a-b;
//BiFunction<Integer, Integer, Integer> mul=(a,b)->a*b;
//BiFunction<Integer, Integer, Integer> div=(a,b)->a/b;
////System.out.println(doCalculate(20,10 , div));
//System.out.println(doCalculate(20,10 , add));
//System.out.println(doCalculate(20,10 , sub));
//System.out.println(doCalculate(20,10 , mul));


	}


private static int doCalculate(int a,int b,BiFunction operation) {
	return operation.calculate(a, b);
}public Calculator() {
	// TODO Auto-generated constructor stub
}
interface BiFunction{
	int operation(int a,int b);

	int calculate(int a, int b);
}

}
