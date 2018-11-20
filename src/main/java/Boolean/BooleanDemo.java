package Boolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import HashMap.HashMap;

public class BooleanDemo {
    public static void main(String[] args) {
        Boolean aBoolean = valueOf(true);
        System.out.println(aBoolean);

        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        Map<String, List<String>> m = HashMap.newInstance();
        m.put("01", list);
        m.put("02", list);
        m.put("03", list);
        System.out.println(m.toString());
    }

    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}
