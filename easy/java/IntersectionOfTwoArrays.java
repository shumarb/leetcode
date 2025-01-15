// Question: https://leetcode.com/problems/intersection-of-two-arrays/description/

class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] a1 = new boolean[1001];
        boolean[] a2 = new boolean[1001];
        boolean t = false;

        populate(nums1, a1);
        populate(nums2, a2);

        int c = 0;
        for (int i = 0; i <= 1000; i++) {
            if (a1[i] && a2[i]) {
                c++;
            }
        }

        int[] ans = new int[c];
        int j = 0;
        for (int i = 0; i <= 1000; i++) {
            if (a1[i] && a2[i]) {
                ans[j++] = i;
            }
        }

        if (t) {
            System.out.println("ans: " + Arrays.toString(ans));
        }
        return ans;
    }

    private void populate(int[] n, boolean[] a) {
        for (int x: n) {
            a[x] = true;
        }
    }
}