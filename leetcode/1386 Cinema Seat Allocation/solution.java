class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) { // 位运算！！！
        Map<Integer, Integer> hashRecord = new HashMap<>(); // 存储每排预约情况，为1表示已预约，0表示空位！！！
        for (int[] seat : reservedSeats) {
            hashRecord.put(seat[0], hashRecord.getOrDefault(seat[0], 0) | 1 << (10 - seat[1]));
        }
        int result = (n - hashRecord.size()) * 2; // 细节：完全无预约的排必然可以连坐2组！！！
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