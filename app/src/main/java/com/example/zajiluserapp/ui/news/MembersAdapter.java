package com.example.zajiluserapp.ui.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zajiluserapp.FullImageView;
import com.example.zajiluserapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.NewsViewAdapter> {

    private Context context;
    private ArrayList<NewsData> list;

    public MembersAdapter(Context context, ArrayList<NewsData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);
        return new NewsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewAdapter holder, int position) {

        final NewsData currentItem = list.get(position);
        holder.deleteNoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());

        try {
            if (currentItem.getImage() != null)
                Picasso.get().load(currentItem.getImage()).into(holder.deleteNoticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.deleteNoticeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(context, FullImageView.class);
                intent.putExtra("image",currentItem.getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewsViewAdapter extends RecyclerView.ViewHolder {

        private TextView deleteNoticeTitle, date, time;
        private ImageView deleteNoticeImage;

        public NewsViewAdapter(@NonNull View itemView) {
            super(itemView);
            deleteNoticeTitle = itemView.findViewById(R.id.deleteNewsTitle);
            deleteNoticeImage = itemView.findViewById(R.id.deleteNewsImage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);

        }
    }
}
