package dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;

class Category_EntretenimientoAdapter extends RecyclerView.Adapter<Category_EntretenimientoAdapter.ViewHolder> {

    private List<CategoryEntretenimientoItem> itemList;
    private final View.OnClickListener clickListener;

    public Category_EntretenimientoAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }

    public void addItem(CategoryEntretenimientoItem item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<CategoryEntretenimientoItem> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<CategoryEntretenimientoItem> items){
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
                .inflate(R.layout.category_entretenimiento_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.categoryEntretenimientoButton.setText(itemList.get(position).title);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final Button categoryEntretenimientoButton;

        ViewHolder(View view) {
            super(view);
            categoryEntretenimientoButton = view.findViewById(R.id.entretenimientoButton);
        }
    }
}


