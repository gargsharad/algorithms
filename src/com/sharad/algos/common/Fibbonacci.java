package com.sharad.algos.common;

public class Fibbonacci {

    public static int generateNumbers(int n) {
	
	if (n == 1 || n == 2) {
	    return  1;
	} else {
	    return  generateNumbers(n - 1) + generateNumbers(n - 2);
	}
    }

    public static void main(String[] args) {
	for(int i=1; i<=10; i++){
            System.out.print(generateNumbers(i) +" ");
        }
	
	/*int range = 0;
	if (args[0].isEmpty()) {
	    System.out.println("Please provide an input");
	} else {
	    range = Integer.parseInt(args[0]);
	    

	}*/

    }
}