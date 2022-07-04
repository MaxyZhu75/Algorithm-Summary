class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) { // λ���㣡����
        Map<Integer, Integer> hashRecord = new HashMap<>(); // �洢ÿ��ԤԼ�����Ϊ1��ʾ��ԤԼ��0��ʾ��λ������
        for (int[] seat : reservedSeats) {
            hashRecord.put(seat[0], hashRecord.getOrDefault(seat[0], 0) | 1 << (10 - seat[1]));
        }
        int result = (n - hashRecord.size()) * 2; // ϸ�ڣ���ȫ��ԤԼ���ű�Ȼ��������2�飡����
        for (int row : hashRecord.keySet()) {
            int seats = hashRecord.get(row);
            if ((seats & 0b0111111110) == 0) {
                result += 2;
			} else if ((seats & 0b0111100000) == 0 || (seats & 0b0001111000) == 0 || (seats & 0b0000011110) == 0) {
                result += 1;
			}
        }
        return result;
    }
}