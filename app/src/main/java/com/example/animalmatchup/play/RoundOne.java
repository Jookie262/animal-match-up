package com.example.animalmatchup.play;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animalmatchup.R;
import com.example.animalmatchup.adapter.CardRecyclerViewAdapter;
import com.example.animalmatchup.model.PopulateCard;

public class RoundOne extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_round_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.animals_card);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        PopulateCard populateCard = new PopulateCard();
        CardRecyclerViewAdapter cardRecyclerViewAdapter = new CardRecyclerViewAdapter(populateCard.populateCard(), getContext());
        recyclerView.setAdapter(cardRecyclerViewAdapter);
    }
}