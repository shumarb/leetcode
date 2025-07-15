// Question: https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/description/

class PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Set<String>> map = new HashMap<>();
        boolean[] isSubset = new boolean[favoriteCompanies.size()];
        boolean isTest = false;
        int len = favoriteCompanies.size();

        if (isTest) {
            System.out.println("favoriteCompanies:");
            for (int i = 0; i < len; i++) {
                System.out.println(" * " + i + ": " + favoriteCompanies.get(i));
            }
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < len; i++) {
            List<String> companies = favoriteCompanies.get(i);
            Set<String> set = new HashSet<>();
            for (String company: companies) {
                set.add(company);
            }
            map.put(i, set);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                Set<String> current = map.get(i);
                Set<String> check = map.get(j);
                if (check.containsAll(current)) {
                    isSubset[i] = true;
                }
            }
        }
        for (int i = 0; i < isSubset.length; i++) {
            if (!isSubset[i]) {
                result.add(i);
            }
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, Set<String>> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("------------------------------------------");
            System.out.println("isSubset: " + Arrays.toString(isSubset));
            System.out.println("result: " + result);
        }

        return result;
    }
}