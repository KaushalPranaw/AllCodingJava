package Leetcode.Leetcode150.Calender_Meetings;

import java.util.TreeMap;

public class MyCalendarILeetCode729 {
    private TreeMap<Integer, Integer> treeMap;

    public MyCalendarILeetCode729() {
        this.treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        /*
        Before adding:
        Check previous event and next event.
        If overlap:
        previousEnd > newStart
        or
        newEnd > nextStart
         */

        // event just after current event
        //Mere start ke barabar ya usse bada sabse chhota key do
        Integer nextStart=treeMap.ceilingKey(start);

        // check next event overlap
        if(nextStart != null && nextStart < end) {
            return false;
        }

        // event before current event
        //Mere start ke barabar ya usse chhota sabse bada key do
        Integer prevStart = treeMap.floorKey(start);

        // check previous event overlap
        if(prevStart != null && treeMap.get(prevStart) > start) {
            return false;
        }

        treeMap.put(start,end);

        return true;
    }

    public static void main(String[] args) {
        MyCalendarILeetCode729 cal = new MyCalendarILeetCode729();


        System.out.println(cal.book(10,20));

        System.out.println(cal.book(15,25));

        System.out.println(cal.book(20,30));

    }
}
