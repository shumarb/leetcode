// Question: https://leetcode.com/problems/stock-price-fluctuation/description/

class StockPrice {
    private Map<Integer, Integer> timestampPrice;
    private TreeMap<Integer, Integer> priceCount;
    private int latest;

    public StockPrice() {
        latest = 0;
        priceCount = new TreeMap<>();
        timestampPrice = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        if (timestampPrice.containsKey(timestamp)) {
            int previousPrice = timestampPrice.get(timestamp);
            int previousCount = priceCount.get(previousPrice);

            if (previousCount == 1) {
                priceCount.remove(previousPrice);
            } else {
                priceCount.put(previousPrice, previousCount - 1);
            }
        }

        timestampPrice.put(timestamp, price);
        priceCount.put(price, 1 + priceCount.getOrDefault(price, 0));
        latest = Math.max(latest, timestamp);
    }

    public int current() {
        return timestampPrice.get(latest);
    }

    public int maximum() {
        return priceCount.lastKey();
    }

    public int minimum() {
        return priceCount.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */