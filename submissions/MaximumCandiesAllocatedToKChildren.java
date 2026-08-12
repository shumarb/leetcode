// Question: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/

class MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        boolean isTest = false;
        int left = 1;
        int result = 0;
        int right = 0;
        long total = 0;

        for (int candy: candies) {
            right = Math.max(candy, right);
            total += candy;
        }
        if (isTest) {
            System.out.println("range: [" + left + ", " + right + "]" + ", total: " + total);
            System.out.println("------------------------------");
        }

        // 1. Not all kids will receive at least 1 candy.
        if (total < k) {
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;

            if (isTest) {
                System.out.println(" * [" + left + ", " + right + "] -> mid: " + mid);
            }
            for (int candy: candies) {
                count += candy / mid;

                if (count >= k) {
                    break;
                }
            }

            if (count >= k) {
                if (isTest) {
                    System.out.println(" ** possible answer: " + mid + " -> count: " + count + " -> total candies given: " + (mid * count));
                }
                result = mid;
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        if (isTest) {
            System.out.println("------------------------------\nresult: " + result);
        }

        return result;
    }
}
