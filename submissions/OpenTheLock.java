// Question: https://leetcode.com/problems/open-the-lock/description/

class OpenTheLock {
    private Set<String> banned;
    private Set<String> visited;
    private char[] next;
    private char[] previous;

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        boolean isTest = false;
        int level = 0;
        banned = new HashSet<>();
        next = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        previous = new char[] {'9', '0', '1', '2', '3', '4', '5', '6', '7', '8'};
        visited = new HashSet<>();

        for (String code: deadends) {
            if (code.equals("0000")) {
                return -1;
            }
            banned.add(code);
        }

        if (isTest) {
            System.out.println("target: " + target + "\nbanned: " + banned);
        }

        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("----------------------------------------------------------\nlevel: " + level + ": " + queue);
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String code = queue.poll();
                if (code.equals(target)) {
                    if (isTest) {
                        System.out.println(" * found @ level " + level);
                    }
                    return level;
                }

                List<String> neighbours = getNeighbours(code);
                if (isTest) {
                    System.out.println(" * code: " + code + " -> neighbours: " + neighbours);
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

    private List<String> getNeighbours(String code) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < code.length(); i++) {
            String key;
            char[] digits = code.toCharArray();

            digits[i] = next[digits[i] - '0'];
            key = new String(digits);
            if (!banned.contains(key) && !visited.contains(key)) {
                result.add(key);
                visited.add(key);
            }

            digits = code.toCharArray();
            digits[i] = previous[digits[i] - '0'];
            key = new String(digits);
            if (!banned.contains(key) && !visited.contains(key)) {
                result.add(key);
                visited.add(key);
            }
        }

        return result;
    }
}
