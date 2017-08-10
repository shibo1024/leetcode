package h1.t0;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/7].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 18;
        int[] result = new TwoSum().twoSum(input, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}