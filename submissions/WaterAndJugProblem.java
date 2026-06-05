// Question: https://leetcode.com/problems/water-and-jug-problem/description/

class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        boolean isTest = false;
        int[] source = new int[] {0, 0};
        int level = 0;

        queue.offer(source);
        isVisited.add(Arrays.toString(source));

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("---------------------------\nlevel " + level + ":");
                for (int[] e: queue) {
                    System.out.print(Arrays.toString(e) + " ");
                }
                System.out.println();
            }

            int size = queue.size();
            while (size-- > 0) {
                int[] top = queue.poll();
                int a = top[0];
                int b = top[1];

                if (a == target || b == target || a + b == target) {
                    if (isTest) {
                        System.out.println(" * found @ level " + level);
                    }

                    return true;
                }

                List<int[]> nextStates = new ArrayList<>();

                // 1. Empty a.
                nextStates.add(new int[] {0, b});

                // 2. Empty b.
                nextStates.add(new int[] {a, 0});

                // 3. Fill x.
                nextStates.add(new int[] {x, b});

                // 4. Empty y.
                nextStates.add(new int[] {a, y});

                // 5. Transfer a -> b.
                int transfer = Math.min(a, y - b);
                nextStates.add(new int[] {
                        a - transfer,
                        b + transfer
                });

                // 6. Transfer b -> a.
                transfer = Math.min(b, x - a);
                nextStates.add(new int[] {
                        a + transfer,
                        b - transfer
                });

                for (int[] e: nextStates) {
                    if (isVisited.add(Arrays.toString(e))) {
                        queue.offer(e);
                    }
                }
            }

            level++;
        }

        return false;
    }
}
