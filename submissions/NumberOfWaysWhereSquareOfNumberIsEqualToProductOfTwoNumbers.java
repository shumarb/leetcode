// Question: https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/description/

class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
    private boolean isTest;
    private long result = 0;

    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Long> map1 = countSquareFrequencies(nums1);
        Map<Long, Long> map2 = countSquareFrequencies(nums2);
        isTest = false;

        countWays(nums1, map2);
        countWays(nums2, map1);
        if (isTest) {
            System.out.println("nums1: " + Arrays.toString(nums1) + " -> map1: " + map1);
            System.out.println("nums2: " + Arrays.toString(nums2) + " -> map2: " + map2);
            System.out.println("result: " + result);
        }

        return (int) result;
    }

    private void countWays(int[] arr, Map<Long, Long> map) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long key = (long) (arr[i]) * (long) (arr[j]);
                if (isTest) {
                    System.out.println("first: " + arr[i] + ", second: " + arr[j] + " -> key: " + key);
                    if (isTest) {
                        System.out.println(" * found " + key);
                    }
                }
                result += map.getOrDefault(key, 0l);
            }
        }
    }

    private Map<Long, Long> countSquareFrequencies(int[] arr) {
        Map<Long, Long> map = new HashMap<>();

        for (int e: arr) {
            long key = (long) (e) * (long) (e);
            map.put(key, 1l + map.getOrDefault(key, 0l));
        }

        return map;
    }
}