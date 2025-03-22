// Question: https://leetcode.com/problems/sort-vowels-in-a-string/description/

class SortVowelsInAString {
    public String sortVowels(String s) {
        boolean isTest = false;
        StringBuilder result = new StringBuilder();
        List<String> vowels = new ArrayList<>();

        if (isTest) {
            System.out.println("s: " + s);
        }

        for (char letter: s.toCharArray()) {
            if (isVowel(letter)) {
                vowels.add(Character.toString(letter));
            }
        }
        vowels.sort((a, b) -> a.compareTo(b));
        if (isTest) {
            System.out.println("sorted vowels: " + vowels);
        }

        int j = 0;
        for (char letter: s.toCharArray()) {
            if (!isVowel(letter)) {
                result.append(letter);
            } else {
                result.append(vowels.get(j++).charAt(0));
            }
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
                letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U';
    }
}