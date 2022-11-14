package com.hfad.vacationdestination;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class dialogueShowDest extends DialogFragment
{
    private VacationDestination dest;

    public dialogueShowDest(VacationDestination dest)
    {
        this.dest = dest;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialogue, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        TextView tvTitle = dialogView.findViewById(R.id.tvTitle);
        tvTitle.setText(dest.getPlaceName());
        CheckBox cbFav = dialogView.findViewById(R.id.tvIsFavorite);
        if(dest.getFavorite())
        {
            cbFav.setClickable(false);
            cbFav.setChecked(true);
            cbFav.setText("Favorite");

        }
        else
        {
            cbFav.setClickable(false);
            cbFav.setChecked(false);
            cbFav.setText("Not Favorite");
        }

        Button btnDoneShowingDest = dialogView.findViewById(R.id.btnDoneShowingNote);

        btnDoneShowingDest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        builder.setView(dialogView);
        return builder.create();
    }
}