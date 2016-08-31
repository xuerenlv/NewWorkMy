package leetcode_final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Xuehj on 16/7/11.
 */
public class Reconstruct_Itinerary_332 {
    public static void main(String[] a){

    }
}




class Solution_Reconstruct_Itinerary_332 {
    public List<String> findItinerary(String[][] tickets) {
        ArrayList<String> result = new ArrayList<String>();

        if(tickets == null || tickets.length == 0){
            return result;
        }

        int total = tickets.length + 1;

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for(int i = 0; i < tickets.length; i++){
            if(map.containsKey(tickets[i][0])){
                ArrayList<String> tmp = map.get(tickets[i][0]);
                listAdd(tickets[i][1], tmp);
            }
            else{
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(tickets[i][1]);
                map.put(tickets[i][0], tmp);
            }
        }

        result.add("JFK");

        itineraryHelper("JFK", map, result, total, 1);

        return result;
    }

    public boolean itineraryHelper(String current, HashMap<String, ArrayList<String>> map, ArrayList<String> result, int total, int num){

        if(num >= total){
            return true;
        }

        if(!map.containsKey(current) || map.get(current).size() == 0){
            return false;
        }

        ArrayList<String> curList = map.get(current);
        int i = 0;

        while(i < curList.size()){
            String next = curList.remove(i);
            result.add(next);

            if(itineraryHelper(next, map, result, total, num + 1)){
                return true;
            }

            result.remove(result.size() - 1);
            listAdd(next, curList);
            i++;
        }

        return false;
    }


    public void listAdd(String value, ArrayList<String> list){
        if(list.size() == 0){
            list.add(value);
            return;

        }
        else{
            int i = 0;
            while(i < list.size()){
                if(value.compareTo(list.get(i)) <= 0){
                    list.add(i, value);
                    return;
                }
                i++;
            }
            list.add(value);
            return;
        }
    }
}