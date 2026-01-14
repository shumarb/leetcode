// Question: https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/description/

class EvaluateTheBracketPairsOfAString {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder current = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        boolean isTest = false;

        for (List<String> e: knowledge) {
            map.put(e.get(0), e.get(1));
        }
        if (isTest) {
            System.out.println("map: " + map);
            System.out.println("-------------------------------------------------");
        }

        for (char c: s.toCharArray()) {
            if (c == '(') {
                result.append(current);
                current = new StringBuilder();
            } else if (c == ')') {
                if (isTest) {
                    System.out.println(" * within brackets: " + current.toString());
                }
                if (map.containsKey(current.toString())) {
                    result.append(map.get(current.toString()));
                } else {
                    result.append('?');
                }
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        result.append(current);
        if (isTest) {
            System.out.println("-------------------------------------------------");
            System.out.println("result: " + result);
        }

        return result.toString();
    }
}