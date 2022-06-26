public class SORTracker {
    private PriorityQueue<Pair> smaller; //「大顶堆」存储「分数小于排名第i的景点」！！！
    private PriorityQueue<Pair> larger; //「小顶堆」存储「分数大于排名第i的景点」！！！

    public SORTracker() { // 构造方法；new两个堆并定义排序方式！！！
        this.smaller = new PriorityQueue<>((o1, o2) -> (o1.score == o2.score) ? (o1.name.compareTo(o2.name)) : (o2.score - o1.score));
        this.larger = new PriorityQueue<>((o1, o2) -> (o1.score == o2.score) ? (o2.name.compareTo(o1.name)) : (o1.score - o2.score));
    }

    public void add(String name, int score) { // smaller堆顶维护排名第i的景点，因此要先进larger排序，再pop进入smaller排序！！！
        larger.add(new Pair(name, score));
        smaller.add(larger.poll());
    }

    public String get() { // 第i次查询，每次查询都会从smaller中pop一个到larger，使得smaller堆顶景点排名靠后一位！！！
        String result = smaller.peek().name;
        larger.add(smaller.poll());
        return result;
    }
}

class Pair { // 手写辅助类！！！
    String name;
    int score;

    public Pair(String name, int score) { // 构造方法！！！
        this.name = name;
        this.score = score;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */