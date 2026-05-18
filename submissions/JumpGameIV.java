// Question: https://leetcode.com/problems/jump-game-iv/description/

class JumpGameIV {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        int n = arr.length;
        boolean[] isVisited = new boolean[n];
        boolean isTest = false;

        if (n == 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + "\nmap:");
            for (int key: map.keySet()) {
                System.out.println(" * " + key + ": " + map.get(key));
            }
        }

        queue.offer(0);
        isVisited[0] = true;
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("------------------------------\n * " + level + ": " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                int index = queue.poll();
                if (index == n - 1) {
                    if (isTest) {
                        System.out.println(" * found @ level " + level);
                    }

                    return level;
                }

                if (index - 1 >= 0 && !isVisited[index - 1]) {
                    queue.offer(index - 1);
                    isVisited[index - 1] = true;
                }

                if (index + 1 < n && !isVisited[index + 1]) {
                    queue.offer(index + 1);
                    isVisited[index + 1] = true;
                }

                // 1. Add all available indices equal to key to queue
                //    so that all possible paths from key to next key are explored in 1 level.
                //    Otherwise, same keys are explored multiple times.
                int key = arr[index];
                for (int nextIndex: map.get(key)) {
                    if (!isVisited[nextIndex]) {
                        queue.offer(nextIndex);
                        isVisited[nextIndex] = true;
                    }
                }
                map.get(key).clear();
            }

            level++;
        }

        return -1;
    }
}
