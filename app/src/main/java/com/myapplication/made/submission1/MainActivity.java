package com.myapplication.made.submission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle, dataReleaseDate, dataDuration, dataLanguage, dataUserScore, dataRating, dataRevenue, dataGenre, dataOverview;
    private TypedArray dataPhoto;
    private FilmAdapter adapter;
    private ArrayList<FilmModel> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new FilmAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String filmTitle = films.get(position).getTitle();
                Toast.makeText(MainActivity.this, "Anda memilih " + filmTitle, Toast.LENGTH_SHORT).show();

                FilmModel filmModel = films.get(position);
                Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailFilmActivity.class);
                moveWithObjectIntent.putExtra(DetailFilmActivity.EXTRA_DATA, filmModel);
                startActivity(moveWithObjectIntent);
            }
        });
    }

    private void prepare() {
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataReleaseDate = getResources().getStringArray(R.array.data_release_date);
        dataDuration = getResources().getStringArray(R.array.data_duration);
        dataLanguage = getResources().getStringArray(R.array.data_language);
        dataUserScore = getResources().getStringArray(R.array.data_user_score);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataRevenue = getResources().getStringArray(R.array.data_revenue);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataOverview = getResources().getStringArray(R.array.data_overview);
    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            FilmModel filmModel = new FilmModel();
            filmModel.setPhoto(dataPhoto.getResourceId(i, -1));
            filmModel.setTitle(dataTitle[i]);
            filmModel.setReleaseDate(dataReleaseDate[i]);
            filmModel.setDuration(dataDuration[i]);
            filmModel.setLanguage(dataLanguage[i]);
            filmModel.setUserScore(dataUserScore[i]);
            filmModel.setRating(dataRating[i]);
            filmModel.setRevenue(dataRevenue[i]);
            filmModel.setGenre(dataGenre[i]);
            filmModel.setOverview(dataOverview[i]);
            films.add(filmModel);
        }
        adapter.setFilms(films);
    }
}
