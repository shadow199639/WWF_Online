package com.example.wwfonline.ui.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.wwfonline.Models.News.NewsDetailsModel;
import com.example.wwfonline.R;
import com.example.wwfonline.Service.APIClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Bundle arguments = getIntent().getExtras();
        Integer id = (Integer) arguments.get("id");

        final ImageView imgDetail = (ImageView) findViewById(R.id.imgDetail);
        final TextView txtHeader1 = (TextView) findViewById(R.id.txtHeader1);
        final TextView txtTitle1 = (TextView) findViewById(R.id.txtTitle1);
        final TextView txtDisc = (TextView) findViewById(R.id.txtDisc1);

        APIClient.getInstance()
                .getAPI()
                .getNewsById(id)
                .enqueue(new Callback<NewsDetailsModel>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsDetailsModel> call, @NonNull Response<NewsDetailsModel> response) {
                        NewsDetailsModel post = response.body();
                        Picasso.get().load(post.getDIng()).into(imgDetail);
                        txtHeader1.setText(post.getHead());
                        txtTitle1.setText(post.getTitle());
                        txtDisc.setText(post.getDescription());
                        Toast.makeText(getApplicationContext(), "Load Successful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<NewsDetailsModel> call, @NonNull Throwable t) {

                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();

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
