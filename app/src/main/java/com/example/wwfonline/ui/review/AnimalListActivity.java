package com.example.wwfonline.ui.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.wwfonline.Adapters.AnimalDetailsAdapter;
import com.example.wwfonline.Adapters.CatListAdapter;
import com.example.wwfonline.Adapters.ConListAdapter;
import com.example.wwfonline.Adapters.StatusListAdapter;
import com.example.wwfonline.Models.Animal.AnimalDetailsModel;
import com.example.wwfonline.Models.Category.CategoryModel;
import com.example.wwfonline.Models.Category.byCategoryModel;
import com.example.wwfonline.Models.Continent.byConModel;
import com.example.wwfonline.Models.Status.byStatusModel;
import com.example.wwfonline.R;
import com.example.wwfonline.Service.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalListActivity extends AppCompatActivity {

    private ListView listViewAnimalDetails;
    private List<AnimalDetailsModel> animalDetailsModels;
    private List<byCategoryModel> byCategoryModelList;
    private List<byConModel> byConModelList;
    private List<byStatusModel> byStatusModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        Bundle arguments = getIntent().getExtras();
        String animalList = arguments.getString("animalList");
        String cname = arguments.getString("cname");

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        listViewAnimalDetails = (ListView) findViewById(R.id.listAnimal);

        if(animalList.compareTo("allAnimals") == 0) {
            APIClient.getInstance()
                    .getAPI()
                    .findAllAnimals()
                    .enqueue(new Callback<List<AnimalDetailsModel>>() {
                        @Override
                        public void onResponse(Call<List<AnimalDetailsModel>> call, Response<List<AnimalDetailsModel>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(AnimalListActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                animalDetailsModels = (List<AnimalDetailsModel>) response.body();
                                listViewAnimalDetails.setAdapter(new AnimalDetailsAdapter(AnimalListActivity.this, animalDetailsModels));
                                listViewAnimalDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        AnimalDetailsModel animalDetailsModel = animalDetailsModels.get(position);
                                        Intent intent = new Intent(AnimalListActivity.this, AnimalDetailsActivity.class);
                                        intent.putExtra("id", animalDetailsModel.getAnimalId());
                                        startActivity(intent);

                                    }
                                });
                            } else {
                                Toast.makeText(AnimalListActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<AnimalDetailsModel>> call, Throwable t) {
                            Toast.makeText(AnimalListActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        if(animalList.compareTo("byCat") == 0){
            APIClient.getInstance()
                    .getAPI()
                    .findCatByName(cname)
                    .enqueue(new Callback<List<byCategoryModel>>() {
                        @Override
                        public void onResponse(Call<List<byCategoryModel>> call, Response<List<byCategoryModel>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(AnimalListActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                byCategoryModelList = (List<byCategoryModel>) response.body();
                                listViewAnimalDetails.setAdapter(new CatListAdapter(AnimalListActivity.this, byCategoryModelList));
                                listViewAnimalDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        byCategoryModel byCategoryModel = byCategoryModelList.get(position);
                                        Intent intent = new Intent(AnimalListActivity.this, AnimalDetailsActivity.class);
                                        intent.putExtra("id", byCategoryModel.getAnimalId());
                                        startActivity(intent);

                                    }
                                });

                            } else {
                                Toast.makeText(AnimalListActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<byCategoryModel>> call, Throwable t) {
                            Toast.makeText(AnimalListActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        if(animalList.compareTo("byCon") == 0){
            APIClient.getInstance()
                    .getAPI()
                    .findConByName(cname)
                    .enqueue(new Callback<List<byConModel>>() {
                        @Override
                        public void onResponse(Call<List<byConModel>> call, Response<List<byConModel>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(AnimalListActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                byConModelList = (List<byConModel>) response.body();
                                listViewAnimalDetails.setAdapter(new ConListAdapter(AnimalListActivity.this, byConModelList));
                                listViewAnimalDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        byConModel byConModel = byConModelList.get(position);
                                        Intent intent = new Intent(AnimalListActivity.this, AnimalDetailsActivity.class);
                                        intent.putExtra("id", byConModel.getAnimalId());
                                        startActivity(intent);

                                    }
                                });

                            } else {
                                Toast.makeText(AnimalListActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<byConModel>> call, Throwable t) {
                            Toast.makeText(AnimalListActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        if(animalList.compareTo("byStat") == 0){
            APIClient.getInstance()
                    .getAPI()
                    .findStatusByName(cname)
                    .enqueue(new Callback<List<byStatusModel>>() {
                        @Override
                        public void onResponse(Call<List<byStatusModel>> call, Response<List<byStatusModel>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(AnimalListActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                byStatusModelList = (List<byStatusModel>) response.body();
                                listViewAnimalDetails.setAdapter(new StatusListAdapter(AnimalListActivity.this, byStatusModelList));
                                listViewAnimalDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        byStatusModel byStatusModel = byStatusModelList.get(position);
                                        Intent intent = new Intent(AnimalListActivity.this, AnimalDetailsActivity.class);
                                        intent.putExtra("id", byStatusModel.getAnimalId());
                                        startActivity(intent);

                                    }
                                });

                            } else {
                                Toast.makeText(AnimalListActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<byStatusModel>> call, Throwable t) {

                        }
                    });
        }

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