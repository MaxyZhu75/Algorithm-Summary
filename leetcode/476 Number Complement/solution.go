func findComplement(num int) int {
    var higherOne int = 1<<30 // ����ñ������num�����λ��1����λ�ã�����32λΪ����λ���������λΪ0����������31λ���ɣ�����
    mask := 0
    for higherOne&num == 0 { // go������forѭ��ʵ��whileѭ���Ĺ��ܣ�����
            higherOne = higherOne>>1 
    }
    mask = (higherOne<<1)-1 // num�����λ��1����λ�ü���Ϊ��iλ����������Ҫi��1�Ķ�������mask��num��򼴿�ʹnumȡ������֪mask����higherOne���Ƽ�1�õ�������
    return num^mask
}