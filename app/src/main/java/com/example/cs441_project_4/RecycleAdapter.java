package com.example.cs441_project_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ImageViewHolder> {
    private int[] imageArray;
    public RecycleAdapter(int[] imageArray){
        this.imageArray = imageArray;
    }

    @Override
    public ImageViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        int image_id = imageArray[position];
        holder.Images.setImageResource(image_id);
        holder.TV.setText("Image "+position);
    }

    @Override
    public int getItemCount() {
        return imageArray.length;
    }
    public static class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView Images;
        TextView TV;
        public ImageViewHolder(View itemView) {
            super(itemView);
            Images= itemView.findViewById(R.id.foodImages);
            TV = itemView.findViewById(R.id.foodTV);

        }
    }

}
