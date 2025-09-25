package array.prefix_sum;

import java.util.HashMap;

public class LC523 {
    public static void main(String[] args) {
        var nums = new int[]{5, 0, 0, 0};
        var k = 3;
        System.out.println(checkSubarraySum(nums, k));
    }

    private static boolean checkSubarraySum(int[] nums, int k) {
        // true -> good array, else -> false
        // good array: its length >= 2,
        // total sum is multiple of k
        // sub-array is contiguous
        if (nums.length < 2) {
            return false;
        }

        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        var sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            var mod = (sum % k + k) % k;
            var prefixMod = map.get(mod);
            if (prefixMod != null && i - prefixMod >= 2) return true;
            map.putIfAbsent(mod, i);
        }
        return false;
    }
}
