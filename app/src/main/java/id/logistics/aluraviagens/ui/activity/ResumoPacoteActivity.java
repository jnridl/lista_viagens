package id.logistics.aluraviagens.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.logistics.aluraviagens.R;
import id.logistics.aluraviagens.model.Pacote;
import id.logistics.aluraviagens.util.DataUtil;
import id.logistics.aluraviagens.util.DiasUtil;
import id.logistics.aluraviagens.util.MoedaUtil;
import id.logistics.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);

    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBR = MoedaUtil.formataParaBR(pacote.getPreco());
        preco.setText(moedaBR);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.FormataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacoteSP) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacoteSP.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}