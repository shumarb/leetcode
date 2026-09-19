// Question: https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-ii/description/

class CountValuesWithEquallySpacedOccurrencesII {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            // 1. Each element's initial mapping: [secondLastIndex, lastIndex, count, isSpecial]
            map.computeIfAbsent(nums[i], x -> new int[] {-1, -1, 0, 1});
        }
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            int[] value = map.get(key);

            value[2]++;
            if (value[3] == 0) {
                continue;
            }

            if (value[0] == -1) {
                value[0] = i;

            } else if (value[1] == -1) {
                value[1] = i;

            } else {
                int difference = value[1] - value[0];

                if (i - value[1] != difference) {
                    value[3] = 0;

                } else {
                    value[0] = value[1];
                    value[1] = i;
                }
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n\nmap: ");
            for (int key: map.keySet()) {
                System.out.println(" * " + key + ": " + Arrays.toString(map.get(key)));
            }
            System.out.println("------------------------------------------");
        }
        for (int key: map.keySet()) {
            int[] value = map.get(key);

            if (value[2] >= 3 && value[3] == 1) {
                if (isTest) {
                    System.out.println(" * valid: " + key);
                }
                result++;
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
