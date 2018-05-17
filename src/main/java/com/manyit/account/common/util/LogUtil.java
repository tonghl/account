package com.manyit.account.common.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Copyright ® 上海旻瑞信息技术有限公司版权所有。</p>
 * 类名:LogUtil
 * 创建人:童海龙    创建时间:2018/5/17
 */
public class LogUtil {
    private static Logger logger= LoggerFactory.getLogger(LogUtil.class);
    public static void logAction(Object o) {
        for (int i = 0; i < 100; i++) {
            logger.info(logger.getName() + JSON.toJSONString(o));
        }
    }
}
