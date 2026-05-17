// Question: https://leetcode.com/problems/jump-game-iii/description/

class JumpGameThree {
    public boolean canReach(int[] arr, int start) {
        if (arr.length == 1) {
            return arr[0] == 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[arr.length];
        boolean isTest = false;
        int largest = 0;
        int level = 0;

        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("level: " + level + ": " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                int index = queue.poll();
                if (arr[index] == 0) {
                    return true;
                }

                int backIndex = index - arr[index];
                int forwardIndex = index + arr[index];
                if (backIndex >= 0 && !isVisited[backIndex]) {
                    isVisited[backIndex] = true;
                    queue.offer(backIndex);
                }
                if (forwardIndex < arr.length && !isVisited[forwardIndex]) {
                    isVisited[forwardIndex] = true;
                    queue.offer(forwardIndex);
                }
            }
            level++;
        }

        return false;
    }
}
