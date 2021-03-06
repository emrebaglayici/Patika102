package Collactions.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("TR","Turkey");
        map.put("USA","United States");
        map.put("FR","France");
        map.put("EN","England");

        for (String key:map.keySet()){
            System.out.println(key);
        }

        for(String value: map.values()){
            System.out.println(value);
        }

        for (String a: map.keySet()){
            System.out.println(map.get(a));
        }

    }
}
