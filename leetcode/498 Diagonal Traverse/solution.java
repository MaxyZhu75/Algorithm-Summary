class Solution {
    public int[] findDiagonalOrder(int[][] mat) { // 分析题目找规律！！！
		int m = mat.length;
		int n = mat[0].length;
		int[] result = new int[m*n];
		int direction = 0, downMax = 0, upMax = 0, down=0, up =0, k = 0; // 两种方向交替；某一对角线由开始到结束，横纵坐标总是一增一减，且各元素的横纵坐标之和相同！！！
		for(int indexSum=0; indexSum <= m+n-2; indexSum++) { // 遍历不同对角线即由小到大遍历不同坐标之和！！！
			downMax = (direction == 0) ? m : n; // 确定递增递索引与递减索引的边界！！！
			upMax = (direction == 0) ? n : m;
			down = (indexSum < downMax) ? indexSum : downMax - 1; // 确定递增递索引与递减索引的初始值！！！
			up = indexSum - down;

			while (down >= 0 && up < upMax){ // 判断当前方向，遍历当前对角线上的元素！！！
				result[k++] = (direction == 0) ? mat[down][up] : mat[up][down]; // 注意横纵坐标的增减性每轮会反转，应根据对角线的方向，确定i与j分别是递增还是递减！！！
				down--;
				up++;
			}

			direction = 1 - direction; // 对角线方向反转！！！
		}
		return result;
    }
}