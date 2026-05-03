// Question: https://leetcode.com/problems/sort-vowels-in-a-string/description/

class SortVowelsInAString {
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        boolean isTest = false;
        char[] letters = s.toCharArray();

        for (char letter: letters) {
            if (isVowel(letter)) {
                list.add(letter);
            }
        }
        Collections.sort(list);
        if (isTest) {
            System.out.println("s: " + s + "\nbefore, letters: " + Arrays.toString(letters) + "\nlist: " + list);
        }

        int j = 0;
        for (int i = 0; i < letters.length; i++) {
            if (isVowel(letters[i])) {
                letters[i] = list.get(j++);
            }
        }
        if (isTest) {
            System.out.println("after, letters: " + Arrays.toString(letters));
        }

        return new String(letters);
    }

    private boolean isVowel(char letter) {
        return letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' ||
                letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}
