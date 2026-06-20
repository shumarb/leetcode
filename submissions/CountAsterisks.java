// Question: https://leetcode.com/problems/count-asterisks/description/

class CountAsterisks {
    public int countAsterisks(String s) {
        boolean isTest = false;
        char[] tokens = s.toCharArray();
        int[] indicesOfBar = new int[1001];
        int index = 0;
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == '|') {
                indicesOfBar[index++] = i;
            }
        }
        if (index == 0) {
            return count(tokens, 0, tokens.length - 1);
        }

        if (isTest) {
            System.out.println("indicesOfBar: " + Arrays.toString(Arrays.copyOfRange(indicesOfBar, 0, index)) + "\n-----------------------");
            System.out.println(" * check: [0," + (indicesOfBar[0] - 1) + "]: " + s.substring(0, indicesOfBar[0]));
        }

        result += count(tokens, 0, indicesOfBar[0]);
        for (int i = 1; i < index - 1; i += 2) {
            int start = indicesOfBar[i] + 1;
            int end = indicesOfBar[i + 1] - 1;
            if (isTest) {
                System.out.println(" * check: [" + start + ", " + end + "]: " + s.substring(start, end + 1));
            }
            result += count(tokens, start, end);
        }

        result += count(tokens, indicesOfBar[index - 1] + 1, tokens.length - 1);
        if (isTest) {
            System.out.println("-----------------------\nresult: " + result);
        }

        return result;
    }

    private int count(char[] tokens, int start, int end) {
        int result = 0;

        for (int i = start; i <= end; i++) {
            if (tokens[i] == '*') {
                result++;
            }
        }

        return result;
    }
}
