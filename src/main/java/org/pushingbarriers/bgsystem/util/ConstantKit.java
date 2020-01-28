package org.pushingbarriers.bgsystem.util;

public final class ConstantKit {

    /**
     * set delete flag True
     */
    public static final Integer DEL_FLAG_TRUE = 1;

    /**
     * set delete flag false
     */
    public static final Integer DEL_FLAG_FALSE = 0;

    /**
     * redis token expires time, 10 mins
     */
    public static final Integer TOKEN_EXPIRE_TIME = 60 * 20;

    public static final Integer TOKEN_EXPIRE_TIME_FOR_APP= 60*30;

    /**
     * reset token expired time limitation
     */
    public static final Integer TOKEN_RESET_TIME = 1000 * 100;


}
