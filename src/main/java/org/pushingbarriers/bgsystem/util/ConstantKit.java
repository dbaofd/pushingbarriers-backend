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
     * redis token expires time, 12 mins/30 days
     * use "jedis.expire()" to set key expired time, the unit here is second
     */
    public static final Integer TOKEN_EXPIRE_TIME = 60 * 12;

    public static final Integer TOKEN_EXPIRE_TIME_FOR_APP= 60*60*24*30;

    /**
     * reset token expired time limitation, 15 mins, the unit here is millisecond
     */
    public static final Integer TOKEN_RESET_TIME = 1000 * 60* 8;


}
