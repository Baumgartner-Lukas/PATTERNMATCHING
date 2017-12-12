package com.webtree.algorithms;

public class KMP {
    private static int[] failure;
    private static int count;

    public static Result search(String pattern, String text) throws IllegalArgumentException {
        if (pattern == null || text == null)
            throw new IllegalArgumentException("Provide pattern and/or text you want to search");

        failure = new int[pattern.length()];
        failFunction(pattern);
        int index = positionMatch(text, pattern);

        if (index == -1) {
            return new Result(-1, 0);
        } else {
            System.out.println("Pattern at index " + index + " Pattern found: " + count + " times.");
            return new Result(index, count);
        }
    }

    private static int positionMatch(String text, String pattern) {
        int i = 0, j = 0;
        int stringLength = text.length();
        int patternLength = pattern.length();

        while (i < stringLength) {
            j = 0;
            while (i < stringLength && j < patternLength) {
                if (text.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                } else if (j == 0)
                    i++;
                else
                    j = failure[j - 1] + 1;
            }
            count++;
        }
        return ((count != 0) ? (i - patternLength) : -1);
    }

    private static void failFunction(String pattern) {
        int n = pattern.length();
        failure[0] = -1;
        for (int j = 1; j < n; j++) {
            int i = failure[j - 1];
            while ((pattern.charAt(j) != pattern.charAt(i + 1)) && i >= 0)
                i = failure[i];
            if (pattern.charAt(j) == pattern.charAt(i + 1))
                failure[j] = i + 1;
            else
                failure[j] = -1;
        }
    }
}
