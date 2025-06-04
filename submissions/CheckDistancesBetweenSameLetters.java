// Question: https://leetcode.com/problems/check-distances-between-same-letters/description/

class CheckDistancesBetweenSameLetters {
    public boolean checkDistances(String s, int[] distance) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("s: " + s + "\ndistance: " + Arrays.toString(distance));
        }

        for (char letter: s.toCharArray()) {
            int indexDifference = computeIndexDifference(s, letter);
            if (isTest) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("letter: " + letter + ", indexDifference: " + indexDifference + ", distance: " + distance[letter - 'a']);
            }
            if (indexDifference != distance[letter - 'a']) {
                return false;
            }
        }

        return true;
    }

    private int computeIndexDifference(String s, char letter) {
        int firstIndex = 0;
        int lastIndex = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == letter) {
                lastIndex = i;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                firstIndex = i;
                break;
            }
        }

        return lastIndex - firstIndex - 1;
    }
}