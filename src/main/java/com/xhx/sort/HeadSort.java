package com.xhx.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class HeadSort {
    @Test
    public void headSort(){
        int[] arr = {4,6,8,5,9};
        buildHead(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void buildHead(int[] arr){
        int temp = 0;
        //最后-个非叶子结点开始 i = k/2 -1
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            adjustHead(arr,i,arr.length);
        }
        //依次拿出最大值到数据后面
        for (int i = arr.length-1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //顺序打乱后需重新调成大堆顶
            adjustHead(arr,0,i);
        }
    }
    //调整到大堆顶--升序
    private void adjustHead(int[] arr,int leftRoot,int size){
        int temp = arr[leftRoot];
        //k=i*2+1  k是i结点的左子结点
        for (int k = 2*leftRoot + 1;k<size;k = 2*k + 1){
            //判断右结点
            if (k+1 < size && arr[k] < arr[k+1]){
                k++;
            }
            //交换位置(下沉)
            if (arr[k] > arr[leftRoot]){
                arr[leftRoot] = arr[k];
                leftRoot = k;
            }
        }
        arr[leftRoot] = temp;
    }
}
