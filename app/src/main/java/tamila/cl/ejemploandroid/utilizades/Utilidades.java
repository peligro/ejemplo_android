package tamila.cl.ejemploandroid.utilizades;


import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;

public class Utilidades {

    public static String formateaRut(String rut) {
        String firstPart = rut.substring(0, rut.length() - 1);
        firstPart = firstPart.replaceAll("[\\.\\-]", "");
        String tmp = "";
        while (firstPart.length() > 3) {
            tmp = "." + firstPart.substring(firstPart.length() - 3) + tmp;
            firstPart = firstPart.substring(0, firstPart.length() - 3);
        }
        String secondPart = rut.substring(rut.length() - 1, rut.length());
        return firstPart + tmp + "-" + secondPart;
    }

}
