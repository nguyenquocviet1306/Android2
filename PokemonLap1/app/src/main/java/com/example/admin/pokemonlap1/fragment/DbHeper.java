package com.example.admin.pokemonlap1.fragment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.admin.pokemonlap1.models.Pokemon;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/20/2016.
 */

public class DbHeper extends SQLiteAssetHelper {

    private final static String DB_NAME = "pokemon.db";
    private final static int DB_VERSION = 1;
    //========= POKEMON =============//
    private final static String POKEMON_TABLE_NAME = "pokemon";
    private final static String POKEMON_ID = "id";
    private final static String POKEMON_NAME = "name";
    private final static String POKEMON_TAG = "tag";
    private final static String POKEMON_GEN = "gen";
    private final static String POKEMON_IMG = "img";
    private final static String POKEMON_COLOR = "color";
    private final static String[] POKEMON_COLOUM =
            new String[] {
                    POKEMON_ID,
                    POKEMON_NAME,
                    POKEMON_TAG,
                    POKEMON_GEN,
                    POKEMON_IMG,
                    POKEMON_COLOR
            };


    public DbHeper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private Pokemon createPokemon(Cursor cursor) {
            int id = cursor.getInt(cursor.getColumnIndex(POKEMON_ID));
            String name = cursor.getString(cursor.getColumnIndex(POKEMON_NAME));
            String tag = cursor.getString(cursor.getColumnIndex(POKEMON_TAG));
            int gen = cursor.getInt(cursor.getColumnIndex(POKEMON_GEN));
            String img = cursor.getString(cursor.getColumnIndex(POKEMON_IMG));
            String color = cursor.getString(cursor.getColumnIndex(POKEMON_COLOR));
            Pokemon pokemon = new Pokemon(id,name,tag,gen,img,color);
        Log.d("db", pokemon.toString());
            return pokemon;
    }

    public List<Pokemon> selectAllPokemon(){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(POKEMON_TABLE_NAME,
                POKEMON_COLOUM,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()){
            pokemons.add(createPokemon(cursor));
        }
        cursor.close();
        db.close();
        return pokemons;
    }

    public Pokemon slectRandomPokemon(){
        Pokemon pokemon = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                POKEMON_TABLE_NAME,
                POKEMON_COLOUM,
                null,
                null,
                null,
                null,
                "RANDOM()",
                "1"
        );
        if (cursor.moveToNext()) {
            pokemon = createPokemon(cursor);
            cursor.close();
            db.close();
            return pokemon;
        } else {
            return null;

        }
    }

    /*==== Singleton =========*/
    private static DbHeper instance;
    public static DbHeper getInstance() {
        return instance;
    }
    public static void init(Context context) {
        instance = new DbHeper(context);
    }
}
