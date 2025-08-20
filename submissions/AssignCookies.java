// Question: https://leetcode.com/problems/assign-cookies/description/

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // 1. Edge case: Empty size array, so no children's content satisfied.
        if (s.length == 0) {
            return 0;
        }

        boolean isTest = false;
        int count = 0;
        int i = 0;
        int j = 0;

        g = sort(g);
        s = sort(s);
        while (i < g.length && j < s.length) {
            // 2. For each greed, greedily find smallest size that that fulfills it.
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        if (isTest) {
            System.out.println("sorted g: " + Arrays.toString(g) + "\nsorted s: " + Arrays.toString(s) + "\ncount: " + count);
        }

        return count;
    }

    private int[] sort(int[] arr) {
        int[] frequency;
        int j = 0;
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            largest = Math.max(arr[i], largest);
        }
        frequency = new int[largest + 1];
        for (int number: arr) {
            frequency[number]++;
        }

        for (int i = 0; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }
}