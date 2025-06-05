// Question: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        char smallestLetter = letters[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] > target) {
                /**
                 current letter greater than target,
                 so all letters from indices [mid + 1, high] are greater than target,
                 so take note of current letter as smallest letter greater than target
                 and set binary search boundary as [low, mid - 1]
                 */
                smallestLetter = letters[mid];
                high = mid - 1;

            } else {
                /**
                 current letter <= target,
                 so all letters from indices [low, mid] <= target,
                 hence discard all these letters and set binary search boundary as [mid + 1, high]
                 */
                low = mid + 1;
            }
        }

        return smallestLetter;
    }
}