// Question: https://leetcode.com/problems/fruit-into-baskets/description/

class FruitsIntoBaskets {
    public int totalFruit(int[] fruits) {
        boolean isTest = false;
        int[] count = new int[100001];
        int countDistinct = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < fruits.length; right++) {
            if (++count[fruits[right]] == 1) {
                countDistinct++;
            }

            while (countDistinct > 2) {
                if (--count[fruits[left++]] == 0) {
                    countDistinct--;
                }
            }

            if (isTest) {
                System.out.println(" * valid | indices: [" + left + ", " + right + "] | subarray: " + Arrays.toString(Arrays.copyOfRange(fruits, left, right + 1)) + " | total: " + (right - left + 1));
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
