package com.vtest.angular2.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static List<Integer> getRandomList(int n, int bound) {
        List<Integer> randList = new ArrayList<>();
        if (n > bound) {
            n = bound;
            for (int i = 0; i < n; i++) {
                randList.add(i);
            }
            return randList;
        }
        Random generator = new Random(bound);
        while (randList.size() < n) {            
            int value = generator.nextInt(bound);
            if(!randList.contains(value)) {
                randList.add(value);
            }
        }
        return randList;
    }
}
