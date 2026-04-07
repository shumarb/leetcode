// Question: https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/

class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> recipesSet = new HashSet<>(Arrays.asList(recipes));
        boolean isTest = false;
        int n = recipes.length;

        for (int i = 0; i < n; i++) {
            String recipe = recipes[i];

            for (String part: ingredients.get(i)) {
                graph.computeIfAbsent(part, k -> new ArrayList<>()).add(recipe);
                inDegree.put(recipe, 1 + inDegree.getOrDefault(recipe, 0));
            }
        }
        if (isTest) {
            System.out.println("inDegree:");
            for (String key: inDegree.keySet()) {
                System.out.println(" * " + key + ": " + inDegree.get(key));
            }
            System.out.println("-----------------------------------------------\ngraph:");
            for (String key: graph.keySet()) {
                System.out.println(" * " + key + ": " + graph.get(key));
            }
        }

        for (String supply: supplies) {
            queue.offer(supply);
        }
        while (!queue.isEmpty()) {
            String source = queue.poll();

            if (recipesSet.contains(source)) {
                result.add(source);
            }
            for (String destination: graph.getOrDefault(source, new ArrayList<>())) {
                inDegree.put(destination, inDegree.get(destination) - 1);
                if (inDegree.get(destination) == 0) {
                    queue.offer(destination);
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
