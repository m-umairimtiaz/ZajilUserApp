package com.example.zajiluserapp.ui.members;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.admin.R;
import com.example.zajiluserapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

//import es.dmoral.toasty.Toasty;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.NewsViewAdapter> {

    private List<MembersData> list;
    private Context context;

    public MembersAdapter(List<MembersData> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public NewsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.member_item_layout, parent, false);

        return new NewsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewAdapter holder, int position) {

        final MembersData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());
        try {
            Picasso.get().load(item.getImage()).placeholder(R.drawable.profile_image).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewsViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email, post;
        private ImageView imageView;

        public NewsViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacherName);
            email = itemView.findViewById(R.id.teacherEmail);
            post = itemView.findViewById(R.id.teacherPost);
            imageView = itemView.findViewById(R.id.teacherImage);
        }
    }

}
