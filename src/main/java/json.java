import com.alibaba.fastjson.JSON;

public class json {
    public static void main(String[] args) {
        String jsonStr = "[{\"cx\":\"ss\",\"cs\":\"se\"},{\"cs\":\"ww\",\"cx\":\"eew\"}]";
        JSON json = JSON.parseArray(jsonStr);
        System.out.println(json);
        String s = json.toString();
        System.out.println(s);
    }
}
