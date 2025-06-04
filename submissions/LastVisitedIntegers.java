// Question: https://leetcode.com/problems/last-visited-integers/description/

class LastVisitedIntegers {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> seen = new ArrayList<>();
        boolean isTest = false;
        int countSeen = 0;
        int k = 0;
        int len = nums.length;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
        }

        for (int i = 0; i < len; i++) {
            int number = nums[i];
            if (isTest) {
                System.out.println("------------------------------------------");
                System.out.println("i: " + i + ", number: " + number);
                System.out.println(" * before | k: " + k + ", seen: " + seen + ", ans: " + ans);
            }
            if (number > 0) {
                // 1. Reset k to 0 as chain of consecutive -1's is broken.
                k = 0;
                seen.addFirst(number);
            } else {
                k++;
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
            }
            if (isTest) {
                System.out.println(" * after | k: " + k + ", seen: " + seen + ", ans: " + ans);
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------");
            System.out.println("ans: " + ans);
        }

        return ans;
    }
}