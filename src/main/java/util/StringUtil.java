package util;

public class StringUtil {

    public static String repeat(String str, int times){

        if(times < 0) {
            throw new IllegalArgumentException();
        }

        String resultado = "";

        for (int i = 0; i < times; i++) {
            resultado += str;
        }

        return resultado;
    }
}
