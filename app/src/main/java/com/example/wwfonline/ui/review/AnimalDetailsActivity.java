package com.example.wwfonline.ui.review;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.wwfonline.Models.Animal.AnimalDetailsModel;
import com.example.wwfonline.R;
import com.example.wwfonline.Service.APIClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AnimalDetailsActivity extends AppCompatActivity {

    TextView txtName;
    TextView txtDesc;
    TextView txtHab;
    TextView txtPop;
    TextView txtPlace;
    ImageView imgAnimal;
    TextView txtStatus;
    TextView txtCat;
    CardView cardStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);


        Bundle arguments = getIntent().getExtras();
        int id = arguments.getInt("id");

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        txtName = (TextView) findViewById(R.id.txtName);
        txtDesc = (TextView) findViewById(R.id.txtDesp);
        txtDesc.setTextIsSelectable(true);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        txtHab = (TextView) findViewById(R.id.txtHab);
        txtPop = (TextView) findViewById(R.id.txtPop);
        txtPlace = (TextView) findViewById(R.id.txtPlace);
        imgAnimal = (ImageView) findViewById(R.id.imgId);
        txtCat = (TextView) findViewById(R.id.txtCat);
        cardStatus = (CardView) findViewById(R.id.cardStatus);

        cardStatus = (CardView) findViewById(R.id.cardStatus);
        final String[] sNames = {"EXTINCT", "EXTINCT IN THE WILD", "CRITICALLY ENDANGERED", "ENDANGERED", "VULNERABLE", "NEAR THREATENED", "LEAST CONCERN"};



        APIClient.getInstance()
                .getAPI()
                .getAnimalById(id)
                .enqueue(new Callback<AnimalDetailsModel>() {
                    @Override
                    public void onResponse(@NonNull Call<AnimalDetailsModel> call, @NonNull Response<AnimalDetailsModel> response) {
                        AnimalDetailsModel post = response.body();

                        txtName.setText(post.getAnimalName());
                        txtDesc.setText(post.getDescription());
                        txtStatus.setText(post.getStatusName());
                        txtHab.setText(post.getHabitat());

                        if(post.getPopulation() == null)
                            txtPop.setText("No information");
                        else txtPop.setText(post.getPopulation().toString());

                        txtPlace.setText(post.getPlace());
                        txtCat.setText(post.getCatName());
                        Picasso.get().load(post.getImg()).into(imgAnimal);

                        if(post.getStatusName().compareTo(sNames[0]) == 0) cardStatus.setCardBackgroundColor(Color.parseColor("#ffecb3"));
                        if(post.getStatusName().compareTo(sNames[1]) == 0) cardStatus.setCardBackgroundColor(Color.parseColor("#ffe082"));
                        if(post.getStatusName().compareTo(sNames[2]) == 0) cardStatus.setCardBackgroundColor(Color.parseColor("#ffd54f"));
                        if(post.getStatusName().compareTo(sNames[3]) == 0) cardStatus.setCardBackgroundColor(Color.parseColor("#ffca28"));
                        if(post.getStatusName().compareTo(sNames[4]) == 0) cardStatus.setCardBackgroundColor(Color.parseColor("#ffc107"));
                        if(post.getStatusName().compareTo(sNames[5]) == 0) cardStatus.setCardBackgroundColor(Color.parseColor("#ffb300"));
                        if(post.getStatusName().compareTo(sNames[6]) == 0) cardStatus.setCardBackgroundColor(Color.parseColor("#ffa000"));

                        Toast.makeText(AnimalDetailsActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<AnimalDetailsModel> call, @NonNull Throwable t) {

                        t.printStackTrace();
                        Toast.makeText(AnimalDetailsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
