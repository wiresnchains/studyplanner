package me.dgrachov.studyplanner.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class HashUtil {
    public static String make(String plain) {
        return BCrypt.withDefaults().hashToString(12, plain.toCharArray());
    }

    public static Boolean verify(String plain, String hash) {
        return BCrypt.verifyer().verify(plain.toCharArray(), hash.toCharArray()).verified;
    }
}
