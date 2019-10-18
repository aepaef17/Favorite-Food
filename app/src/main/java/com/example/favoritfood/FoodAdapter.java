package com.example.favoritfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//ini adalah class adapter yang dibutuhkan untuk menampilkan data ke listview
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Food> foods;

    //Disini tambahkan constructur untuk kedua hal diatas


    public FoodAdapter(Context mContext, ArrayList<Food> foods) {
        this.mContext = mContext;
        this.foods = foods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflater adalah perngubah xml agar bisa jadi object di java
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_food_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Membind data yang akan ditampilkan
        Food currentFood = foods.get(position);
        holder.tvName.setText(currentFood.getName());
        holder.tvPrice.setText("RP "+currentFood.getPrice()+"");
        holder.ratingBar.setRating(currentFood.getRate());
        if (currentFood.isFave()){
            holder.imageView.setImageResource(R.drawable.ic_favorite);
        }else {
            holder.imageView.setImageResource(R.drawable.ic_nonfav);
        }
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    //ini adalah Viewholder yang nantinya dibutuhkan oleh adapter
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName, tvPrice;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}