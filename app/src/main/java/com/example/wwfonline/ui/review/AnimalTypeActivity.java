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

import com.example.wwfonline.Adapters.CatAdapter;
import com.example.wwfonline.Adapters.ConAdapter;
import com.example.wwfonline.Adapters.StatAdapter;
import com.example.wwfonline.Models.Category.CategoryModel;
import com.example.wwfonline.Models.Continent.ConModel;
import com.example.wwfonline.Models.Status.StatusModel;
import com.example.wwfonline.R;
import com.example.wwfonline.Service.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class AnimalTypeActivity extends AppCompatActivity {

    private ListView listViewAnimalType;
    private List<CategoryModel> categoryModelList;
    private List<ConModel> conModelList;
    private List<StatusModel> statusModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_type);

        Bundle arguments = getIntent().getExtras();
        final String animalType = arguments.getString("type");
        listViewAnimalType = findViewById(R.id.typeAnimal);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if(animalType.compareTo("byCat") == 0){
            APIClient.getInstance()
                    .getAPI()
                    .findAllCat()
                    .enqueue(new Callback<List<CategoryModel>>(){
                        @Override
                        public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(AnimalTypeActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                categoryModelList = (List<CategoryModel>) response.body();
                                listViewAnimalType.setAdapter(new CatAdapter(AnimalTypeActivity.this, categoryModelList));
                                listViewAnimalType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        CategoryModel categoryModel = categoryModelList.get(position);
                                        Intent intent = new Intent(AnimalTypeActivity.this, AnimalListActivity.class);
                                        intent.putExtra("cname", categoryModel.getCatName());
                                        intent.putExtra("animalList", "byCat");
                                        startActivity(intent);

                                    }
                                });
                            }
                            else
                                Toast.makeText(AnimalTypeActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
                            Toast.makeText(AnimalTypeActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        if(animalType.compareTo("byCon") == 0){
            APIClient.getInstance()
                    .getAPI()
                    .findAllCon()
                    .enqueue(new Callback<List<ConModel>>() {
                        @Override
                        public void onResponse(Call<List<ConModel>> call, Response<List<ConModel>> response) {
                            if(response.isSuccessful()) {
                                Toast.makeText(AnimalTypeActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                conModelList = (List<ConModel>) response.body();
                                listViewAnimalType.setAdapter(new ConAdapter(AnimalTypeActivity.this, conModelList));
                                listViewAnimalType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        ConModel conModel = conModelList.get(position);
                                        Intent intent = new Intent(AnimalTypeActivity.this, AnimalListActivity.class);
                                        intent.putExtra("cname", conModel.getConName());
                                        intent.putExtra("animalList", "byCon");
                                        startActivity(intent);

                                    }
                                });
                            }
                            else
                                Toast.makeText(AnimalTypeActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<List<ConModel>> call, Throwable t) {
                            Toast.makeText(AnimalTypeActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        if(animalType.compareTo("byStat") == 0){
            APIClient.getInstance()
                    .getAPI()
                    .findAllStat()
                    .enqueue(new Callback<List<StatusModel>>() {
                        @Override
                        public void onResponse(Call<List<StatusModel>> call, Response<List<StatusModel>> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(AnimalTypeActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                statusModelList = (List<StatusModel>) response.body();
                                listViewAnimalType.setAdapter(new StatAdapter(AnimalTypeActivity.this, statusModelList));
                                listViewAnimalType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        StatusModel statusModel = statusModelList.get(position);
                                        Intent intent = new Intent(AnimalTypeActivity.this, AnimalListActivity.class);
                                        intent.putExtra("cname", statusModel.getStatusName());
                                        intent.putExtra("animalList", "byStat");
                                        startActivity(intent);

                                    }
                                });
                            }
                            else
                                Toast.makeText(AnimalTypeActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<List<StatusModel>> call, Throwable t) {
                            Toast.makeText(AnimalTypeActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
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
