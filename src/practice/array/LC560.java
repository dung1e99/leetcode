package practice.array;

import java.util.HashMap;

public class LC560 {

    public static void main(String[] args) {
        var nums = new int[]{1, 1, 1};
        var k = 2;
        System.out.println(subarraySum(nums, k));
    }

    private static int subarraySum(int[] nums, int k) {
        var prefixMap = new HashMap<Integer, Integer>();
        prefixMap.put(0, 1);
        var count = 0;
        var prefixSum = 0;

        for (var num : nums) {
            prefixSum += num;
            count += prefixMap.getOrDefault(prefixSum - k, 0);
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
