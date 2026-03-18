// Question: https://leetcode.com/problems/first-unique-even-element/description/

class FirstUniqueEvenElement {
    public int firstUniqueEven(int[] nums) {
        boolean isTest = false;
        int[] count;
        int largest = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: nums) {
            if (e % 2 == 0) {
                count[e]++;
            }
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(count));
        }

        for (int e: nums) {
            if (e % 2 == 0 && count[e] == 1) {
                return e;
            }
        }

        return -1;
    }
}
