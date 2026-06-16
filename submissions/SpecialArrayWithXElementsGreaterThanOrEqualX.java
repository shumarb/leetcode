// Question: https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/

class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        boolean isTest = false;
        int[] count = new int[1001];
        int largest = 0;
        int result = -1;

        for (int e: nums) {
            count[e]++;
            largest = Math.max(e, largest);
        }
        for (int i = largest - 1; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        for (int i = largest; i >= 0; i--) {
            if (count[i] == i) {
                result = i;
                break;
            }
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(Arrays.copyOfRange(count, 0, largest + 1)) + "\nresult: " + result);
        }

        return result;
    }
}
