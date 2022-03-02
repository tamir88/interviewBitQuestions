package arrays;/*Given a set of non-overlapping intervals, insert a new interval into the intervals
(merge if necessary).
You may assume that the intervals were initially sorted according to their start times.*/

import java.util.ArrayList;

public class MergeIntervals {
      public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
          ArrayList<Integer> A = findStart(intervals, newInterval.start);
          findend(intervals, A, newInterval.end);
          int start = A.get(0);
          int end = A.get(2);
          del_update(intervals, A, start, end);
          return intervals;
    }

    private void del_update(ArrayList<Interval> inter, ArrayList<Integer> A, int start, int end){
          Interval newIn = new Interval(start, end);
          if(A.get(3) == -1) {
              inter.add(0, newIn);
              return;
          }
          if(A.get(1) == inter.size()) {
              inter.add(newIn);
              return;
          }
          for( int i=A.get(1); i<=A.get(3); i++)
              inter.remove(i);
          inter.add(A.get(1), newIn);
          return;
    }

    private void findend(ArrayList<Interval> inter, ArrayList<Integer> A, int end){
          for(int i=inter.size()-1; i>-1; i--){
              if(inter.get(i).end <= end){
                  A.add(end);
                  A.add(i);
                  return;
              }
              if(inter.get(i).end > end && inter.get(i).start <= end){
                  A.add(inter.get(i).end);
                  A.add(i);
                  return;
              }
          }
        A.add(end);
        A.add(-1);
    }


    private ArrayList<Integer> findStart(ArrayList<Interval> intervals, int start){
          ArrayList<Integer> A = new ArrayList<>();
          for(int i=0; i<intervals.size(); i++){
              if (intervals.get(i).start >= start ){
                  A.add(start);
                  A.add(i);
                  return A;
              }
              if(intervals.get(i).start < start && intervals.get(i).end >= start){
                  A.add(intervals.get(i).start);
                  A.add(i);
                  return A;
              }
          }
          A.add(start);
          A.add(intervals.size());
          return A;
    }




    /*// (1) finding upper border in the array
    private int findEnd(ArrayList<Interval> intervals, int end){
          int N = intervals.size();
          int lowerBound = 0;
          int upperBound = N -1;

          int midPoint = 0;

          while(upperBound > lowerBound){
              midPoint = lowerBound + (upperBound - lowerBound)/2;
              if(intervals.get(midPoint).end < end) {
                  lowerBound = midPoint + 1;
                  continue;
              }
              if(intervals.get(midPoint).end > end) {
                  upperBound = midPoint - 1;
                  continue;
              }
              if(intervals.get(midPoint).end == end)
                  break;
          }
           return intervals.get(midPoint).end;
    }

    private int findStart(ArrayList<Interval> intervals, int start, int end){
        int N = intervals.size();
        int lowerBound = 0;
        int upperBound = N -1;

        int midPoint = 0;

        while(upperBound > lowerBound){
            midPoint = lowerBound + (upperBound - lowerBound)/2;
            if(intervals.get(midPoint).start < start) {
                lowerBound = midPoint + 1;
                continue;
            }
            if(intervals.get(midPoint).start > start) {
                upperBound = midPoint - 1;
                continue;
            }
            if(intervals.get(midPoint).start == start)
                break;
        }
        intervals.get(midPoint).start;

    }*/
}
