package com.flz.dt.common.context;

public class UserContext {
    private static final ThreadLocal<Long> USER_IDS = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        USER_IDS.set(userId);
    }

    public static void clear() {
        USER_IDS.remove();
    }

    public static Long getUserId() {
        return USER_IDS.get();
    }
}
