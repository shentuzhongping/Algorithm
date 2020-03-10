package com.shentu;

import java.util.Arrays;

//基数排序
//依次取个位十位百位...进行计数排序得到结果
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {345,456,745,564,342,578};
        int maxLength = findMax(arr);
//        System.out.println(maxLength);
        arr = sort(arr,maxLength);
        print(arr);
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int n = 0;
        int division = 1;
        while (max/division != 0) {
            n++;
            division = (int)Math.pow(10,n);
        }
        return n;
    }

//    private static void swap(int[] arr,int i;int k) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    private static int[] sort(int[] arr,int m) {
        int[] result = new int[arr.length];
        int[] count = new int[10];
        for (int i = 0; i < m; i++) {
            int division = (int)Math.pow(10,i);
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j]/division%10;
                count[num]++;
            }
            for (int k = 1; k < count.length; k++) {
                count[k] = count[k] + count[k-1];
            }
//            System.out.print("count:");
//            print(count);
//            System.out.println();
            for (int n = arr.length-1; n >=0; n--) {
                int num = arr[n]/division%10;
                result[--count[num]] = arr[n];
            }
//            System.out.print("result:");
//            print(result);
//            System.out.println();
//            for (int t = 0;t < count.length;t++ ) {
//                count[t] = 0;
//            }
//            for (int t = 0; t < result.length; t++) {
//                arr[t] = result[t];
//            }
            System.arraycopy(result,0,arr,0,result.length);
            Arrays.fill(count,0);
        }
        return result;
    }


    public static void print(int[] arr) {
        for (int i = 0;i <arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
