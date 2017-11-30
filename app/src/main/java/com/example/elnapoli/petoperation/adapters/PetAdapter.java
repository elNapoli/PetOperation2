package com.example.elnapoli.petoperation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elnapoli.petoperation.R;
import com.example.elnapoli.petoperation.models.Pets;

import java.util.ArrayList;

/**
 * Created by elnapoli on 29-11-17.
 */
public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    ArrayList<Pets> misMascotas;
    private Context mContext;

    public PetAdapter(Context mContext, ArrayList<Pets> misMascotas){
        this.misMascotas = misMascotas;
        this.mContext = mContext;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet,parent,false);
        return new PetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder petViewHolder, int position) {
        final Pets mascota = misMascotas.get(position);
        petViewHolder.ivProfile.setImageResource(mascota.getPhoto());
        petViewHolder.tvName.setText(mascota.getName());
        petViewHolder.tvRating.setText(String.valueOf( mascota.getRating()));

        petViewHolder.ivBoneOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mascota.getIsLike()){
                    mascota.setRating(mascota.getRating()-1);
                    petViewHolder.ivBoneOn.setImageResource(R.drawable.animals_dog_bone_icon);
                    Toast.makeText(mContext, v.getResources().getString(R.string.un_like)+" "+ mascota.getName(), Toast.LENGTH_SHORT).show();
                    petViewHolder.tvRating.setText(String.valueOf( mascota.getRating()));
                    mascota.setIsLike(false);
                }
                else{
                    mascota.setRating(mascota.getRating()+1);
                    petViewHolder.ivBoneOn.setImageResource(R.drawable.bone_dog);
                    Toast.makeText(mContext, v.getResources().getString(R.string.like)+" "+ mascota.getName(), Toast.LENGTH_SHORT).show();
                    petViewHolder.tvRating.setText(String.valueOf( mascota.getRating()));
                    mascota.setIsLike(true);
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return misMascotas.size();
    }

    public  static class PetViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivProfile;
        private TextView tvName;
        private TextView tvRating;
        private ImageView  ivBoneOn;

        public PetViewHolder(View itemView) {
            super(itemView);
            ivProfile = (ImageView) itemView.findViewById(R.id.ivProfile);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            ivBoneOn = (ImageView) itemView.findViewById(R.id.ivBoneOn);
        }
    }
}
