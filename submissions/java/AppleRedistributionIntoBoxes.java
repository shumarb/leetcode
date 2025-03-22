// Question: https://leetcode.com/problems/apple-redistribution-into-boxes/description/

class AppleRedistributionIntoBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int countMinimumBoxes = 0;
        int totalApples = 0;
        int maximumCapacity = Integer.MIN_VALUE;
        boolean isTest = false;

        for (int quantity: apple) {
            totalApples += quantity;
        }
        for (int size: capacity) {
            maximumCapacity = Math.max(size, maximumCapacity);
        }
        int[] boxCapacityFrequency = new int[maximumCapacity + 1];
        for (int size: capacity) {
            boxCapacityFrequency[size]++;
        }
        if (isTest) {
            System.out.println("apple: " + Arrays.toString(apple) + "\ncapacity: " + Arrays.toString(capacity));
            System.out.println("totalApples: " + totalApples + "\nboxCapacityFrequency: " + Arrays.toString(boxCapacityFrequency));
            System.out.println("---------------------------------------------------------------------");
        }

        for (int i = boxCapacityFrequency.length - 1; i >= 1 && totalApples > 0; i--) {
            while (boxCapacityFrequency[i] > 0 && totalApples > 0) {
                if (isTest) {
                    System.out.println(" * using box capacity of " + i);
                    System.out.println(" ** before | totalApples: " + totalApples + ", countMinimumBoxes: " + countMinimumBoxes);
                }
                totalApples -= i;
                countMinimumBoxes++;
                boxCapacityFrequency[i]--;
                if (isTest) {
                    System.out.println(" ** after | totalApples: " + totalApples + ", countMinimumBoxes: " + countMinimumBoxes);
                    System.out.println("---------------------------------------------------------------------");
                }
            }
        }

        return countMinimumBoxes;
    }
}