// Question: https://leetcode.com/problems/last-visited-integers/description/

class LastVisitedIntegers {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> seen = new ArrayList<>();
        int k = 0;
        int lastElement = Integer.MIN_VALUE;
        int len = nums.length;
        boolean isTest = false;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
        }

        for (int i = 0; i < len; i++) {
            int number = nums[i];
            if (isTest) {
                System.out.println("---------------------------------------------------------");
                System.out.println("i: " + i + " | number: " + number );
                System.out.println(" * before | k: " + k + ", seen: " + seen + ", ans: " + ans + ", lastElement: " + lastElement);
            }
            if (number > 0) {
                // 1. Reset k to 0 as number (positive) breaks chain of consecutive -1's.
                k = 0;
                seen.add(0, number);
            } else {
                if (k == 0 || lastElement == -1) {
                    k++;
                } if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else if (k > seen.size()) {
                    ans.add(-1);
                }
            }
            lastElement = number;
            if (isTest) {
                System.out.println(" * after | k: " + k + ", seen: " + seen + ", ans: " + ans + ", lastElement: " + lastElement);
            }
        }

        if (isTest) {
            System.out.println("ans: " + ans);
        }

        return ans;
    }
}