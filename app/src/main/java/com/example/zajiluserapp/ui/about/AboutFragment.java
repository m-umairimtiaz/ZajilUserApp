package com.example.zajiluserapp.ui.about;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.zajiluserapp.R;

import java.util.ArrayList;


public class AboutFragment extends Fragment {

        private ImageView map;
        ImageSlider imageSlider;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_about, container, false);

            imageSlider = (ImageSlider) view.findViewById(R.id.image_slider);

            ArrayList<SlideModel> slideModels = new ArrayList<>();

            //slideModels.add(new SlideModel(R.drawable.battery, ScaleTypes.FIT));
            slideModels.add(new SlideModel("https://media.licdn.com/dms/image/C4D22AQGPVy9zvcMyTQ/feedshare-shrink_2048_1536/0/1661254572270?e=1681344000&v=beta&t=K0zu0Fcc2hWc4VlBeh0SedLXSAv9n7FkpNPiAnTF2XQ", ScaleTypes.FIT));
            slideModels.add(new SlideModel("https://media.licdn.com/dms/image/C4D22AQEx24rOIOlqeg/feedshare-shrink_2048_1536/0/1658471337925?e=1681344000&v=beta&t=dazKHoHQHpxhT0EKaEIHaJrtwUDb-1sN8MsZ-gTjwHY", ScaleTypes.FIT));
            slideModels.add(new SlideModel("https://www.zajil.com/wp-content/uploads/2022/11/our-vision.png", ScaleTypes.FIT));
            slideModels.add(new SlideModel("https://www.zajil.com/wp-content/uploads/2022/11/our-milestone.png", ScaleTypes.FIT));
            slideModels.add(new SlideModel("https://media.licdn.com/dms/image/D4D22AQFF9aw7TCjJdw/feedshare-shrink_2048_1536/0/1666533569019?e=1681344000&v=beta&t=O2lV4meVGixRylA9RmyD94llE8cklbIwISiZQWyG3F4", ScaleTypes.FIT));

            imageSlider.setImageList(slideModels);

            return view;
        }
}