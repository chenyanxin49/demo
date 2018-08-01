package com.example.controller;

import java.util.Arrays;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/31
 * Time     :       11:54
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * HeapSortTest
 */
public class HeapSortTest {

    /*
     * 建立堆时只需要保证根结点小于两个子结点或者大于两个子结点，对两个子结点大小没有要求
     */
    public static void main(String[] args) {
        int[] a = {2, 6, 7, 9, 5, 8, 3, 4, 1, 0};
        //在堆排序之前，打印初始数组
        System.out.println(Arrays.toString(a));
        //进行堆排序
        heapSort(a);
        //进行堆排序之后
        System.out.println(Arrays.toString(a));
    }

    private static void heapSort(int[] a) {
        //建立大根堆
        buildMaxHeap(a);
        System.out.println(Arrays.toString(a));
        int c = 0;
        for (int i = a.length - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            maxHeap(a, i, 0);
            c++;
            System.out.println("[heapSort " + c + " "+ i +"]" + Arrays.toString(a));
        }
    }

    private static void buildMaxHeap(int[] a) {
        int half = a.length / 2;
        int c = 0;
        for (int i = half; i >= 0; i--) {
            maxHeap(a, a.length, i);
            c++;
            System.out.println("[maxHeap " + c + " "+ i +"]" + Arrays.toString(a));
        }
    }

    private static void maxHeap(int[] a, int heapSize, int index) {
        //找出index位置处左右孩子的位置left和right
        int left = (index << 1) + 1;
        int right = (index << 1) + 2;

        int largest = index;

        if (left < heapSize) {
            System.out.println("[left : " + a[left] + "] index : " + index);
        }

        if (right < heapSize) {
            System.out.println("[left : " + a[right] + "] index : " + a[largest]);
        }

        if (left < heapSize && a[left] > a[index]) {
            System.out.println("[left : " + a[left] + "] index : " + index);
            largest = left;
        }

        if (right < heapSize && a[right] > a[largest]) {
            System.out.println("[left : " + a[right] + "] index : " + a[largest]);
            largest = right;
        }

        if (index != largest) {
            //交换两个数据
            int temp = a[index];
            a[index] = a[largest];
            a[largest] = temp;
            maxHeap(a, heapSize, largest);
        }
    }
}
