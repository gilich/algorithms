import java.util.*;

class TheHighOfTree {
    ArrayList<Integer> cache = new ArrayList<>();
    int root;

    public static void main(String[] args) {
        TheHighOfTree tree = new TheHighOfTree();
        tree.run();
    }

    public void run() {
//        Scanner scanner = new Scanner(System.in);
//        int amountOfNodes = scanner.nextInt();
//        int[] array = new int[amountOfNodes];
//        for (int i = 0; i < amountOfNodes; i++) {
//            array[i] = scanner.nextInt();
//        }
//        scanner.close();
        int [] a = new int[]{4, -1, 4, 1, 1};
    }
//    public String [] getChildren (int [] array) {
//        String [] parentsWithChildren = new String[array.length];
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == - 1) root = i;
//            else {
//                if (parentsWithChildren[array[i]].isBlank()) parentsWithChildren[array[i]] = String.valueOf(i);
//            }
//
//        }
//        return parentsWithChildren;
//    }

    public int getHeight(int num, int [] array){
        int height = 1;
        for (int i = num; i < array.length; i++) {
            if (array[i] == - 1) height = 1;
            else  {
                height = Math.max(height, 1 + getHeight(array[i], array));
            }
            cache.add(height);
        }
        return height;
    }
}
