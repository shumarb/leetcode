// Question: https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/description/

class EvaluateTheBracketPairsOfAString {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        StringBuilder current;
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        char[] tokens = s.toCharArray();
        int i = 0;
        int n = tokens.length;

        for (List<String> e: knowledge) {
            map.put(e.get(0), e.get(1));
        }
        if (isTest) {
            System.out.println("tokens: " + Arrays.toString(tokens) + "\nmap: " + map);
            System.out.println("----------------------------------------------------");
        }
        while (i < n) {
            char c = tokens[i];

            if (c >= 'a' && c <= 'z') {
                result.append(c);
                i++;

            } else if (c == '(') {
                int j = i + 1;

                while (j < n && tokens[j] != ')') {
                    j++;
                }

                String key = s.substring(i + 1, j);
                String value = map.getOrDefault(key, "?");
                if (isTest) {
                    System.out.println(" * key: " + key + " | indices: [" + i + ", " + (j - 1) + "]" + ", value: " + value);
                }

                result.append(value);

                i = j + 1;
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------\nresult: " + result);
        }

        return result.toString();
    }
}
