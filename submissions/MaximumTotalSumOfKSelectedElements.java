// Question: https://leetcode.com/problems/maximum-total-sum-of-k-selected-elements/description/

class MaximumTotalSumOfKSelectedElements {
    public long maxSum(int[] nums, int k, int mul) {
        boolean isTest = false;
        int index = nums.length - 1;
        long result = 0l;

        sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nk: " + k + "\nmul: " + mul);
            System.out.println("------------------------------------");
        }

        while (index >= 0 && k > 0) {
            long value = nums[index];

            if (mul > 0) {
                value *= (long) mul;
            }

            if (isTest) {
                System.out.println(" * add | e: " + nums[index] + " | mul: " + mul + " | value: " + value);
            }

            result += value;

            index--;
            k--;
            mul--;
        }
        if (isTest) {
            System.out.println("------------------------------------");
            System.out.println("after processing: \n * k: " + k + "\n * mul: " + mul + "\n * index: " + index);
            System.out.println("------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void sort(int[] arr) {
        int[] count = new int[100001];
        int largest = 0;
        int j = 0;

        for (int e: arr) {
            largest = Math.max(e, largest);
            count[e]++;
        }

        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }
    }
}
