// Question: https://leetcode.com/problems/faulty-keyboard/description/

class FaultyKeyboard {
    public String finalString(String s) {
        StringBuilder finalString = new StringBuilder();
        for (char letter: s.toCharArray()) {
            if (letter != 'i') {
                finalString.append(letter);
            } else {
                finalString = finalString.reverse();
            }
        }
        return finalString.toString();
    }
}