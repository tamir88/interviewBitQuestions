package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {
    public int bulbs(ArrayList<Integer> A) {
        int switches = 0;
        int onOff = 0;

        for (int t : A) {
            if(switches % 2 == 0)
                onOff = 0;
            else
                onOff = 1;
            if(t == onOff)
                switches++;
        }
        return switches;
    }

    public static void main(String[] args) {
        Bulbs a = new Bulbs();
        System.out.println(a.bulbs(new ArrayList<>(Arrays.asList(0,1,0,1))));
    }

}
