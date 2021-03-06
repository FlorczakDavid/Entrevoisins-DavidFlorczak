package com.openclassrooms.entrevoisins.service;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//import android.content.SharedPreferences;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoriteNeighbours = new ArrayList<>();

//    private SharedPreferences sharedPreferences;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }
    @Override
    public List<Neighbour> getFavoriteNeighbours(/*Context context*/) {
//        sharedPreferences = context.getSharedPreferences("Neighbours", Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPreferences.getString("NeighboursList", "");
//        Type type = new TypeToken<List<Neighbour>>() {}.getType();
//
//        if (json == null || json.isEmpty()) {
//            return new ArrayList<>();
//        }

//        favoriteNeighbours = gson.fromJson(json, type);
//        return favoriteNeighbours;
        return favoriteNeighbours;
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }
    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour/*, Context context*/) {
        favoriteNeighbours.remove(neighbour);
//        saveData(context);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }
    @Override
    public void createFavoriteNeighbour(Neighbour neighbour/*, Context context*/) {
        favoriteNeighbours.add(neighbour);
//        saveData(context);
    }

//    public void saveData(Context context) {
//        sharedPreferences = context.getSharedPreferences("Neighbours", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        Gson gson = new Gson();
//        String json = gson.toJson(favoriteNeighbours);
//
//        editor.putString("NeighboursList", json);
//        editor.apply();
//    }
}
