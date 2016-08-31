package leetcode_final;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Xuehj on 16/6/22.
 */
public class Find_Median_from_Data_Stream_295 {
    public static void main(String[] a){
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);

        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());


        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

//        medianFinder.addNum(6);
//        System.out.println(medianFinder.findMedian());
//
//        medianFinder.addNum(5);
//        System.out.println(medianFinder.findMedian());


    }
}

class NodeT{
    int val=-1;
    NodeT next=null;

    NodeT(){
    }

    NodeT(int va){
        val = va;
    }

}


class MedianFinder {
    NodeT head = new NodeT();
    int len = 0;

    double medin = 0.0;
    boolean changed = false;


    // Adds a number into the data structure.
    public void addNum(int num) {
        NodeT pre = head,s = new NodeT(num);

        while(pre.next!=null && num>pre.next.val)
                pre = pre.next;

        s.next = pre.next;
        pre.next = s;

        len++;
        changed = true;
        show_list(head);
    }

    private void show_list(NodeT head){
        NodeT cur = head.next;
        while (cur!=null){
            System.out.print(cur.val+"----&");
            cur=cur.next;
        }
        System.out.println();
    }


    // Returns the median of current data stream
    public double findMedian() {
//        System.out.println(changed);
        if(!changed)
            return medin;
        double res=0.0;

        if((len&1)==0){ // even
            int medin_index = len>>1;
            NodeT cur = head;
            while (medin_index>1) {
                cur = cur.next;
                medin_index--;
            }
            res = (cur.next.val+cur.next.next.val)/2.0;

        }else{ // odd
            int medin_index = (len>>1)+1;
            NodeT cur = head;
            while (medin_index>1) {
                cur = cur.next;
                medin_index--;
            }
            res = cur.next.val;
        }

        changed = false;
        return res;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();