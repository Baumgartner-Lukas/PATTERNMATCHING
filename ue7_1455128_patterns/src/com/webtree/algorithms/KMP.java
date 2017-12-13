package com.webtree.algorithms;

public class KMP {
    private static int count;

    public static Result search(String pattern, String text) throws IllegalArgumentException {
        if (pattern == null || text == null)
            throw new IllegalArgumentException("Provide pattern and/or text you want to search");
        int pLength = pattern.length();
        int tLength = text.length();
        int index = 0;
        int lmp[] = new int[pLength]; //lmp = longest matching Prefix
        int j = 0, i = 0; //index for pattern, index for text

        getLMP(pattern, pLength, lmp);

        while (i < tLength) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pLength) {
                count++;
                index = i-j;
                j = lmp[j-1];
            } else if (i < tLength && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lmp[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        //System.out.println(count + " patterns found. Last at index: " + index);
        return new Result(index, count);
    }

    private static void getLMP(String pattern, int pLength, int lmp[]) {
        int length = 0;
        int i = 1;
        lmp[0] = 0;

        while (i < pLength) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lmp[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lmp[length - 1];
                } else {
                    lmp[i] = length;
                    i++;
                }
            }

        }
    }


}
