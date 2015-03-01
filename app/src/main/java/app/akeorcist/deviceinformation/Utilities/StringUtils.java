package app.akeorcist.deviceinformation.Utilities;

import java.util.Locale;

/**
 * Created by Akexorcist on 2/26/15 AD.
 */
public class StringUtils {

    public static String wrapBlank(String str) {
        if(str == null || str.toLowerCase(Locale.getDefault()).equals("null"))
            str = "";
        return str;
    }

    public static String wrapUnknown(String str) {
        if(str == null || str.toLowerCase(Locale.getDefault()).equals("null") || str.equals(""))
            str = "Unknown";
        return str;
    }

    public static String wrapUnknownLower(String str) {
        if(str == null || str.toLowerCase(Locale.getDefault()).equals("null") || str.equals(""))
            str = "unknown";
        return str;
    }

}
