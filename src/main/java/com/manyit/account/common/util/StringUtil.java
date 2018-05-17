package com.manyit.account.common.util;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.sql.Clob;
import java.util.*;

/**
 * <p>Copyright ® 上海旻瑞信息技术有限公司版权所有。</p>
 * 类名:StringUtil
 * 创建人:童海龙    创建时间:2018/5/17
 */
public class StringUtil {
    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public StringUtil() {
    }



    public static void clob2Str(Object obj) {
        if (null != obj) {
            if (obj instanceof Map) {
                Map item = (Map)obj;
                Set<String> keys = item.keySet();
                Iterator i$ = keys.iterator();

                while(i$.hasNext()) {
                    String key = (String)i$.next();
                    Object v = item.get(key);
                    if (v instanceof Clob) {
                        item.put(key, convertToString(v));
                    }
                }
            }

        }
    }

    public static String convertToString(Object obj) {
        String result = "";
        if (obj != null) {
            if (obj instanceof Clob) {
                try {
                    Clob clob = (Clob)obj;
                    result = clob.getSubString(1L, NumberUtil.convertToInt(clob.length()));
                } catch (Exception var3) {
                    result = var3.getMessage();
                }
            } else {
                result = obj.toString();
            }
        }

        return result;
    }

    public static boolean isChineseCharacter(String chineseStr) {
        char[] charArray = chineseStr.toCharArray();

        for(int i = 0; i < charArray.length; ++i) {
            if (charArray[i] >= 19968 && charArray[i] <= '龻') {
                return true;
            }
        }

        return false;
    }

    public static String BASE64DecoderString(String s) {
        byte[] b = BASE64Decoder(s);
        return new String(b);
    }

    public static String BASE64Encoder(String s) throws UnsupportedEncodingException {
        byte[] b = s.getBytes("utf-8");
        return BASE64Encoder(b);
    }

    public static String BASE64Encoder(byte[] b) {
        return b != null && b.length > 0 ? (new BASE64Encoder()).encode(b) : null;
    }

    public static byte[] BASE64Decoder(String s) {
        try {
            if (s != null) {
                return (new BASE64Decoder()).decodeBuffer(s);
            }
        } catch (IOException var2) {
            logger.error("", var2);
        }

        return null;
    }

    public static String list2str(Collection list) {
        return list2str(list, ",");
    }

    public static String dhstrtrim(String str, String splitstr) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(str)) {
            String[] ss = str.split(splitstr);
            String[] arr$ = ss;
            int len$ = ss.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String s = arr$[i$];
                sb.append(s.trim());
                sb.append(splitstr);
            }

            if (sb.length() > 0) {
                sb.delete(sb.lastIndexOf(splitstr), sb.length());
            }
        }

        return sb.toString();
    }

    public static String dhstrtrim(String str) {
        return dhstrtrim(str, ",");
    }

    public static String list2str(Collection list, String splitstr) {
        StringBuilder sb = new StringBuilder();
        if (null != list && list.size() > 0) {
            Iterator iterator = list.iterator();

            while(iterator.hasNext()) {
                String item = convertToString(iterator.next());
                sb.append(item);
                sb.append(splitstr);
            }

            if (sb.length() > 0) {
                sb.delete(sb.lastIndexOf(splitstr), sb.length());
            }
        }

        return sb.toString();
    }

    public static List<String> str2list(String str) {
        return str2list(str, ",");
    }

    public static List<String> str2list(String str, String splitstr) {
        String[] strs = str.split(splitstr);
        return Arrays.asList(strs);
    }

    public static String html2Text(String html) {
        String ret = html.replaceAll("&[^;]*;", "");
        ret = ret.replaceAll("<[^>]*>", "");
        return ret;
    }

    public static String getLineSeparator() {
        String ret = (String)ValidateUtil.canonicalize(System.getProperty("line.separator"));
        ret = (String)ValidateUtil.validateObject(ret);
        return ret;
    }

    public static String getRandomString(int length) {
        StringBuilder ret = new StringBuilder();
        SecureRandom ran = new SecureRandom();
        if (length > 0) {
            for(int i = 0; i < length; ++i) {
                int num = (int)(ran.nextDouble() * 10.0D);
                ret.append(num);
            }
        }

        return ret.toString();
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }
}

