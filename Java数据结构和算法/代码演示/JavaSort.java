package com.hejianfeng.javaRetest;

import java.util.Arrays;

/**
 * @aouthor HJF
 * @create 2021-04-21-7:58
 */
public class JavaSort {
    private static int count;
//    private static int[] arr = {3,9,-2,10,20,13,-4,10,23,1};
private static int[] arr = {13,9,23,10,4,7};
    private static int temp;

    public static void main(String[] args) {
        radixSort();
    }
//    @Test
//    //冒泡排序
//    public void BubbleSort(){
//        for(int i = arr.length - 1; i > 0 ; i--){
//            for(int j = 0; j < i; j++){
//                if(arr[j] > arr[j + 1]){
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    count++;
//                }
//            }
//            System.out.println("第" + (arr.length - i) + "趟排序结果：" + Arrays.toString(arr));
//            if(count != 0)
//                count = 0;
//            else
//                break;
//        }
//    }
//
//    @Test
//    //选择排序
//    public void SelectSort(){
//        System.out.println(Arrays.toString(arr));
//        System.out.println("-------------------------------");
//        int index;
//        for(int i = 0; i < arr.length - 1; i++){
//            temp = arr[i];
//            index = i;
//            for(int j = i + 1; j < arr.length; j ++){
//                if(temp > arr[j]){
//                    temp = arr[j];
//                    index = j;
//                }
//            }
//            if(index != i){
//                arr[index] = arr[i];
//                arr[i] = temp;
//            }
//            System.out.println("第" + (i + 1) + "趟排序结果：" + Arrays.toString(arr));
//        }
//    }
//
//    @Test
//    //插入排序(从左开始比较)
//    public void InsertSort(){
//        System.out.println("第0趟排序结果：" + Arrays.toString(arr));
//        for(int i = 1; i < arr.length; i++){
//            temp = arr[i];
//            for(int j = 0; j < i; j++){
//                if(temp < arr[j]){
//                    for(int k = i; k > j; k--)
//                        arr[k] = arr[k - 1];
//                    arr[j] = temp;
//                    System.out.println("第" + i + "趟排序结果：" + Arrays.toString(arr));
//                    break;
//                }
//            }
//        }
//    }
//    @Test
//    //插入排序(从右开始比较)
//    public void InsertSort1(){
//        System.out.println("第0趟排序结果：" + Arrays.toString(arr));
//        boolean flag = false;
//        for(int i = 1; i < arr.length; i++){
//            temp = arr[i];
//            for(int j = i; j > 0; j--){
//                if(temp < arr[j - 1]){
//                    for(int k = i; k > j - 1; k--)
//                        arr[k] = arr[k - 1];
//                    arr[j] = temp;
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag){
//                for(int j = i; j > 0; j--)
//                    arr[j] = arr[j - 1];
//                arr[0] = temp;
//            }
//            System.out.println("第" + i + "趟排序结果：" + Arrays.toString(arr));
//            flag = false;
//        }
////        int insertval;
////        int insertindex;
////        for(int i = 0; i < arr.length; i++){
////            insertindex = i - 1;
////            insertval = arr[i];
////            while (insertindex >= 0 && insertval < arr[insertindex]){
////                arr[insertindex + 1] = arr[insertindex];
////                insertindex--;
////            }
////            arr[insertindex + 1] = insertval;
////            System.out.println("第" + i + "趟排序结果：" + Arrays.toString(arr));
////        }
//    }
//
//    @Test
//    //快速排序
//    public void QuickSort(){
//        System.out.println(Arrays.toString(arr));
//        System.out.println("-------------------------------");
//        Quicksort(0,arr.length-1,arr);
//        System.out.println(Arrays.toString(arr));
//    }
//    public void Quicksort(int left, int right, int[] arr){
//        if(left < right){
//            int temp =  arr[left];
//            int l = left;
//            int r = right;
//            while(l < r){
//                while (arr[r] >= temp && r > l)
//                    r--;
//                if(r > l){
//                    arr[l++] = arr[r];
//                }
//                while (arr[l] < temp && r > l)
//                    l++;
//                if(r > l){
//                    arr[r--] = arr[l];
//                }
//            }
//            arr[l] = temp;
//            Quicksort(left,r - 1,arr);
//            Quicksort(l + 1,right,arr);
//        }
//    }
//
//    @Test
//    //归并排序
//    public void MergeSort(){
////        System.out.println(Arrays.toString(Mergesort(0,arr.length - 1, arr)));
//        int[] temp = new int[arr.length];
//        System.out.println(Arrays.toString(arr));
//        System.out.println("------------------------------");
//        mergesort(arr,temp,0,arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//    }
//    public int[] Mergesort(int left, int right, int[] arr){
//        if((right - left) == 0){
//            return new int[]{arr[right]};
//        }
//        int mid = (left + right) / 2;
//        int[] leftarr = Mergesort(left,mid,arr);
//        int[] rightarr = Mergesort(mid + 1,right,arr);
//        int[] temp = new int[right - left + 1];
//        int lefttop = 0;
//        int righttop = 0;
//        for(int i = 0; i < (right - left) + 1; i++){
//            if(lefttop < leftarr.length && righttop < rightarr.length && leftarr[lefttop] < rightarr[righttop]) {
//                temp[i] = leftarr[lefttop++];
//            }else if (righttop < rightarr.length){
//                temp[i] = rightarr[righttop++];
//            }else{
//                if(lefttop >= leftarr.length){
//                    while(righttop < rightarr.length){
//                        temp[i++] = rightarr[righttop++];
//                    }
//                }
//                if(righttop >= rightarr.length){
//                    while(lefttop < leftarr.length){
//                        temp[i++] = leftarr[lefttop++];
//                    }
//                }
//                break;
//            }
//        }
//        return temp;
//    }
//    public void mergesort(int[] arr, int[] temp, int left, int right){
//        if(left < right){
//            int mid = (left + right) / 2;
//            mergesort(arr,temp,left,mid);
//            mergesort(arr,temp,mid + 1,right);
//            Merge(left,mid,right,arr,temp);
//        }
//    }
//    public void Merge(int left, int mid, int right, int[] arr, int[] temp){
//        int t = 0;
//        int lefttop = left;
//        int righttop = mid + 1;
//        while(lefttop <= mid && righttop <= right){
//            if(arr[lefttop] < arr[righttop])
//                temp[t++] = arr[lefttop++];
//            if(arr[righttop] < arr[lefttop])
//                temp[t++] = arr[righttop++];
//        }
//        //把剩余的数据保存进temp数组
//        while(righttop <= right){
//            temp[t++] = arr[righttop++];
//        }
//        while(lefttop <= mid){
//            temp[t++] = arr[lefttop++];
//        }
//        //将temp数组转移到arr数组
//        t = 0;
//        lefttop = left;
//        while(lefttop <= right){
//            arr[lefttop++] = temp[t++];
//        }
//    }
//
    //基数排序
    public static void radixSort(){
        int[][] bucket = new int[10][arr.length + 1];
        int m = 0;
        for(int i = 0; i < arr.length; i++){
            if(m < arr[i])
                m = arr[i];
        }
        int maxLength = (m + "").length();
        m = 0;
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------------");
        for(int i = 1; i <= maxLength; i++){
            for(int j = 0; j < arr.length; j++){//求各个位数上的数字(num/pow(10,i-1)%pow(10,i))
                bucket[(int) (arr[j]/Math.pow(10,i - 1)%Math.pow(10,i))][bucket[(int) (arr[j]/Math.pow(10,i - 1)%Math.pow(10,i))][arr.length]] = arr[j];
                bucket[(int) (arr[j]/Math.pow(10,i - 1)%Math.pow(10,i))][arr.length] += 1;
            }
            for(int j = 0; j < bucket.length; j++){
                while (count < bucket[j][6]){
                    arr[m] = bucket[j][count];
                    m++;
                    count++;
                }
                count = 0;
                bucket[j][6] = 0;
            }
            m = 0;
            System.out.println(Arrays.toString(arr));

        }
    }
}
