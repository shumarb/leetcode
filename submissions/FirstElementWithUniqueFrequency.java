// Question: https://leetcode.com/problems/first-element-with-unique-frequency/description/

class FirstElementWithUniqueFrequency {
    public int firstUniqueFreq(int[] nums) {
        boolean isTest = false;
        int[] countOfElements = getCount(nums);
        int[] countOfFrequencies = getCount(countOfElements);

        if (isTest) {
            displayCount("countOfElements: ", countOfElements);
            displayCount("countOfFrequencies: ", countOfFrequencies);
        }
        for (int e: nums) {
            if (countOfFrequencies[countOfElements[e]] == 1) {
                if (isTest) {
                    System.out.println(" * return: " + e);
                }
                return e;
            }
        }

        return -1;
    }

    private void displayCount(String s, int[] arr) {
        System.out.println(s);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println(" * " + i + " -> " + arr[i]);
            }
        }
        System.out.println("---------------------------------------------");
    }

    private int[] getCount(int[] nums) {
        int[] count;
        int largest = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: nums) {
            if (e > 0) {
                count[e]++;
            }
        }

        return count;
    }
}