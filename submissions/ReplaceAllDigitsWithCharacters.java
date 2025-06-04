// Question: https://leetcode.com/problems/replace-all-digits-with-characters/description/

class ReplaceAllDigitsWithCharacters {
    public String replaceDigits(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i += 2) {
            int increment = Character.getNumericValue(charArray[i]);
            charArray[i] = (char) (charArray[i - 1] + increment);
        }
        return new String(charArray);
    }
}