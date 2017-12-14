package com.webtree;

import com.webtree.algorithms.KMP;
import com.webtree.algorithms.RabinKarp;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //KMP.search("xxx", "abcdexxxunbxxxxke");
        System.out.println("KMP: ");
        System.out.println(KMP.search("xxx", "abcdexxxunbxxxxke"));

        System.out.println("RabinKarp: ");
        System.out.println(RabinKarp.search("xxx", "abcdexxxunbxxxxke"));
    }
}
