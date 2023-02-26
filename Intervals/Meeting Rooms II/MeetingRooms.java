import java.util.*;

class MeetingRooms {

    public static void main(String[] args) {
        int[][] meetings = acceptInput();

        System.out.println(minMeetingRooms(meetings));
    }

    public static int minMeetingRooms(int meetings[][]) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for(int[] meeting : meetings) {
            if(rooms.size() == 0) {
                rooms.add(meeting[1]); //create a new room
            } else {
                if(rooms.peek() > meeting[0]) {
                    //will need a new room
                    rooms.add(meeting[1]);
                } else {
                    //replace the meeting in the current room
                    rooms.remove();
                    rooms.add(meeting[1]);
                }
            }
        }

        return rooms.size();
    }

    private static int[][] acceptInput() {
        Scanner sc= new Scanner(System.in);
        String total = sc.nextLine();
        int size = Integer.parseInt(total);

        int[][] intervals = new int[size][2];

        for(int i=0; i<size; i++) {
            String interval = sc.nextLine();
            String[] input = interval.split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            intervals[i] = new int[]{start, end};
        }

        return intervals;
    }
}