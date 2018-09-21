package com;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LookAndSayTest {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }
        
        int _n;
        _n = Integer.parseInt(in.nextLine());
        
        res = LookAndSay(_start, _n);
        bw.write(res);
        bw.newLine();
        
        bw.close();
    }
    
    static String LookAndSay(String start, int n) {
    	for (int i=0; i<n; i++) {
    		start = LookAndSay(start);
    	}
    	return start;
    }
    
    static String LookAndSay (String start) {
    	String lookedAndSaidNumber = "";
    	int previousDigit = -1;
    	int groupCount = 0;
    	for (int i=0; i< start.length(); i++) {
    		int digitParsed = Integer.parseInt(String.valueOf(start.charAt(i)));
    		if (previousDigit == -1) {
    			previousDigit = digitParsed;
    		}  
			if (digitParsed == previousDigit) {
				groupCount ++;
			} else {
				lookedAndSaidNumber += String.valueOf(groupCount) + String.valueOf(previousDigit);
				groupCount = 1;
				previousDigit = -1;
			}
			
			if (i == (start.length()-1)) {
				lookedAndSaidNumber += String.valueOf(groupCount) + String.valueOf(digitParsed);
			}
    	}
    	return lookedAndSaidNumber;
    }
}

