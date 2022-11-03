import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SegmentCoverFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfSegments = scanner.nextInt();
        ArrayList<ArrayList<Integer>> segments = new ArrayList<>();
        for (int i = 0; i < amountOfSegments; i++) {
            ArrayList<Integer> oneSegment = new ArrayList<>();
            int begin = scanner.nextInt();
            int end = scanner.nextInt();
            oneSegment.add(begin);
            oneSegment.add(end);
            segments.add(oneSegment);
        }
        scanner.close();
        Collections.sort(segments, ((o1, o2) -> {
            int between = o1.get(1) - o2.get(1);
            return (between != 0 ? between : o1.get(0) - o2.get(0));
        }));
        String[] result = findPoints(segments);
        System.out.println(result.length);
        for (String s : result) {
            System.out.print(s + " ");
        }

    }

    public static String[] findPoints(ArrayList<ArrayList<Integer>> segments) {
        StringBuilder sb = new StringBuilder();
        int point = segments.get(0).get(1);
        sb.append(point).append(" ");
        for (int i = 1; i < segments.size(); i++) {
            if (segments.get(i).get(0) <= point) continue;
            else sb.append(segments.get(i).get(1)).append(" ");
            point = segments.get(i).get(1);
        }
        return sb.toString().split(" ");

    }
}
