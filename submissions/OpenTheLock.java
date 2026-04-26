// Question: https://leetcode.com/problems/open-the-lock/description/

class OpenTheLock {
    private char[] next;
    private char[] previous;

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> banned = new HashSet<>(List.of(deadends));
        Set<String> visited = new HashSet<>();
        boolean isTest = false;
        int level = 0;
        next = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        previous = new char[] {'9', '0', '1', '2', '3', '4', '5', '6', '7', '8'};

        if (isTest) {
            System.out.println("target: " + target + "\nbanned: " + banned);
        }

        // 1. Edge case: impossible to unlock if start of target are deadends.
        if (banned.contains("0000") || banned.contains(target)) {
            return -1;

        } else if (target.equals("0000")) {
            return 0;
        }

        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("------------------------------------------------------");
                System.out.println("level: " + level + ": " + queue);
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String code = queue.poll();
                if (code.equals(target)) {
                    if (isTest) {
                        System.out.println(" ** found @ level " + level);
                    }
                    return level;
                }

                List<String> neighbours = getNeighbours(code, banned, visited);
                if (isTest) {
                    System.out.println(" * " + code + " -> neighbours: " + neighbours);
                }

                for (String neighbour: neighbours) {
                    if (neighbour.equals(target)) {
                        level++;
                        if (isTest) {
                            System.out.println(" ** found @ level " + level);
                        }

                        return level;
                    }

                    queue.offer(neighbour);
                }
            }

            level++;
        }

        return -1;
    }

    private List<String> getNeighbours(String code, Set<String> banned, Set<String> visited) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < code.length(); i++) {
            String neighbour;
            char[] digits = code.toCharArray();

            char initial = digits[i];
            digits[i] = next[initial - '0'];
            neighbour = new String(digits);
            if (!banned.contains(neighbour) && !visited.contains(neighbour)) {
                result.add(neighbour);
                visited.add(neighbour);
            }

            digits[i] = previous[initial - '0'];
            neighbour = new String(digits);
            if (!banned.contains(neighbour) && !visited.contains(neighbour)) {
                result.add(neighbour);
                visited.add(neighbour);
            }
        }

        return result;
    }
}
