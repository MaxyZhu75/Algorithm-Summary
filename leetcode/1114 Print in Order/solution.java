class Foo {
    private AtomicInteger firstJobDone = new AtomicInteger(0); // 原子类提供线程安全的加减操作接口！！！
    private AtomicInteger secondJobDone = new AtomicInteger(0); // 优点：可以避免多线程的优先级倒置和死锁情况的发生！！！

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) { // 细节：使用while进行等待！！！
        }
        printSecond.run();
        secondJobDone.getAndIncrement(); // 完成后进行安全地自增，CAS乐观锁！！！
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
        }
        printThird.run();
    }
}
