package Utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unchecked")
public class StringUtil {

	/**
	 * java按要求长度截取字段
	 * 
	 * @param str
	 *            字符
	 * @param num
	 *            长度
	 * @return
	 */
	public static String getStrLen(String str, int num) {
		int forNum = 0;
		int alli = 0;//
		int strLen = 0;// 要循环的长度
		if (str.length() >= num) {
			strLen = num;
		} else {
			strLen = str.length();
		}
		for (int i = 0; i < strLen; i++) {
			if (num == Math.floor(forNum / 2f))
				break;
			if (str.substring(i, i + 1).getBytes().length > 1) {
				// 如果是字符
				alli = alli + 1;
			}
			alli = alli + 1;
			if (alli >= num) {
				return str.substring(0, i);
			}
		}
		return str.substring(0, strLen);
	}

	
	public static boolean isNotEmpty(String str){
		if(str != null && !"".equalsIgnoreCase(str))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 填充字符
	 * 
	 * @param source
	 *            源字符串
	 * @param fillChar
	 *            填充字符
	 * @param len
	 *            填充到的长度
	 * @return 填充后的字符串
	 */
	public static String fillLeft(String source, char fillChar, long len) {
		StringBuffer ret = new StringBuffer();
		if (null == source)
			ret.append("");
		if (source.length() > len) {
			ret.append(source);
		} else {
			long slen = source.length();
			while (ret.toString().length() + slen < len) {
				ret.append(fillChar);
			}
			ret.append(source);
		}
		return ret.toString();
	}

	/**
	 * 过滤<, >,\n 字符的方法。
	 * 
	 * @param input
	 *            需要过滤的字符
	 * @return 完成过滤以后的字符串
	 */
	public static String filterHtml(String input) {
		if (input == null) {
			return null;
		}
		if (input.length() == 0) {
			return input;
		}
		input = input.replaceAll("&", "&");
		input = input.replaceAll("<", "<");
		input = input.replaceAll(">", ">");
		input = input.replaceAll(" ", " ");
		input = input.replaceAll("'", "''");
		input = input.replaceAll("\"", "\"");
		return input.replaceAll("\n", "<br>");
	}

	/**
	 * 方法filterStr将字符串中带有" ' "替换为" '' "
	 * 
	 * @param str
	 * @return
	 */
	public static String filterStr(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}
		str = str.replaceAll("'", "''");
		return str;
	}

	/**
	 * 判断字符是否超过长度
	 * 
	 * @param str
	 * @param num
	 * @return 超过规定字符返回true
	 */
	public static boolean isLen(String str, int num) {
		int forNum = 0;
		int alli = 0;//
		int strLen = 0;// 要循环的长度

		if (str.length() >= num) {
			strLen = num;
			return true;// 超过规定字符返回true
		} else {
			strLen = str.length();
		}
		for (int i = 0; i < strLen; i++) {
			if (num == Math.floor(forNum / 2f))
				break;
			if (str.substring(i, i + 1).getBytes().length > 1) {
				// 如果是字符
				alli = alli + 1;
			}
			alli = alli + 1;
		}
		if (alli > num) {
			return true;// 超过规定字符返回true
		}
		return false;// 不超过规定字符返回False
	}

	/**
	 * 方法isNumber判断输入的字符串是否是数字
	 * 
	 * @param str
	 *            字符串类型
	 * @return 是数字返回true 反之返回false
	 */
	public static boolean isNumber(String obj) {
//		boolean t = false;
//		if (StringUtils.isNotEmpty(obj)) {
//			try {
//				if (Double.valueOf(obj) > 0D) {
//					t = true;
//				}
//			} catch (Exception e) {
//
//			}
//		}
		if(isEmpty(obj)) return false;
		return obj.matches("[\\d.]+");
	}

	/**
	 * 检测字符是否是数字
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isDigit(char c) {
		String nums = "0123456789.";
		if (nums.indexOf(String.valueOf(c)) == -1) {
			return false;
		}
		return true;
	}

	/**
	* @Title: addDouble
	* @Description: TODO(浮点数相加)
	* @param @param d1
	* @param @param d2
	* @param @param t
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/
	public static String addDouble(String d1, String d2, boolean t) {
		if (isNumber(d1) && isNumber(d2)) {
			d1 = new BigDecimal(d1).add(new BigDecimal(d2)).toString();
		} else if (isNumber(d2)) {
			d1 = d2;
		}
		if (t) {
			d1 = d1.substring(0, d1.indexOf("."));
		}
		return d1;
	}

	
	/**
	 * 判断输入的字符串参数是否为空。
	 * 
	 * @param args
	 *            输入的字串
	 * @return true/false
	 */
	public static boolean isEmpty(String args) {
		if (args == null || args.trim().equalsIgnoreCase("null")|| args.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 返回指定个数的字符串
	 * 
	 * @param c
	 * @return
	 */
	public static String subString(String str, int num) {
		byte[] substr = new byte[num];
		System.arraycopy(str.getBytes(), 0, substr, 0, num);
		str = new String(substr);
		return str;
	}
	
	
	/**
	* @Title: cutoffString
	* @Description: TODO(字符串截取显示)
	* @param @param str
	* @param @param max_num
	* @param @param lan
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/
	public static String cutoffString(String str, int max_num, String lan) {
		if (str.length() > max_num)
			try {
				str = str.substring(0, max_num);
				if (lan.equals("en")) {
					str = str.substring(0, str.lastIndexOf(" "));
					str = (new StringBuilder(String.valueOf(str))).append(
							" ...").toString();
				} else {
					int j;
					for (j = 0; j < max_num; j++) {
						byte word[] = str.substring(j, j + 1).getBytes();
						int tempInt = word[0] & 255;
						if (tempInt > 128)
							j++;
					}

					if (j != max_num)
						str = str.substring(0, max_num - 1);
					str = (new StringBuilder(String.valueOf(str)))
							.append("...").toString();
				}
			} catch (Exception e) {
				return str;
			}
		return str;
	}

	/**
	* @Title: isEqual
	* @Description: TODO(判断2个字符数组是否相同)
	* @param @param one
	* @param @param other
	* @param @return    设定文件
	* @return boolean    返回类型
	* @throws
	*/
	public static boolean isEqual(char one[], char other[]) {
		boolean retVal = false;
		if (one != null && other != null && one.length == other.length) {
			for (int i = 0; i < one.length; i++) {
				if (one[i] != other[i])
					break;
				if (i == one.length - 1)
					retVal = true;
			}

		}
		return retVal;
	}
	
	/**
	* @Title: trimEmpty
	* @Description: TODO(去掉空字符串和字符串空格)
	* @param @param str
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/
	public static String trimEmpty(String str) {
		return str == null ? "" : str.trim();
	}
	
	
	/**
	 * string转list
	 * 
	 * @param str
	 * @return list
	 */
	public static List str2list(String str) {
		if (str == null || str == "") {
			return null;
		}
		if (str.endsWith(",")) {
			str = str.substring(0, str.length() - 1);
		}
		ArrayList list = new ArrayList();
		String[] id = str.split(",");
		for (int i = 0; i < id.length; i++) {
			list.add(id[i]);
		}
		return list;
	}
	
	/**
	 * MD5对字符串加密
	 * @param str
	 * @return
	 */
	public static String MD5(String str){
		StringBuffer strBuf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(str.getBytes());
			byte[] b = md.digest();
			for(int i = 0; i < b.length; i++){
				int temp = b[i] & 0xff;
				if(temp < 16)
					strBuf.append("0");
				strBuf.append(Integer.toHexString(temp));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}
	
	/***
	 * 计算字数长度
	 * @param str
	 */
	public static int calculationWords(String str){
		if(str == null || "".equals(str)){
			return 0;
		}
		str = str.trim();

		Pattern p = Pattern.compile("[^\\x00-\\xff]",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);

		String after = m.replaceAll( "11" );
		int len = (int)Math.ceil(after.length()/2F);
		return len;
	}

	/***
	 * 替换回车、换行
	 * @param s
	 * @return
	 */
	public static String replace( String s ){
		if(s == null){
			return "";
		}
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(s);
		String after = m.replaceAll("");
		return after;
	}
}
