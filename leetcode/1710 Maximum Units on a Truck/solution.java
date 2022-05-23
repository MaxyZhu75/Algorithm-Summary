class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) { // 贪心地加入价值最大的即可！！！
        int n = boxTypes.length;
        int result = 0;
        
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                return o1[1] > o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1);
            }
        });

        for(int i=0; i<n; i++) {
            if (boxTypes[i][0] <= truckSize) {
                result += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                result += truckSize * boxTypes[i][1];
                return result;
            }
        }
        return result;
    }
}