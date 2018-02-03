package com.zou.juc2;

import java.util.Arrays;
import java.util.List;

public class ThreadTest7 {


    public static int add(List<Integer> list) {

        return list.parallelStream().mapToInt(a -> a).sum();
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 6);

        System.out.println(add(list));
    }


}























