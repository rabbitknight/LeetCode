package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

/**
 * <url>
 * https://leetcode-cn.com/problems/sudoku-solver/
 * </url>
 * <p>
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class Sub037 {
    public void solveSudoku(char[][] board) {
        int[] cFlag = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rFlag = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] boxFlag = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public boolean isValidSudoku(char[][] board) {
        int[] cFlag = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rFlag = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] boxFlag = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];  // 获取char
                int box = (j / 3) * 3 + i / 3;
                if (ch == '.') {
                    continue;
                }
                int flag = 0x1 << (ch - '0');
                if (flag == (cFlag[i] & flag) || flag == (rFlag[j] & flag) || (flag == (boxFlag[box] & flag)))
                    return false;
                cFlag[i] |= flag;
                rFlag[j] |= flag;
                boxFlag[box] |= flag;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sub036 sub036 = new Sub036();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean rst = sub036.isValidSudoku(board);
        Printer.println(rst);

    }
}
