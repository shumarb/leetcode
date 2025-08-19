// Question:

class WiggleSortTwo {
    public void wiggleSort(int[] nums) {
        boolean isTest = false;
        int[] sorted = sort(nums.clone());
        int n = nums.length;

        int mid = (n + 1) / 2;
        int left = mid - 1;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 0) ? sorted[left--] : sorted[right--];
        }

        if (isTest) {
            System.out.println("sorted: " + Arrays.toString(sorted) + "\nnums:   " + Arrays.toString(nums));
        }
    }

    private int[] sort(int[] nums) {
        int[] frequency;
        int j = 0;
        int largest = nums[0];

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];

        for (int number: nums) {
            frequency[number]++;
        }
        for (int i = 0; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                nums[j++] = i;
            }
        }

        return nums;
    }
}