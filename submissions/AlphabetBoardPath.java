// Question: https://leetcode.com/problems/alphabet-board-path/description/

class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int[] columnMap = getMap('c');
        int[] rowMap = getMap('r');
        int lastColumn = 0;
        int lastRow = 0;

        if (isTest) {
            System.out.println("columnMap: " + Arrays.toString(columnMap) + "\nrowMap:    " + Arrays.toString(rowMap));
            System.out.println("---------------------------------------------------------------------------------------------");
        }

        for (char c: target.toCharArray()) {
            int cColumn = columnMap[c - 'a'];
            int cRow = rowMap[c - 'a'];

            int[] diff = new int[] {cRow - lastRow, cColumn - lastColumn};
            if (isTest) {
                System.out.println(" * c: " + c + " | [" + cRow + ", " + cColumn + "] | last: [" + lastRow + ", " + lastColumn + "] | diff: " + Arrays.toString(diff));
            }

            /**
             1.  Edge case: z is only character with no adjacent neighbours,
                 so move horizontal steps first then move vertical steps
                 to ensure no stepping out of grid.
             */
            if (c == 'z') {
                moveHorizontal(cColumn - lastColumn, result);
                moveVertical(cRow - lastRow, result);
            } else {
                moveVertical(cRow - lastRow, result);
                moveHorizontal(cColumn - lastColumn, result);
            }
            result.append('!');

            lastColumn = cColumn;
            lastRow = cRow;
        }
        if (isTest) {
            System.out.println("---------------------------------------------------------------------------------------------\nresult: " + result);
        }

        return result.toString();
    }

    private void moveVertical(int steps, StringBuilder result) {
        if (steps == 0) {
            return;
        }

        char direction = steps < 0 ? 'U' : 'D';
        if (steps < 0) {
            steps = Math.abs(steps);
        }

        for (int i = 0; i < steps; i++) {
            result.append(direction);
        }
    }

    private void moveHorizontal(int steps, StringBuilder result) {
        if (steps == 0) {
            return;
        }

        char direction = steps < 0 ? 'L' : 'R';
        if (steps < 0) {
            steps = Math.abs(steps);
        }
        for (int i = 0; i < steps; i++) {
            result.append(direction);
        }
    }

    private int[] getMap(char code) {
        String[] words = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        int[] result = new int[26];

        if (code == 'r') {
            for (int i = 0; i < words.length; i++) {
                for (char c: words[i].toCharArray()) {
                    result[c - 'a'] = i;
                }
            }

        } else {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    result[word.charAt(j) - 'a'] = j;
                }
            }
        }

        return result;
    }
}
