// Question: https://leetcode.com/problems/sort-the-students-by-their-kth-score/description/

class SortTheStudentsByTheirKthScore {
    public int[][] sortTheStudents(int[][] score, int k) {
        List<int[]> list = new ArrayList<>();
        for (int[] row: score) {
            list.add(row);
        }
        list.sort((a, b) -> Integer.compare(b[k], a[k]));
        for (int j = 0; j < list.size(); j++) {
            score[j] = list.get(j);
        }
        return score;
    }
}