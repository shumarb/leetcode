// Question: https://leetcode.com/problems/find-common-elements-between-two-arrays/description/

class FindCommonElementsBetweenTwoArrays {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int answer1 = countIndices(nums2, nums1);
        int answer2 = countIndices(nums1, nums2);
        return new int[] {answer1, answer2};
    }

    private int countIndices(int[] source, int[] check) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("source: " + Arrays.toString(source) + ", check: " + Arrays.toString(check));
        }
        int countIndices = 0;
        boolean[] isPresent = new boolean[101];
        for (int number: source) {
            isPresent[number] = true;
        }

        for (int number: check) {
            if (isTest) {
                System.out.println(" * checking: " + number);
            }
            if (isPresent[number]) {
                countIndices++;
            }
        }

        if (isTest) {
            System.out.println("countIndices: " + countIndices);
        }
        return countIndices;
    }
}