// Question: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/

class MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        boolean isTest = true;
        int left = 1;
        int result = 0;
        int right = 0;

        for (int candy: candies) {
            right = Math.max(candy, right);
        }
        if (isTest) {
            System.out.println("range: [" + left + ", " + right + "]");
            System.out.println("------------------------------");
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

            if (count <= k) {
                if (isTest) {
                    System.out.println(" * possible answer: " + mid + " -> count: " + count);
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
