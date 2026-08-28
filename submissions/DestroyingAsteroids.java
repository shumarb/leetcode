// Question: https://leetcode.com/problems/destroying-asteroids/description/

class DestroyingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        boolean isTest = false;
        int i = 0;
        int n = asteroids.length;
        long total = mass;

        sort(asteroids);
        if (isTest) {
            System.out.println("sorted: " + Arrays.toString(asteroids));
        }
        while (i < n) {
            if (isTest) {
                System.out.println(" * i: " + i + " | mass: " + mass + " | incoming: " + asteroids[i]);
            }

            if (total < asteroids[i]) {
                return false;
            }

            total += asteroids[i++];
        }

        return true;
    }

    private void sort(int[] arr) {
        int[] count = new int[100001];
        int j = 0;
        int largest = 0;
        int smallest = Integer.MAX_VALUE;

        for (int e: arr) {
            count[e]++;
            largest = Math.max(e, largest);
            smallest = Math.min(e, smallest);
        }
        for (int i = smallest; i <= largest; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }
    }
}
