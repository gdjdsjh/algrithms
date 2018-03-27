package com.lean.sjh;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        char[][] arr2 = {{'0','0','0','1','0','0','0'},{'0','0','1','1','1','0','0'},{'0','1','1','1','1','1','0'}};

        //int output = new Topic84().answer(arr);
        int output = new Topic85().answer(arr2);
        System.out.println(output);
    }
}
