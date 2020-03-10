package com.shentu;
//适合量大但数值的取值范围比较小的时候
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {10,6,2,6,3,6,1,8,9,6,6};
        sort(arr);
        print(arr);
    }

    private static void sort(int[] arr) {
        int length = arr.length;

        int[] result = new int[length];
        //定义一个取值范围长度的数组
        int[] countArr = new int[11];
        //将原数组的数计数到计数数组中
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
//        //依次填写结果数组
//        int k = 0;
//        for (int i = 0;i < countArr.length; i++) {
//            while (countArr[i] > 0) {
//                result[k++] = i;
//                countArr[i]--;
//            }
//        }
        //为了使排序稳定，对计数数组再处理一下
        //这样计数数组中的元素表示：未来在结果数组中某个数的脚标-1
        for (int j = 1; j < countArr.length; j++) {
            countArr[j] = countArr[j] + countArr[j-1];
        }
        //反向遍历原数组,填写结果数组
        int r = 0;
        for (int k = arr.length-1; k >= 0; k--) {
            result[--countArr[arr[k]]] = arr[k];
        }
        System.out.print("result:");
        print(result);
        System.out.println();

        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
    }


    public static void print(int[] arr) {
        for (int i = 0;i <arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
