package com.gyx.leetcode.list1_50;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //判断行
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (!isOneToNine(aChar)) {
                    return false;
                }
            }
            contrast = new char[9];
        }

        //判断列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isOneToNine(board[j][i])) {
                    return false;
                }
            }
            contrast = new char[9];
        }

        //行倍数
        int row = 0;
        //列倍数
        int col = 0;
        //判断九宫格
        while (row <= 2 && col <= 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!isOneToNine(board[i + 3 * row ][j + 3 * col])) {
                        return false;
                    }
                }
            }
            contrast = new char[9];
            ++col;
            if (col == 3) {
                col = 0;
                ++row;
            }
        }
        return true;
    }

    private char[] contrast = new char[9];

    public boolean isOneToNine(char c) {
        if (c == '.') {
            return true;
        }
        if ('0' > c || c > '9') {
            return false;
        }
        if (contrast[Integer.parseInt("" + c) - 1] == c) {
            return false;
        } else {
            contrast[Integer.parseInt("" + c) - 1] = c;
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();

        boolean validSudoku = isValidSudoku.isValidSudoku(new char[][]{
                {'.','.','1',    '.','.','.',   '3','.','.'},
                {'.','.','4',    '.','.','.',   '1','.','.'},
                {'.','.','.',    '.','.','.',   '.','.','.'},

                {'.','.','.',    '.','8','.',   '.','.','.'},
                {'.','1','.',    '.','2','.',   '.','.','.'},
                {'.','.','.',    '.','.','.',   '6','3','.'},

                {'7','.','.',    '.','.','.',   '.','.','.'},
                {'5','8','.',    '.','.','.',   '4','.','.'},
                {'.','5','.',    '.','4','.',   '.','.','8'}
        });
        System.out.println(validSudoku);

        validSudoku = isValidSudoku.isValidSudoku(new char[][]{
                {'.','.','.',    '.','5','.',   '.','1','.'},
                {'.','4','.',    '3','.','.',   '.','.','.'},
                {'.','.','.',    '.','.','3',   '.','.','1'},

                {'8','.','.',    '.','.','.',   '.','2','.'},
                {'.','.','2',    '.','7','.',   '.','.','.'},
                {'.','1','5',    '.','.','.',   '.','.','.'},

                {'.','.','.',    '.','.','2',   '.','.','.'},
                {'.','2','.',    '9','.','.',   '.','.','.'},
                {'.','.','4',    '.','.','.',   '.','.','.'}
        });
        System.out.println(validSudoku);

        validSudoku = isValidSudoku.isValidSudoku(new char[][]{
                {'.','2','.',     '.','.','.',   '.','.','.'},
                {'.','.','.',     '.','.','.',   '5','.','1'},
                {'.','.','.',     '.','.','.',   '8','1','3'},


                {'4','.','9',     '.','.','.',   '.','.','.'},
                {'.','.','.',     '.','.','.',   '.','.','.'},
                {'.','.','2',     '.','.','.',   '.','.','.'},


                {'7','.','6',     '.','.','.',   '.','.','.'},
                {'9','.','.',     '.','.','4',   '.','.','.'},
                {'.','.','.',     '.','.','.',   '.','.','.'}
        });
        System.out.println(validSudoku);
    }


}
