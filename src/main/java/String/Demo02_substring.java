package String;

import Utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class Demo02_substring {
    public static void main(String[] args) {
        String obj = "0,1,2,3,4,5,6,7,8,9,X,Z,Y,N,O,P,q,R,S,T,U,A,C,I,J,V,W,h,i,l,o,z,#,$,%,u,&";
//        String obj = "L";
        Map<String, Object> map1 = control(obj);
        String bussinessControl = map1.get("bussinessControl").toString();
        String serviceControl = map1.get("serviceControl").toString();

        System.out.println("bussinessControl: " + bussinessControl);
        System.out.println("serviceControl: " + serviceControl);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bussinessControl", bussinessControl);
        map.put("serviceControl", serviceControl);
        System.out.println(map);
    }

    public static Map<String, Object> control(String bussControl) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String bussinessControl = "0123456789XZYNOPqRSTUACIJVWhiloz#$%u&";//业务控制字典
        String serviceControl = "BDEFGHLMOQabkKyoxcdefvwgjstmpr@n";//服务控制字典

        StringBuffer bussinessControlBuffer = new StringBuffer("");
        StringBuffer serviceControlBuffer = new StringBuffer("");

        if (StringUtil.isNotEmpty(bussControl)) {
            if (bussControl.length() > 1) {
                //有多个值：1,2,X,a,8
                String[] split = bussControl.split(",");
                for (int i = 0; i < split.length; i++) {
                    boolean bussinessFlag = compare(split[i], bussinessControl);//比较是否为业务控制字典值
                    if (bussinessFlag) {
                        //属于业务控制
                        bussinessControlBuffer.append(split[i] + ",");
                    }
                    boolean serviceFlag = compare(split[i], serviceControl);
                    if (serviceFlag) {
                        //属于服务控制
                        serviceControlBuffer.append(split[i] + ",");
                    }
                }
            } else if (bussControl.length() == 1) {
                //一个值
                boolean bussinessFlag = compare(bussControl, bussinessControl);
                if (bussinessFlag) {
                    bussinessControlBuffer.append(bussControl);
                }
                boolean serviceFlag = compare(bussControl, serviceControl);
                if (serviceFlag) {
                    serviceControlBuffer.append(bussControl);
                }
            }
            String bussiness = bussinessControlBuffer.toString();
            String service = serviceControlBuffer.toString();
            if (bussinessControlBuffer.length() > 0 && ",".equalsIgnoreCase(bussinessControlBuffer.substring(bussinessControlBuffer.length() - 1, bussinessControlBuffer.length()))) {
                bussiness = bussinessControlBuffer.substring(0, bussinessControlBuffer.length() - 1);
            }
            if (serviceControlBuffer.length() > 0 && ",".equalsIgnoreCase(serviceControlBuffer.substring(serviceControlBuffer.length() - 1, serviceControlBuffer.length()))) {
                service = serviceControlBuffer.substring(0, serviceControlBuffer.length() - 1);
            }
            resMap.put("bussinessControl", bussiness);//属于业务控制
            resMap.put("serviceControl", service);//属于服务控制
        } else {
            //空值
            resMap.put("bussinessControl", "");//属于业务控制
            resMap.put("serviceControl", "");//属于服务控制
        }
        return resMap;
    }

    /**
     *
     * @param comp1
     * @param control 业务控制/服务控制
     * @return
     */
    public static boolean compare(String comp1, String control) {
        boolean flag = false;
        if (StringUtil.isNotEmpty(comp1) && StringUtil.isNotEmpty(control)) {
            char[] chars = control.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (comp1.equals(String.valueOf(chars[i]))) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
