package com.example.wwfonline.ui.statistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.wwfonline.Models.Category.cntByCatModel;
import com.example.wwfonline.Models.Continent.cntByConModel;
import com.example.wwfonline.Models.Status.cntByStatusModel;
import com.example.wwfonline.R;
import com.example.wwfonline.Service.APIClient;
import com.example.wwfonline.ui.CustomColorTemplate;
import com.example.wwfonline.ui.review.AnimalListActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatActivity extends AppCompatActivity {

    private PieChart pieChart;
    private List<PieEntry> values = new ArrayList<>();

    private List<cntByCatModel> cntByCatModelList;
    private cntByCatModel cntByCatModel;

    private List<cntByConModel> cntByConModelList;
    private cntByConModel cntByConModel;

    private List<cntByStatusModel> cntByStatusModelList;
    private cntByStatusModel cntByStatusModel;

    void setPieChart(String name) {
        Description description = new Description();
        description.setEnabled(true);

        if (name.compareTo("byCat") == 0) {
            description.setText("All animals by categories");
            description.setPosition(800, 1800);
        }

        else if(name.compareTo("byCon") == 0) {
            description.setText("All animals by continents");
            description.setPosition(800, 1800);

        }
        else if(name.compareTo("byStat") == 0) {
            description.setText("All animals by status");
            description.setPosition(800, 1300);

        }

        description.setTextSize(25);

        pieChart.setDescription(description);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(40f);
        pieChart.setTransparentCircleRadius(50f);
//        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Animals count");
        pieChart.setCenterTextSize(20);

        pieChart.setExtraOffsets(0f, -85f, 0f, 85f);

        PieDataSet pieDataSet = new PieDataSet(values, "");
        pieDataSet.setValueTextSize(20);

        pieDataSet.setFormSize(25);
        pieDataSet.setSliceSpace(2);
        pieDataSet.setColors(CustomColorTemplate.Custom_material);


        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        //pieChart.setEntryLabelTextSize(12);
        pieChart.setDrawEntryLabels(false);
        //pieChart.setEntryLabelColor(Color.parseColor("#212121"));
        pieChart.animateXY(700, 700);

        Legend legend = pieChart.getLegend();
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setFormToTextSpace(10);
        legend.setTextSize(18);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);

        pieChart.invalidate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Bundle arguments = getIntent().getExtras();
        final String name = arguments.get("type").toString();
        pieChart = (PieChart) findViewById(R.id.statusPie);

        if (name.compareTo("byCon") == 0) {
            APIClient.getInstance()
                    .getAPI()
                    .findCntByCon()
                    .enqueue(new Callback<List<cntByConModel>>() {
                        @Override
                        public void onResponse(Call<List<cntByConModel>> call, Response<List<cntByConModel>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(StatActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                cntByConModelList = (List<cntByConModel>) response.body();
                                int cnt = 0;
                                while (cnt < cntByConModelList.size()) {
                                    cntByConModel = cntByConModelList.get(cnt);
                                    values.add(new PieEntry(cntByConModel.getCount(), cntByConModel.getConName()));
                                    cnt++;
                                }
                                setPieChart(name);

                                pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                                    @Override
                                    public void onValueSelected(Entry e, Highlight h) {
                                        Intent intent = new Intent(StatActivity.this, AnimalListActivity.class);
                                        intent.putExtra("cname", ((PieEntry) e).getLabel());
                                        intent.putExtra("animalList", "byCon");
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onNothingSelected() {

                                    }
                                });
                            } else
                                Toast.makeText(StatActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<List<cntByConModel>> call, Throwable t) {
                            Toast.makeText(StatActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();

                        }
                    });
        }

        if (name.compareTo("byCat") == 0) {
            APIClient.getInstance()
                    .getAPI()
                    .findCntByCat()
                    .enqueue(new Callback<List<cntByCatModel>>() {
                        @Override
                        public void onResponse(Call<List<cntByCatModel>> call, Response<List<cntByCatModel>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(StatActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                cntByCatModelList = (List<cntByCatModel>) response.body();
                                int cnt = 0;
                                while (cnt < cntByCatModelList.size()) {
                                    cntByCatModel = cntByCatModelList.get(cnt);
                                    values.add(new PieEntry(cntByCatModel.getCount(), cntByCatModel.getCatName()));
                                    cnt++;
                                }
                                setPieChart(name);

                                pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                                    @Override
                                    public void onValueSelected(Entry e, Highlight h) {
                                        Intent intent = new Intent(StatActivity.this, AnimalListActivity.class);
                                        intent.putExtra("cname", ((PieEntry) e).getLabel());
                                        intent.putExtra("animalList", "byCat");
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onNothingSelected() {

                                    }
                                });
                            } else
                                Toast.makeText(StatActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<List<cntByCatModel>> call, Throwable t) {
                            Toast.makeText(StatActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();

                        }
                    });
        }

        if (name.compareTo("byStat") == 0) {
            APIClient.getInstance()
                    .getAPI()
                    .findCntByStatus()
                    .enqueue(new Callback<List<cntByStatusModel>>() {
                        @Override
                        public void onResponse(Call<List<cntByStatusModel>> call, Response<List<cntByStatusModel>> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(StatActivity.this, "Load Successful", Toast.LENGTH_SHORT).show();
                                cntByStatusModelList = (List<cntByStatusModel>) response.body();
                                int cnt = 0;
                                while (cnt < cntByStatusModelList.size()) {
                                    cntByStatusModel = cntByStatusModelList.get(cnt);
                                    values.add(new PieEntry(cntByStatusModel.getCount(), cntByStatusModel.getStatusName()));
                                    cnt++;
                                }
                                setPieChart(name);

                                pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                                    @Override
                                    public void onValueSelected(Entry e, Highlight h) {
                                        Intent intent = new Intent(StatActivity.this, AnimalListActivity.class);
                                        intent.putExtra("cname", ((PieEntry) e).getLabel());
                                        intent.putExtra("animalList", "byStat");
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onNothingSelected() {

                                    }
                                });
                            } else
                                Toast.makeText(StatActivity.this, "Server is not returned any data", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<List<cntByStatusModel>> call, Throwable t) {
                            Toast.makeText(StatActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();

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
