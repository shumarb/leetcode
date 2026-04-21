// Question: https://leetcode.com/problems/minimum-jumps-to-reach-home/description/

class MinimumJumpsToReachHome {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new LinkedList<>(); // [position, isBackwardUsed].
        boolean[] isForbidden = new boolean[6001]; // largest position to reach is 6000.
        boolean[][] isVisited = new boolean[6001][2]; // 6000 is max (x, largest position in forbidden) + a + b.
        boolean isTest = false;
        int largest = 0;
        int level = 0;
        int limit = 6000; // 6000 is max (x, largest position in forbidden) + a + b.

        for (int e: forbidden) {
            largest = Math.max(e, largest);
            isForbidden[e] = true;
        }
        if (isTest) {
            System.out.println("a: " + a + ", b: " + b + ", x: " + x);
            System.out.println("isForbidden: " + Arrays.toString(Arrays.copyOfRange(isForbidden, 0, largest + 1)));
        }

        queue.offer(new int[] {0, 0});
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("-----------------------------------------------");
                System.out.println("level: " + level + "\nqueue:");
                for (int[] e: queue) {
                    System.out.print(Arrays.toString(e) + " ");
                }
                System.out.println("\n");
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int isBackwardUsed = top[1];
                int position = top[0];

                if (position == x) {
                    return level;
                }

                int countBackward = position - b;
                int countForward = position + a;

                if (isTest) {
                    System.out.println(" * position: " + position + " | countBackward: " + countBackward + " | countForward: " + countForward);
                }
                if (countForward <= limit && !isForbidden[countForward] && !isVisited[countForward][0]) {
                    isVisited[countForward][0] = true;
                    queue.offer(new int[] {countForward, 0});
                }

                if (isBackwardUsed == 0 && countBackward >= 0 && countBackward <= limit && !isForbidden[countBackward] && !isVisited[countBackward][1]) {
                    isVisited[countBackward][1] = true;
                    queue.offer(new int[] {countBackward, 1});
                }
            }

            level++;
        }

        return -1;
    }
}
