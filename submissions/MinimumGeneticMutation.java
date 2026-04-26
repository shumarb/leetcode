// Question: https://leetcode.com/problems/minimum-genetic-mutation/description/

class MinimumGeneticMutation {
    private boolean isTest;

    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> unvisited = new HashSet<>();
        int level = 0;
        isTest = false;

        for (String gene: bank) {
            unvisited.add(gene);
        }
        if (isTest) {
            System.out.println(startGene + " -> " + endGene + "\nunvisited: " + unvisited);
        }

        // 1. Both genes are the same, no transformation needed.
        if (startGene.equals(endGene)) {
            return 0;

        } else if (!unvisited.contains(endGene)) {
            // 2. Both genes are different, and no transformation from startGent to endGene can happen.
            return -1;
        }

        queue.offer(startGene);
        unvisited.remove(startGene);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("--------------------------------------------------------------");
                System.out.println("level: " + level + ": " + queue + " | unvisited: " + unvisited);
            }

            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                if (word.equals(endGene)) {
                    if (isTest) {
                        System.out.println(" * found @ level " + level);
                    }
                    return level;
                }

                for (String neighbour: getNeighbours(word, unvisited)) {
                    if (neighbour.equals(endGene)) {
                        if (isTest) {
                            System.out.println(" ** found @ level " + (level + 1));
                        }
                        return level + 1;
                    }
                    queue.offer(neighbour);
                }
            }

            level++;
        }

        return -1;
    }

    private List<String> getNeighbours(String word, Set<String> unvisited) {
        List<String> result = new ArrayList<>();
        char[] available = new char[] {'A', 'C', 'G', 'T'};

        for (int i = 0; i < word.length(); i++) {
            char[] letters = word.toCharArray();
            for (char c: available) {
                letters[i] = c;

                String neighbour = new String(letters);
                if (unvisited.contains(neighbour)) {
                    if (isTest) {
                        System.out.println(" * word: " + word + " -> neighbour: " + neighbour);
                    }
                    result.add(neighbour);
                    unvisited.remove(neighbour);
                }
            }
        }

        return result;
    }
}
