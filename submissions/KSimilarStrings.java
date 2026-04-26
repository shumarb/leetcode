// Question: https://leetcode.com/problems/k-similar-strings/description/

class KSimilarStrings {
    public int kSimilarity(String s1, String s2) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean isTest = false;
        int level = 0;

        if (isTest) {
            System.out.println(s1 + " -> " + s2);
        }
        if (s1.equals(s2)) {
            return 0;
        }

        queue.offer(s1);
        visited.add(s1);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("------------------------------------------------\nlevel: " + level + ": " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                if (word.equals(s2)) {
                    if (isTest) {
                        System.out.println(" ** found @ level " + level);
                    }

                    return level;
                }

                List<String> neighbours = getNeighbours(word, s2, visited);
                if (isTest) {
                    System.out.println(" * " + word + " -> neighbours: " + neighbours);
                }

                for (String neighbour: neighbours) {
                    if (neighbour.equals(s2)) {
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

    private List<String> getNeighbours(String source, String target, Set<String> visited) {
        List<String> result = new ArrayList<>();
        char[] sourceLetters = source.toCharArray();
        char[] targetLetters = target.toCharArray();
        int i = 0;
        int n = source.length();

        // 1. Skip characters that are already in correct position as no swaps required.
        while (i < n && source.charAt(i) == target.charAt(i)) {
            i++;
        }

        // 2. From letters @ indices [i + 1, n - 1], both conditions must be true
        // condition 1: j-th character of source == i-th character of target (swap is possible)
        // condition 2: j-th character of source and target are different (swapping does not affect a character that is already in its correct position), proceed.
        for (int j = i + 1; j < n; j++) {
            if (sourceLetters[j] == targetLetters[i] && sourceLetters[j] != targetLetters[j]) {
                char[] neighbourLetters = source.toCharArray();
                char temp = neighbourLetters[i];
                neighbourLetters[i] = neighbourLetters[j];
                neighbourLetters[j] = temp;

                String neighbour = new String(neighbourLetters);
                if (!visited.contains(neighbour)) {
                    result.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return result;
    }
}
