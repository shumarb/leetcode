// Question: https://leetcode.com/problems/destroying-asteroids/description/

class DestroyingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        boolean isTest = false;
        int i = 0;
        int n = asteroids.length;
        long total = mass;

        asteroids = sort(asteroids);
        if (isTest) {
            System.out.println("sorted: " + Arrays.toString(asteroids));
        }
        while (i < n) {
            if (isTest) {
                System.out.println(" * i: " + i + " | mass: " + mass + " | incoming: " + asteroids[i]);
            }
            if (total < (long) asteroids[i]) {
                return false;
            }
            total += asteroids[i++];
        }

        return true;
    }

    private int[] sort(int[] arr) {
        int[] count;
        int j = 0;
        int largest = 0;

        for (int e: arr) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: arr) {
            count[e]++;
        }
        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }
}
