package com.example.efbonus.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.efbonus.R;
import com.example.efbonus.entities.Books;
import java.util.List;
public class booksAdapter extends RecyclerView.Adapter {
    List<Books> datosBooks;
    public booksAdapter(List<Books> datosBooks){
        this.datosBooks=datosBooks;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_books,parent,false);
        return new booksAdapter.booksAdapterViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final booksAdapter.booksAdapterViewHolder viewHolder = (booksAdapterViewHolder) holder;
        TextView tvautorbook = holder.itemView.findViewById(R.id.idAutorBooks);
        TextView tvtitulobook = holder.itemView.findViewById(R.id.idTituloBooks);
        tvautorbook.setText(datosBooks.get(position).autor);
        tvtitulobook.setText(datosBooks.get(position).titulo);
    }
    @Override
    public int getItemCount() {
        return datosBooks.size();
    }
    static class booksAdapterViewHolder extends RecyclerView.ViewHolder{

        public booksAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
