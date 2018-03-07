package com.lean.sjh;

import java.util.Stack;

/**
 * Created by shanjianhui on 2018/3/6.
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class Topic84 implements IntegersToInteger{

    @Override
    public int answer(int[] heights) {
        int maxArea = 0;
        //主要思路：指针从左往右扫，遇到stack为空或者大于stack top那个高度的把索引push到stack里，
        // 当遇到小于的就pop出top的计算以它为最低的面积，然后跟maxArea比较一下，保留最大的。
        //总的思路就是计算每个柱子以自己为高度的最大面积，然后求最大
        Stack<Integer> stack = new Stack<>();
        // i <= heights.length 有深意，斟酌一下
        for (int i = 0; i <= heights.length; i++){
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || heights[stack.peek()] < h){
                stack.push(i);
            }else {
                int topHeight = heights[stack.pop()];
                //这里照顾到了所有高度都一致时的处理，需要注意一下
                int area = topHeight * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
                //i减一是为了重新把当前元素跟stack的top进行下一轮的比较
                i--;
            }
        }
        return maxArea;
    }
}
