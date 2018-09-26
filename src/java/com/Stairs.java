package com;

import java.util.Scanner;

public class  Stairs {

	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int _n;
        System.out.println ("Please enter the number of Stairs");
        _n = Integer.parseInt(in.nextLine().trim());
        
        StairCase(_n);
        
    }
	
	static void StairCase(int n) {
        if (n > 0 && n < 101) {
            for (int i=1; i<(n+1); i++) {
                for (int j=i; j<n; j++){
                    System.out.print (" ");
                }
                for (int j=1; j<(i+1);j++) {
                    System.out.print ("#");    
                }
                System.out.println ("");
            }
        } else {
        	throw new IllegalArgumentException("Starcase rows should be between 1 and 100");
        }

    }

}
