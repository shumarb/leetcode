// Question: https://leetcode.com/problems/check-array-formation-through-concatenation/description/

class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        if (isTest) {
            System.out.println("map: " + map);
        }

        for (int[] piece: pieces) {
            if (isTest) {
                System.out.println("---------------------------------------");
                System.out.println("piece: " + Arrays.toString(piece));
            }
            if (piece.length == 1) {
                if (!map.containsKey(piece[0])) {
                    return false;
                }
            } else {
                int previous = piece[0];
                if (!map.containsKey(previous)) {
                    return false;
                }

                for (int i = 1; i < piece.length; i++) {
                    int current = piece[i];
                    if (!map.containsKey(current)) {
                        return false;
                    }

                    int currentIndex = map.get(current);
                    int previousIndex = map.get(previous);

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