// Question: https://leetcode.com/problems/accounts-merge/description/

class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToNameMap = new HashMap<>();
        Set<String> isVisited = new HashSet<>();
        boolean isTest = false;

        for (List<String> account: accounts) {
            if (isTest) {
                System.out.println(" * account: " + account);
            }

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String firstEmail = account.get(i);
                emailToNameMap.putIfAbsent(firstEmail, name);
                graph.putIfAbsent(firstEmail, new HashSet<>());

                for (int j = i + 1; j < account.size(); j++) {
                    String additionalEmail = account.get(j);

                    emailToNameMap.putIfAbsent(additionalEmail, name);

                    graph.putIfAbsent(additionalEmail, new HashSet<>());
                    graph.get(additionalEmail).add(firstEmail);
                    graph.get(firstEmail).add(additionalEmail);
                }
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
            String name = emailToNameMap.get(email);
            List<String> component = new ArrayList<>();
            List<String> mergedAccounts = new ArrayList<>();

            component.add(name);
            if (graph.get(email).isEmpty()) {
                component.add(email);
                result.add(component);
                continue;
            }

            if (!isVisited.contains(email)) {
                if (isTest) {
                    System.out.println(" ** dfs: " + email);
                }
                dfs(email, mergedAccounts, isVisited, graph);

                if (mergedAccounts.size() > 1) {
                    Collections.sort(mergedAccounts);
                }

                for (String value: mergedAccounts) {
                    component.add(value);
                }
                result.add(component);
            }
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
