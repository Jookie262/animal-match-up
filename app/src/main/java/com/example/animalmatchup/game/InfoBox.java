package com.example.animalmatchup.game;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class InfoBox {

    Context context;

    public InfoBox(Context context){
        this.context = context;
    }

    public void infoBox(){
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // Set the message show for the Alert time
        builder.setMessage("A Task Performance in Mobile App that aims to develop a simple mobile game like Memory Game");

        // Set Alert Title
        builder.setTitle("Animal Match Up");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
            // When the user click yes button then app will close
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
}
