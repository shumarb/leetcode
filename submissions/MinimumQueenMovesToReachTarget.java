// Question: https://leetcode.com/problems/minimum-queen-moves-to-reach-target/description/

class MiniumumQueenMovesToReachTarget {
    public int minQueenMoves(int[] source, int[] target) {
        // 1. source == target.
        if (Arrays.equals(source, target)) {
            return 0;
        }

        int countColumnMoves = Math.abs(source[1] - target[1]);
        int countRowMoves = Math.abs(source[0] - target[0]);

        // 2. 1 move if both coordinates lie on same diagonal or share either smae row or column.
        return (countColumnMoves == 0 || countRowMoves == 0 || countColumnMoves == countRowMoves) ? 1 : 2;
    }
}
