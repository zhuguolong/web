package Utils;

public class AES
{
//  private static final String HEX = "0123456789ABCDEF";
  private static byte[] S;
  private static byte[] Si;
  private static byte[] rcon;
  private static int[] log;
  private static int[] alog;

  public static byte[] toByte(String hexString)
  {
    int len = hexString.length() / 2;
    byte[] result = new byte[len];
    for (int i = 0; i < len; i++)
      result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
    return result;
  }
  public static String encrypt(String text, String pwd) throws Exception {
    return toHex(encrypt(text.getBytes("gbk"), pwd.getBytes("gbk")));
  }

  public static String decrypt(String text, String pwd) throws Exception
  {
    return new String(decrypt(toByte(text), pwd.getBytes()));
  }

  public static String toHex(byte[] buf) {
    if (buf == null)
      return "";
    StringBuffer result = new StringBuffer(2 * buf.length);
    for (int i = 0; i < buf.length; i++) {
      appendHex(result, buf[i]);
    }
    return result.toString();
  }

  private static void appendHex(StringBuffer sb, byte b) {
    sb.append("0123456789ABCDEF".charAt(b >> 4 & 0xF)).append("0123456789ABCDEF".charAt(b & 0xF));
  }

  public static byte[] encrypt(byte[] txt, byte[] key) {
    init();
    byte[][] k = new byte[0][];
    k = keySchedule(key);
    int nSize = txt.length / 16;
    int nLeft = txt.length % 16;
    byte[] cpr = new byte[(nSize + (nLeft > 0 ? 1 : 0)) * 16];
    int L = 0;
    byte[] src = new byte[16];
    byte[] dest = new byte[16];
    for (int i = 0; i < nSize; i++) {
      System.arraycopy(txt, L, src, 0, 16);
      blockEncrypt(src, dest, k);
      System.arraycopy(dest, 0, cpr, L, 16);
      L += 16;
    }
    if (nLeft > 0) {
      System.arraycopy(txt, L, src, 0, nLeft);
      for (int i = nLeft; i < 16; i++)
        src[i] = 0;
      blockEncrypt(src, dest, k);
      System.arraycopy(dest, 0, cpr, L, 16);
      L += 16;
    }
    return cpr;
  }

  public static byte[] decrypt(byte[] cpr, byte[] key) {
    init();
    byte[][] k = keySchedule(key);
    int nSize = cpr.length / 16;
    byte[] txt = new byte[nSize * 16];
    int L = 0;
    byte[] src = new byte[16];
    byte[] dest = new byte[16];
    for (int i = 0; i < nSize; i++) {
      System.arraycopy(cpr, L, src, 0, 16);
      blockDecrypt(src, dest, k);
      System.arraycopy(dest, 0, txt, L, 16);
      L += 16;
    }
    return txt;
  }

  private static void init()
  {
    if (S == null)
      S = new byte[] { 99, 124, 119, 
        123, -14, 107, 111, 
        -59, 48, 1, 103, 
        43, -2, -41, -85, 
        118, -54, -126, -55, 
        125, -6, 89, 71, 
        -16, -83, -44, -94, 
        -81, -100, -92, 114, 
        -64, -73, -3, -109, 
        38, 54, 63, -9, 
        -52, 52, -91, -27, 
        -15, 113, -40, 49, 
        21, 4, -57, 35, 
        -61, 24, -106, 5, 
        -102, 7, 18, -128, 
        -30, -21, 39, -78, 
        117, 9, -125, 44, 
        26, 27, 110, 90, 
        -96, 82, 59, -42, 
        -77, 41, -29, 47, 
        -124, 83, -47, 
        0, -19, 32, -4, -79, 
        91, 106, -53, -66, 
        57, 74, 76, 88, 
        -49, -48, -17, -86, 
        -5, 67, 77, 51, 
        -123, 69, -7, 2, 
        127, 80, 60, -97, 
        -88, 81, -93, 64, 
        -113, -110, -99, 56, 
        -11, -68, -74, -38, 
        33, 16, -1, -13, 
        -46, -51, 12, 19, 
        -20, 95, -105, 68, 
        23, -60, -89, 126, 
        61, 100, 93, 25, 
        115, 96, -127, 79, 
        -36, 34, 42, -112, 
        -120, 70, -18, -72, 
        20, -34, 94, 11, 
        -37, -32, 50, 58, 
        10, 73, 6, 36, 
        92, -62, -45, -84, 
        98, -111, -107, -28, 
        121, -25, -56, 55, 
        109, -115, -43, 78, 
        -87, 108, 86, -12, 
        -22, 101, 122, -82, 
        8, -70, 120, 37, 
        46, 28, -90, -76, 
        -58, -24, -35, 116, 
        31, 75, -67, -117, 
        -118, 112, 62, -75, 
        102, 72, 3, -10, 
        14, 97, 53, 87, 
        -71, -122, -63, 29, 
        -98, -31, -8, -104, 
        17, 105, -39, -114, 
        -108, -101, 30, -121, 
        -23, -50, 85, 40, 
        -33, -116, -95, -119, 
        13, -65, -26, 66, 
        104, 65, -103, 45, 
        15, -80, 84, -69, 
        22 };
    if (Si == null)
      Si = new byte[] { 82, 9, 106, 
        -43, 48, 54, -91, 
        56, -65, 64, -93, 
        -98, -127, -13, -41, 
        -5, 124, -29, 57, 
        -126, -101, 47, -1, 
        -121, 52, -114, 67, 
        68, -60, -34, -23, 
        -53, 84, 123, -108, 
        50, -90, -62, 35, 
        61, -18, 76, -107, 
        11, 66, -6, -61, 
        78, 8, 46, -95, 
        102, 40, -39, 36, 
        -78, 118, 91, -94, 
        73, 109, -117, -47, 
        37, 114, -8, -10, 
        100, -122, 104, -104, 
        22, -44, -92, 92, 
        -52, 93, 101, -74, 
        -110, 108, 112, 72, 
        80, -3, -19, -71, 
        -38, 94, 21, 70, 
        87, -89, -115, -99, 
        -124, -112, -40, -85, 
        0, -116, -68, -45, 
        10, -9, -28, 88, 
        5, -72, -77, 69, 
        6, -48, 44, 30, 
        -113, -54, 63, 15, 
        2, -63, -81, -67, 
        3, 1, 19, -118, 
        107, 58, -111, 17, 
        65, 79, 103, -36, 
        -22, -105, -14, -49, 
        -50, -16, -76, -26, 
        115, -106, -84, 116, 
        34, -25, -83, 53, 
        -123, -30, -7, 55, 
        -24, 28, 117, -33, 
        110, 71, -15, 26, 
        113, 29, 41, -59, 
        -119, 111, -73, 98, 
        14, -86, 24, -66, 
        27, -4, 86, 62, 
        75, -58, -46, 121, 
        32, -102, -37, -64, 
        -2, 120, -51, 90, 
        -12, 31, -35, -88, 
        51, -120, 7, -57, 
        49, -79, 18, 16, 
        89, 39, -128, -20, 
        95, 96, 81, 127, 
        -87, 25, -75, 74, 
        13, 45, -27, 122, 
        -97, -109, -55, -100, 
        -17, -96, -32, 59, 
        77, -82, 42, -11, 
        -80, -56, -21, -69, 
        60, -125, 83, -103, 
        97, 23, 43, 4, 
        126, -70, 119, -42, 
        38, -31, 105, 20, 
        99, 85, 33, 12, 
        125 };
    if (log == null)
      log = new int[] { 0, 0, 25, 1, 50, 2, 26, 198, 75, 
        199, 27, 104, 51, 238, 223, 3, 100, 4, 224, 
        14, 52, 141, 129, 239, 76, 113, 8, 200, 248, 
        105, 28, 193, 125, 194, 29, 181, 249, 185, 39, 
        106, 77, 228, 166, 114, 154, 201, 9, 120, 101, 
        47, 138, 5, 33, 15, 225, 36, 18, 240, 130, 
        69, 53, 147, 218, 142, 150, 143, 219, 189, 54, 
        208, 206, 148, 19, 92, 210, 241, 64, 70, 131, 
        56, 102, 221, 253, 48, 191, 6, 139, 98, 179, 
        37, 226, 152, 34, 136, 145, 16, 126, 110, 72, 
        195, 163, 182, 30, 66, 58, 107, 40, 84, 250, 
        133, 61, 186, 43, 121, 10, 21, 155, 159, 94, 
        202, 78, 212, 172, 229, 243, 115, 167, 87, 175, 
        88, 168, 80, 244, 234, 214, 116, 79, 174, 233, 
        213, 231, 230, 173, 232, 44, 215, 117, 122, 235, 
        22, 11, 245, 89, 203, 95, 176, 156, 169, 81, 
        160, 127, 12, 246, 111, 23, 196, 73, 236, 216, 
        67, 31, 45, 164, 118, 123, 183, 204, 187, 62, 
        90, 251, 96, 177, 134, 59, 82, 161, 108, 170, 
        85, 41, 157, 151, 178, 135, 144, 97, 190, 220, 
        252, 188, 149, 207, 205, 55, 63, 91, 209, 83, 
        57, 132, 60, 65, 162, 109, 71, 20, 42, 158, 
        93, 86, 242, 211, 171, 68, 17, 146, 217, 35, 
        32, 46, 137, 180, 124, 184, 38, 119, 153, 227, 
        165, 103, 74, 237, 222, 197, 49, 254, 24, 13, 
        99, 140, 128, 192, 247, 112, 7 };
    if (alog == null)
      alog = new int[] { 1, 3, 5, 15, 17, 51, 85, 255, 
        26, 46, 114, 150, 161, 248, 19, 53, 95, 225, 
        56, 72, 216, 115, 149, 164, 247, 2, 6, 10, 
        30, 34, 102, 170, 229, 52, 92, 228, 55, 89, 
        235, 38, 106, 190, 217, 112, 144, 171, 230, 49, 
        83, 245, 4, 12, 20, 60, 68, 204, 79, 209, 
        104, 184, 211, 110, 178, 205, 76, 212, 103, 169, 
        224, 59, 77, 215, 98, 166, 241, 8, 24, 40, 
        120, 136, 131, 158, 185, 208, 107, 189, 220, 127, 
        129, 152, 179, 206, 73, 219, 118, 154, 181, 196, 
        87, 249, 16, 48, 80, 240, 11, 29, 39, 105, 
        187, 214, 97, 163, 254, 25, 43, 125, 135, 146, 
        173, 236, 47, 113, 147, 174, 233, 32, 96, 160, 
        251, 22, 58, 78, 210, 109, 183, 194, 93, 231, 
        50, 86, 250, 21, 63, 65, 195, 94, 226, 61, 
        71, 201, 64, 192, 91, 237, 44, 116, 156, 191, 
        218, 117, 159, 186, 213, 100, 172, 239, 42, 126, 
        130, 157, 188, 223, 122, 142, 137, 128, 155, 182, 
        193, 88, 232, 35, 101, 175, 234, 37, 111, 177, 
        200, 67, 197, 84, 252, 31, 33, 99, 165, 244, 
        7, 9, 27, 45, 119, 153, 176, 203, 70, 202, 
        69, 207, 74, 222, 121, 139, 134, 145, 168, 227, 
        62, 66, 198, 81, 243, 14, 18, 54, 90, 238, 
        41, 123, 141, 140, 143, 138, 133, 148, 167, 242, 
        13, 23, 57, 75, 221, 124, 132, 151, 162, 253, 
        28, 36, 108, 180, 199, 82, 246, 1 };
    if (rcon == null)
      rcon = new byte[] { 1, 2, 4, 8, 
        16, 32, 64, -128, 
        27, 54, 108, -40, 
        -85, 77, -102, 47, 
        94, -68, 99, -58, 
        -105, 53, 106, -44, 
        -77, 125, -6, -17, 
        -59, -111 };
  }

  private static int mul(int a, int b) {
    return (a != 0) && (b != 0) ? alog[((log[(a & 0xFF)] + log[(b & 0xFF)]) % 255)] : 
      0;
  }

  private static void subBytes(byte[][] txt) {
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        txt[i][j] = S[(txt[i][j] & 0xFF)];
  }

  private static void invSubBytes(byte[][] txt) {
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        txt[i][j] = Si[(txt[i][j] & 0xFF)];
  }

  private static void shiftRows(byte[][] txt) {
    byte[][] tmp = new byte[4][4];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        tmp[i][j] = txt[i][j];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        txt[i][j] = tmp[i][((i + j) % 4)];
  }

  private static void invShiftRows(byte[][] txt) {
    byte[][] tmp = new byte[4][4];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        tmp[i][j] = txt[i][j];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        txt[i][((i + j) % 4)] = tmp[i][j];
  }

  private static void mixColumns(byte[][] txt) {
    byte[][] tmp = new byte[4][4];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        tmp[i][j] = txt[i][j];
    for (int i = 0; i < 4; i++) {
      txt[0][i] = 
        ((byte)(mul(2, tmp[0][i]) ^ mul(3, tmp[1][i]) ^ 
        tmp[2][i] ^ tmp[3][i]));
      txt[1][i] = 
        ((byte)(mul(2, tmp[1][i]) ^ mul(3, tmp[2][i]) ^ 
        tmp[0][i] ^ tmp[3][i]));
      txt[2][i] = 
        ((byte)(mul(2, tmp[2][i]) ^ mul(3, tmp[3][i]) ^ 
        tmp[1][i] ^ tmp[0][i]));
      txt[3][i] = 
        ((byte)(mul(2, tmp[3][i]) ^ mul(3, tmp[0][i]) ^ 
        tmp[2][i] ^ tmp[1][i]));
    }
  }

  private static void invMixColumns(byte[][] txt) {
    byte[][] tmp = new byte[4][4];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        tmp[i][j] = txt[i][j];
    for (int i = 0; i < 4; i++) {
      txt[0][i] = 
        ((byte)(mul(14, tmp[0][i]) ^ mul(11, tmp[1][i]) ^ 
        mul(13, tmp[2][i]) ^ mul(9, tmp[3][i])));
      txt[1][i] = 
        ((byte)(mul(9, tmp[0][i]) ^ mul(14, tmp[1][i]) ^ 
        mul(11, tmp[2][i]) ^ mul(13, tmp[3][i])));
      txt[2][i] = 
        ((byte)(mul(13, tmp[0][i]) ^ mul(9, tmp[1][i]) ^ 
        mul(14, tmp[2][i]) ^ mul(11, tmp[3][i])));
      txt[3][i] = 
        ((byte)(mul(11, tmp[0][i]) ^ mul(13, tmp[1][i]) ^ 
        mul(9, tmp[2][i]) ^ mul(14, tmp[3][i])));
    }
  }

  private static byte[][] keySchedule(byte[] key) {
    byte[][] w = new byte[44][4];
    int i = 0;
    for (i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        w[i][j] = key[(4 * i + j)];
    byte[] temp = null;
    for (i = 4; i < 44; i++) {
      temp = new byte[w[(i - 1)].length];
      for (int i2 = 0; i2 < temp.length; i2++)
        temp[i2] = w[(i - 1)][i2];
      if (i % 4 == 0) {
        rotWord(temp);
        subWord(temp);
        int tmp108_107 = 0;
        byte[] tmp108_106 = temp; tmp108_106[tmp108_107] = ((byte)(tmp108_106[tmp108_107] ^ rcon[(i / 4 - 1)]));
      }
      for (int k = 0; k < w[i].length; k++)
        w[i][k] = ((byte)(w[(i - 4)][k] ^ temp[k]));
    }
    return w;
  }

  private static void addRoundKey(byte[][] txt, byte[][] w, int round) {
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
      {
        int tmp16_14 = j;
        byte[] tmp16_13 = txt[i]; tmp16_13[tmp16_14] = ((byte)(tmp16_13[tmp16_14] ^ w[(round * 4 + j)][i]));
      }
  }

  private static void rotWord(byte[] w) { byte temp = w[0];
    w[0] = w[1];
    w[1] = w[2];
    w[2] = w[3];
    w[3] = temp; }

  private static void subWord(byte[] w)
  {
    for (int i = 0; i < w.length; i++)
      w[i] = S[(w[i] & 0xFF)];
  }

  private static void blockEncrypt(byte[] txt, byte[] cpr, byte[][] key) {
    byte[][] state = new byte[4][4];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        state[i][j] = txt[(i + 4 * j)];
    addRoundKey(state, key, 0);
    for (int i = 1; i <= 9; i++) {
      subBytes(state);
      shiftRows(state);
      mixColumns(state);
      addRoundKey(state, key, i);
    }
    subBytes(state);
    shiftRows(state);
    addRoundKey(state, key, 10);
    for (int j = 0; j < 4; j++)
      for (int l = 0; l < 4; l++)
        cpr[(j + 4 * l)] = state[j][l];
  }

  private static void blockDecrypt(byte[] cpr, byte[] txt, byte[][] key) {
    byte[][] state = new byte[4][4];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        state[i][j] = cpr[(i + 4 * j)];
    addRoundKey(state, key, 10);
    for (int i = 9; i > 0; i--) {
      invShiftRows(state);
      invSubBytes(state);
      addRoundKey(state, key, i);
      invMixColumns(state);
    }
    invSubBytes(state);
    invShiftRows(state);
    addRoundKey(state, key, 0);
    for (int j = 0; j < 4; j++)
      for (int l = 0; l < 4; l++)
        txt[(j + 4 * l)] = state[j][l];
  }

  public static void main(String[] args)
  {
    String a = "E515659494DAD696A69105B4021DA45EBFCDEBDDBEB04CE808DCB081FE2A7F5B16760FF498E69C98D7F993CF6141A81D";
    String word = "hello bernard";
    String key = "hello world 1234";
    try {
      String b = encrypt(word, key);

      System.out.println(b);
      String c = decrypt(a, key);
      System.out.println(c);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}