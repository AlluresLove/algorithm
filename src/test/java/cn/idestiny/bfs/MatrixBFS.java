package cn.idestiny.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Lv Fan
 * @description: 广度优先遍历矩阵
 * @date: Create in 2020/7/23 7:27
 *
 * 542. 01 矩阵
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 */
public class MatrixBFS {

    public int[][] updateMatrix(int[][] matrix){
        // 数据判断
        if (matrix == null || matrix.length == 0){
            return null;
        }
        // 1、获取矩阵长度
        int matrix_x = matrix.length,matrix_y = matrix[0].length;
        // 2、创建结果集矩阵
        int[][] res_matrix = new int[matrix_x][matrix_y];
        // 3、创建记录已经计算过结果的结果集
        boolean[][] visited = new boolean[matrix_x][matrix_y];
        // 4、创建广度搜索队列
        Queue<int[]> queue = new LinkedList<>();
        // 5、初始化所有准备数据
        for (int x = 0; x < matrix_x; x++){
            for (int y = 0; y < matrix_y; y++){
                if (matrix[x][y] == 0){
                    res_matrix[x][y] = 0;
                    visited[x][y] = true;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        //初始化上下左右四个位置
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            // 获取为0元素的位置
            int[] poll = queue.poll();
            // x坐标和y坐标
            int x = poll[0],y = poll[1];
            // 遍历0元素周围的四个元素
            for (int n = 0;n < 4 ;n++){
                // 获取上下左右指定位置的值
                int nx = x + direction[n][0],ny = y + direction[n][1];
                // 没有计算过的位置一定为1
                if (nx >= 0 && ny >= 0  && nx < matrix_x && ny < matrix_y && !visited[nx][ny]){
                    // 计算距离
                    res_matrix[nx][ny] = res_matrix[x][y] + 1;
                    // 标记计算完成
                    visited[nx][ny] = true;
                    // 重新计算队列
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        return res_matrix;
    }

}
