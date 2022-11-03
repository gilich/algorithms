import java.util.*;

class MyPrQueue {

    private Node coreNode;

    public static void main(String[] args) {
        //readFromConsole();
    }

    public static void readFromConsole() {
        MyPrQueue myPrQueue = new MyPrQueue();
        Scanner scan = new Scanner(System.in);
        int numberOfOperations = scan.nextInt();
        ArrayList<String> commands = new ArrayList<>();
        for (int i = 0; i <= numberOfOperations; i++) {
            String command = scan.nextLine();
            commands.add(command);
        }
        scan.close();
        for (String command : commands) {
            if (command.startsWith("Insert")) {
                String[] commandSplit = command.split(" ");
                int val = (Integer.parseInt(commandSplit[1]));
                myPrQueue.insert(val);
            } else if (command.startsWith("ExtractMax")) {
                myPrQueue.extractMax();
            }
        }
    }

    public void insert(int value) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(value);
        if (coreNode == null) {
            coreNode = node;
            return;
        }
        queue.offer(coreNode);
        while (true) {
            Node tmp = queue.poll();
            if (tmp.leftChild == null) {
                tmp.leftChild = node;
                node.parent = tmp;
                siftUp(tmp.leftChild);
                return;
            } else {
                queue.offer(tmp.leftChild);
            }

            if (tmp.rightChild == null) {
                tmp.rightChild = node;
                node.parent = tmp;
                siftUp(tmp.rightChild);
                return;
            } else {
                queue.offer(tmp.rightChild);
            }
        }
    }

    private void siftUp(Node child) {
        while (true) {
            Node parent = child.parent;
            if (child.value > child.parent.value) swapValues(child, parent);
            else break;
            child = parent;
            if (child.getParent() == null) break;
        }
    }

    public int extractMax() {
        int result = coreNode.value;
        //System.out.println(result);
        if ((coreNode.rightChild == null) && (coreNode.leftChild == null)) return result;
        moveHeadNodeFromList();
        siftDown();
        return result;
    }

    private void moveHeadNodeFromList() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(coreNode);
        Node tmp = null;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp.leftChild != null) queue.offer(tmp.leftChild);
            if (tmp.rightChild != null) queue.offer(tmp.rightChild);
        }
        if (Objects.isNull(tmp)) return;
        coreNode.value = tmp.value;
        if (tmp == tmp.parent.rightChild) tmp.parent.rightChild = null;
        if (tmp == tmp.parent.leftChild) tmp.parent.leftChild = null;
        tmp.parent = null;
    }

    private void siftDown() {
        Node core = coreNode;
        while (true) {
            int leftValue = Objects.isNull(core.leftChild) ? -1 : core.leftChild.value;
            int rightValue = Objects.isNull(core.rightChild) ? -1 : core.rightChild.value;
            int coreValue = core.value;
            boolean checkNull = (core.leftChild == null) && (core.rightChild == null);
            boolean checkDifferences = (coreValue >= leftValue) && (coreValue >= rightValue);
            if (checkNull || checkDifferences) return;

            if (leftValue > rightValue) {
                swapValues(core, core.leftChild);
                core = core.leftChild;
            } else {
                swapValues(core, core.rightChild);
                core = core.rightChild;
            }
        }
    }

    public void swapValues(Node one, Node two) {
        if ((one == null) || (two == null)) return;
        int tmp = one.value;
        one.value = two.value;
        two.value = tmp;
    }

    static class Node {
        int value;
        Node leftChild;
        Node rightChild;
        Node parent;

        public Node(int value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

    }
}
