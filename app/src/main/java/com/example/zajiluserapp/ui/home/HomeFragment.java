package com.example.zajiluserapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.zajiluserapp.R;
import com.example.zajiluserapp.ui.connectzajil.connectzajil;

import java.util.ArrayList;

//import com.example.zajiluserapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private ImageView map;
    ImageSlider imageSlider;

    //public Home() {
        // Required empty public constructor
    //}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = (ImageSlider) view.findViewById(R.id.image_slider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        //slideModels.add(new SlideModel(R.drawable.battery, ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.licdn.com/dms/image/C4D0BAQG9ONuc9Ib2zQ/company-logo_200_200/0/1670232986058?e=2147483647&v=beta&t=kXXgpMs548QZqwwf_txg-Rvl-y4_BmIGhxNETO_G-yM", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://kuwaitlocal.com/img/News/37953/internet-service-providers-in-kuwait_0_21-06-22-08-06-34.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.licdn.com/dms/image/C4D22AQG5WocyfHkWmw/feedshare-shrink_800/0/1675241750462?e=1680739200&v=beta&t=57RvuELsGbxZW_XNH-d9KnGQN12lP_TyC9UEwDE9XMM", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.zajil.com/wp-content/uploads/2022/11/our-vision.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.zajil.com/wp-content/uploads/2022/01/Kuwait.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.zajil.com/wp-content/uploads/2022/11/our-milestone.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://content3.jdmagicbox.com/comp/def_content/internet_service_providers/default-internet-service-providers-4.jpg?clr=273f3f", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);

        map = view.findViewById(R.id.map);
        Button cnbutton = view.findViewById(R.id.connectzajilbtn);
        cnbutton.setOnClickListener(this);


        //cnbutton.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //connect();
                //Intent intent = new Intent(getContext(), connectzajil.class);
                //((MainActivity) getActivity()).startActivity(intent);
            //}
        //});


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        //final Button button = (Button) findViewById(R.id.connectzajilbtn);
        //button.setOnClickListener(new View.OnClickListener() {
          //  public void onClick(View v) {
                // your handler code here
            //}
        //});

       return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.connectzajilbtn:
                Intent intent = new Intent(getActivity(), connectzajil.class);
                startActivity(intent);
                break;

        }
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=kems Kuwait City");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void connect() {
        Intent intent = new Intent(getActivity(), connectzajil.class);
        startActivity(intent);
    }

}