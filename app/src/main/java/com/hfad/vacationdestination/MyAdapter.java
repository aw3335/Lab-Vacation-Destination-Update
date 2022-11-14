package com.hfad.vacationdestination;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private ArrayList<VacationDestination> destinationList;
    private FragmentManager fragManager;

    public MyAdapter(FragmentManager fragManager)
    {
        this.fragManager = fragManager;
        destinationList = Database.getData();
        System.out.println("Done making list");

    }



    //Create empty view of a single row
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vacationitem, parent, false);

        System.out.println("Done Creating a View");
        return new MyViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    //Binds data to an empty row view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) //Position is the index in the list that you want to show
    {
        VacationDestination vd = destinationList.get(position);
        holder.setData(vd, position);


        System.out.println("Done Populating a Row: " + position + "" + vd.getPlaceName());

    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ImageView imgDestination;
        private TextView tvName;
        private ImageView imvDelete;
        private ImageView imvMakeCopy;
        private ImageView imvStar;


        private int currentPositionInList = -1;
        private VacationDestination currentDest = null;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgDestination = itemView.findViewById(R.id.imvPlace);
            tvName = itemView.findViewById(R.id.tvPlaceName);
            imvDelete = itemView.findViewById(R.id.imvDelete);
            imvMakeCopy = itemView.findViewById(R.id.imvMakeCopy);
            imvStar = itemView.findViewById(R.id.imvBlankStar);

            imvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    destinationList.remove(currentPositionInList);
                    notifyItemRemoved(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, destinationList.size());
                }
            });
            imvMakeCopy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    destinationList.add(currentPositionInList, currentDest);
                    notifyItemInserted(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, destinationList.size());
                }
            });
            imvStar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!currentDest.getFavorite())
                    {
                        imvStar.setImageResource(R.drawable.gold_star_svg);
                        currentDest.setFavorite(true);
                    }
                    else
                    {
                        imvStar.setImageResource(R.drawable._00px_five_pointed_star_svg);
                        currentDest.setFavorite(false);
                    }

                }
            });

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            dialogueShowDest dialog = new dialogueShowDest(currentDest);
            dialog.show(fragManager, "");
        }

        public void setData(VacationDestination vd, int position)
        {
            imgDestination.setImageResource(vd.getImageId());
            tvName.setText(vd.getPlaceName());
            currentPositionInList = position;
            currentDest = vd;

        }


    }



}
