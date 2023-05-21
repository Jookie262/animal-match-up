package com.example.animalmatchup.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalmatchup.R;
import com.example.animalmatchup.model.CardModel;
import com.example.animalmatchup.model.GameModel;
import com.example.animalmatchup.play.CongratsScreen;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardRecyclerViewAdapter.ViewHolder>{

    private ArrayList<CardModel> mData;
    private ArrayList<EasyFlipView> flipCards;
    private ArrayList<String> names;
    GameModel gameModel;
    Context context;
    TextView gameScore;
    int totalCard;

    FragmentManager fragment;

    public CardRecyclerViewAdapter(ArrayList<CardModel> mData, Context context, GameModel gameModel, TextView gameScore, int totalCard, FragmentManager fragment) {
        this.mData = mData;
        this.context = context;
        this.gameModel = gameModel;
        this.gameScore = gameScore;
        this.totalCard = totalCard;
        this.fragment = fragment;
        flipCards = new ArrayList<>();
        names = new ArrayList<>();
    }

    @NonNull
    @Override
    public CardRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardModel model = mData.get(position);
        holder.getBackImage().setImageResource(model.getBack_img());
        holder.getFrontImage().setImageResource(model.getImg());
        Handler handler = new Handler();



        holder.getEasyFlipView().setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {

                if(easyFlipView.isBackSide()){
                    flipCards.add(easyFlipView);
                    names.add(model.getName());
                    easyFlipView.setFlipOnTouch(false);
                } else {
                    easyFlipView.setFlipOnTouch(true);
                }

                if (flipCards.size() == 2) {
                    if(names.get(0).equals(names.get(1))){
                        totalCard--;
                        gameModel.setScore(+10);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                for (EasyFlipView view : flipCards) {
                                    view.setFlipEnabled(false);
                                }
                                flipCards.clear();
                                names.clear();
                            }
                        }, 200);
                    } else {
                        gameModel.setScore(-5);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                for (EasyFlipView view : flipCards) {
                                    view.flipTheView();
                                }
                                flipCards.clear();
                                names.clear();
                            }
                        }, 200);
                    }
                }
                gameScore.setText(String.valueOf(gameModel.getScore()));

                if(totalCard == 0){
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fragment.beginTransaction().replace(R.id.fragment_container, new CongratsScreen()).commit();
                        }
                    }, 300);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView backImage;
        private final ImageView frontImage;
        private final EasyFlipView easyFlipView;

        public ViewHolder(View view) {
            super(view);
            backImage = view.findViewById(R.id.back_img);
            frontImage = view.findViewById(R.id.front_img);
            easyFlipView = view.findViewById(R.id.card_flip);
        }

        public ImageView getBackImage() {
            return backImage;
        }

        public ImageView getFrontImage() {
            return frontImage;
        }

        public EasyFlipView getEasyFlipView() {
            return easyFlipView;
        }

    }
}
