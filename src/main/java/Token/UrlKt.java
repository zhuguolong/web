package Token;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static com.google.common.base.MoreObjects.firstNonNull;

public class UrlKt {
    public static String encode(String src) {
        return encode(src, Charsets.UTF_8);
    }

    public static String encode(String src, Charset charset) {
        if (src == null || src.isEmpty()) {
            return src;
        }
        Charset c = firstNonNull(charset, Charsets.UTF_8);
        try {
            return URLEncoder.encode(src, c.displayName());
        } catch (UnsupportedEncodingException ex) {
            return null; // 一般不会发生。
        }
    }

    public static Map<String, String[]> encodeMap(Map<String, String[]> map, Charset charset) {
        if (map == null || map.isEmpty()) return ImmutableMap.of();
        HashMap<String, String[]> result = new HashMap<>(map.size());
        String encodedName;
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            encodedName = encode(entry.getKey());
            if (entry.getValue() == null) result.put(encodedName, new String[0]);
            switch (entry.getValue().length) {
                case 0: result.put(encodedName, new String[0]); break;
                case 1: result.put(encodedName, new String[] {
                        firstNonNull(encode(map.get(entry.getKey())[0], charset), "")
                }); break;
                default:
                    result.put(encodedName,
                            Stream.of(entry.getValue()).map(it -> encode(it, charset))
                                    .filter(Objects::nonNull).toArray(String[]::new));
            }
        }
        return result;
    }

    public static String decode(String src, Charset charset) {
        if (src == null) return null;
        Charset c = firstNonNull(charset, Charsets.UTF_8);
        try {
            return URLDecoder.decode(src, c.displayName());
        } catch (UnsupportedEncodingException ex) {
            // 只有当指定的 charset 不被支持时，才会发生 （基本不会发生的异常）
            return null;
        }
    }

    public static String decode(String src) {
        return decode(src, Charsets.UTF_8);
    }

    public static String buildUrl(String baseUrl, Map<String, Object> params) {
        if (params == null || params.isEmpty()) return baseUrl;
        StringBuilder sb = new StringBuilder(baseUrl);
        if (baseUrl.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        int i, innerSize;
        Object innerVal;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue().getClass().isArray()) {
                innerSize = Array.getLength(entry.getValue());
                if (innerSize > 0) {
                    for (i = 0; i < innerSize; i++) {
                        innerVal = Array.get(entry.getValue(), i);
                        sb.append(entry.getKey()).append("=").append(
                                innerVal == null ? "" : innerVal.toString())
                                .append("&");
                    }
                }
            } else {
                sb.append(entry.getKey()).append("=").append(String.valueOf(entry.getValue())).append("&");
            }
        }
        if (sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private UrlKt() {}
}
