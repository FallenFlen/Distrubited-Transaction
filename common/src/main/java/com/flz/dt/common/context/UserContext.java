package com.flz.dt.common.context;

public class UserContext {
    private static final ThreadLocal<User> USER_IDS = new ThreadLocal<>();

    public static void setUser(User user) {
        USER_IDS.set(user);
    }

    public static void clear() {
        USER_IDS.remove();
    }

    public static User getUser() {
        return USER_IDS.get();
    }
}
