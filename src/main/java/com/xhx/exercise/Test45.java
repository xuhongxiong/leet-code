package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2383 赢得比赛需要的最少训练时长
 */
public class Test45 {

    @Test
    public void test(){
        int initialEnergy = 1;
        int initialExperience = 1;
        int[] energy = {1,1,1,1};
        int[] experience = {1,1,1,50};
        System.out.println(minNumberOfHours(initialEnergy,initialExperience,energy,experience));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        int energySum = Arrays.stream(energy).sum();
        if (initialEnergy <= energySum){
            res += (energySum-initialEnergy+1);
        }
        for (int i : experience) {
            if (initialExperience <= i){
                res += (i-initialExperience+1);
                initialExperience += (i-initialExperience+1);
            }
            initialExperience += i;
        }
        return res;
    }
}
