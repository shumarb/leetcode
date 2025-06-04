// Question: https://leetcode.com/problems/fruits-into-baskets-ii/description/

class FruitsIntoBasketsTwo {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean isTest = false;
        int countUsedBaskets = 0;

        if (isTest) {
            System.out.println("before:\nfruits: " + Arrays.toString(fruits));
            System.out.println("baskets: " + Arrays.toString(baskets));
            System.out.println("--------------------------------");
        }

        for (int i = 0; i < fruits.length; i++) {
            int fruit = fruits[i];
            for (int j = 0; j < baskets.length; j++) {
                int basket = baskets[j];
                if (isTest) {
                    System.out.println("fruit: " + fruit + " | basket: " + basket);
                }
                if (basket >= fruit) {
                    baskets[j] = -1;
                    countUsedBaskets++;
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
            System.out.println("after:\nfruits: " + Arrays.toString(fruits));
            System.out.println("baskets: " + Arrays.toString(baskets));
            System.out.println("countUsedBaskets: " + countUsedBaskets);
        }

        return baskets.length - countUsedBaskets;
    }
}