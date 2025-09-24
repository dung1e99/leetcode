package array;

import java.util.HashMap;

public class LC525 {
    public static void main(String[] args) {

        var nums = new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}; //0,1,1,1,1,1,0,0,0
        System.out.println(findMaxLength(nums));
    }

    private static int findMaxLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        var count = 0;
        var total = 0;
        for (var num : nums) {
            if (num == 0) num = -1;
            total += num;
            count++;
            if (map.containsKey(total)) {
                map.put(total, Math.max(count, map.getOrDefault(total, 0)));
                count = 0;
            }
        }
        return map.values().stream().findFirst().orElse(0);
    }
}
