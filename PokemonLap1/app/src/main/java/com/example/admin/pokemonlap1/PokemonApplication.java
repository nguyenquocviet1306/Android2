package com.example.admin.pokemonlap1;

import android.app.Application;
import android.util.Log;

import com.example.admin.pokemonlap1.fragment.DbHeper;
import com.example.admin.pokemonlap1.models.Pokemon;

/**
 * Created by Admin on 11/20/2016.
 */

public class PokemonApplication extends Application {
    private static final String TAG = PokemonApplication.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();
        DbHeper.init(this);
//        for (Pokemon pokemon: DbHeper.getInstance().selectAllPokemon()) {
//            Log.d(TAG,pokemon.toString());
//        }
        Log.d(TAG,"Inserted");
        Log.d(TAG,DbHeper.getInstance().slectRandomPokemon().toString()+"");
    }
}
