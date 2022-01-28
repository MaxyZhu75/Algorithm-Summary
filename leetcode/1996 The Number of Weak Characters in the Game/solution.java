class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int maxDefense = 0;
        int weak = 0;

        Arrays.sort(properties, new Comparator<int[]>() { // �ؼ��㣺�˴�����Ҫ��ѭ�������򣡣���
            @Override // ����һ���������鹥���������У�����
            public int compare(int[] o1, int[] o2) { // �������������ͬ���Ӽ��������������У�����
                return (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o2[0] - o1[0]); // ����д������ͬʱд�����������ֻ��δ���Ǽ����������ʹ�ü������LeetCode435�⣡����
            }
        });

        for (int[] property : properties) {
            if (property[1] < maxDefense) { // ������ͬ�������Ӽ��У��������ѱ����ڸ��Ӽ�������棬��֤�˱������Ӽ��ڲ�ʱ�����ܲ���weak++������
                weak++;
            } else {
                maxDefense = property[1]; // ����������������
            }
        }

        return weak;
    }
}