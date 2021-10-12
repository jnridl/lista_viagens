package id.logistics.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

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

        Pacote pacoteSP = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));
        mostraPreco(pacoteSP);

        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);


    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBR = MoedaUtil.formataParaBR(pacote.getPreco());
        preco.setText(moedaBR);
    }

}