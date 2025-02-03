// Question: https://leetcode.com/problems/isomorphic-strings/description/

class IsomorphicStrings {
    private boolean test = false;

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Set<Character>> sMap = new HashMap<> ();
        Map<Character, Set<Character>> tMap = new HashMap<> ();
        populate(s, t, sMap);
        populate(t, s, tMap);
        if (test) {
            print(s, sMap);
            print(t, tMap);
        }

        return isValid(sMap) && isValid(tMap);
    }

    private void print(String str, Map<Character, Set<Character>> map) {
        System.out.println("string: " + str);
        for (Map.Entry<Character, Set<Character>> e: map.entrySet()) {
            System.out.println("entry: " + e.getKey() + " - " + e.getValue());
        }
    }

    private void populate(String source, String check, Map<Character, Set<Character>> map) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char sourceLet = source.charAt(i);
            char checkLet = check.charAt(i);
            if (!map.containsKey(sourceLet)) {
                Set<Character> set = new HashSet<> ();
                set.add(checkLet);
                map.put(sourceLet, set);
            } else {
                map.get(sourceLet).add(checkLet);
            }
        }
    }

    private boolean isValid(Map<Character, Set<Character>> map) {
        for (Map.Entry<Character, Set<Character>> e: map.entrySet()) {
            if (e.getValue().size() > 1) {
                return false;
            }
        }
        return true;
    }
}