package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeeNeighbourDetailActivity extends AppCompatActivity {

    @BindView(R.id.backgroudImageView)
    ImageView backgroundImage;
    @BindView(R.id.nameOnBackgroundTextView)
    TextView nameOneBackground;
    @BindView(R.id.cardViewName)
    TextView nameOneCardView;
    @BindView(R.id.cardViewAdress)
    TextView cardViewAdress;
    @BindView(R.id.cardViewPhone)
    TextView cardViewPhoneNumber;
    @BindView(R.id.cardViewWebAdress)
    TextView cardViewWebAdress;
    @BindView(R.id.cardViewAProposDescrition)
    TextView cardViewDescription;

    @BindView(R.id.favoriteButton)
    FloatingActionButton favoriteButton;
    @BindView(R.id.backButtom)
    ImageButton backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);
        init();
    }


    private void init() {
//        Glide.with(this).load(mNeighbourImage).placeholder(R.drawable.ic_account)
//                .apply(RequestOptions.circleCropTransform()).into(avatar);
        nameOneBackground.setText(this.getIntent().getExtras().getString("neighbourName"));
        nameOneCardView.setText(this.getIntent().getExtras().getString("neighbourName"));
        cardViewAdress.setText(this.getIntent().getExtras().getString("neighbourAdress"));
        cardViewPhoneNumber.setText(this.getIntent().getExtras().getString("phoneNumber"));
        cardViewDescription.setText(this.getIntent().getExtras().getString("APropos"));

        cardViewWebAdress.setText("www.facebook.fr/" + this.getIntent().getExtras().getString("neighbourName"));
    }

    @OnClick(R.id.backButtom)
    void goBack() {

    }

    @OnClick(R.id.favoriteButton)
            void addFavorite() {

    }

    /**
     * Used to navigate to this activity
     * @param activity
     */
    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddNeighbourActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}
