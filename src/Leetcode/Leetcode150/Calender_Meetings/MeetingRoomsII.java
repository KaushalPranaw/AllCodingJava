package Leetcode.Leetcode150.Calender_Meetings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] meetings = {
                {9, 10},
                {9, 11},
                {11, 12}
        };

        int result = minRooms(meetings);

        System.out.println("Minimum rooms required: " + result);

    }
    public static int minRooms(int[][] meetings){
        //sort by start time
        Arrays.sort(meetings, Comparator.comparingInt(a->a[0]));

        //store end time in minHeap
        PriorityQueue<Integer> pq =
                new PriorityQueue<>();

        for(int[] meeting: meetings){
            if(!pq.isEmpty() && pq.peek()<=meeting[0]){
                pq.poll();
            }
            pq.add(meeting[1]);
        }
        return pq.size();

    }
}
