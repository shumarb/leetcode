// Question: https://leetcode.com/problems/custom-sort-string/description/

class CustomSortString {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        Arrays.fill(map, Integer.MAX_VALUE);
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        List<Character> letters = new ArrayList<>();
        boolean isTest = false;
        for (char letter: s.toCharArray()) {
            letters.add(letter);
        }
        letters.sort(
                (a, b) -> Integer.compare(map[a - 'a'], map[b - 'a']) == 0
                        ? Character.compare(a, b)
                        : Integer.compare(map[a - 'a'], map[b - 'a'])
        );
        if (isTest) {
            System.out.println("order: " + order + "\ns: " + s + "\nletters: " + letters);
        }

        StringBuilder result = new StringBuilder();
        for (char letter: letters) {
            result.append(letter);
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}