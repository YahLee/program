package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输入n个整数自动排序
 * @author liyan-1
 *
 */
public class NumSort {

    public static void main(String[] asdf) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        List<Integer> numList = new ArrayList<Integer>();
        System.out.println("开始输入以空格区分，'end'结束输入'");
        while (scan.hasNext()) {
            String str = scan.next();
            if ("end".equals(str)) {
                break;
            }
            try {
                numList.add(Integer.valueOf(str));
            } catch (Exception e) {
                System.out.println("类型转换失败：输入格式不正确");
                e.printStackTrace();
            }

        }
        scan.close();
        Integer[] nums = numList.toArray(new Integer[numList.size()]);
        quitsort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 对数组进行快速排序
     * @param a 要排序的数组
     * @param begin 开始坐标
     * @param end   结束坐标
     */
    public static void quitsort(Integer[] a, int begin, int end) {
        int tbegin = begin;
        int tend = end;
        int pivot = a[begin]; //将第一个作为枢轴
        while (tbegin < tend) {
            while (tbegin < tend && a[tend] >= pivot) {
                --tend;
            }
            a[tbegin] = a[tend];
            while (tbegin < tend && a[tbegin] <= pivot) {
                ++tbegin;
            }
            a[tend] = a[tbegin];
        }
        a[tbegin] = pivot;
        if (begin < tend) {
            quitsort(a, begin, tend - 1);
        }
        if (tbegin < end) {
            quitsort(a, tbegin + 1, end);
        }

    }

}
