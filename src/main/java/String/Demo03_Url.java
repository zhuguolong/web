package String;

public class Demo03_Url {
    public static void main(String[] args) {
        String encryptStr = "custNo|0040140143-backUrl|http://220.248.101.90:8080/m/mall/index.html#!/xjyj/ktxjyj.html?srcOpen=TKMall&tkr=AB4A0CDF-E9ED-fundCompanyCode|001";
        if (encryptStr.indexOf("fundCompanyCode") != -1) {
            //三个参数
            int custNo = encryptStr.indexOf("custNo");
            System.out.println(custNo);
            System.out.println("encryptStr: " + encryptStr);

            String cust = "";
            String url = "";
            String fundAcc = "";
            if (encryptStr.indexOf("custNo") != -1) {
                cust = encryptStr.substring(encryptStr.indexOf("custNo"), encryptStr.indexOf("backUrl") - 1);
            }
            if (encryptStr.indexOf("backUrl") != -1) {
                url = encryptStr.substring(encryptStr.indexOf("backUrl"), encryptStr.indexOf("fundCompanyCode") - 1);
            }
            fundAcc = encryptStr.substring(encryptStr.indexOf("fundCompanyCode"));
            System.out.println(cust);
            System.out.println(url);
            System.out.println(fundAcc);
        }
    }
}
