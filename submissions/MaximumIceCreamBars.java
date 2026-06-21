// Question: https://leetcode.com/problems/maximum-ice-cream-bars/description/

class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        boolean isTest = false;
        int[] count = new int[100001];
        int largest = 0;
        int result = 0;

        for (int e: costs) {
            count[e]++;
            largest = Math.max(e, largest);
        }
        if (isTest) {
            System.out.println("coins: " + coins + "\ncosts: " + Arrays.toString(costs));
            System.out.println("count: " + Arrays.toString(Arrays.copyOfRange(count, 0, largest + 1)));
            System.out.println("---------------------------");
        }

        for (int i = 1; i <= largest; i++) {
            if (coins < i) {
                break;
            }
            while (count[i] > 0 && coins - i >= 0) {
                result++;
                coins -= i;
                count[i]--;
                if (isTest) {
                    System.out.println(" * buy: " + i + " | balance: " + coins);
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------------\nresult: " + result);
        }

        return result;
    }
}
