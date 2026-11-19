// Question: https://leetcode.com/problems/total-distance-traveled/description/

class TotalDistanceTraveled {
    public int distanceTraveled(int mainTank, int additionalTank) {
        boolean isTest = false;
        int result = 0;

        while (mainTank >= 5) {
            if (isTest) {
                System.out.println("before:\n * mainTank: " + mainTank + "\n * additionalTank: " + additionalTank);
            }

            result += 50;
            mainTank -= 5;

            if (additionalTank > 0) {
                additionalTank--;
                mainTank += 1;
            }

            if (isTest) {
                System.out.println("\nafter:\n * mainTank: " + mainTank + "\n * additionalTank: " + additionalTank);
                System.out.println("------------------------------------");
            }
        }

        result += (mainTank * 10);
        if (isTest) {
            System.out.println("final:\n * mainTank: " + mainTank + "\n * additionalTank: " + additionalTank + "\n\nresult: " + result);
        }

        return result;
    }
}
