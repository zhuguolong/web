package String;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(" | ")
                .add("one")
                .add("two")
                .add("three");
        System.out.println(sj);
    }
}
