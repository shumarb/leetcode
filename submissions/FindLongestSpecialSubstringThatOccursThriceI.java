// Question: https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/

class FindLongestSpecialSubstringThatOccursThriceI {
    public int maximumLength(String s) {
        boolean[] isPresent = new boolean[26];
        boolean isTest = false;
        char[] letters = s.toCharArray();
        char previous = letters[0];
        int count = 1;
        int n = letters.length;
        int result = -1;
        int[][] map = new int[26][n + 1];

        isPresent[previous - 'a'] = true;
        map[previous - 'a'][1]++;

        for (int i = 1; i < n; i++) {
            char current = letters[i];
            int index = current - 'a';

            if (!isPresent[index]) {
                isPresent[index] = true;
            }

            if (current == previous) {
                map[index][++count]++;

            } else {
                count = 1;
                map[index][1]++;
                previous = current;
            }
        }

        for (int i = 0; i < isPresent.length; i++) {
            if (!isPresent[i]) {
                continue;
            }

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
            System.out.println("letters: " + Arrays.toString(letters));
            System.out.println("------------------------------\nmap:");
            for (int i = 0; i < isPresent.length; i++) {
                if (isPresent[i]) {
                    System.out.println(" * " + (char) ('a' + i) + ": " + Arrays.toString(map[i]));
                }
            }
            System.out.println("------------------------------\nresult: " + result);
        }

        return result;
    }
}
