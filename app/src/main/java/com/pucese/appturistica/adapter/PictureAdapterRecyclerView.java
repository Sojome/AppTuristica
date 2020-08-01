package com.pucese.appturistica.adapter;

import android.app.Activity;
        import android.content.Intent;
        import android.os.Build;
        import android.transition.Explode;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
        import androidx.recyclerview.widget.RecyclerView;

        import com.pucese.appturistica.R;
        import com.pucese.appturistica.model.Picture;
        import com.pucese.appturistica.view.PictureDetailActivity;
        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;

public class PictureAdapterRecyclerView extends  RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>
{
    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {

        final Picture picture=pictures.get(position);
        holder.usernameCard.setText(picture.getUsername());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        Picasso.get().load(picture.getPicture()).into(holder.picturecard);

        holder.picturecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(activity, PictureDetailActivity.class);
                intent.putExtra("picture",picture.getPicture());
                intent.putExtra("name",picture.getUsername());
                intent.putExtra("time",picture.getTime());
                intent.putExtra("like",picture.getLike_number());
                intent.putExtra("description",picture.getDescription());
                intent.putExtra("titulo",picture.getTitleImage());
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
                {
                    Explode explode=new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity
                            (intent, ActivityOptionsCompat.makeSceneTransitionAnimation
                                    (activity,view,activity.getString(R.string.transitionname_picture)).toBundle());
                }else {
                    activity.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView picturecard;
        private TextView usernameCard, timeCard, likeNumberCard, description, titulo;

        public PictureViewHolder(@Nullable View itemView)
        {
            super(itemView);
            picturecard=(ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard=(TextView) itemView.findViewById(R.id.userNameCard);
            timeCard=(TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard=(TextView) itemView.findViewById(R.id.likeNumberCard);
            description=(TextView) itemView.findViewById(R.id.textContentImageDetail);
            titulo=(TextView) itemView.findViewById(R.id.titleImage);
        }
    }
}
