// Question: https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/

class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> recipesSet = new HashSet<>();
        boolean isTest = false;
        int n = recipes.length;

        for (int i = 0; i < n; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, 0);
            recipesSet.add(recipe);

            for (String part: ingredients.get(i)) {
                inDegree.putIfAbsent(part, 0);
                inDegree.put(recipe, 1 + inDegree.getOrDefault(recipe, 0));
                graph.putIfAbsent(part, new HashSet<>());
                graph.get(part).add(recipe);
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
            System.out.println("-----------------------------------------------");
        }

        for (String supply: supplies) {
            if (inDegree.containsKey(supply) && inDegree.get(supply) == 0) {
                queue.offer(supply);
            }
        }
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println(" * queue: " + queue);
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String source = queue.poll();

                if (recipesSet.contains(source)) {
                    result.add(source);
                }
                if (graph.containsKey(source)) {
                    for (String destination: graph.get(source)) {
                        inDegree.put(destination, inDegree.get(destination) - 1);
                        if (inDegree.get(destination) == 0) {
                            queue.offer(destination);
                        }
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
