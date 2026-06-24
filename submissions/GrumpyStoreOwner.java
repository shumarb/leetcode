// Question: https://leetcode.com/problems/grumpy-bookstore-owner/description/

class GrumpyStoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        boolean isTest = false;
        int current = 0;
        int largest = 0;
        int largestLeftIndex = 0;
        int largestRightIndex = minutes - 1;
        int n = customers.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                current += customers[i];
            }
        }
        largest = current;
        if (isTest) {
            System.out.println("minutes: " + minutes + "\nn: " + n);
            System.out.println("customers: " + Arrays.toString(customers) + "\ngrumpy: " + Arrays.toString(grumpy));
            System.out.println("--------------------------------------------\n * window: [0" + ", " + (minutes - 1) + "]: " + current);
        }

        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                current -= customers[i - minutes];
            }

            if (grumpy[i] == 1) {
                current += customers[i];
            }

            if (isTest) {
                System.out.println(" * window: [" + (i - minutes + 1) + ", " + i + "]: " + current);
            }
            if (current > largest) {
                largest = current;
                largestLeftIndex = i - minutes + 1;
                largestRightIndex = i;
            }
        }

        result += largest;

        if (isTest) {
            System.out.println("--------------------------------------------\nlargest: [" + largestLeftIndex + ", " + largestRightIndex + "]: " + largest + "\nresult: " + result);
        }

        return result;
    }
}
