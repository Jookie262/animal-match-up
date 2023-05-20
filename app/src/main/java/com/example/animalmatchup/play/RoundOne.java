package com.example.animalmatchup.play;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.animalmatchup.R;
import com.example.animalmatchup.adapter.CardAdapter;
import com.example.animalmatchup.model.CardModel;
import com.example.animalmatchup.model.PopulateCard;

import java.util.ArrayList;

public class RoundOne extends Fragment implements AdapterView.OnItemClickListener {

    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_round_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.animals_card);
        CardAdapter cardAdapter = new CardAdapter(getContext(), new PopulateCard().populateCard());
        gridView.setAdapter(cardAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CardModel cardModel = (CardModel) parent.getItemAtPosition(position);
        Toast.makeText(getActivity(), cardModel.getName(), Toast.LENGTH_SHORT).show();
    }
}