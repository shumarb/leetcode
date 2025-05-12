// Question: https://leetcode.com/problems/substring-matching-pattern/description/

class SubstringMatchingPattern {
    public boolean hasMatch(String s, String p) {
        String[] parts = p.split("\\*");
        boolean isTest = false;
        int index = 0;
        if (isTest) {
            System.out.println("s: " + s + "\np: " + p + "\nparts: " + Arrays.toString(parts));
        }

        for (String part: parts) {
            int foundIndex = s.indexOf(part, index);
            if (foundIndex == -1) {
                return false;
            }
            index = foundIndex + part.length();
        }

        return true;
    }
}