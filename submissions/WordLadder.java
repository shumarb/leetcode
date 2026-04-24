// Question: https://leetcode.com/problems/word-ladder/description/

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        boolean isTest = false;
        int level = 1;

        // 1. Edge cases: transformation needed but no path to endWord.
        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);
        for (String word: wordList) {
            graph.put(word, new HashSet<>());
        }
        for (String first: wordList) {
            for (String second: wordList) {
                if (first.equals(second) || first.length() != second.length()) {
                    continue;
                }
                if (isAdjacent(first, second)) {
                    graph.get(first).add(second);
                    graph.get(second).add(first);
                }
            }
        }
        if (isTest) {
            System.out.println("beginWord: " + beginWord + ", endWord: " + endWord);
            System.out.println("wordList: " + wordList + "\n-----------------------------------------------\ngraph:");
            for (String key: graph.keySet()) {
                System.out.println(" * " + key + ": " + graph.get(key));
            }
            System.out.println("-----------------------------------------------");
        }

        queue.offer(beginWord);
        isVisited.add(beginWord);

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println(" * level: " + level + ": " + queue);
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String source = queue.poll();

                if (source.equals(endWord)) {
                    if (isTest) {
                        System.out.println(" ** found @ level " + level);
                    }
                    return level;
                }

                for (String destination: graph.get(source)) {
                    if (destination.equals(endWord)) {
                        if (isTest) {
                            System.out.println(" ** found @ level " + level);
                        }
                        return level + 1;
                    }

                    if (!isVisited.contains(destination)) {
                        isVisited.add(destination);
                        queue.offer(destination);
                    }
                }
            }

            level++;
        }

        return 0;
    }

    private boolean isAdjacent(String first, String second) {
        boolean isTest = true;
        int countLetterDifference = 0;
        int i = 0;
        int j = 0;

        while (i < first.length() && j < second.length()) {
            if (first.charAt(i++) != second.charAt(j++)) {
                if (++countLetterDifference > 1) {
                    return false;
                }
            }
        }

        return countLetterDifference == 1;
    }
}
