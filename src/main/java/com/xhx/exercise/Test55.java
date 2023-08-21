package com.xhx.exercise;

import com.xhx.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1444 切披萨的方案数
 *
 * 给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1 次，得到 k 块披萨并送给别人。
 */
public class Test55 {
    @Test
    public void test(){
        String[] pizza = {"A..","AAA","..."};
        //String[] pizza = {"A..","A..","..."};
        int k = 3;
        System.out.println(ways(pizza,k));

    }
    int res = 0;
    public int ways(String[] pizza, int k) {
        dfs(pizza,k);
        return res;
    }

    private void dfs(String[] pizza, int k){
        if (k == 1){
            if (checkPizza(pizza)){
                res++;
            }
            return;
        }
        if (!checkPizza(pizza)){
            return;
        }
        int n = pizza.length;
        int m = pizza[0].length();
        //左->右
        for (int i = 0; i < m; i++) {
            boolean dfs = false;
            String[] newPizza = new String[n];
            for (int j = 0; j < n; j++) {
                newPizza[j] = pizza[j].substring(i+1,m);
                if (pizza[j].substring(0,i+1).contains("A")){
                    dfs = true;
                }
            }
            if (dfs){
                dfs(newPizza,k-1);
            }
        }
        //上->下
        for (int i = 1; i <= n; i++) {
            boolean dfs = false;
            String[] newPizza = new String[n-i];
            for (int j = 0; j < i; j++) {
                if (pizza[j].contains("A")){
                    dfs = true;
                    break;
                }
            }
            if (dfs){
                System.arraycopy(pizza, i, newPizza, 0, n - i);
                dfs(newPizza,k-1);
            }
        }
    }

    private boolean checkPizza(String[] pizza){
        for (String str : pizza) {
            if (str.contains("A")) {
                return true;
            }
        }
        return false;
    }

}
