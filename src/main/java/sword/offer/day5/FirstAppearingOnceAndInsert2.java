package sword.offer.day5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author youtiaoguagua
 * @date 2020/9/13 20:41
 */
public class FirstAppearingOnceAndInsert2 {
    LinkedHashMap<Character,Integer> map =new LinkedHashMap<Character,Integer>();
    LinkedList<Character> list = new LinkedList<>();

    //Insert one char from stringstream
    public void insert(char ch){
        Integer merge = map.merge(ch, 1, Integer::sum);
        if (merge>1){
            while (!list.isEmpty()&&map.get(list.peekFirst())>1){
                list.removeFirst();
            }
        }else {
            list.add(ch);
        }

    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        if (list.isEmpty()){
            return '#';
        }else {
            return list.peekFirst();
        }
    }

}
