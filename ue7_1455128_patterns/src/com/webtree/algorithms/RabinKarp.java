package com.webtree.algorithms;

public class RabinKarp {
    private static int count;
    private static int index;


    public static Result search(String pattern, String text) throws IllegalArgumentException {
        if (pattern == null || text == null || (pattern.length() > text.length()))
            throw new IllegalArgumentException("Error with input");
        char[] pArray = pattern.toCharArray();
        int pHash = getHashValue(pArray);
        int pos = 0;

        while (pos + pattern.length() < text.length()) {
            String tPart = ""; //used for matching
            for (int i = 0; i < pattern.length(); i++) {
                tPart += text.charAt(pos + i);
            }
            int tHash = getHashValue(tPart.toCharArray());
            if (pHash == tHash) {
                for (int i = 0; i < pattern.length(); i++) {
                    if (pattern.charAt(i) != text.charAt(pos + i)) {
                        break;
                    } else if (i == pattern.length() - 1) {
                        count++;
                        index = pos;
                    }
                }
            }
            pos++;
        }

        return new Result(index, count);
    }

    static private int getHashValue(char[] c) {
        int vHash = 0;
        for (int i = 0; i < c.length; i++) {
            vHash = (c[i] * pow(10, (c.length - i - 1)) + vHash) % 101;
        }
        return vHash;
    }

    static private int pow(int base, int exp) {
        return (int) Math.pow(base, exp);
    }


}
