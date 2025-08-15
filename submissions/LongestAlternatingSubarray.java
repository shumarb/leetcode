// Question: https://leetcode.com/problems/longest-alternating-subarray/description/

class LongestAlternatingSubarray {
    public int alternatingSubarray(int[] nums) {
        boolean isTest = false;
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int[] subarray = Arrays.copyOfRange(nums, i, j + 1);
                if (isTest) {
                    System.out.println("subarray: " + Arrays.toString(subarray));
                }
                if (subarray.length >= 2 && isValid(subarray) && subarray.length > longest) {
                    if (isTest) {
                        System.out.println(" * valid: " + Arrays.toString(subarray));
                    }
                    longest = subarray.length;
                }
            }
        }

        return longest == 0 ? -1 : longest;
    }

    private boolean isValid(int[] arr) {
        int first = arr[0];
        int second = arr[1];

        if (second - first != 1) {
            return false;
        }

        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] != first) {
                return false;
            }
        }
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] != second) {
                return false;
            }
        }

        return true;
    }
}