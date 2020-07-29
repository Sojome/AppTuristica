package com.pucese.appturistica.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pucese.appturistica.R;
import com.pucese.appturistica.adapter.PictureAdapterRecyclerView;
import com.pucese.appturistica.model.Picture;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search,container,false);
        RecyclerView picturesRecycler=(RecyclerView) view.findViewById(R.id.search_recyclerview_photos);
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),2);

        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView=new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture,getActivity() );
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buidPictures()
    {
        ArrayList<Picture> pictures =new ArrayList<>();
        pictures.add(new Picture("https://fotosnginx.vive1.com/thumbs/s/358x230xC/s3.amazonaws.com/fvive1/production/image/property/90/240790/240790__2343765.jpg",
                "Aaron Jaramillo","3 dias","3 Me gusta"));
        pictures.add(new Picture("https://www.salud.gob.ec/wp-content/uploads/2014/02/centro-de-salud-san-lorenzo.jpg",
                "Centro de salud","20 dias","23 Me Gusta"));
        pictures.add(new Picture("https://www.esmeraldas.gob.ec/turismo/images/rocketlauncher/home/fp-secondfullwidth/parqueinfantil.jpg",
                "Parque infantil","6 dias","12 Me gusta"));
        pictures.add(new Picture("https://i.ytimg.com/vi/5DhZgQtDFzA/maxresdefault.jpg",
                "Hotel Tonsupa","3 dias","4 Me gusta"));
        pictures.add(new Picture("https://i.ytimg.com/vi/5DhZgQtDFzA/maxresdefault.jpg",
                "Hotel Tonsupa","3 dias","4 Me gusta"));
        return pictures;
    }
}