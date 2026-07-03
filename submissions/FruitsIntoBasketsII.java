// Question: https://leetcode.com/problems/fruits-into-baskets-ii/description/

class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean isTest = false;
        int n = fruits.length;
        int result = n;

        if (isTest) {
            System.out.println("before:\n * fruits:  " + Arrays.toString(fruits) + "\n * baskets: " + Arrays.toString(baskets));
            System.out.println("--------------------------------");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isTest) {
                    System.out.println("fruit: " + fruits[i] + " | basket: " + baskets[j]);
                }
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = -1;
                    result--;
                    if (isTest) {
                        System.out.println(" * insert");
                    }
                    break;
                }
            }
            if (isTest) {
                System.out.println("--------------------------------");
            }
        }

        if (isTest) {
            System.out.println("after:\n * fruits:  " + Arrays.toString(fruits) + "\n * baskets: " + Arrays.toString(baskets) + "\n * result: " + result);
        }

        return result;
    }
}
