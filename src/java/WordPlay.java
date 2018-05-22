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

        System.out.println(wordPlay.solution("nice", "niece"));
        System.out.println(wordPlay.solution("niece", "nice"));
        System.out.println(wordPlay.solution("nice", "nice"));
        System.out.println(wordPlay.solution("o", "odd"));
    }
}
