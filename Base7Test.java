package com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Base7Test {

	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        int _n;
        _n = Integer.parseInt(in.nextLine());
        
        res = base7 (_n);
        bw.write(res);
        bw.newLine();
        
        bw.close();
    }
	
	static String base7(int input) {
	
		String[] base7mapping =  {"0", "a", "t", "l", "s", "i", "n"};
        String base7 = "";
        while (input > 6) {
        	base7 =  base7mapping[input % 7] + base7;
        	input /= 7;
        }
        base7 =  base7mapping[input] + base7;
        
        System.out.println(base7);
        return base7;
	}

}
