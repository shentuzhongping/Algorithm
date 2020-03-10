package com.shentu;
//快速排序
public class SinglePivotQuickSort {
    public static void main(String[] args) {
        int[] arr = {10,6,2,6,3,6,1,8,9,6,6};
//        int[] arr = {4,6};
        sort(arr,0,arr.length-1);
        print(arr);
    }

    public static void sort (int[] arr,int leftBound, int rightBound) {
        if (leftBound == rightBound) return;
        int mid = partition(arr,leftBound,rightBound);
        if (mid == leftBound) {
            sort(arr,mid+1,rightBound);
        } else if (mid == rightBound) {
            sort(arr,leftBound,mid-1);
        } else {
            sort(arr,leftBound,mid-1);
            sort(arr,mid+1,rightBound);
        }


    }

    public static int partition (int[] arr,int left,int right) {
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && arr[i] < pivot) i++;
            while (i <= j && arr[j] >= pivot) j--;
            if (i < j) swap(arr,i,j);
        }

        swap(arr,left,j);
        return j;
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr) {
        for (int i = 0;i <arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
