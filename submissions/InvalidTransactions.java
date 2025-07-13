// Question: https://leetcode.com/problems/invalid-transactions/description/

class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        boolean isTest = false;
        int len = transactions.length;

        for (int i = 0; i < len; i++) {
            String[] t1 = transactions[i].split(",");
            if (Integer.parseInt(t1[2]) > 1000) {
                set.add(i);
            }
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                String[] t2 = transactions[j].split(",");
                if (t1[0].equals(t2[0]) && !t1[3].equals(t2[3]) && Math.abs(Integer.parseInt(t1[1]) - Integer.parseInt(t2[1])) <= 60) {
                    set.add(i);
                    set.add(j);
                }
            }
        }
        for (int index: set) {
            result.add(transactions[index]);
        }
        if (isTest) {
            System.out.println("transactions:");
            for (int i = 0; i < len; i++) {
                System.out.println(" * " + i + " --> " + transactions[i]);
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("indices of invalid transactions: " + set);
            System.out.println("---------------------------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }
}