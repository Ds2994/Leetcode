import java.util.*;

class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = acceptInput();

        System.out.println(canAttendMeeting(intervals));
    }

    public static boolean canAttendMeeting(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        //Itterate and check for overlaps
        int lastMeetingEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            int currentMeetingStart = intervals[i][0];
            int currentMeetingEnd = intervals[i][1];

            if(currentMeetingStart <= lastMeetingEnd) {
                return false;
            }

            lastMeetingEnd = currentMeetingEnd;
        }
        return true;
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