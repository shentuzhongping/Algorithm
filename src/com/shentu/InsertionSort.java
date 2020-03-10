package com.shentu;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,3,5,9,4,6,2,7};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            for (int j = i; j > 0; j--) {
                //大的往后挪一位
                if (temp < arr[j-1]) {
                   arr[j] = arr[j-1];
                   index = j-1;
                }
            }
            arr[index] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
