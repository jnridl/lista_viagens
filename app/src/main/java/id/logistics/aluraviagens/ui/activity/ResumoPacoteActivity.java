package id.logistics.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import id.logistics.aluraviagens.R;
import id.logistics.aluraviagens.dao.PacoteDAO;
import id.logistics.aluraviagens.model.Pacote;
import id.logistics.aluraviagens.util.DiasUtil;
import id.logistics.aluraviagens.util.MoedaUtil;
import id.logistics.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSP.getLocal());

        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil
                .devolveDrawable(this, pacoteSP.getImagem());
        imagem.setImageDrawable(drawableDoPacote);

        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.FormataEmTexto(pacoteSP.getDias());
        dias.setText(diasEmTexto);

        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil
                .formataParaBR(pacoteSP.getPreco());
        preco.setText(moedaBrasileira);

    }
}