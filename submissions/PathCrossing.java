// Question: https://leetcode.com/problems/path-crossing/description/

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        boolean isPathCrossed = false;
        boolean isTest = false;
        int[] coordinates = new int[2];

        set.add("[0, 0]");
        for (char letter: path.toCharArray()) {
            if (letter == 'N') {
                coordinates[0]++;
            } else if (letter == 'S') {
                coordinates[0]--;
            } else if (letter == 'W') {
                coordinates[1]--;
            } else {
                coordinates[1]++;
            }

            String value = "[" + coordinates[0] + ", " + coordinates[1] + "]";
            if (set.contains(value)) {
                isPathCrossed = true;
                break;
            }
            set.add(value);
        }
        if (isTest) {
            System.out.println("path: " + path + "\nset: " + set);
            System.out.println("\ncoordinates: " + Arrays.toString(coordinates) + "\nisPathCrossed: " + isPathCrossed);
        }

        return isPathCrossed;
    }
}