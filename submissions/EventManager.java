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
            map.computeIfAbsent(priority, k -> new TreeSet<>()).add(event);
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

        Integer priority = lastPriority.get(eventId);
        if (priority != null) {
            TreeSet<Integer> set = map.get(priority);
            set.remove(eventId);
            if (set.isEmpty()) {
                map.remove(priority);
            }
        }

        lastPriority.put(eventId, newPriority);
        map.computeIfAbsent(newPriority, k -> new TreeSet<>()).add(eventId);
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
