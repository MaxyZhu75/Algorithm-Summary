class Solution {
    public String minRemoveToMakeValid(String s) { // ����һ��Stack + List ������
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> myStack = new Stack<>();
        List<Integer> toBeRemove = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            char letter = s.charAt(i);
            if (letter == '(') { // ��������ջ������
                myStack.push(i);
            } else if (letter == ')') { // �����ŷ������������
                if (!myStack.isEmpty()) 
                    myStack.pop(); // case1��ջ��Ϊ��ʱ������ջ��һ�������ţ�ƥ��ɹ�������
                } else {
                    toBeRemove.add(i); // case2: ջΪ��ʱ���޷�ƥ�������ţ��������ż����ɾList������
                }
            }
        }

        while (!myStack.isEmpty()) {
            toBeRemove.add(myStack.pop()); // ��ѭ������ջ��Ϊ�գ���ջ��������δƥ�䣬������ɾList������
        }

        for (int i=0; i<n; i++) {
            if (!toBeRemove.contains(i)) { // StringBuilder����Ӵ�ɾList�е�Ԫ�أ�����
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}