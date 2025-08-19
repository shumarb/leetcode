// Question: https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/description/

class MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int[] frequency = new int[101];int largest = nums[0];
        int total = 0;
        int totalComplement = 0;

        for (int number: nums) {
            frequency[number]++;
            total += number;
        }

        for (int i = 100; i >= 0; i--) {
            while (frequency[i]-- > 0) {
                int number = i;
                if (totalComplement <= total) {
                    if (isTest) {
                        System.out.println("number: " + number + "\n * total: " + total + ", totalComplement: " + totalComplement);
                        System.out.println(" * before, result: " + result);
                    }
                    result.add(number);
                    if (isTest) {
                        System.out.println(" * after, result: " + result);
                        System.out.println("--------------------------------------------");
                    }

                } else {
                    break;
                }

                total -= number;
                totalComplement += number;
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}