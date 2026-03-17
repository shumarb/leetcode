// Question: https://leetcode.com/problems/smallest-pair-with-different-frequencies/description/

class SmallestPairWithDifferentFrequencie {
    public int[] minDistinctFreqPair(int[] nums) {
        // 1. Edge case: nums has 1 element.
        if (nums.length == 1) {
            return new int[] {-1, -1};
        }

        boolean isTest = false;
        int[] countElements = populate(nums);
        int firstUniqueFrequency = -1;
        int secondUniqueFrequency = -1;
        int x = -1;
        int y = -1;

        for (int i = 1; i < countElements.length; i++) {
            if (countElements[i] > 0 && firstUniqueFrequency == -1) {
                firstUniqueFrequency = countElements[i];
                x = i;
            } else if (countElements[i] > 0 && countElements[i] != firstUniqueFrequency) {
                secondUniqueFrequency = countElements[i];
                y = i;
                break;
            }
        }
        if (isTest) {
            System.out.println("countElements: " + Arrays.toString(countElements) + "\nx: " + x + " | firstUniqueFrequency: " + firstUniqueFrequency);
            System.out.println("y: " + y + " | secondUniqueFrequency: " + secondUniqueFrequency);
        }

        return x == -1 || y == -1 ? new int[] {-1, -1} : new int[] {x, y};
    }

    private int[] populate(int[] arr) {
        int[] result;
        int largest = 0;

        for (int e: arr) {
            largest = Math.max(e, largest);
        }
        result = new int[largest + 1];
        for (int e: arr) {
            if (e > 0) {
                result[e]++;
            }
        }

        return result;
    }
}
