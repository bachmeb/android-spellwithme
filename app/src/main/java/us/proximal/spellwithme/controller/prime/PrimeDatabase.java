package us.proximal.spellwithme.controller.prime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

/**
 * Created by b on 11/28/14.
 */
public class PrimeDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "spellwithme.db";

    private static final int DATABASE_VERSION = 2;
    private static final String DICTIONARY_TABLE_NAME = "dictionary";
    /*
    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + DICTIONARY_TABLE_NAME + " (" +
                    KEY_WORD + " TEXT, " +
                    KEY_DEFINITION + " TEXT);";
    */

    public PrimeDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    public boolean exists(Context ctx){

        boolean value = false;

        File database = ctx.getApplicationContext().getDatabasePath(DATABASE_NAME);

        if (database.exists()) {
            value = true;
        }

        return value;
    }
    public void create(Context ctx){



    }

    public boolean delete(Context ctx) {
        boolean result = false;

        try {

            ctx.deleteDatabase(DATABASE_NAME);
            result = true;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

}
