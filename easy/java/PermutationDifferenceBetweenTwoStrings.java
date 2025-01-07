// Question: https://leetcode.com/problems/permutation-difference-between-two-strings/description/

class PermutationDifferenceBetweenTwoStrings {
    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        boolean isTest = false;
        populate(s, sMap);
        populate(t, tMap);
        if (isTest) {
            System.out.println("s: " + s + " | sMap: " + sMap);
            System.out.println("t: " + t + " | tMap: " + tMap);
        }
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            if (isTest) {
                System.out.println("letter: " + letter);
            }
            int sVal = 0;
            int tVal = 0;
            if (sMap.containsKey(letter)) {
                sVal = sMap.get(letter);
            } else {
                sVal = 0;
            }
            if (tMap.containsKey(letter)) {
                tVal = tMap.get(letter);
            } else {
                tVal = 0;
            }
            if (isTest) {
                System.out.println("sVal = " + sVal + ", tVal = " + tVal);
            }
            sum += Math.abs(sVal - tVal);
        }
        return sum;
    }

    private void populate(String s, Map<Character, Integer> map) {
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            char letter = s.charAt(i);
            map.put(letter, i);
        }
    }
}