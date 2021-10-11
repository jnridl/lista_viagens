package id.logistics.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil
{

    public static final String LINGUA = "pt";
    public static final String PAIS = "br";

    public static String formataParaBR(BigDecimal valor) {

        NumberFormat formatBR = DecimalFormat.getCurrencyInstance(new Locale(LINGUA, PAIS));
        return formatBR.format(valor);

    }

}
