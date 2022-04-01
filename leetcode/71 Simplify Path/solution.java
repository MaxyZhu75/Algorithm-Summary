class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/"); // String.split(�ָ���)������
        Deque<String> myDeque = new ArrayDeque<>(); // java.util.ArrayDeque������
        for (String name : names) {
            if (name.equals("..")) { // case1����..�� ������deque�������deque��Ϊ���򵯳�ջ��������
                if (!myDeque.isEmpty()) myDeque.removeFirst();
            } else if (!name.equals(".") && name.length() != 0) { // case2����.������ַ��������ġ�/���ָ��Ϊ���ַ���������deque������Ԫ��ѹ��ջ��������
                myDeque.addFirst(name);
            }
        }
        StringBuffer sb = new StringBuffer();
        if (myDeque.isEmpty()) { // case1��dequeΪ����ʱ���и�Ŀ¼��/��������
            return "/";
        } else {
            while (!myDeque.isEmpty()) { // case2��deque��Ϊ��ʱ����ջ��ȡԪ������ƴ�ӣ��˴������ϳ���ջ����������˫������������
                sb.append('/');
                sb.append(myDeque.pollLast());
            }
        }
        return sb.toString();
    }
}