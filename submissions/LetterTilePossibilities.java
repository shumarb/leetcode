// Question: https://leetcode.com/problems/letter-tile-possibilities/description/

class LetterTilePossibilities {
    private int result;

    public int numTilePossibilities(String tiles) {
        char[] letters = tiles.toCharArray();
        result = 0;

        Arrays.sort(letters);
        dfs(new boolean[tiles.length()], letters);

        return result;
    }

    private void dfs(boolean[] isIndexUsed, char[] letters) {
        for (int i = 0; i < isIndexUsed.length; i++) {
            if (i > 0 && !isIndexUsed[i - 1] && letters[i] == letters[i - 1]) {
                continue;
            }

            if (!isIndexUsed[i]) {
                isIndexUsed[i] = true;
                result++;
                dfs(isIndexUsed, letters);
                isIndexUsed[i] = false;
            }
        }
    }
}
