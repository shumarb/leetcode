// Question: https://leetcode.com/problems/accounts-merge/description/

class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToNameMap = new HashMap<>();
        Set<String> isVisited = new HashSet<>();
        boolean isTest = false;

        // 1. Edge case: 1 account.
        if (accounts.size() == 1) {
            result.add(accounts.get(0));
            return result;
        }

        for (List<String> account: accounts) {
            if (isTest) {
                System.out.println(" * account: " + account);
            }

            String firstEmail = account.get(1);
            String name = account.get(0);

            emailToNameMap.put(firstEmail, name);
            graph.putIfAbsent(firstEmail, new HashSet<>());

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);

                emailToNameMap.putIfAbsent(email, name);
                graph.putIfAbsent(email, new HashSet<>());

                /**
                 2.  Store edges connecting email to firstEmail and vice versa,
                 so that DFS checks all emails in same component, ensuring faster time
                 compared to storing all email connections.
                 */
                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------\ngraph");
            for (String key: graph.keySet()) {
                System.out.println(" * " + key + ": " + graph.get(key));
            }
            System.out.println("----------------------------------------");
        }

        for (String email: graph.keySet()) {
            List<String> component = new ArrayList<>();
            List<String> mergedAccounts = new ArrayList<>();

            component.add(emailToNameMap.get(email));
            if (isVisited.contains(email)) {
                continue;
            }

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
