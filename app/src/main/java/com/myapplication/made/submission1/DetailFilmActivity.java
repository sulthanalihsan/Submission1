package com.myapplication.made.submission1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilmActivity extends AppCompatActivity {
    private TextView dtl_film_title, dtl_film_release_date, dtl_film_duration, dtl_film_language, dtl_film_user_score, dtl_film_rating, dtl_film_revenue, dtl_film_genre, dtl_film_overview;
    private ImageView dtl_imgPhoto;

    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Film");
        }

        dtl_imgPhoto = findViewById(R.id.dtl_imgPhoto);
        dtl_film_title = findViewById(R.id.dtl_film_title);
        dtl_film_release_date = findViewById(R.id.dtl_film_release_date);
        dtl_film_duration = findViewById(R.id.dtl_film_duration);
        dtl_film_language = findViewById(R.id.dtl_film_language);
        dtl_film_user_score = findViewById(R.id.dtl_film_user_score);
        dtl_film_rating = findViewById(R.id.dtl_film_rating);
        dtl_film_revenue = findViewById(R.id.dtl_film_revenue);
        dtl_film_genre = findViewById(R.id.dtl_film_genre);
        dtl_film_overview = findViewById(R.id.dtl_film_overview);


        FilmModel filmModel = getIntent().getParcelableExtra(EXTRA_DATA);

        dtl_imgPhoto.setImageResource(filmModel.getPhoto());
        dtl_film_title.setText(filmModel.getTitle());
        dtl_film_release_date.setText(filmModel.getReleaseDate());
        dtl_film_duration.setText(filmModel.getDuration());
        dtl_film_language.setText(filmModel.getLanguage());
        dtl_film_user_score.setText(filmModel.getUserScore());
        dtl_film_rating.setText(filmModel.getRating());
        dtl_film_revenue.setText(filmModel.getRevenue());
        dtl_film_genre.setText(filmModel.getGenre());
        dtl_film_overview.setText(filmModel.getOverview());


    }
}
