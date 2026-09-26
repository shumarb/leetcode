// Question: https://leetcode.com/problems/minimum-queen-moves-to-reach-target/description/

class MiniumumQueenMovesToReachTarget {
    public int minQueenMoves(int[] source, int[] target) {
        int countColumnMoves = Math.abs(source[1] - target[1]);
        int countRowMoves = Math.abs(source[0] - target[0]);

        // 1. source == target.
        if (countColumnMoves == 0 && countRowMoves == 0) {
            return 0;
        }

        // 2. both coordinates share same row or column, so only 1 move required to move from sourceRow -> targetRow, or sourceColumn -> targetColumn; or coordinates lie in same diagonal.
        if (countColumnMoves == 0 || countRowMoves == 0 || countColumnMoves == countRowMoves) {
            return 1;
        }

        return 2;
    }
}
