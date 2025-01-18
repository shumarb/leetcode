// Question: https://leetcode.com/problems/word-pattern/description/

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        boolean t = true;
        int n = pattern.length();
        Map<Character, String> m1 = new HashMap<> ();
        Map<String, Character> m2 = new HashMap<> ();

        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (m1.containsKey(c)) {
                if (!m1.get(c).equals(w)) {
                    return false;
                }
            } else {
                m1.put(c, w);
            }
        }
        if (t) {
            System.out.println("m1: " + m1);
        }

        for (int i = 0; i < n; i++) {
            String w = words[i];
            char c = pattern.charAt(i);
            if (m2.containsKey(w)) {
                if (c != m2.get(w)) {
                    return false;
                }
            } else {
                m2.put(w, c);
            }
        }

        return true;
    }
}