package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

/**
 * <url>
 * https://leetcode-cn.com/problems/valid-sudoku/
 * </url>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <cost>
 * 执行用时 : 3 ms, 在Valid Sudoku的Java提交中击败了99.92% 的用户
 * 内存消耗 : 39.8 MB, 在Valid Sudoku的Java提交中击败了92.91% 的用户
 * </cost>
 */
public class Sub036 {
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
