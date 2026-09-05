// Question: https://leetcode.com/problems/sort-even-and-odd-indices-independently/description/

class SortEvenAndOddIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        boolean isTest = false;
        int evenIndex = 0;
        int n = nums.length;
        int oddIndex = 0;
        int[] elementsAtEvenIndices = new int[n];
        int[] elementsAtOddIndices = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                elementsAtEvenIndices[evenIndex++] = nums[i];
            } else {
                elementsAtOddIndices[oddIndex++] = nums[i];
            }
        }
        sort(elementsAtEvenIndices);
        sort(elementsAtOddIndices);
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums) + "\n\nelementsAtEvenIndices: " + Arrays.toString(Arrays.copyOfRange(elementsAtEvenIndices, 0, evenIndex)) + "\nelementsAtOddIndices:  " + Arrays.toString(Arrays.copyOfRange(elementsAtOddIndices, 0, oddIndex)));
        }

        evenIndex = 0;
        oddIndex--;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = elementsAtEvenIndices[evenIndex++];
            } else {
                nums[i] = elementsAtOddIndices[oddIndex--];
            }
        }
        if (isTest) {
            System.out.println("\nafter, nums: " + Arrays.toString(nums));
        }

        return nums;
    }

    private void sort(int[] arr) {
        int[] count = new int[101];
        int j = 0;

        for (int e: arr) {
            count[e]++;
        }

        for (int i = 1; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }
    }
}
