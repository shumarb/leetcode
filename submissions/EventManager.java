// Question: https://leetcode.com/problems/design-event-manager/description/

class EventManager {
    private Map<Integer, Integer> lastPriority;
    private TreeMap<Integer, TreeSet<Integer>> map;
    private boolean isTest;

    public EventManager(int[][] events) {
        isTest = false;
        lastPriority = new HashMap<>();
        map = new TreeMap<>();

        for (int[] e: events) {
            int event = e[0];
            int priority = e[1];
            lastPriority.put(event, priority);
            map.putIfAbsent(priority, new TreeSet<>());
            map.get(priority).add(event);
        }
        if (isTest) {
            print("map:");
        }
    }

    private void print(String s) {
        System.out.println("-----------------------------\n" + s);
        for (int key: map.keySet()) {
            System.out.println(" * " + key + ": " + map.get(key));
        }
        System.out.println("\nlastPriority: " + lastPriority);
    }

    public void updatePriority(int eventId, int newPriority) {
        if (isTest) {
            print("update | event: " + eventId + ", priority: " + newPriority + "\nmap:");
        }

        // 1. Check if event assigned to a priority.
        // If yes, remove event from that priority's set,
        // and add event to new priority's set.
        if (lastPriority.containsKey(eventId)) {
            int lastPriorityValue = lastPriority.get(eventId);
            lastPriority.remove(eventId);

            if (map.containsKey(lastPriorityValue)) {
                map.get(lastPriorityValue).remove(eventId);
                if (map.get(lastPriorityValue).isEmpty()) {
                    map.remove(lastPriorityValue);
                }
            }

            if (map.containsKey(newPriority)) {
                map.get(newPriority).add(eventId);
                lastPriority.put(eventId, newPriority);
            }
        }

        lastPriority.put(eventId, newPriority);
        map.putIfAbsent(newPriority, new TreeSet<>());
        map.get(newPriority).add(eventId);
    }

    public int pollHighest() {
        if (isTest) {
            print("pollHighest" + "\nmap: ");
        }

        int result = -1;
        if (!map.isEmpty()) {
            int highestPriority = map.lastKey();
            TreeSet<Integer> set = map.get(highestPriority);
            if (!set.isEmpty()) {
                result = map.get(highestPriority).pollFirst();
            }
            if (set.isEmpty()) {
                map.remove(highestPriority);
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */
