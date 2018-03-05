package com.lean.sjh;

/**
 * Created by shanjianhui on 2018/3/5.
 *
 * In a given integer array nums, there is always exactly one largest element.

 Find whether the largest element in the array is at least twice as much as every other number in the array.

 If it is, return the index of the largest element, otherwise return -1.
 */
class Topic747 {
    static int answer(int[] nums){
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return 0;
        }
        int index = -1;
        int maxNumber = Integer.MIN_VALUE;
        int sencondMaxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNumber){
                sencondMaxNumber = maxNumber;
                maxNumber = nums[i];
                index = i;
            }
            else if (nums[i] > sencondMaxNumber && nums[i] < maxNumber){
                sencondMaxNumber = nums[i];
            }
        }

        return maxNumber >= 2*sencondMaxNumber ? index : -1;
    }
}
