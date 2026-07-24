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

            if (!isPresent[current - 'a']) {
                isPresent[current - 'a'] = true;
            }

            if (current == previous) {
                map[current - 'a'][++count]++;

            } else {
                count = 1;
                map[current - 'a'][1]++;
                previous = current;
            }
        }

        for (int i = 0; i < isPresent.length; i++) {
            if (!isPresent[i]) {
                continue;
            }

            for (int j = n - 1; j >= 1; j--) {
                map[i][j] += map[i][j + 1];
            }
        }
        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters) + "\nmap:");
            for (int i = 0; i < isPresent.length; i++) {
                if (isPresent[i]) {
                    System.out.println(" * " + (char) ('a' + i) + ": " + Arrays.toString(map[i]));
                }
            }
        }

        for (int i = 0; i < isPresent.length; i++) {
            if (!isPresent[i]) {
                continue;
            }

            for (int j = n; j >= 1; j--) {
                if (map[i][j] >= 3) {
                    result = Math.max(j, result);
                    break;
                }
            }
        }

        return result;
    }
}
