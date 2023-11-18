package com.example.wallet.adapter;

import static android.os.Build.VERSION_CODES.P;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallet.R;
import com.example.wallet.model.Updates;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    ArrayList<Updates> updates;

    public RecyclerAdapter(ArrayList<Updates> updates) {
        this.updates = updates;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layoutView = inflater.inflate(R.layout.updates_item,parent,false);
        return new MyViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.get().load(updates.get(position).getImage()).into(holder.imageView);

        holder.title.setText(updates.get(position).getTitle());
        holder.date.setText(updates.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return updates.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView date, title;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.update_image);
            date = itemView.findViewById(R.id.update_date);
            title = itemView.findViewById(R.id.update_name);
        }
    }
}
