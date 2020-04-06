package com.example.wwfonline.ui.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wwfonline.Adapters.AnimalDetailsAdapter;
import com.example.wwfonline.Models.AnimalDetailsModel;
import com.example.wwfonline.R;
import com.example.wwfonline.Service.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalListActivity extends AppCompatActivity {

    private ListView listViewAnimalDetails;
    private List<AnimalDetailsModel> animalDetailsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        Bundle arguments = getIntent().getExtras();
        String type = arguments.getString("type");

        if (type.compareTo("allAnimals") == 0) {
            listViewAnimalDetails = (ListView) findViewById(R.id.listAnimal);
            APIClient.getInstance()
                    .getAPI()
                    .findAllAnimals()
                    .enqueue(new Callback<List<AnimalDetailsModel>>() {
                        @Override
                        public void onResponse(Call<List<AnimalDetailsModel>> call, Response<List<AnimalDetailsModel>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Load Successful", Toast.LENGTH_SHORT).show();
                                animalDetailsModels = (List<AnimalDetailsModel>) response.body();
                                listViewAnimalDetails.setAdapter(new AnimalDetailsAdapter(getApplicationContext(), animalDetailsModels));
                                listViewAnimalDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        AnimalDetailsModel animalDetailsModel = animalDetailsModels.get(position);
                                        Intent intent = new Intent(AnimalListActivity.this, AnimalDetailsActivity.class);
                                        intent.putExtra("id", animalDetailsModel.getAnimalId());
                                        intent.putExtra("animal_name", animalDetailsModel.getAnimalName());
                                        intent.putExtra("desp", animalDetailsModel.getDescription());
                                        intent.putExtra("habitat", animalDetailsModel.getHabitat());
                                        intent.putExtra("population", animalDetailsModel.getPopulation());
                                        intent.putExtra("place", animalDetailsModel.getPlace());
                                        intent.putExtra("img", animalDetailsModel.getImg());
                                        intent.putExtra("status", animalDetailsModel.getStatusName());
                                        intent.putExtra("category", animalDetailsModel.getCatName());
                                        startActivity(intent);
                                    }
                                });
                            } else {
                                Toast.makeText(getApplicationContext(), "Server is not returned any data", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<AnimalDetailsModel>> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "There is no internet connection", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}