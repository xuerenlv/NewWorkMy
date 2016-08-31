package leetcode_final;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Xuehj on 16/7/12.
 */
public class Flatten_Nested_List_Iterator_341 {

}


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}




class NestedIterator implements Iterator<Integer> {

    ArrayList<Integer> container;

    public NestedIterator(List<NestedInteger> nestedList) {
        container = new ArrayList<>();
        add_nestedList(container,nestedList);
    }

    private void add_nestedList(ArrayList<Integer> container,List<NestedInteger> nestedList){
        for(int i=0;i<nestedList.size();i++){
            if(!nestedList.get(i).isInteger()){
                add_nestedList(container,nestedList.get(i).getList());
            }else{
                container.add(nestedList.get(i).getInteger());
            }
        }
    }


    @Override
    public Integer next() {
        if (container.isEmpty())
            return -1;
        Integer re = container.remove(0);
        return  re;
    }

    @Override
    public boolean hasNext() {
        return !container.isEmpty();
    }
}