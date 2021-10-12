package id.logistics.aluraviagens.ui.activity;

import static id.logistics.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import id.logistics.aluraviagens.R;
import id.logistics.aluraviagens.model.Pacote;
import id.logistics.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);
            configuraBotao(pacote);

        }
    }

    private void configuraBotao(Pacote pacote) {

        Button btnRealizaPagamento  = findViewById(R.id.pagamento_botao_finaliza_compra);
        btnRealizaPagamento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                vaiParaResumoCompra(pacote);
            }

        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBR = MoedaUtil.formataParaBR(pacote.getPreco());
        preco.setText(moedaBR);
    }

}