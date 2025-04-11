// Question: https://leetcode.com/problems/sort-even-and-odd-indices-independently/description/

class SortEvenAndOddIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> evenIndices = new ArrayList<>();
        List<Integer> oddIndices = new ArrayList<>();
        boolean isTest = false;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenIndices.add(nums[i]);
            } else {
                oddIndices.add(nums[i]);
            }
        }
        Collections.sort(evenIndices);
        Collections.sort(oddIndices);
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("evenIndices: " + evenIndices);
            System.out.println("oddIndices: " + oddIndices);
            System.out.println("-------------------------------------------------------------");
        }

        int j = 0;
        int k = oddIndices.size() - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = evenIndices.get(j++);
            } else {
                nums[i] = oddIndices.get(k--);
            }
        }
        if (isTest) {
            System.out.println("final nums: " + Arrays.toString(nums));
            System.out.println("-------------------------------------------------------------");
        }

        return nums;
    }
}