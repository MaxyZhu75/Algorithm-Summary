class Solution {
    int n;
	char board [][];
    List<List<String>> result = new ArrayList<>();
    Set<Integer> diagonals = new HashSet<>();
	Set<Integer> antiDiagonals = new HashSet<>();
	Set<Integer> colums = new HashSet<>();
	
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0);
        return result;
    }
    
    private void backtrack(int row) {
        if (row == n) {
            result.add(toStringList(board));
            return;
        }

        for (int colum=0; colum<n; colum++) {
            int diagonal = row - colum; // ����ȷ�����ڡ��Խ��ߡ�������
            int antiDiagonal = row + colum; // �ӷ�ȷ�����ڡ����Խ��ߡ�������
            if (colums.contains(colum) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
                continue;
            }

            colums.add(colum); // �൱�ڡ����visited��������
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);
            board[row][colum] = 'Q';

            backtrack(row+1); // dfs�ݹ飡����

            colums.remove(colum); // �൱�ڡ�ɾ��visited��������
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
            board[row][colum] = '.';
        }
    }
	
    private List<String> toStringList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            String row = new String(board[i]);
            result.add(row);
        }
        return result;
    }
}