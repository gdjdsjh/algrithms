package com.lean.sjh;

import java.util.Stack;

/**
 * Created by shanjianhui on 2018/3/26.
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class Topic85 {
    public int answer(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] heights = new int[rows][columns];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            int[] curHeight = new int[columns];
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1'){
                    heights[i][j] = i == 0 ? 1 : heights[i-1][j] + 1;
                }else {
                    heights[i][j] = 0;
                }
                curHeight[j] = heights[i][j];
            }

            //计算当前行为底的Topic84问题
            Stack<Integer> stack = new Stack();
            for (int j = 0; j <= columns; j++) {
                int h = (j == columns ? 0 : curHeight[j]);
                if (stack.isEmpty() || h > curHeight[stack.peek()]){
                    stack.push(j);
                }else {
                    //int index = stack.pop();
                    int topHeight = curHeight[stack.pop()];
                    int area = topHeight * (stack.isEmpty() ? j : j - stack.peek() - 1);
                    maxArea = Math.max(maxArea, area);
                    j--;//继续将当前元素与下一个stack上的元素比较
                }
            }
        }
        return maxArea;
    }
}
