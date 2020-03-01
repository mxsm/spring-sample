package com.github.mxsm.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/2/20 22:02
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if(nums == null || nums.length < 3){
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            for(int j = i+1; j < nums.length; ++j){
                Integer[] array = new Integer[3];
                int sum = -(nums[i]+nums[j]);
                for(int k = 0; k < nums.length; ++k){
                    if(k == i || k == j){
                        continue;
                    }
                    if(sum == nums[k]){
                        array[0] = nums[i];
                        array[1] = nums[j];
                        array[2] = nums[k];
                        list.add(Arrays.asList(array));
                    }
                }
            }
        }
        return list;
    }

}
