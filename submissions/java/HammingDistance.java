// Question: https://leetcode.com/problems/hamming-distance/description/

class HammingDistance {
    public int hammingDistance(int x, int y) {
        Queue<Integer> xBits = getBits(x);
        Queue<Integer> yBits = getBits(y);
        boolean isTest = false;
        int count = 0;

        if (isTest) {
            System.out.println("x: " + x + ", xBits: " + xBits);
            System.out.println("y: " + x + ", yBits: " + yBits);
        }

        while (!xBits.isEmpty() && !yBits.isEmpty()) {
            if (xBits.poll() != yBits.poll()) {
                count++;
            }
        }
        while (!xBits.isEmpty()) {
            if (xBits.poll() == 1) {
                count++;
            }
        }
        while (!yBits.isEmpty()) {
            if (yBits.poll() == 1) {
                count++;
            }
        }

        return count;
    }

    private Queue<Integer> getBits(int n) {
        Queue<Integer> queue = new LinkedList<>();
        while (n != 0) {
            queue.offer(n % 2);
            n /= 2;
        }
        return queue;
    }
}