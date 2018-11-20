package Comparable;

import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {
        String str = "KSDFHDFAJSUYIKG1654354TEWFHAKJV";
        Set<String> s = new HashSet<String>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            s.add(String.valueOf(c));
        }

        List<String> list = new ArrayList<String>();
        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            list.add(next);
        }
        System.out.println("排序前：" + list);
        Collections.sort(list);
        System.out.println("排序后：" + list);
    }
}
