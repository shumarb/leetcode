// Question: https://leetcode.com/problems/delete-columns-to-make-sorted/description/

class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int minDeletionSize = 0;
        int wordCount = strs.length;
        int wordLength = strs[0].length();

        for (int j = 0; j < wordLength; j++) {
            for (int i = 0; i < wordCount - 1; i++) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    minDeletionSize++;
                    break;
                }
            }
        }

        return minDeletionSize;
    }
}