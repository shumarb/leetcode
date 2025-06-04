// Question: https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/

class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] result = null;
        boolean isTest = false;

        Map<String, Integer> map1 = getWordIndexMap(list1);
        if (isTest) {
            System.out.println("list1: " + Arrays.toString(list1));
            System.out.println("list2: " + Arrays.toString(list2));
            System.out.println("map1: " + map1);
            System.out.println("------------------------------------------------------------");
        }

        List<String> wordsOfMinimumIndexSum = new ArrayList<>();
        int minimumIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String word = list2[i];
            if (map1.containsKey(word)) {
                int indexSum = map1.get(word) + i;
                if (indexSum < minimumIndexSum) {
                    minimumIndexSum = indexSum;
                    wordsOfMinimumIndexSum.clear();
                    wordsOfMinimumIndexSum.add(word);
                } else if (indexSum == minimumIndexSum) {
                    wordsOfMinimumIndexSum.add(word);
                }
            }
        }
        if (isTest) {
            System.out.println("minimumIndexSum: " + minimumIndexSum);
            System.out.println("wordsOfMinimumIndexSum: " + wordsOfMinimumIndexSum);
        }

        result = new String[wordsOfMinimumIndexSum.size()];
        for (int i = 0; i < wordsOfMinimumIndexSum.size(); i++) {
            result[i] = wordsOfMinimumIndexSum.get(i);;
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------");
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private List<String> findCommonWords(String[] list1, Map<String, Integer> map2) {
        List<String> result = new ArrayList<>();
        for (String word: list1) {
            if (map2.containsKey(word)) {
                result.add(word);
            }
        }
        return result;
    }

    private Map<String, Integer> getWordIndexMap(String[] list) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            map.put(list[i], i);
        }
        return map;
    }
}