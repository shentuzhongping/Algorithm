package com.shentu;

public class MergSort {
    public static void main(String[] args) {
        int[] arr = {9,4,3,5,2,1,8,6,7};
        sort(arr,0,arr.length-1);
        print(arr);
    }

    public static void sort(int[] arr,int left,int right) {
        if (left == right) return;
        int mid = left + (right-left)/2;
        //排左边
        sort(arr,left,mid);
        //排右边
        sort(arr,mid+1,right);

        mergSort(arr,left,mid + 1,right);

    }

//    public static int[] sort(int[] arr) {
//        if (arr.length == 2) {
//            swap(arr);
//            return arr;
//        } else if (arr.length == 1) {
//            return arr;
//        }
//        int mid = arr.length/2;
//        int left = 0;
//        int right = mid + 1;
//        System.out.println(check(arr,mid + 1,arr.length-1));
//        if (check(arr,0,mid) && check(arr,mid + 1,arr.length-1)) {
//            arr = mergSort(arr);
//            return arr;
//        } else {
//            if (!check(arr,0,mid)) {
//                int[] temp = new int[mid + 1];
//                int k = 0;
//                while (left <= mid) temp[k++] = arr[left++];
//                temp = sort(temp);
//                k = 0;
//                left = 0;
//                while (k < temp.length) arr[left++] = temp[k++];
//            }
//            if (!check(arr,mid + 1,arr.length-1)) {
//                int[] temp = new int[arr.length - mid -1];
//                int k = 0;
//                while (right < arr.length) temp[k++] = arr[right++];
//                temp = sort(temp);
//                k = 0;
//                right = mid +1;
//                while (k < temp.length) arr[right++] = temp[k++];
//            }
//            arr = mergSort(arr);
//            return arr;
//        }
//    }

    public static void mergSort(int[] arr,int leftPoint,int rightPoint,int rightBound) {
        int mid = rightPoint - 1;
        int[] temp = new int[rightBound - leftPoint + 1];
        int i = leftPoint;
        int j = rightPoint;
        int k = 0;
        while (i <= mid  && j <= rightBound ) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
//            if (arr[left] <= arr[right]) {
//                temp[last++] = arr[left++];
//            } else {
//                temp[last++] = arr[right++];
//            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];

        for (int m = 0; m < temp.length; m++) {
            arr[leftPoint + m] = temp[m];
        }
    }


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


