package com.webtree.algorithms;

public class RabinKarp {


    public static Result search(String pattern, String text) throws IllegalArgumentException {
        if (pattern == null || text == null)
            throw new IllegalArgumentException("Provide pattern and/or text you want to search");
        char[] pArray = pattern.toCharArray();
        int pHash = getHashValue(pArray);
        return null;
    }

    static private int getHashValue(char[] c){

        return 0;
    }

    static private int pow(int base, int exp){
        return 0;
    }



}
