package id.logistics.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import id.logistics.aluraviagens.R;
import id.logistics.aluraviagens.model.Pacote;
import id.logistics.aluraviagens.util.DataUtil;
import id.logistics.aluraviagens.util.MoedaUtil;
import id.logistics.aluraviagens.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteSP);
        mostraImagem(pacoteSP);
        mostraData(pacoteSP);
        mostraPreco(pacoteSP);

    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBR(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data_viagem);
        String periodoEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }

}