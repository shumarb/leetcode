// Question: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array-ii/description/

class FindAllNumbersDisappearedInAnArrayII {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isPresent;
        boolean isTest = false;
        int largest = upper;
        int left = lower;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        isPresent = new boolean[largest + 1];
        for (int e: nums) {
            isPresent[e] = true;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nrange: [" + lower + ", " + upper + "]");
            System.out.println("\nisPresent: " + Arrays.toString(isPresent) + "\n----------------------------------------------------------");
        }

        while (left <= upper) {
            if (isPresent[left]) {
                left++;
                continue;
            }

            int right = left;
            while (right <= upper && !isPresent[right]) {
                right++;
            }
            if (isTest) {
                System.out.println(" * missing: [" + left + ", " + (right - 1) + "]");
            }
            result.add(List.of(left, right - 1));
            left = right + 1;
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }
}
