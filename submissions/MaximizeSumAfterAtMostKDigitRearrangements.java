// Question: https://leetcode.com/problems/maximize-sum-after-at-most-k-digit-rearrangements/description/

class MaximizeSumAfterAtMostKDigitRearrangements {
    public long maximizeSum(int[] nums, int k) {
        List<int[]> list = new ArrayList<>();
        boolean isTest = false;
        long result = 0;

        for (int e: nums) {
            int[] count = new int[10];
            int newNumber = 0;
            int eCopy = e;
            result += e;

            while (eCopy > 0) {
                count[eCopy % 10]++;
                eCopy /= 10;
            }

            for (int i = 9; i >= 0; i--) {
                while (count[i]-- > 0) {
                    newNumber *= 10;
                    newNumber += i;
                }
            }

            list.add(new int[] {e, newNumber});
        }

        list.sort((a, b) -> Integer.compare(b[1] - b[0], a[1] - a[0]));
        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums) + "\nlist: ");
            for (int[] e: list) {
                System.out.println(" * " + Arrays.toString(e));
            }
            System.out.println("----------------------------------------------------------------------------------");
        }
        for (int[] e: list) {
            int gain = e[1] - e[0];

            if (isTest) {
                System.out.println(" * e: " + e[0] + ", complement: " + e[1] + ", gain: " + gain);
            }

            if (gain > 0 && k > 0) {
                result += gain;
                k--;

            } else {
                break;
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
