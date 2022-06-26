public class SORTracker {
    private PriorityQueue<Pair> smaller; //���󶥶ѡ��洢������С��������i�ľ��㡹������
    private PriorityQueue<Pair> larger; //��С���ѡ��洢����������������i�ľ��㡹������

    public SORTracker() { // ���췽����new�����Ѳ���������ʽ������
        this.smaller = new PriorityQueue<>((o1, o2) -> (o1.score == o2.score) ? (o1.name.compareTo(o2.name)) : (o2.score - o1.score));
        this.larger = new PriorityQueue<>((o1, o2) -> (o1.score == o2.score) ? (o2.name.compareTo(o1.name)) : (o1.score - o2.score));
    }

    public void add(String name, int score) { // smaller�Ѷ�ά��������i�ľ��㣬���Ҫ�Ƚ�larger������pop����smaller���򣡣���
        larger.add(new Pair(name, score));
        smaller.add(larger.poll());
    }

    public String get() { // ��i�β�ѯ��ÿ�β�ѯ�����smaller��popһ����larger��ʹ��smaller�Ѷ�������������һλ������
        String result = smaller.peek().name;
        larger.add(smaller.poll());
        return result;
    }
}

class Pair { // ��д�����࣡����
    String name;
    int score;

    public Pair(String name, int score) { // ���췽��������
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