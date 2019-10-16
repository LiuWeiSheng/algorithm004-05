package leetcode.editor.cn;//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_1_480 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
        Solution solution = new Leetcode_1_480().new Solution();
        int[] ints = solution.twoSum(arr, 6);
        System.out.println(ints);
    }


    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> indexMap = map.get(nums[i]);
                if (indexMap != null) {
                    indexMap.add(i);
                } else {
                    indexMap = new ArrayList<>();
                    indexMap.add(i);
                }
                map.put(nums[i], indexMap);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != null && !map.get(complement).isEmpty()) {
                    Integer index = fetchIndex(i, map.get(complement));
                    if (index != null) {
                        return new int[]{i, index};
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }

        private Integer fetchIndex(Integer currentIndex, List<Integer> indexes) {
            for (Integer index : indexes) {
                if (!index.equals(currentIndex)) {
                    return index;
                }
            }
            return null;
        }
    }
}