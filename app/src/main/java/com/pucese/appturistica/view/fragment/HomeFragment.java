package com.pucese.appturistica.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pucese.appturistica.R;
import com.pucese.appturistica.adapter.PictureAdapterRecyclerView;
import com.pucese.appturistica.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        RecyclerView picturesRecycler=(RecyclerView) view.findViewById(R.id.pictureRecycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView=new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture,getActivity() );
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;

    }
    public ArrayList<Picture> buidPictures()
    {
        ArrayList<Picture> pictures =new ArrayList<>();
        pictures.add(new Picture("https://i.postimg.cc/yD6kBYGN/cevicheria-lider.jpg",
                "Cevicheria Lider","12 dias","45 Me gusta","Es una cevicheria",
                "Oe5h & Óceano Índico, Quito 170148, Ecuador, Piso 2 CASA DE 4 PISOSCOLOR AMAE PICANTERIARILLO CON LETREO D , Pichincha 170148"));

        pictures.add(new Picture("https://i.postimg.cc/WDhzFYTL/cisne.jpg",
                "Hotel Cisne","20 dias","30 Me gusta","Es un hotel",
                "Moderno, confortable y familiar las instalaciones del hotel han sido concebidas con la idea de compaginar las " +
                        "necesidades de los viajes de negocios y turismo con la confortable atención de un servicio esmerado."));

        pictures.add(new Picture("https://i.postimg.cc/wRJstf5T/esmeraldas-playa.jpg",
                "Playa de Esmeraldas","3 dias","4 Me gusta","Es una playa",
                "Las playas son sistemas dinámicos de arena, agua, flora y fauna en constante cambio." +
                        "Como destinos para nadar, surfear, ir con amigos, relajarse y observar hermosos atardeceres, " +
                        "nuestras playas ofrecen infinidad de momentos placenteros."));

        pictures.add(new Picture("https://i.postimg.cc/w3hvmm8v/gran-aki.jpg",
                "Gran Aki","43 dias","54 Me gusta","Es un lugar para comprar",
                "En 2007 se crea Gran Akí. Gran Akí es parte de la división de la cadena \"Akí\" dirigido al público popular," +
                        "incorpora a su línea de oferta productos para el hogar," +
                        "juguetería, vestido, ferretería, electrodomésticos y entretenimiento, en una suerte de tienda departamental."));

        pictures.add(new Picture("https://i.postimg.cc/GTJmwZJY/muisne.jpg",
                "Playa de muisne","12 dias","13 Me gusta","Es una playa",
                "Las playas son sistemas dinámicos de arena, agua, flora y fauna en constante cambio." +
                        "Como destinos para nadar, surfear, ir con amigos, relajarse y observar hermosos atardeceres," +
                        "nuestras playas ofrecen infinidad de momentos placenteros."));

        pictures.add(new Picture("https://i.postimg.cc/xJmdgkX6/municipio.jpg",
                "Municipio","71 dias","11 Me gusta","Es un edificio publico",
                "Nacimos en el corazón del Pueblo Esmeraldeño, haciendo de nuestras ilusiones y esperanzas," +
                        "la motivación que se necesita para continuar construyendo el próspero presente que Esmeraldas necesita."));

        pictures.add(new Picture("https://i.postimg.cc/Rqntbhr5/pacomiler.png",
                "PacoMiler","43 dias","76 Me gusta","Es una licorería",
                "El licor es una bebida alcohólica obtenida por maceración en aguardiente de hierbas o frutos, que a veces son endulzados con sacarosa," +
                        "azúcar de uva, mosto o miel, con una riqueza en azúcares superior a 100 gramos/litro."));

        pictures.add(new Picture("https://i.postimg.cc/87wfrrvW/terminal.jpg",
                "Terminal Terrestre de Esmeraldas","35 dias","9 Me gusta","Es un terminal terrestre",
                "Existen espacios que suelen convertirse en la cara oculta de las urbes a pesar de la importancia que tienen en el diario vivir de sus habitantes."));

        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton,View view)
    {
        Toolbar toolbar=(Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity() ).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity() ).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity() ).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
