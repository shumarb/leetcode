// Question: https://leetcode.com/problems/open-the-lock/description/

class OpenTheLock {
    private Set<String> banned;
    private Set<String> visited;

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        boolean isTest = false;
        int level = 0;
        banned = new HashSet<>();
        visited = new HashSet<>();

        for (String code: deadends) {
            if (code.equals("0000")) {
                return -1;
            }

            visited.add(code);
        }

        if (isTest) {
            System.out.println("target: " + target + "\ndeadends: " + Arrays.toString(deadends));
        }

        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("------------------------------------------------------\nlevel: " + level + "\nqueue: " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                String source = queue.poll();
                if (source.equals(target)) {
                    if (isTest) {
                        System.out.println(" ** found @ level " + level);
                    }

                    return level;
                }

                List<String> neighbours = getNeighbours(source);
                if (isTest) {
                    System.out.println(" * source: " + source + " -> neighbours: " + neighbours);
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

    private List<String> getNeighbours(String source) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < source.length(); i++) {
            char[] digits = source.toCharArray();

            if (digits[i] == '0') {
                digits[i] = '9';
                String key = new String(digits);
                if (!banned.contains(key) && !visited.contains(key)) {
                    result.add(key);
                    visited.add(key);
                }
            }

            digits = source.toCharArray();
            if (digits[i] == '9') {
                digits[i] = '0';
                String key = new String(digits);
                if (!banned.contains(key) && !visited.contains(key)) {
                    result.add(key);
                    visited.add(key);
                }
            }

            digits = source.toCharArray();
            int value = Character.getNumericValue(digits[i]);
            if (value - 1 >= 0) {
                digits[i] = (char) ('0' + value - 1);
                String key = new String(digits);
                if (!banned.contains(key) && !visited.contains(key)) {
                    result.add(key);
                    visited.add(key);
                }
            }

            digits = source.toCharArray();
            value = digits[i] - '0';
            if (value + 1 <= 9) {
                digits[i] = (char) ('0' + value + 1);
                String key = new String(digits);
                if (!banned.contains(key) && !visited.contains(key)) {
                    result.add(key);
                    visited.add(key);
                }
            }
        }

        return result;
    }
}
