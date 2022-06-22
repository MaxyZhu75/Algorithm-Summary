class Solution {
    public int[][] reconstructQueue(int[][] people) { //��̰�ġ�������
        Arrays.sort(people, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) { //�����ȼ���������ɸߵ��ͣ������һ����k�ɵ͵��ߣ�����
			    return (o1[0] == o2[0]) ? o1[1]-o2[1] : o2[0]-o1[0];
		    }
        });

        List<int[]> result = new LinkedList<>(); // �����б���ָ��λ�����Ԫ��ʱ������Ԫ����˳���ƶ������ʣ�����
        for (int[] person : people) { // �ԡ�k��Ϊ������̰�ĵ������������ˣ����������ȼ���������
		    result.add(person[1], person); // ����ӵģ����Ӹߵģ���Ϊ����������ӵģ����Ӱ��ģ�����˿��ܻᱻ���ƣ��Ӷ���������ӵģ����Ӱ��ģ�������
        }

        int n = people.length;
        return result.toArray(new int[n][2]);
    }
}