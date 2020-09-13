package sword.offer.day5;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author youtiaoguagua
 * @date 2020/9/13 20:41
 */
public class FirstAppearingOnceAndInsert {
    LinkedHashMap<Character,Integer> map =new LinkedHashMap<Character,Integer>();
    ArrayList<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public void insert(char ch){
        Integer merge = map.merge(ch, 1, Integer::sum);
        if (merge==1){
            list.add(new Character(ch));
        }else {
            list.remove(new Character(ch));
        }
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        if (list.size()==0){
            return '#';
        }else {
            return list.get(0);
        }

    }
}
