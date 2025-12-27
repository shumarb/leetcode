// Question: https://leetcode.com/problems/count-number-of-teams/description/

class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        boolean isTest = false;
        int n = rating.length;
        int result = 0;

        for (int j = 0; j < n; j++) {
            int leftGreater = 0;
            int leftSmaller = 0;
            int rightGreater = 0;
            int rightSmaller = 0;

            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmaller++;
                } else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }

            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    rightSmaller++;
                } else if (rating[k] > rating[j]) {
                    rightGreater++;
                }
            }
            if (isTest) {
                System.out.println("j: " + j + " -> element: " + rating[j]);
                System.out.println(" * leftSmaller: " + leftSmaller + "\n * leftGreater: " + leftGreater);
                System.out.println(" * rightSmaller: " + rightSmaller + "\n * rightGreater: " + rightGreater);
                System.out.println(" ** before | result: " + result);
            }

            // 1. Count triplets of ascending order.
            result += (leftSmaller * rightGreater);

            // 2. Count triplets of descending order.
            result += (rightSmaller * leftGreater);

            if (isTest) {
                System.out.println(" ** after | result: " + result);
                System.out.println("----------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}