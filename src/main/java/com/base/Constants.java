package com.base;

/**
 * 常量表
 *
 * @author ShenHuaJie
 * @version $Id: Constants.java, v 0.1 2014-2-28 上午11:18:28 ShenHuaJie Exp $
 */
public interface Constants {
    /**
     * 异常信息统一头信息<br>
     * 非常遗憾的通知您,程序发生了异常
     */
    String Exception_Head = "OH,MY GOD! SOME ERRORS OCCURED! AS FOLLOWS :";
    /**
     * 客户端语言
     */
    String USERLANGUAGE = "userLanguage";
    /**
     * 客户端主题
     */
    String WEBTHEME = "webTheme";
    /**
     * 当前用户
     */
    String CURRENT_USER = "CURRENT_USER";
    /**
     * 在线用户数量
     */
    String ALLUSER_NUMBER = "ALLUSER_NUMBER";
    /**
     * 登录用户数量
     */
    String USER_NUMBER = "USER_NUMBER";
    /**
     * 上次请求地址
     */
    String PREREQUEST = "PREREQUEST";
    /**
     * 上次请求时间
     */
    String PREREQUEST_TIME = "PREREQUEST_TIME";
    /**
     * 非法请求次数
     */
    String MALICIOUS_REQUEST_TIMES = "MALICIOUS_REQUEST_TIMES";
    /**
     * 缓存命名空间
     */
    String CACHE_NAMESPACE = "iBase4J:";

    String KEY_CAPTCHA = "SE_KEY_TFZQ_CODE";
    String KEY_SMS = "SE_KEY_SMS";
    String KEY_PHONE = "SE_KEY_PHONE";

}
