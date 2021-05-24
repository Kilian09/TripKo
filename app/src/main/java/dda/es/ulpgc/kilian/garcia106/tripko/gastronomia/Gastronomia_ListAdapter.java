package dda.es.ulpgc.kilian.garcia106.tripko.gastronomia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.data.GastronomiaItem;

public class Gastronomia_ListAdapter
        extends RecyclerView.Adapter<Gastronomia_ListAdapter.ViewHolder> {

    private List<GastronomiaItem> itemList;
    private final View.OnClickListener clickListener;


    public Gastronomia_ListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }

    public void addItem(GastronomiaItem item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<GastronomiaItem> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<GastronomiaItem> items){
        itemList = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gastronomia_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(itemList.get(position).title);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.regionTextView);
        }
    }
}
