// Question: https://leetcode.com/problems/search-suggestions-system/description/

class SearchSuggestionsSystem {
    private boolean isTest = false;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        StringBuilder word = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            word.append(searchWord.charAt(i));
            List<String> suggestions = getSuggestions(word.toString(), products);
            result.add(suggestions);
        }
        if (isTest) {
            System.out.println("result:");
            for (List<String> suggestion: result) {
                System.out.println(" * " + suggestion);
            }
        }

        return result;
    }

    private List<String> getSuggestions(String word, String[] products) {
        List<String> suggestions = new ArrayList<>();
        if (isTest) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("word: " + word);
        }

        for (String product: products) {
            if (product.startsWith(word)) {
                if (isTest) {
                    System.out.println(" * adding: " + product);
                }
                suggestions.add(product);
            }
        }
        Collections.sort(suggestions);

        if (suggestions.size() > 3) {
            if (isTest) {
                System.out.println(" ** more than 3 suggestions. update.");
                System.out.println(" *** before, suggestions: " + suggestions);
            }
            List<String> updated = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                updated.add(suggestions.get(i));
            }
            if (isTest) {
                System.out.println(" *** after, suggestions: " + suggestions);
            }
            return updated;
        }

        return suggestions;
    }
}
