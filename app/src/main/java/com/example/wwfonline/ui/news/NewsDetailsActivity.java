package com.example.wwfonline.ui.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wwfonline.Models.NewsDetailsModel;
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
}
