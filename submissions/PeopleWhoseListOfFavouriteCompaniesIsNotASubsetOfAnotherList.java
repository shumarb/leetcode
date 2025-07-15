// Question: https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/description/

class PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new ArrayList<>();
        List<Set<String>> map = new ArrayList<>();
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
            Set<String> set = new HashSet<>(favoriteCompanies.get(i));
            map.add(set);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || isSubset[i] || isSubset[j]) {
                    continue;
                }
                Set<String> current = map.get(i);
                Set<String> check = map.get(j);
                if (current.size() >= check.size() && current.containsAll(check)) {
                    isSubset[j] = true;
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
            for (int i = 0; i < map.size(); i++) {
                System.out.println(" * " + i + " -> " + map.get(i));
            }
            System.out.println("------------------------------------------");
            System.out.println("isSubset: " + Arrays.toString(isSubset));
            System.out.println("result: " + result);
        }

        return result;
    }
}