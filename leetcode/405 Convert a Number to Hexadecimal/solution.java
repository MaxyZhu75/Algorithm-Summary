class Solution {
    public String toHex(int num) { // �����ǶԳ���Ϊ32�Ķ��������з��飬ÿ4����һ�鹲���飡����
        if (num == 0) {
            return "0";
        }

        String[] hexNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        StringBuilder sb = new StringBuilder();
        while (num != 0) { // ���ڲ������Ⲣ����Ҫ��������Ϊ�������������������ǲ����ʾ�ģ�����
            String oneBit = hexNum[num & 0b1111]; // ��������ͨ����ת����ͬ��û����%��/��������Ϊ��Ը����������Ҫ�󣡣���
            sb.append(oneBit);
            num >>>= 4; // ����ѭ��������num��Ϊ0������ÿ�δ�����һ��������Ҫʹ���޷������ƣ���λ��0��������
        }

        return sb.reverse().toString();
    }
}