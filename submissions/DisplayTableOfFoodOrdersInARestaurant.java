// Question: https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/description/

class DisplayTableOfFoodOrdersInARestaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> foodIndex = new HashMap<>();
        TreeMap<Integer, int[]> map = new TreeMap<>();
        TreeSet<String> foods = new TreeSet<>();
        boolean isTest = false;
        int index = 0;

        for (List<String> order: orders) {
            foods.add(order.get(2));
        }
        for (String food: foods) {
            foodIndex.put(food, index++);
        }
        for (List<String> order: orders) {
            map.put(Integer.valueOf(order.get(1)), new int[foods.size()]);
        }

        for (List<String> order: orders) {
            String foodItem = order.get(2);
            int tableNumber = Integer.valueOf(order.get(1));
            map.get(tableNumber)[foodIndex.get(foodItem)]++;
        }
        if (isTest) {
            System.out.println("foods: " + foods + "\nfoodIndex: " + foodIndex + "\nmap:");
            for (int key: map.keySet()) {
                System.out.println(" * " + key + ": " + Arrays.toString(map.get(key)));
            }
        }

        List<String> line = new ArrayList<>();
        line.add("Table");
        for (String food: foods) {
            line.add(food);
        }
        result.add(line);
        for (int key: map.keySet()) {
            line = new ArrayList<>();
            line.add(Integer.toString(key));
            for (int e: map.get(key)) {
                line.add(Integer.toString(e));
            }
            result.add(line);
        }
        if (isTest) {
            System.out.println("----------------------------------\nresult:");
            for (List<String> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }
}
