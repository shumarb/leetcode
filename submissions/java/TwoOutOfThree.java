// Question: https://leetcode.com/problems/two-out-of-three/description/

class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();
        int maximum = findMaximum(nums1, nums2, nums3);
        boolean isTest = false;
        boolean[] isNumberPresentInNums1 = getIsNumberPresentArray(maximum, nums1);
        boolean[] isNumberPresentInNums2 = getIsNumberPresentArray(maximum, nums2);
        boolean[] isNumberPresentInNums3 = getIsNumberPresentArray(maximum, nums3);

        if (isTest) {
            System.out.println("isNumberPresentInNums1: " + Arrays.toString(isNumberPresentInNums1));
            System.out.println("isNumberPresentInNums2: " + Arrays.toString(isNumberPresentInNums2));
            System.out.println("isNumberPresentInNums3: " + Arrays.toString(isNumberPresentInNums3));
        }

        for (int i = 1; i <= isNumberPresentInNums1.length - 1; i++) {
            int count = 0;
            if (isNumberPresentInNums1[i]) {
                count++;
            }
            if (isNumberPresentInNums2[i]) {
                count++;
            }
            if (isNumberPresentInNums3[i]) {
                count++;
            }
            if (count >= 2) {
                result.add(i);
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private boolean[] getIsNumberPresentArray(int maximum, int[] arr) {
        boolean[] isNumberPresent = new boolean[maximum + 1];
        for (int number: arr) {
            isNumberPresent[number] = true;
        }
        return isNumberPresent;
    }

    private int findMaximum(int[] first, int[] second, int[] third) {
        int maximum = 0;
        for (int number: first) {
            maximum = Math.max(maximum, number);
        }
        for (int number: second) {
            maximum = Math.max(maximum, number);
        }
        for (int number: third) {
            maximum = Math.max(maximum, number);
        }
        return maximum;
    }
}