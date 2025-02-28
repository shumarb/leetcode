// Question: https://leetcode.com/problems/design-an-ordered-stream/description/

class OrderedStream {
    /**
     1.  Use array for a map,
     where the index is the idKey,
     and the element is the value.
     */
    private String[] map;
    private int pointer;
    private int len;

    public OrderedStream(int n) {
        map = new String[n + 1];
        pointer = 1;
    }

    public List<String> insert(int idKey, String value) {
        map[idKey] = value;
        List<String> result = new ArrayList<>();

        /**
         2.  While pointer is at an index whose element is not null, 
         add the element at index pointer to the result,
         and keep incrementing pointer until index whose element is null is encountered.
         */
        while (pointer <= map.length - 1 && map[pointer] != null) {
            result.add(map[pointer++]);
        }

        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */