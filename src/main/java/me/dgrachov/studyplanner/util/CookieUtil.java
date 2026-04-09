package me.dgrachov.studyplanner.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.Duration;

public class CookieUtil {
    public static void setCookie(HttpServletResponse response, String name, String value) {
        setCookie(response, name, value, null);
    }

    public static void setCookie(HttpServletResponse response, String name, String value, Duration duration) {
        var cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        int maxAgeSeconds = -1;

        if (duration != null) {
            maxAgeSeconds = (int) duration.toSeconds(); // unsafe in rare cases
        }

        cookie.setMaxAge(maxAgeSeconds);
        response.addCookie(cookie);
    }

    public static void removeCookie(HttpServletResponse response, String name) {
        var cookie = new Cookie(name, "");
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
