package com.ifox.platform.common.constant;

/**
 * rest接口状态常量
 * @author Yeager
 */
public final class RestStatusConstant {

    /**
     * 标准http状态
     */

    public static final Integer SUCCESS = 200;


    public static final Integer INVALID_REQUEST = 400;

    public static final Integer UNAUTHORIZED = 401;

    public static final Integer NOT_FOUND = 404;

    public static final Integer SERVER_EXCEPTION = 500;

    /**
     * 以下为自定义异常(从480开始排列)
     */
    // 用户名或者密码错误
    public static final Integer USER_NAME_OR_PASSWORD_ERROR = 480;
    //Token校验失败
    public static final Integer TOKEN_ERROR = 481;

}
