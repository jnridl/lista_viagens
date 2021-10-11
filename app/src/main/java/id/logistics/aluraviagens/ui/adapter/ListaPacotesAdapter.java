package id.logistics.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.logistics.aluraviagens.util.DiasUtil;
import id.logistics.aluraviagens.util.MoedaUtil;
import id.logistics.aluraviagens.R;
import id.logistics.aluraviagens.util.ResourceUtil;
import id.logistics.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {

        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;

    }

    private void mostraPreco(View viewCriada, Pacote pacote) {

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String precoBR = MoedaUtil.formataParaBR(pacote.getPreco());
        preco.setText(precoBR);

    }

    private void mostraDias(View viewCriada, Pacote pacote) {

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasText = DiasUtil.FormataEmTexto(pacote.getDias());
        dias.setText(diasText);

    }

    private void mostraImagem(View viewCriada, Pacote pacote) {

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);

    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }

}
