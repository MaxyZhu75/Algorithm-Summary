class Solution {
    public int countPrimes(int n) { // �÷���Ϊ���䰣��ɸ�����и��������ɸ������
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i=2; i<n; i++) {
            if (isPrime[i]) {
                count++;
            }
            for(long j=(long)i*i; j<n; j+=i) { // Ҫ��:��i*i��ʼ��ѭ����i�ı������notPrime������
                isPrime[(int)j] = false; // ����ʱ���������Ҫ˼�������Ƿ���Ҫת�ͣ�������Go���Ը����㣡����
            }
        }

        return count;
    }
}