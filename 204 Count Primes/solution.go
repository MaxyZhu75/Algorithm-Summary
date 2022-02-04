func countPrimes(n int) int { // �÷���Ϊ���䰣��ɸ�����и��������ɸ������
    isPrime := make([]bool, n)
    count := 0
    for i, _ := range isPrime {
        isPrime[i] = true
    }
    for i:=2; i<n; i++ {
        if isPrime[i] {
            count++
        }
        for j:=i*i; j<n; j+=i { // Ҫ��:��i*i��ʼ��ѭ����i�ı������notPrime������
            isPrime[j] = false // ����ʱ���������Ҫ˼�������Ƿ���Ҫת�ͣ�������Go���Ը����㣡����
        }
    }

    return count
}