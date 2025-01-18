package java;// Question: https://leetcode.com/problems/majority-element-ii/description/

import java.util.*;

class MajorityElementTwo {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean t = false;

        for (int x: nums) {
            map.put(x, 1 + map.getOrDefault(x, 0));
        }
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("map: " + map);
            System.out.println("list: " + list);
        }
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (t) {
                System.out.println("e: " + e);
            }
            if (e.getValue() > (nums.length / 3)) {
                list.add(e.getKey());
            }
        }
        if (t) {
            System.out.println("after | list: " + list);
        }
        
        return list;
    }
}