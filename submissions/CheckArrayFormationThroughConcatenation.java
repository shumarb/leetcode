// Question: https://leetcode.com/problems/check-array-formation-through-concatenation/description/

class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        boolean isTest = false;
        int[] map = new int[101];

        Arrays.fill(map, -1);
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]] = i;
        }

        for (int[] piece: pieces) {
            if (isTest) {
                System.out.println("---------------------------------------");
                System.out.println("piece: " + Arrays.toString(piece));
            }

            /**
             1.  For pieces of size 1, check if its element is in the map.
             Return false if element is not in the map because array concatenation can't be formed
             if element is not present.
             */
            if (piece.length == 1) {
                if (map[piece[0]] == -1) {
                    return false;
                }

                /**
                 2.  For pieces with more than 1 element,
                 compare two adjacent elements and ensure the indices of each element
                 differs by exactly 1; otherwise, array concatenation can't be formed.
                 */
            } else {
                int previous = piece[0];
                if (map[previous] == -1) {
                    return false;
                }

                for (int i = 1; i < piece.length; i++) {
                    int current = piece[i];
                    if (map[current] == -1) {
                        return false;
                    }

                    int currentIndex = map[current];
                    int previousIndex = map[previous];

                    if (isTest) {
                        System.out.println(" * current: " + current + " -> currentIndex: " + currentIndex);
                        System.out.println(" * previous: " + previous + " -> previousIndex: " + previousIndex);
                    }
                    if (currentIndex - previousIndex != 1) {
                        return false;
                    }

                    previous = current;
                }
            }
        }

        return true;
    }
}