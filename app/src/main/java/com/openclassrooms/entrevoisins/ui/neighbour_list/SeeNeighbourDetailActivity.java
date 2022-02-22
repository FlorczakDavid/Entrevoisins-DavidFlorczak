package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
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

    private NeighbourApiService mApiService;
    private Neighbour neighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();
        init();
    }


    private void init() {
        Gson recievedNeighbour = new Gson();
        neighbour = recievedNeighbour.fromJson(this.getIntent().getExtras().getString("neighbour"), Neighbour.class);

        favoriteButton.setColorFilter(mApiService.getFavoriteNeighbours(/*this.getApplicationContext()*/).contains(neighbour) ? ContextCompat.getColor(this, android.R.color.holo_orange_light) : ContextCompat.getColor(this, android.R.color.darker_gray));
        //favoriteButton.setBackgroundColor(mApiService.getFavoriteNeighbours().contains(neighbour) ? ContextCompat.getColor(this, android.R.color.holo_orange_light) : ContextCompat.getColor(this, android.R.color.background_light));

        Glide.with(this).load(neighbour.getAvatarUrl()).into(backgroundImage);
        nameOneBackground.setText(neighbour.getName());
        nameOneCardView.setText(neighbour.getName());
        cardViewAdress.setText(neighbour.getAddress());
        cardViewPhoneNumber.setText(neighbour.getPhoneNumber());
        cardViewDescription.setText(neighbour.getAboutMe());

        cardViewWebAdress.setText("www.facebook.fr/" + neighbour.getName());
    }

    @OnClick(R.id.backButtom)
    void goBack() {
        finish();
    }

    @OnClick(R.id.favoriteButton)
    void addFavorite() {
        if (!mApiService.getFavoriteNeighbours(/*this.getApplicationContext()*/).contains(neighbour)) {
            mApiService.createFavoriteNeighbour(neighbour/*, this.getApplicationContext()*/);
        } else {
            mApiService.deleteFavoriteNeighbour(neighbour/*, this.getApplicationContext()*/);
        }
        init();
        //finish();
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
