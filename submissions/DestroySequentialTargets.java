// Question: https://leetcode.com/problems/destroy-sequential-targets/description/

class DestroySequentialTargets {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int maximumDestroyed = 0;
        int result = Integer.MAX_VALUE;

        // 1. Count the size of all possible subsequences.
        // Elements with same remainder when divided in space belong to same subsequence.
        for (int e: nums) {
            map.merge(e % space, 1, Integer::sum);
        }
        if (isTest) {
            System.out.println("space: " + space + "\nnums: " + Arrays.toString(nums) + "\nmap: " + map);
            System.out.println("-----------------------------------------");
        }
        for (int e: nums) {
            int remainder = e % space;
            int countDestroyed = map.get(remainder);

            if (isTest) {
                System.out.println(" * " + e + ", group number: " + remainder + ", group size: " + countDestroyed);
            }

            // 2. Element belongs to larger-sized group, soo it is the minimum value that destroys maximum number of targets so far.
            if (countDestroyed > maximumDestroyed) {
                maximumDestroyed = countDestroyed;
                result = e;

                // 3. Element is in same group with maximum number of targets destroyed so far, so set result as the lowest value in the group.
            } else if (countDestroyed == maximumDestroyed) {
                result = Math.min(e, result);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------\nresult: " + result);
        }

        return result;
    }
}
