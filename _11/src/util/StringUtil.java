package util;

public class StringUtil {

    private StringUtil(){}

    public static boolean hasLength(String str){
        return str != null && !"".equals(str.trim());
    }
}
