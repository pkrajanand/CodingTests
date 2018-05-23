package com;

import org.springframework.util.Assert;

public class WordPlay {
    public String solution(String S, String T) {
        if (S.equalsIgnoreCase(T)) {
            return "NOTHING";
        } else if (Math.abs(S.length() - T.length()) > 1) {
            return "IMPOSSIBLE";
        } else {
            int smallerArrayLength = Math.min(S.length(), T.length());
            for (int i = 0; i < smallerArrayLength; i++) {
                if (S.charAt(i) != T.charAt(i)) {
                    if (S.length() == T.length()) {
                        if (S.charAt(i) == T.charAt(i + 1) && S.charAt(i + 1) == T.charAt(i)) {
                            return "SWAP " + S.charAt(i) + " " + T.charAt(i);
                        }
                    } else if (S.length() > T.length()) {
                        if (S.charAt(i + 1) == T.charAt(i)) {
                            return "DELETE " + S.charAt(i);
                        }
                    } else {
                        if (S.charAt(i) == T.charAt(i + 1)) {
                            return "INSERT " + T.charAt(i);
                        }
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }


    public static void main(String[] args) {
        WordPlay wordPlay = new WordPlay();
        
        String solution1 = wordPlay.solution("nice", "niece");
		System.out.println(solution1);
        Assert.isTrue(solution1.equals("INSERT e"), "solution is "+solution1+", instead of INSERT e");
        
        String solution2 = wordPlay.solution("niece", "nice");
		System.out.println(solution2);
        Assert.isTrue(solution2.equals("DELETE e"), "solution is "+solution2+", instead of DELETE e");
        
        String solution3 = wordPlay.solution("nice", "nice");
		System.out.println(solution3);
        Assert.isTrue(solution3.equals("NOTHING"), "solution is "+solution3+", instead of NOTHING");
        
        String solution4 = wordPlay.solution("o", "odd");
		System.out.println(solution4);
        Assert.isTrue(solution4.equals("IMPOSSIBLE"), "solution is "+solution4+", instead of IMPOSSIBLE");
    }
}
