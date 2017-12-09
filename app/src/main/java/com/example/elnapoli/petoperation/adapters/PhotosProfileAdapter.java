package com.example.elnapoli.petoperation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elnapoli.petoperation.R;
import com.example.elnapoli.petoperation.models.Photos;

import java.util.ArrayList;

/**
 * Created by elnapoli on 09-12-17.
 */

public class PhotosProfileAdapter  extends RecyclerView.Adapter<PhotosProfileAdapter.PhotoProfileViewHolder>{

    Context mcontext;
    ArrayList<Photos> myPhotos;

    public PhotosProfileAdapter(Context mcontext, ArrayList<Photos> myPhotos){
        this.mcontext = mcontext;
        this.myPhotos = myPhotos;
    }
    @Override
    public PhotoProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_photos_profile,parent,false);
        return new PhotosProfileAdapter.PhotoProfileViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoProfileViewHolder holder, int position) {
        Photos myPhoto = myPhotos.get(position);
        holder.ivProfilePersonal.setImageResource(myPhoto.getSrc());
        holder.tvRatingPersonal.setText(String.valueOf(myPhoto.getRanking()));
    }

    @Override
    public int getItemCount() {
        return myPhotos.size();
    }

    public  static class PhotoProfileViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivProfilePersonal;
        private TextView tvRatingPersonal;

        public PhotoProfileViewHolder(View itemView) {
            super(itemView);
            ivProfilePersonal = (ImageView) itemView.findViewById(R.id.ivProfilePersonal);
            tvRatingPersonal = (TextView) itemView.findViewById(R.id.tvRatingPersonal);
        }
    }
}
