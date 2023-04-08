package com.example.zajiluserapp.ui.Gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.zajiluserapp.R;

//import com.example.zajiluserapp.databinding.FragmentNotificationsBinding;

public class GalleryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_helpsupport, container, false);
        return view;
    }
}