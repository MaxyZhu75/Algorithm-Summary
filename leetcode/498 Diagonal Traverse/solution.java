class Solution {
    public int[] findDiagonalOrder(int[][] mat) { // ������Ŀ�ҹ��ɣ�����
		int m = mat.length;
		int n = mat[0].length;
		int[] result = new int[m*n];
		int direction = 0, downMax = 0, upMax = 0, down=0, up =0, k = 0; // ���ַ����棻ĳһ�Խ����ɿ�ʼ��������������������һ��һ�����Ҹ�Ԫ�صĺ�������֮����ͬ������
		for(int indexSum=0; indexSum <= m+n-2; indexSum++) { // ������ͬ�Խ��߼���С���������ͬ����֮�ͣ�����
			downMax = (direction == 0) ? m : n; // ȷ��������������ݼ������ı߽磡����
			upMax = (direction == 0) ? n : m;
			down = (indexSum < downMax) ? indexSum : downMax - 1; // ȷ��������������ݼ������ĳ�ʼֵ������
			up = indexSum - down;

			while (down >= 0 && up < upMax){ // �жϵ�ǰ���򣬱�����ǰ�Խ����ϵ�Ԫ�أ�����
				result[k++] = (direction == 0) ? mat[down][up] : mat[up][down]; // ע����������������ÿ�ֻᷴת��Ӧ���ݶԽ��ߵķ���ȷ��i��j�ֱ��ǵ������ǵݼ�������
				down--;
				up++;
			}

			direction = 1 - direction; // �Խ��߷���ת������
		}
		return result;
    }
}