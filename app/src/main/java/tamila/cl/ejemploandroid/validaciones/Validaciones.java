package tamila.cl.ejemploandroid.validaciones;

import android.app.Activity;
import android.widget.EditText;

public class Validaciones {
    private boolean booleano;
    public boolean campoRequerido(EditText editText)
    {

        if(editText.getText().toString().isEmpty())
        {
            this.booleano=false;
        }else
        {
            this.booleano=true;
        }
        return this.booleano;
    }
    public  boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }else
            {
                validacion=false;
            }

        } catch (java.lang.NumberFormatException e) {
            validacion=false;
        } catch (Exception e) {
            validacion=false;
        }
        return validacion;
    }
}
