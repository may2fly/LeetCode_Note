/**
 * 36. 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 1、数字 1-9 在每一行只能出现一次。
 * 2、数字 1-9 在每一列只能出现一次。
 * 3、数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
*/

/**
 * 思路：
 * 1. 遍历矩阵，判断每一行、每一列、每一个3x3宫内是否有重复的数字
 * 2. 遍历矩阵，判断
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] grids = new int[3][3][9];//此为三维数组，需要注意

        int m = board.length, n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    int index = ch - '0' - 1;   //数字开始与数组开始差1，需要减1

                    rows[i][index] = rows[i][index] + 1;
                    cols[j][index] = cols[j][index] + 1;
                    grids[i/3][j/3][index] = grids[i/3][j/3][index] + 1;

                    if(rows[i][index] > 1 || cols[j][index] > 1 || grids[i/3][j/3][index] > 1){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}