// Question: https://leetcode.com/problems/count-integers-appearing-in-a-single-block/description/

class CountIntegersAppearingInASingleBlock {
    public int countSpecialIntegers(int[] nums) {
        boolean[] isPresent = new boolean[101];
        boolean[] isSpecial = new boolean[101];
        boolean isTest = false;
        int[] lastIndex = new int[101];
        int result = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n---------------------------------------");
        }
        Arrays.fill(isSpecial, true);
        Arrays.fill(lastIndex, -1);
        for (int e: nums) {
            isPresent[e] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (lastIndex[current] == -1) {
                lastIndex[current] = i;

            } else if (i - lastIndex[current] != 1) {
                isSpecial[current] = false;
            }

            lastIndex[current] = i;
        }
        for (int i = 0; i < isSpecial.length; i++) {
            if (isPresent[i] && isSpecial[i]) {
                if (isTest) {
                    System.out.println(" * special: " + i);
                }

                result++;
            }
        }
        if (isTest) {
            System.out.println("---------------------------------------\nresult: " + result);
        }
        return result;
    }
}
