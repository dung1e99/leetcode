package array;

import java.util.HashMap;

public class LC560 {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3}; // 1,2,3
        var k = 3;
        System.out.println(subarraySum(nums, k));
    }

    private static int subarraySum(int[] nums, int k) {
        var prefixCountMap = new HashMap<Integer, Integer>();
        prefixCountMap.put(0, 1);

        var prefixSum = 0;
        var count = 0;
        for (var num : nums) {
            prefixSum += num;
            count += prefixCountMap.getOrDefault(prefixSum - k, 0);
            prefixCountMap.put(prefixSum, prefixCountMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
