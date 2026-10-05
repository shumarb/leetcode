// Question: https://leetcode.com/problems/group-anagrams/description/

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs));
        }

        Map<String, List<String>> map = new HashMap<>();
        boolean isTest = false;

        if (isTest) {
            System.out.println("strs: " + Arrays.toString(strs) + "\n----------------------------------------");
        }
        for (String word: strs) {
            char[] letters = word.toCharArray();
            sort(letters);
            if (isTest) {
                System.out.println("word: " + word + " -> sorted letters: " + Arrays.toString(letters));
            }

            map.computeIfAbsent(new String(letters), k -> new ArrayList<>()).add(word);
        }
        if (isTest) {
            System.out.println("----------------------------------------\nmap:");
            for (String key: map.keySet()) {
                System.out.println(" * " + key + ": " + map.get(key));
            }
        }

        return new ArrayList<>(map.values());
    }

    private void sort(char[] letters) {
        int[] count = new int[26];
        int j = 0;

        for (char letter: letters) {
            count[letter - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            char letter = (char) ('a' + i);

            while (count[i]-- > 0) {
                letters[j++] = letter;
            }
        }
    }
}
