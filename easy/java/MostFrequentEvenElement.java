// Question: https://leetcode.com/problems/most-frequent-even-element/description/

import java.util.Arrays;

class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        boolean isEvenExist = false;
        for (int x: nums) {
            if (x % 2 == 0) {
                isEvenExist = true;
                break;
            }
        }
        if (!isEvenExist) {
            return -1;
        }

        boolean t = false;
        int max = getMax(nums);
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmax: " + max);
        }
        int[] freq = new int[max + 1];
        for (int x: nums) {
            freq[x]++;
        }
        if (t) {
            System.out.println("freq: " + Arrays.toString(freq));
        }

        int smallest = 0;
        int count = freq[0];
        for (int i = 2; i < freq.length; i += 2) {
            if (freq[i] > count) {
                smallest = i;
                count = freq[i];
            }
            if (freq[i] == count) {
                smallest = Math.min(i, smallest);
            }
        }
        return smallest;
    }

    private int getMax(int[] n) {
        int max = n[0];
        for (int x: n) {
            max = Math.max(max, x);
        }
        return max;
    }
}