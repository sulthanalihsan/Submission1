package com.myapplication.made.submission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<FilmModel> films;

    public void setFilms(ArrayList<FilmModel> films) {
        this.films = films;
    }

    public FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        FilmModel filmModel = (FilmModel) getItem(position);
        viewHolder.bind(filmModel);
        return convertView;
    }

    private class ViewHolder {
        private ImageView imgPhoto;
        private TextView txtTitle;
        private TextView txtOverview;

        ViewHolder(View view) {
            imgPhoto = view.findViewById(R.id.img_photo);
            txtTitle = view.findViewById(R.id.txt_film_title);
            txtOverview = view.findViewById(R.id.txt_film_overview);
        }

        void bind(FilmModel filmModel) {
            imgPhoto.setImageResource(filmModel.getPhoto());
            txtTitle.setText(filmModel.getTitle());
            txtOverview.setText(filmModel.getOverview());
        }

    }
}
