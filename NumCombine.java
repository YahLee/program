package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列组合
 * @author liyan-1
 *
 */
public class NumCombine {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = { 2, 5, 7, 9 };
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> li = new ArrayList<Integer>();
        subPermutation(list, li, num);
        System.out.println("总共有:" + list.size() + "个");
        for (int temp : list) {
            System.out.println(temp);
        }
    }

    /**
     * 输出组合个数：4*3*2
     * @param list
     * @param li
     * @param num
     */
    public static void subPermutation(List<Integer> list, List<Integer> li, int[] num) {
        if (li.size() == num.length - 1) {
            int temp = 0;
            for (int i = 0; i < li.size(); i++) {
                temp = temp * 10 + li.get(i);
            }
            list.add(temp);
        }
        for (int i = 0; i < num.length; i++) {
            if (li.contains(num[i]))
                continue;
            li.add(num[i]);
            subPermutation(list, li, num);
            //添加到list容器后取出li中最后一个数字
            li.remove(li.size() - 1);
        }
    }
}
