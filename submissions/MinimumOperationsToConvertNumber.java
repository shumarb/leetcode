// Question: https://leetcode.com/problems/minimum-operations-to-convert-number/description/

class MinimumOperationsToConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        boolean isTest = false;
        int level = 0;

        if (isTest) {
            System.out.println("start: " + start + " -> goal: " + goal + "\nnums: " + Arrays.toString(nums));
        }

        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("---------------------------------\nlevel: " + level + ": " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                int top = queue.poll();
                if (top == goal) {
                    if (isTest) {
                        System.out.println(" ** found @ level " + level);
                    }

                    return level;
                }

                List<Integer> neighbours = getNeighbours(top, nums, visited);
                if (isTest) {
                    System.out.println(" * " + top + ": " + neighbours);
                }

                for (int neighbour: neighbours) {
                    if (neighbour == goal) {
                        level++;
                        if (isTest) {
                            System.out.println(" ** found @ level " + level);
                        }

                        return level;
                    }

                    if (neighbour >= 0 && neighbour <= 1000) {
                        queue.offer(neighbour);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    private List<Integer> getNeighbours(int current, int[] nums, Set<Integer> visited) {
        List<Integer> result = new ArrayList<>();

        for (int number: nums) {
            int x = current + number;
            if (!visited.contains(x)) {
                result.add(x);
                visited.add(x);
            }

            x = current - number;
            if (!visited.contains(x)) {
                result.add(x);
                visited.add(x);
            }

            x = current ^ number;
            if (!visited.contains(x)) {
                result.add(x);
                visited.add(x);
            }
        }

        return result;
    }
}
