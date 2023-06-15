package com.example.animalmatchup.game;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.animalmatchup.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class InfoBox {

    private AlertDialog alertDialog;
    ScoreDB scoreDB;

    public void infoBox(Context context){
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

    // Create the dialog only once
    private void createDialog(Context context, String score) {
        // Create a custom layout for the dialog
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_layout, null);
        TextInputLayout editText = dialogView.findViewById(R.id.enter_name_txt);
        TextView alertScore = dialogView.findViewById(R.id.alert_score);
        Button button = dialogView.findViewById(R.id.ok_button);

        final MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context)
                .setView(dialogView)
                .setCancelable(false);

        alertScore.setText("Your Score: " + score);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getEditText().getText().toString().trim();
                scoreDB = new ScoreDB(context);

                if(name.isEmpty() || name.length() > 10 || name.contains(" ")){
                    editText.setError("Please follow the instructions");
                } else {
                    scoreDB.addScore(name, score);
                    Toast.makeText(context, "Successfully Saved", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }
            }
        });

        alertDialog = dialogBuilder.create();
    }

    public void addNameScore(Context context, String score) {
        // Create the dialog if it doesn't exist
        if (alertDialog == null) {
            createDialog(context, score);
        }

        // Show the dialog
        alertDialog.show();
    }


}
