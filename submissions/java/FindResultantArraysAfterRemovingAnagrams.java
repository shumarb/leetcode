// Question: https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/

class FindResultantArraysAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>(Arrays.asList(words));
        boolean isTest = false;
        if (isTest) {
            System.out.println("before, result: " + result);
        }

        for (int i = 1; i < result.size(); i++) {
            String previous = result.get(i - 1);
            String current = result.get(i);
            if (isAnagrams(previous, current)) {
                if (isTest) {
                    System.out.println(" * anagrams: " + previous + ", " + current);
                    System.out.println(" * before removal, result: " + result);
                }

                /**
                 1. Remove anagram found at index i, 
                 and reduce i by 1 to continue comparing current string with new adjacent string after updating result.
                 */
                result.remove(i);
                i--;

                if (isTest) {
                    System.out.println(" * after removal, result: " + result);
                }
            }
        }
        if (isTest) {
            System.out.println("after, result: " + result);
        }

        return result;
    }

    private boolean isAnagrams(String current, String next) {
        char[] currentLetters = current.toCharArray();
        char[] nextLetters = next.toCharArray();
        Arrays.sort(currentLetters);
        Arrays.sort(nextLetters);
        return Arrays.equals(currentLetters, nextLetters);
    }
}