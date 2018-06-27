package com.sort;

import java.util.Arrays;

/**
 * Created by sunwenxiao on 2018/3/5.
 */
public class SortChioce {
    private static int[] sortData = {89,11,34,5,101,22,3};

    public static void main(String[] args) {
        SortChioce sortChioce = new SortChioce();
        int len = sortData.length;
        for(int i = 0 ;i < len-1;i++){
            for(int j = i+1 ;j < len; j++){
                int a = sortData[i];
                int b = sortData[j];
                if (a > b){
                    int c = a;
                    sortData[i] = b;
                    sortData[j] = c ;
                }
            }
        }
        System.out.println("选择排序结果"+Arrays.toString(sortData));

        //冒泡法
        for(int i = 0 ;i < len ;i++){
            for (int j=0;j<len-1-i;j++){
                int a = sortData[j];
                int b = sortData[j+1];
                if (a>b){
                  //  int c = b;
                    sortData[j+1] = a;
                    sortData[j] = b;
                }
            }

        }
        System.out.println("冒泡排序结果"+Arrays.toString(sortData));

        int[] arr = {1, 4, 5, 67, 2, 7, 8, 6, 9, 44};
        quickSort(arr, 0, 9);

        System.out.println("Java3y" + Arrays.toString(arr));

    }
    /**
     * 快速排序
     *
     * @param arr
     * @param L   指向数组第一个元素
     * @param R   指向数组最后一个元素
     */
    public static void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;

        //支点
        int pivot = arr[(L + R) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            //寻找直到比支点大的数
            while (pivot > arr[i])
                i++;

            //寻找直到比支点小的数
            while (pivot < arr[j])
                j--;

            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。


        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j)
            quickSort(arr, L, j);

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R)
            quickSort(arr, i, R);
    }

}
