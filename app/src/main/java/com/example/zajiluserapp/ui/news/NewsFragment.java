package com.example.zajiluserapp.ui.news;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.zajiluserapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewsFragment extends Fragment {
    private RecyclerView deleteNewsRecycler;
    private ProgressBar progressBar;
    private ArrayList<NewsData> list;
    private MembersAdapter adapter;

    private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        deleteNewsRecycler = view.findViewById(R.id.deleteNewsRecycler);
        progressBar = view.findViewById(R.id.progressBar);

        reference = FirebaseDatabase.getInstance().getReference().child("News");

        deleteNewsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        deleteNewsRecycler.setHasFixedSize(true);
        //Toast.makeText(getContext(), "open 1", Toast.LENGTH_SHORT).show();

        getNews();

        return view;
    }

    private void getNews() {
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    NewsData data = snapshot.getValue(NewsData.class);
                    list.add(0,data);

                }

                adapter =  new MembersAdapter(getContext(), list);
                adapter.notifyDataSetChanged();
                //Toast.makeText(getContext(), "opened till here", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

                deleteNewsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "Error"+databaseError, Toast.LENGTH_SHORT).show();
            }
        });
    }

}