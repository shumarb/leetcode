// Question: https://leetcode.com/problems/letter-tile-possibilities/description/

class LetterTilePossibilities {
    private boolean isTest;

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        isTest = false;

        dfs(new StringBuilder(), set, new boolean[tiles.length()], tiles);

        if (isTest) {
            System.out.println("----------------------------\nset: " + set + "\nresult: " + set.size());
        }

        return set.size();
    }

    private void dfs(StringBuilder path, Set<String> set, boolean[] isIndexUsed, String tiles) {
        if (isTest) {
            System.out.println(" * path: " + path);
        }

        if (path.length() > 0) {
            set.add(path.toString());
        }

        for (int i = 0; i < isIndexUsed.length; i++) {
            if (isIndexUsed[i]) {
                continue;
            }

            path.append(tiles.charAt(i));
            isIndexUsed[i] = true;

            dfs(path, set, isIndexUsed, tiles);

            path.deleteCharAt(path.length() - 1);
            isIndexUsed[i] = false;
        }
    }
}
