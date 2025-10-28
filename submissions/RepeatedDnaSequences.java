// Question: https://leetcode.com/problems/repeated-dna-sequences/description/

class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> repeated = new HashSet<>();
        Set<String> seen = new HashSet<>();
        boolean isTest = false;

        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (!seen.add(substring)) {
                repeated.add(substring);
            }
        }
        if (isTest) {
            System.out.println("seen: " + seen + "\nrepeated: " + repeated);
        }

        return new ArrayList<>(repeated);
    }
}