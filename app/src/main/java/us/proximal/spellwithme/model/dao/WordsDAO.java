package us.proximal.spellwithme.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import us.proximal.spellwithme.model.def.IWordsDAO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */

public class WordsDAO extends SQLiteOpenHelper implements IWordsDAO {

    private static final String TABLE_NAME = "words";
    private static final String PRIMARY_KEY = "wordId";
    private static final String WORD = "word";

//    public ThingDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    public WordsDAO(Context context) {
        super(context, "spellwithme.db", null, 1);
    }


    @Override
    public boolean create(WordDTO w) {

        // create an insert statement to insert this thing into the database
        // content values is like a hashamp.
        ContentValues cv = new ContentValues(6);
        cv.put(WORD, w.getWord());


        // put into the database
        getWritableDatabase().insert(TABLE_NAME, PRIMARY_KEY, cv);

        return true;
    }

    @Override
    public WordDTO read(int wordId) throws Exception {

        // our flexible query.
        String fetchQuery  = "select * from " + TABLE_NAME + " where "+ PRIMARY_KEY +" = '" + wordId +"' ";

        // run the query.
        Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);


        if (cursor.getCount() == 1) {
            // find out who our user is.

            // move our cursor to the first position.
            cursor.moveToFirst();

            WordDTO w = populateThingFromCursor(cursor);

            // return the populated user.
            return w;
        } else if (cursor.getCount() > 1){
            throw new Exception("Too many results returned.  Expected 1, got " + cursor.getCount());
        } else {
            // if we got here, we have 0 results.  Return null.
            return null;
        }
    }

    @Override
    public void update(WordDTO word) {

    }

    @Override
    public void delete(WordDTO word) {

    }

    private WordDTO populateThingFromCursor(Cursor cursor) {

        // create a new user object to hold our data.
        WordDTO w = new WordDTO();

        // populate this user object from our database data.
        String word = cursor.getString(cursor.getColumnIndex(WORD));


        // populate the thing.
        w.setWord(word);


        return w;
    }

    @Override
    public WordDTO read(String word) throws Exception {

        // our flexible query.
        String fetchQuery  = "select * from " + TABLE_NAME + " where "+ WORD +" = '" + word +"' ";

        // run the query.
        Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);


        if (cursor.getCount() == 1) {
            // find out who our user is.

            // move our cursor to the first position.
            cursor.moveToFirst();

            WordDTO w = populateThingFromCursor(cursor);

            // return the populated user.
            return w;
        } else if (cursor.getCount() > 1){
            throw new Exception("Too many results returned.  Expected 1, got " + cursor.getCount());
        } else {
            // if we got here, we have 0 results.  Return null.
            return null;
        }
    }


    @Override
    public ArrayList<WordDTO> list() {

        // Instantiate ArrayList
        ArrayList<WordDTO> words = new ArrayList<WordDTO>();

        // Write the SQL query
        String sql  = "select * from " + TABLE_NAME;

        // Execute the query
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        // Call moveToFirst on the cursor object
        cursor.moveToFirst();

        // iterate over the cursor until it reaches the last row.
        // notice the ! which negates true to false.
        while(!cursor.isAfterLast()) {
            // populate plant from cursor.
            WordDTO w = populateThingFromCursor(cursor);

            // add to our collection.
            words.add(w);

            // move to the next result.
            cursor.moveToNext();
        }
        return words;
    }

    public void onUpdate(SQLiteDatabase db) {

        //Run a DROP IF EXISTS statement to drop the TABLE_NAME table.
        //Invoke onCreate.

        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //drop the USERS table if it exists
        this.onUpdate(db);

        // define the schema.
        String userSchema = "CREATE TABLE "
                + TABLE_NAME
                + " ("
                + PRIMARY_KEY
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WORD
                + " TEXT );";

        // create our table.
        db.execSQL(userSchema);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Empty method from SQLiteOpenHelper
    }
}
