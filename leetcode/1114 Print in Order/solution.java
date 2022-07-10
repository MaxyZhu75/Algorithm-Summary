class Foo {
    private AtomicInteger firstJobDone = new AtomicInteger(0); // ԭ�����ṩ�̰߳�ȫ�ļӼ������ӿڣ�����
    private AtomicInteger secondJobDone = new AtomicInteger(0); // �ŵ㣺���Ա�����̵߳����ȼ����ú���������ķ���������

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) { // ϸ�ڣ�ʹ��while���еȴ�������
        }
        printSecond.run();
        secondJobDone.getAndIncrement(); // ��ɺ���а�ȫ��������CAS�ֹ���������
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
        }
        printThird.run();
    }
}
