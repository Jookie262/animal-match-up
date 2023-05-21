package com.example.animalmatchup.model;

import com.example.animalmatchup.R;

import java.util.ArrayList;
import java.util.Collections;

public class PopulateCard {

    public ArrayList<CardModel> singleAnimal(){
        ArrayList<CardModel> arrayList = new ArrayList<>();
        arrayList.add(new CardModel("monkey", R.drawable.star, R.drawable.monkey));
        arrayList.add(new CardModel("elephant", R.drawable.star, R.drawable.elephant));
        arrayList.add(new CardModel("giraffe", R.drawable.star, R.drawable.giraffe));
        arrayList.add(new CardModel("koala", R.drawable.star, R.drawable.koala));
        arrayList.add(new CardModel("rhino", R.drawable.star, R.drawable.rhino));
        arrayList.add(new CardModel("tiger", R.drawable.star, R.drawable.tiger));
        return arrayList;
    }

    public ArrayList<CardModel> shuffleDuplicateAnimals(ArrayList<CardModel> originalList) {
        ArrayList<CardModel> duplicatedList = new ArrayList<>();

        for (CardModel animal : originalList) {
            duplicatedList.add(animal);
            duplicatedList.add(new CardModel(animal.getName(), animal.getBack_img(), animal.getImg()));
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
