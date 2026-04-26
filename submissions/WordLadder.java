// Question: https://leetcode.com/problems/word-ladder/description/

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> unvisited = new HashSet<>(wordList);
        boolean isTest = false;
        int level = 1;

        // 1. Edge case: no path to form endWord.
        if (!unvisited.contains(endWord)) {
            return 0;
        }

        if (isTest) {
            System.out.println(beginWord + " -> " + endWord + "\nunvisited: " + unvisited);
        }

        queue.offer(beginWord);
        unvisited.remove(beginWord);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("-------------------------------------------------");
                System.out.println("level: " + level + ": " + queue);
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String source = queue.poll();

                if (source.equals(endWord)) {
                    if (isTest) {
                        System.out.println(" * found @ level " + level);
                    }

                    return level;
                }

                List<String> neighbours = getNeighbours(source, unvisited);
                if (isTest) {
                    System.out.println(" * source: " + source + ", neighbours: " + neighbours);
                }

                for (String neighbour: neighbours) {
                    if (neighbour.equals(endWord)) {
                        level++;
                        if (isTest) {
                            System.out.println(" * found @ level " + level);
                        }

                        return level;
                    }

                    queue.offer(neighbour);
                }
            }

            level++;
        }

        return 0;
    }

    private List<String> getNeighbours(String source, Set<String> unvisited) {
        List<String> result = new ArrayList<>();
        char[] letters = source.toCharArray();

        for (int j = 0; j < source.length(); j++) {
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (letters[j] == letter) {
                    continue;
                }

                char initial = letters[j];
                letters[j] = letter;

                String adjacentWord = new String(letters);
                if (unvisited.contains(adjacentWord)) {
                    result.add(adjacentWord);
                    unvisited.remove(adjacentWord);
                }

                letters[j] = initial;
            }
        }

        return result;
    }
}
