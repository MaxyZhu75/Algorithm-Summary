class Solution {
    public int findComplement(int num) {
        int higherOne = 1<<30; // ����ñ������num�����λ��1����λ�ã�����32λΪ����λ���������λΪ0����������31λ���ɣ�����
        int mask = 0; 
        while ((num&higherOne)==0){
            higherOne = higherOne>>1; // ��while�ṹʹ��higherOne��num�����λ��1����λ��ͣ�£�����
        }
        mask = (higherOne<<1)-1; // num�����λ��1����λ�ü���Ϊ��iλ����������Ҫi��1�Ķ�������mask��num��򼴿�ʹnumȡ������֪mask����higherOne���Ƽ�1�õ�������
		return num^mask;
    }
}