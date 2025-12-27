// Question: https://leetcode.com/problems/count-number-of-teams/description/

class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int count = 0;
        int n = rating.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] <= rating[i]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (rating[k] > rating[j] && rating[k] > rating[i]) {
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] >= rating[i]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (rating[k] < rating[j] && rating[k] < rating[i]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}