package indexOf;

public class indexOf {
    public static void main(String[] args) {
        String ipList = "*";
        String ip = "127.0.0.1";
        int i = ipList.indexOf(ip);
        System.out.println(i);
        if("*".equalsIgnoreCase(ipList.trim()) || ipList.indexOf(ip) > -1){
            System.out.println("SUCCESS");
        } else {
            System.out.println("ERROR");
        }
    }
}
