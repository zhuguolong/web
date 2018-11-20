package ProxyMode;

/**
 * BigV是一个代理
 */
public class BigV implements Programmer {
    private Zgl zgl;

    public BigV() {
        this.zgl = new Zgl();
    }

    public void coding() {
        //程序员zgl写程序
        zgl.coding();
        //大V点赞
        upvote();
    }

    public void upvote() {
        System.out.println("大V点赞评论！");
    }
}
