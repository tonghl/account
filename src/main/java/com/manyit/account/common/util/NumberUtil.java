package com.manyit.account.common.util;

/**
 * <p>Copyright ® 上海旻瑞信息技术有限公司版权所有。</p>
 * 类名:NumberUtil
 * 创建人:童海龙    创建时间:2018/5/17
 */
public class NumberUtil {
    public NumberUtil() {
    }

    public static Integer convertToInt(Object obj) {
        try {
            Double a = convertToDouble(obj);
            return a.intValue();
        } catch (Exception var2) {
            return 0;
        }
    }

    public static Integer convertToInteger(Object obj) {
        return convertToInt(obj);
    }

    public static long convertToLong(Object obj) {
        try {
            return Long.parseLong(obj.toString());
        } catch (Exception var2) {
            return 0L;
        }
    }

    public static Double convertToDouble(Object obj) {
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception var2) {
            return 0.0D;
        }
    }

    public static Boolean isIntegerType(Object obj) {
        if (obj.equals((Object)null)) {
            return false;
        } else {
            try {
                Integer.parseInt("" + obj);
                return true;
            } catch (Exception var2) {
                return false;
            }
        }
    }

    public static Boolean isDoubleType(Object obj) {
        if (obj.equals((Object)null)) {
            return false;
        } else {
            try {
                Double.parseDouble("" + obj);
                return true;
            } catch (Exception var2) {
                return false;
            }
        }
    }
}

