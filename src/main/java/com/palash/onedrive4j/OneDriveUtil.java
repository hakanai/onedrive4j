package com.palash.onedrive4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by palash on 8/1/2016.
 */
public class OneDriveUtil {
    public static final String[] ISO8061_PATTERNS = {
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.S'Z'",
    };

    private static SimpleDateFormat simpleDateFormats[];

    static {
        simpleDateFormats = new SimpleDateFormat[ISO8061_PATTERNS.length];
        for (int i = 0; i < ISO8061_PATTERNS.length; i++) {
            simpleDateFormats[i] = new SimpleDateFormat(ISO8061_PATTERNS[i]);
        }
    }

    public static long parseDate(String dateStr) throws ParseException {
        ParseException pe = null;
        for (SimpleDateFormat simpleDateFormat : simpleDateFormats) {
            try {
                return simpleDateFormat.parse(dateStr).getTime();
            } catch (ParseException e) {
                pe = e;
            }
        }
        throw pe;
    }

    public static void main(String[] args) throws ParseException {
        long l = parseDate("2013-06-02T06:37:12Z");
        System.out.println("l = " + new Date(l));
    }
}
