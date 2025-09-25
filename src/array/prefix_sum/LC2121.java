package array.prefix_sum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC2121 {
    public static void main(String[] args) {
        var arr = new int[]{2, 1, 3, 1, 2, 3, 3};
        System.out.println(Arrays.toString(getDistances(arr)));
    }

    private static long[] getDistances(int[] arr) {

        var map = IntStream.range(0, arr.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> arr[i]));

        var ret = new long[arr.length];

        for (var indices : map.values()) {
            if (indices.size() == 1) continue;
            var prefixSum = new long[indices.size() + 1];

            for (int i = 0; i < indices.size(); i++) {
                prefixSum[i + 1] = prefixSum[i] + indices.get(i);
            }

            for (int i = 0; i < indices.size(); i++) {
                var pos = indices.get(i);
                var leftSum = (long) i * pos - prefixSum[i];
                var rightSum = (prefixSum[indices.size()] - prefixSum[i + 1]) - (long) (indices.size() - i - 1) * pos;
                ret[pos] = leftSum + rightSum;
            }
        }
        return ret;
    }
}
