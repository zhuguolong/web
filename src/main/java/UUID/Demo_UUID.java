package UUID;

import java.util.UUID;

public class Demo_UUID {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);

        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }
}
