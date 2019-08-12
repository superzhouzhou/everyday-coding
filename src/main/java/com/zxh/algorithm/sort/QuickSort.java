package com.zxh.algorithm.sort;

import java.util.Arrays;


/**
 * 参数：array 标准值，low 低阶索引， high 高阶索引 一次排序完成条件：high<=low 1.从高阶开始获取数组并与标准值进行判断 1.1 当高阶标准值，则将高阶的值与t0交换位置
 * 1.2 不大于进行 --high 1.3 high<=low跳出循环 2.从低阶开始进行与标准值的判断 2.1 小于标准值 ++low 2.2 大于标准值与Array[high]交换 2.3
 * low>=high跳出循环 终止条件： high<=low 3. 当high>low递归 3.1 high<low结束
 *
 * @author zhouxiaohui
 */

public class QuickSort {

  public static int[] sort(int[] arrys, int low, int hight) {
    int temp = arrys[low];
    int start = low;
    int end = hight;
    for (; end > start; --end) {
      if (arrys[end] < temp) {
        arrys[start] = arrys[end];
        arrys[end] = temp;
        for (; start < end; start++) {
          if (arrys[start] > temp) {
            temp = arrys[end];
            arrys[end] = arrys[start];
            arrys[start] = temp;
            break;
          }
        }
        break;
      }
    }
    if (hight > low) {
      ++low;
      sort(arrys, low, hight);
    }
    return arrys;
  }


  public static void main(String[] args) {
    int[] testArr2 = new int[]{2, 1, 3, 4, 9, 9, 18, 27, 6, 15};

    int[] sort = QuickSort.sort(testArr2, 0, testArr2.length - 1);
    // System.out.println(Arrays.toString(sort));
    int[] testArr3 = new int[]{5, 6, 7, 1, 9};
    quickSort(testArr3, 0, testArr3.length - 1);
    System.out.println(Arrays.toString(testArr3));
  }


  public static int[] sort2(int[] array, int low, int high) {
    int head = low;
    int tail = high;
    int pivot = array[low];
    while (head < tail) {
      if (array[tail] < pivot) {
        array[head] = array[tail];
        array[tail] = pivot;
        while (head < tail) {
          if (array[head] > pivot) {
            pivot = array[tail];
            array[tail] = array[head];
            array[head] = pivot;
            break;
          }
          ++head;
        }
        break;
      }
      --tail;
    }
    if (head < tail) {
      // sort2(low--,high--);
    }
    return null;
  }

  public static void quickSort(int a[], int left, int right) {

    if (left >= right) {
      return;
    }

    int pivot = a[left];
    int i = left;
    int j = right;

    //如果左右指针碰头就代表这一轮迭代结束
    while (i != j) {
      //先从右边开始,找小于pivot点的数字
      //因此，循环的条件是如果大于pivot就继续查找
      //小于pivot就停止
      while (a[j] >= pivot && i < j) {
        j--;
      }
      //后从左边开始，找大于pivot的数字
      //因此，循环的条件是如果是小于pivot就继续查找
      //大于pivot就停止
      while (a[i] <= pivot && i < j) {
        i++;
      }

      if (i < j) {
        //交换两个数字
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
      }

    }

    //基准归位
    a[left] = a[i];
    a[i] = pivot;

    quickSort(a, left, i - 1);

    quickSort(a, i + 1, right);

  }


}
