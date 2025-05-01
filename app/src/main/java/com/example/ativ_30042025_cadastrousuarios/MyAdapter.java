package com.example.ativ_30042025_cadastrousuarios;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    List<Usuario> usuariosList;

    public MyAdapter(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextViewNome().setText(usuariosList.get(position).getNome());
        holder.getTextViewSexo().setText(usuariosList.get(position).getSexo());
        if (usuariosList.get(position).isEstudante()){
            holder.getTextViewEstudante().setText("Estudante");
        }
        if (usuariosList.get(position).isEstagiario()){
            holder.getTextViewEstagiario().setText("Estagiário");
        }
        if (usuariosList.get(position).isProfissional()){
            holder.getTextViewProfissional().setText("Profissional");
        }
        if (usuariosList.get(position).isDoador()){
            holder.getTextViewDoador().setText("Doador");
        }
    }

    @Override
    public int getItemCount() {
        return usuariosList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNome, textViewSexo, textViewEstudante, textViewEstagiario, textViewProfissional, textViewDoador;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewSexo = itemView.findViewById(R.id.textViewSexo);
            textViewEstudante = itemView.findViewById(R.id.textViewEstudante);
            textViewEstagiario = itemView.findViewById(R.id.textViewEstagiario);
            textViewProfissional = itemView.findViewById(R.id.textViewProfissional);
            textViewDoador = itemView.findViewById(R.id.textViewDoador);
        }

        public TextView getTextViewNome() {
            return textViewNome;
        }

        public TextView getTextViewSexo() {
            return textViewSexo;
        }

        public TextView getTextViewEstudante() {
            return textViewEstudante;
        }

        public TextView getTextViewEstagiario() {
            return textViewEstagiario;
        }

        public TextView getTextViewProfissional() {
            return textViewProfissional;
        }

        public TextView getTextViewDoador() {
            return textViewDoador;
        }
    }
}
