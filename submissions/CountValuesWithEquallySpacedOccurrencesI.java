// Question: https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-i/description/

class CountValuesWithEquallySpacedOccurrencesI {
    public int countSpecialIntegers(int[] nums) {
        int largest = 0;
        int n = nums.length;
        int result = 0;
        int[][] elementIndices = new int[101][n];
        int[] count = new int[101];
        boolean[] isChecked = new boolean[101];
        boolean isTest = false;

        for (int i = 0; i < n; i++) {
            int e = nums[i];
            elementIndices[e][count[e]++] = i;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n\nelementIndices:");
            for (int e: nums) {
                if (count[e] > 0) {
                    System.out.println(" * " + e + ": " + Arrays.toString(Arrays.copyOfRange(elementIndices[e], 0, count[e])));
                }
            }
            System.out.println("----------------------------------------");
        }

        for (int e: nums) {
            if (count[e] != 3 || isChecked[e]) {
                continue;
            }

            if (isValid(elementIndices[e], count[e])) {
                if (isTest) {
                    System.out.println(" ** valid: " + e);
                }

                result++;
            }

            isChecked[e] = true;
        }
        if (isTest) {
            System.out.println("----------------------------------------\nresult: " + result);
        }

        return result;
    }

    private boolean isValid(int[] arr, int n) {
        int difference = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                return false;
            }
        }

        return true;
    }
}
