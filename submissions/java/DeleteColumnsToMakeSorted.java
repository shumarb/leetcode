// Question: https://leetcode.com/problems/delete-columns-to-make-sorted/description/

class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int minDeletionSize = 0;
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    minDeletionSize++;
                    break;
                }
            }
        }
        return minDeletionSize;
    }
}