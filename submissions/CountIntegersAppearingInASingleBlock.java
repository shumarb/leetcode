// Question: https://leetcode.com/problems/count-integers-appearing-in-a-single-block/description/

class CountIntegersAppearingInASingleBlock {
    public int countSpecialIntegers(int[] nums) {
        int[] firstIndex = new int[101];
        int[] lastIndex = new int[101];
        int result = 0;

        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (firstIndex[current] == -1) {
                firstIndex[current] = i;
            }

            lastIndex[current] = i;
        }
        for (int i = 0; i < firstIndex.length; i++) {
            if (firstIndex[i] != -1 && lastIndex[i] != -1) {
                boolean isSpecial = true;

                for (int j = firstIndex[i]; j <= lastIndex[i]; j++) {
                    if (nums[j] != i) {
                        isSpecial = false;
                        break;
                    }
                }

                if (isSpecial) {
                    result++;
                }
            }
        }

        return result;
    }
}
