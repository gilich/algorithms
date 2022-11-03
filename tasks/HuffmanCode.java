import java.util.*;

class HuffmanCode {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        String letters = "accepted";
        Map<String, Integer> map = computeFrequency(letters);
        NodeOne parent = computeParentNode(initQueue(map));
        HashMap<String, String> mapCodes = new HashMap<>();
        if (map.size() == 1) encodeForOneLetter("", mapCodes, parent);
        else encode("", mapCodes, parent);
        printEncodedString(mapCodes, letters);

    }

    public static Map<String, Integer> computeFrequency(String letters) {
        char[] chars = letters.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (char element : chars) {
            String tmp = String.valueOf(element);
            if (map.containsKey(tmp)) map.merge(tmp, 1, Integer::sum);
            else map.put(tmp, 1);
        }
        return map;
    }

    public static PriorityQueue<NodeOne> initQueue(Map<String, Integer> map) {
        PriorityQueue<NodeOne> queueOfNodes = new PriorityQueue<>();
        map.entrySet().stream()
                .map(entry -> new NodeOne(entry.getKey(), entry.getValue()))
                .forEach(queueOfNodes::add);
        return queueOfNodes;
    }

    public static NodeOne computeParentNode(PriorityQueue<NodeOne> queueOfNodes) {
        if (queueOfNodes.isEmpty()) return null;
        while (true) {
            NodeOne first = queueOfNodes.poll();
            NodeOne second = queueOfNodes.poll();
            if (first == null) return null;
            if (second == null) return first;
            NodeOne parentNode = new NodeOne(first, second);
            parentNode.setLeftChild(first);
            parentNode.setRightChild(second);
            queueOfNodes.add(parentNode);
        }
    }

    public static void encode(String s, HashMap<String, String> mapCodes, NodeOne parent)
    {
        if (parent == null)
            return;
        if (parent.leftChild == null && parent.rightChild == null) mapCodes.put(parent.getLetter(), s);
        encode(s + "0", mapCodes, parent.leftChild);
        encode(s + "1", mapCodes, parent.rightChild);
    }

    public static void encodeForOneLetter(String s, HashMap<String, String> mapCodes, NodeOne parent) {
        s = "0";
        mapCodes.put(parent.getLetter(), s);
    }


    public static void printEncodedString(HashMap<String, String> mapCodes, String letters) {
        String[] arrayOfLetters = letters.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (String letter : arrayOfLetters) {
            stringBuilder.append(mapCodes.get(letter));
        }
        System.out.println(letters.length() + " " + stringBuilder.length());
        mapCodes.forEach((key, value) -> System.out.println(key + ":" + " " + value));
        System.out.println(stringBuilder.toString());

    }



    public static class NodeOne implements Comparable<NodeOne> {
        String letter;
        int frequency;
        NodeOne leftChild;
        NodeOne rightChild;

        public NodeOne(String letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
        }

        public NodeOne(NodeOne first, NodeOne second) {
            this.leftChild = first;
            this.rightChild = second;
            this.letter = first.getLetter() + second.getLetter();
            this.frequency = first.getFrequency() + second.getFrequency();
        }

        public String getLetter() {
            return letter;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setLeftChild(NodeOne leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(NodeOne rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public int compareTo(NodeOne o) {
            return Integer.compare(this.getFrequency(), o.getFrequency());
        }
    }
}
