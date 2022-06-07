package ir.khorrami.pagerapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import ir.khorrami.pagerapplication.R;
import ir.khorrami.pagerapplication.model.Items;

public class ItemAdapter extends PagedListAdapter<Items, ItemAdapter.ItemViewHolder> {

    protected Context context;

    public ItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    private static DiffUtil.ItemCallback<Items> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Items>() {
                @Override
                public boolean areItemsTheSame(Items oldItem, Items newItem) {
                    return oldItem.question_id == newItem.question_id;
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(Items oldItem, Items newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_users, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Items item = getItem(position);

        if (item!= null)
        {
            holder.textView.setText(item.owner.display_name);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
