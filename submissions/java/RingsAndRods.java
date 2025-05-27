// Question: https://leetcode.com/problems/rings-and-rods/description/

class RingsAndRods {
    public int countPoints(String rings) {
        boolean isTest = false;
        int[] blueRods = new int[10];
        int[] greenRods = new int[10];
        int[] redRods = new int[10];
        int countPoints = 0;

        for (int i = 0; i < rings.length(); i += 2) {
            char letter = rings.charAt(i);
            int rod = Character.getNumericValue(rings.charAt(i + 1));
            if (isTest) {
                System.out.println(letter + " -> " + rod);
            }
            if (letter == 'B') {
                blueRods[rod]++;
            } else if (letter == 'G') {
                greenRods[rod]++;
            } else if (letter == 'R') {
                redRods[rod]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (blueRods[i] > 0 && greenRods[i] > 0 && redRods[i] > 0) {
                countPoints++;
            }
        }

        if (isTest) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("rings: " + rings);
            System.out.println("blueRods: " + Arrays.toString(blueRods));
            System.out.println("greenRods: " + Arrays.toString(greenRods));
            System.out.println("redRods: " + Arrays.toString(redRods));
            System.out.println("-------------------------------------------------------------");
            System.out.println("countPoints: " + countPoints);
        }

        return countPoints;
    }
}