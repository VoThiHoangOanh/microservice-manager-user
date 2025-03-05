package com.microservice.usertest.utils;

public class UserUtils {
    private static final String USER_ID = "%s_%s";


    public static String generateUserId(int maxSize) {
        return USER_ID.formatted(
                "USER", String.valueOf(maxSize));
    }
    public static String generateUserName(int maxSize) {
        return USER_ID.formatted(
                "User_Tên", String.valueOf(maxSize));
    }
    public static String generateUserEmail(int maxSize) {
        return "user%s@gmail.com".replace("%s", String.valueOf(maxSize));
    }
}
