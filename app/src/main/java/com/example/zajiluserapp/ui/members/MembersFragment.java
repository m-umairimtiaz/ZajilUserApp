package com.example.zajiluserapp.ui.members;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zajiluserapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//import com.example.zajiluserapp.databinding.FragmentDashboardBinding;

public class MembersFragment extends Fragment {

    private RecyclerView csDepartment, mechDepartment, itDepartment, eceDepartment;
    private LinearLayout csNoData, mechNoData, itNoData, eceNoData;
    private List<MembersData> list1, list2, list3, list4;
    private MembersAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_members, container, false);
        csDepartment = view.findViewById(R.id.csDepartment);
        itDepartment = view.findViewById(R.id.itDepartment);
        mechDepartment = view.findViewById(R.id.mechDepartment);
        eceDepartment = view.findViewById(R.id.eceDepartment);

        csNoData = view.findViewById(R.id.csNoData);
        itNoData = view.findViewById(R.id.itNoData);
        mechNoData = view.findViewById(R.id.mechNoData);
        eceNoData = view.findViewById(R.id.eceNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Member");

        csDepartment();
        mechDepartment();
        itDepartment();
        eceDepartment();


        return view;

    }

    private void csDepartment() {
        //dbRef = reference.child("Computer Science");
        dbRef = reference.child("IT Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        MembersData data = snapshot.getValue(MembersData.class);
                        list1.add(data);
                    }

                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new MembersAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void itDepartment() {
        //dbRef = reference.child("Information Technology");
        dbRef = reference.child("Operations Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    itNoData.setVisibility(View.VISIBLE);
                    itDepartment.setVisibility(View.GONE);
                }else{
                    itNoData.setVisibility(View.GONE);
                    itDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        MembersData data = snapshot.getValue(MembersData.class);
                        list2.add(data);
                    }

                    itDepartment.setHasFixedSize(true);
                    itDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new MembersAdapter(list2,getContext());
                    itDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eceDepartment() {
        //dbRef = reference.child("Electronics and Communications");
        dbRef = reference.child("Sales Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    eceNoData.setVisibility(View.VISIBLE);
                    eceDepartment.setVisibility(View.GONE);
                }else{
                    eceNoData.setVisibility(View.GONE);
                    eceDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        MembersData data = snapshot.getValue(MembersData.class);
                        list3.add(data);
                    }

                    eceDepartment.setHasFixedSize(true);
                    eceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new MembersAdapter(list3,getContext());
                    eceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mechDepartment() {
        //dbRef = reference.child("Mechanical Engineering");
        dbRef = reference.child("Technical Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechDepartment.setVisibility(View.GONE);
                }else{
                    mechNoData.setVisibility(View.GONE);
                    mechDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        MembersData data = snapshot.getValue(MembersData.class);
                        list4.add(data);
                    }

                    mechDepartment.setHasFixedSize(true);
                    mechDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new MembersAdapter(list4,getContext());
                    mechDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}