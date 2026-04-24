// Question: https://leetcode.com/problems/word-ladder/description/

class WordLadder {
    private boolean isTest;
    private char[] letters;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> unvisited = new HashSet<>(wordList);
        int level = 1;
        isTest = false;
        letters = new char[26];

        // 1. Edge case: no path to form endWord.
        if (!unvisited.contains(endWord)) {
            return 0;
        }

        for (int i = 0; i < letters.length; i++) {
            letters[i] = (char) (i + 'a');
        }

        if (isTest) {
            System.out.println(beginWord + " -> " + endWord + "\nunvisited: " + unvisited);
        }
        queue.offer(beginWord);
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

                List<String> unvisitedNeighbours = getUnvisitedNeighnours(source, unvisited);
                if (isTest) {
                    System.out.println(" * source: " + source + ", unvisitedNeighbours: " + unvisitedNeighbours);
                }
                for (String neighbour: unvisitedNeighbours) {
                    if (neighbour.equals(endWord)) {
                        if (isTest) {
                            System.out.println(" * found @ level " + (level + 1));
                        }
                        return level + 1;
                    }
                    queue.offer(neighbour);
                }
            }

            level++;
        }

        return 0;
    }

    private List<String> getUnvisitedNeighnours(String source, Set<String> unvisited) {
        List<String> result = new ArrayList<>();
        char[] sourceLetters = source.toCharArray();

        for (int j = 0; j < source.length(); j++) {
            for (char letter: letters) {
                char[] letters = sourceLetters.clone();
                letters[j] = letter;

                String adjacentWord = new String(letters);
                if (unvisited.contains(adjacentWord)) {
                    if (isTest) {
                        System.out.println(" * source: " + source + " -> adjacentWord: " + adjacentWord);
                    }
                    result.add(adjacentWord);
                    unvisited.remove(adjacentWord);
                }
            }
        }

        return result;
    }
}
