package Math;

public class MathDemo {
    public static void main(String[] args) {
        /** 快车速度 */
        long fspeed = 75;
        /** 慢车速度 */
        long lspeed = 65;

        /** 甲比乙多行40km */
        long sub = 40;

        long speedAdd = speedAdd(fspeed, lspeed);
        long speedSub = speedSub(fspeed, lspeed);

        /** 甲乙两地距离 */
        long distance = distance(speedAdd, time(sub, speedSub));
        System.out.println("甲乙两地距离：" + distance + "千米");
    }

    /** 速度和 */
    public static long speedAdd(long a, long b) {
        return a + b;
    }

    /** 速度差 */
    public static long speedSub(long a, long b) {
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    }

    /** 时间 */
    public static long time(long distance, long speed) {
        return distance / speed;
    }

    /** 路程 */
    public static long distance(long speed, long time) {
        return speed * time;
    }
}
