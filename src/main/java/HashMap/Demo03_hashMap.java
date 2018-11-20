package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo03_hashMap {
    public static void main(String[] args) {
        Map<String, Object> map = hashMap();
        System.out.println(map);

        list();

        Map();
    }

    public static Map<String, Object> hashMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("张三", 23);
        map.put("李四", 24);
        map.put("王五", 25);
        map.put("赵六", 26);
        return map;
    }

    public static void list() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(hashMap());
        list.add(hashMap());
        System.out.println(list);
    }

    public static void Map() {
        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map1.put("张三", 23);
        map1.put("李四", 24);
        map1.put("王五", 25);
        map1.put("赵六", 26);

        map2.put("张三", 23);
        map2.put("李四", 24);
        map2.put("王五", 25);
        map2.put("赵六", 26);

        map1.put("map2", map2);

        System.out.println(map1);
    }
}
