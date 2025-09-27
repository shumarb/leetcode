// Question: https://leetcode.com/problems/restore-finishing-order/description/

class RestoreFinishingOrder {
    public int[] recoverOrder(int[] order, int[] friends) {
        int[] result = new int[friends.length];
        int k = 0;

        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (order[i] == friends[j]) {
                    result[k++] = friends[j];
                }
            }
        }

        return result;
    }
}