package com.zy.advanced.class001;

import java.util.LinkedList;

public class Code02_AllLessNumSubArray {
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int len = arr.length;
        int res = 0;
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        while (l < len) {
            while (r < len) {
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[r]) {
                    qMin.pollLast();
                }
                qMin.addLast(r);
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[r]) {
                    qMax.pollLast();
                }
                qMax.addLast(r);
                if (qMax.peekFirst() - qMin.peekFirst() > num) {
                    break;
                }
                r++;
            }
            res += r - l;

            if (qMin.peekFirst() == l) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == l) {
                qMax.pollFirst();
            }
            l++;
        }
        return res;
    }
}
