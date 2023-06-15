package com.example.animalmatchup.game;

import com.example.animalmatchup.R;
import com.example.animalmatchup.model.CardModel;

import java.util.ArrayList;
import java.util.Collections;

public class PopulateCard {

    int numCards;

    public PopulateCard(int numCards){
        this.numCards = numCards;
    }

    public ArrayList<CardModel> singleAnimal(){
        ArrayList<CardModel> arrayList = new ArrayList<>();
        arrayList.add(new CardModel("monkey", R.drawable.star, R.drawable.monkey));
        arrayList.add(new CardModel("elephant", R.drawable.star, R.drawable.elephant));
        arrayList.add(new CardModel("giraffe", R.drawable.star, R.drawable.giraffe));
        arrayList.add(new CardModel("koala", R.drawable.star, R.drawable.koala));
        arrayList.add(new CardModel("rhino", R.drawable.star, R.drawable.rhino));
        arrayList.add(new CardModel("tiger", R.drawable.star, R.drawable.tiger));

        if (arrayList.size() > numCards) {
            arrayList.subList(numCards, arrayList.size()).clear();
        }

        return arrayList;
    }

    public ArrayList<CardModel> shuffleDuplicateAnimals(ArrayList<CardModel> originalList) {
        ArrayList<CardModel> duplicatedList = new ArrayList<>();

        for (CardModel animal : originalList) {
            duplicatedList.add(animal);
            duplicatedList.add(new CardModel(animal.getName(), animal.getBack_img(), animal.getFront_img()));
        }

        Collections.shuffle(duplicatedList);
        return duplicatedList;
    }

    public int getTotalAnimals(){
        return singleAnimal().size();
    }

    public ArrayList<CardModel> populateCard(){
        return shuffleDuplicateAnimals(singleAnimal());
    }
}
