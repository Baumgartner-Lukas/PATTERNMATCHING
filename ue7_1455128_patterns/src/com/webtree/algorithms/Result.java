package com.webtree.algorithms;

public class Result {
    private int resultIndex;
    private int count;

    public Result(int resultIndex, int count){
        this.resultIndex = resultIndex;
        this.count = count;
    }

    public String toString() {
        return "Result{"  + resultIndex +
                "," + count +
                '}';
    }
}
