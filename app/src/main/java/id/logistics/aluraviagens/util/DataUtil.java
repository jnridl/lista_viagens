package id.logistics.aluraviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static String DIA_E_MES = "dd/MM";

    @NonNull
    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatDateBR = new SimpleDateFormat(DIA_E_MES);
        String dataFormatIda = formatDateBR.format(dataIda.getTime());
        String dataFormatVolta = formatDateBR.format(dataVolta.getTime());
        String dataFormatViagem = dataFormatIda + " - " + dataFormatVolta + " de " + dataVolta.get(Calendar.YEAR);
        return dataFormatViagem;
    }

}
