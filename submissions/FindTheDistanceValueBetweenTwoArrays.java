// Question: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/description/

class FindTheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;

        for (int e: arr1) {
            boolean isValid = true;

            for (int value: arr2) {
                if (Math.abs(e - value) <= d) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result++;
            }
        }

        return result;
    }
}
