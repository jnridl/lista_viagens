package id.logistics.aluraviagens.util;

public class DiasUtil {

    public static final String DIAS_PLURAL = " dias";
    public static final String DIA_PLURAL = " dia";

    public static String FormataEmTexto(int qtdDias) {

        if(qtdDias > 1){
            return qtdDias + DIAS_PLURAL;
        }

        return qtdDias + DIA_PLURAL;

    }

}
