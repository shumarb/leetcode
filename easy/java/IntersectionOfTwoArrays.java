// Question: https://leetcode.com/problems/intersection-of-two-arrays/description/

class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] small;
        int[] big;
        boolean t = false;

        if (nums1.length > nums2.length) {
            big = nums1;
            small = nums2;
        } else {
            small = nums1;
            big = nums2;
        }
        if (t) {
            System.out.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2));
            System.out.println("big: " + Arrays.toString(big) + ", small: " + Arrays.toString(small));
        }

        int max1 = getMax(nums1);
        int max2 = getMax(nums2);
        if (t) {
            System.out.println("max1: " + max1 + ", max2: " + max2);
        }

        boolean[] bigFreq = new boolean[1 + Math.max(max1, max2)];
        for (int x: big) {
            bigFreq[x] = true;
        }
        if (t) {
            System.out.println("bigFreq: " + Arrays.toString(bigFreq));
        }

        List<Integer> list = new ArrayList<> ();
        for (int x: small) {
            if (bigFreq[x]) {
                if (t) {
                    System.out.println("intersect: " + x);
                }
                list.add(x);
                bigFreq[x] = false;
            }
        }
        if (t) {
            System.out.println("list: " + list);
        }

        int[] ans = new int[list.size()];
        int j = 0;
        for (int x: list) {
            ans[j++] = x;
        }
        if (t) {
            System.out.println("ans: " + Arrays.toString(ans));
        }
        return ans;
    }

    private int getMax(int[] a) {
        int max = a[0];
        for (int x: a) {
            max = Math.max(max, x);
        }
        return max;
    }
}