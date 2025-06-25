// Question: https://leetcode.com/problems/stone-removal-game/description/

class StoneRemovalGame {
    public boolean canAliceWin(int n) {
        boolean isTest = false;
        int count = 0;
        int nCopy = n;
        int removal = 10;

        while (nCopy - removal >= 0) {
            nCopy -= removal;
            removal--;
            count++;
        }
        if (isTest) {
            System.out.println("n: " + n + "\ncount: " + count);
        }

        return count % 2 == 0 ? false : true;
    }
}