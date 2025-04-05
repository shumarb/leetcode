// Question: https://leetcode.com/problems/summary-ranges/description/

class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        // 1. Edge case: no numbers.
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        boolean isTest = false;
        int i = 0;

        while (i < nums.length) {
            int start = nums[i];
            if (isTest) {
                System.out.println("i: " + i + ", start: " + nums[i]);
            }

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start == nums[i]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[i]);
            }
            if (isTest) {
                System.out.println(" * result so far: " + result);
                System.out.println("--------------------------------");
            }

            i++;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}