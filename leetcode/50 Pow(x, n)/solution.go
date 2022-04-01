func myPow(x float64, n int) float64 { // ���������ݹ飡����
    if n >= 0 {
        return binaryPower(x, n)
    } else {
        return 1.0 / binaryPower(x, -n)
    }
}

func binaryPower(x float64, n int) float64 {
    if n == 0 {
        return 1.0 // �ݹ����ҳ��ڣ�����
    }
    
    y := binaryPower(x, n/2) // ǰһ���˳�������
    
    if n % 2 == 0 { // �ж������η�����ż���η�������
        return y * y
    } else {
        return y * y * x
    }
}