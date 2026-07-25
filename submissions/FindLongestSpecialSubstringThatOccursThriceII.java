// Question: https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/description/

class FindLongestSpecialSubstringThatOccursThriceII {
    public int maximumLength(String s) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        char previous = letters[0];
        int count = 1;
        int n = s.length();
        int result = -1;
        int[][] map = new int[26][n + 1];

        map[previous - 'a'][1]++;

        for (int i = 1; i < n; i++) {
            char current = letters[i];
            int index = current - 'a';

            if (current == previous) {
                map[index][++count]++;

            } else {
                count = 1;
                map[index][1]++;
                previous = current;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = n - 1; j >= 1; j--) {
                map[i][j] += map[i][j + 1];

                if (map[i][j] >= 3) {
                    result = Math.max(result, j);
                    break;
                }
            }

            if (result == n) {
                break;
            }
        }
        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters) + "\n------------------------------\nmap:");
            for (int i = 0; i < 26; i++) {
                System.out.println(" * " + (char) ('a' + i) + ": " + Arrays.toString(map[i]));
            }
            System.out.println("------------------------------\nresult: " + result);
        }

        return result;
    }
}
