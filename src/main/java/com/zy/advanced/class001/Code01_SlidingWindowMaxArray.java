package com.zy.advanced.class001;

import java.util.LinkedList;

public class Code01_SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return new int[0];
        }
        int len = arr.length;
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] res = new int[len - w + 1];
        int index  = 0;

        for (int i = 0; i < len; i++) {
            while (!linkedList.isEmpty() && arr[linkedList.peekLast()] <= arr[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            if (linkedList.peekFirst() == i - w) {
                linkedList.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[linkedList.peekFirst()];
            }
        }
        return res;
    }
}
