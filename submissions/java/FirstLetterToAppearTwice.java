// Question: https://leetcode.com/problems/first-letter-to-appear-twice/description/

class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<> ();
        for (char letter: s.toCharArray()) {
            if (set.contains(letter)) {
                return letter;
            }
            set.add(letter);
        }
        return ' '; // dummy variable that won't be reached.
    }
}