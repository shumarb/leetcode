// Question: https://leetcode.com/problems/accounts-merge/description/

class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        Set<String> isVisited = new HashSet<>();
        boolean isTest = false;

        if (accounts.size() == 1) {
            return accounts;
        }

        for (List<String> account: accounts) {
            if (isTest) {
                System.out.println(" * account: " + account);
            }

            String firstEmail = account.get(1);
            String name = account.get(0);

            graph.putIfAbsent(firstEmail, new HashSet<>());
            owner.put(firstEmail, name);

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);

                graph.putIfAbsent(email, new HashSet<>());
                owner.putIfAbsent(email, name);

                /**
                 1.  Store edges connecting email to firstEmail and vice versa,
                 so that DFS checks all emails in same component, ensuring faster time
                 compared to storing all email connections.
                 */
                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------\nowner:");
            for (String key: owner.keySet()) {
                System.out.println(" * " + key + ": " + owner.get(key));
            }
            System.out.println("----------------------------------------\ngraph");
            for (String key: graph.keySet()) {
                System.out.println(" * " + key + ": " + graph.get(key));
            }
            System.out.println("----------------------------------------");
        }

        for (String email: graph.keySet()) {
            if (isVisited.contains(email)) {
                continue;
            }

            List<String> component = new ArrayList<>();
            List<String> mergedAccounts = new ArrayList<>();

            component.add(owner.get(email));

            if (isTest) {
                System.out.println(" ** dfs: " + email);
            }

            dfs(email, mergedAccounts, isVisited, graph);
            if (mergedAccounts.size() > 1) {
                Collections.sort(mergedAccounts);
            }
            component.addAll(mergedAccounts);
            result.add(component);
        }
        if (isTest) {
            System.out.println("----------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(String source, List<String> accounts, Set<String> isVisited, Map<String, Set<String>> graph) {
        accounts.add(source);
        isVisited.add(source);

        for (String destination: graph.get(source)) {
            if (!isVisited.contains(destination)) {
                dfs(destination, accounts, isVisited, graph);
            }
        }
    }
}
