// Question: https://leetcode.com/problems/first-unique-character-in-a-string/description/

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] letters = s.toCharArray();
        for (char x: letters) {
            map.put(x, 1 + map.getOrDefault(x, 0));
        }
        for (int i = 0; i < letters.length; i++) {
            if (map.get(letters[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}