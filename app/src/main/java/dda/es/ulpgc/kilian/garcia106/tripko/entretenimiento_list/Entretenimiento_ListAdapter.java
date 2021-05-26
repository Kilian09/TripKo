package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.data.EntretenimientoItem;

public class Entretenimiento_ListAdapter extends RecyclerView.Adapter<Entretenimiento_ListAdapter.ViewHolder> {

    private List<EntretenimientoItem> itemList;
    private final View.OnClickListener clickListener;


    public Entretenimiento_ListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }


    public void addItem(EntretenimientoItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<EntretenimientoItem> items) {
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<EntretenimientoItem> items) {
        itemList = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entretenimiento_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.entretenimientoTextViewIzq.setText(itemList.get(position).title);
     //   holder.entretenimientoTextViewDere.setText(itemList.get(position).title2);


        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView entretenimientoTextViewIzq;
       // final TextView entretenimientoTextViewDere;

        ViewHolder(View view) {
            super(view);
            entretenimientoTextViewIzq = view.findViewById(R.id.entretenimientoTextIzq);
           // entretenimientoTextViewDere = view.findViewById(R.id.entretenimientoTextDere);
        }
    }
}