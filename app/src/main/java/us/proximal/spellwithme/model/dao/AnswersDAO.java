package us.proximal.spellwithme.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import us.proximal.spellwithme.model.def.IAnswersDAO;
import us.proximal.spellwithme.model.dto.AnswerDTO;

/**
 * Created by b on 11/26/14.
 */
public class AnswersDAO extends SQLiteOpenHelper implements IAnswersDAO {

    private static final String TABLE_NAME = "answers";
    private static final String PRIMARY_KEY = "answerId";

    private static final String QUESTION_ID = "questionId";
    private static final String STUDENT_ID = "studentId";
    private static final String MKO_ID = "mkoId";
    private static final String DATE = "date";
    private static final String GRADE = "grade";

    public AnswersDAO(Context context) {

        super(context, "spellwithme.db", null, 1);
    }

    @Override
    public boolean create(AnswerDTO dto) throws Exception {

        // create an insert statement to insert this thing into the database
        // content values is like a hashamp
        ContentValues cv = new ContentValues(5);
        // Add fields from DTO
        cv.put(QUESTION_ID, dto.getQuestionId() );
        cv.put(STUDENT_ID, dto.getStudentId() );
        cv.put(MKO_ID, dto.getMkoId() );
        cv.put(DATE, dto.getDate().toString() );
        cv.put(GRADE,  dto.getGrade() );


        // put the values into database
        getWritableDatabase().insert(TABLE_NAME, PRIMARY_KEY, cv);

        return true;


    }

    @Override
    public AnswerDTO read(int answerId) throws Exception {

        // Write the query
        String sql  = "select * from " + TABLE_NAME + " where "+ PRIMARY_KEY +" = '" + answerId +"' ";

        // Run the query
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);


        if (cursor.getCount() == 1) {
            // find out who our user is.

            // move our cursor to the first position.
            cursor.moveToFirst();

            AnswerDTO dto = populateObjectFromCursor(cursor);

            // return the populated user.
            return dto;
        } else if (cursor.getCount() > 1){
            throw new Exception("Too many results returned.  Expected 1, got " + cursor.getCount());
        } else {
            // No results. Return null.
            return null;
        }

    }

    private AnswerDTO populateObjectFromCursor(Cursor cursor) {

        // Create a new DTO
        AnswerDTO dto = new AnswerDTO();

        // Create variables for each cursor field
        int answerId = cursor.getInt(cursor.getColumnIndex(PRIMARY_KEY) );
        int questionId = cursor.getInt(cursor.getColumnIndex(QUESTION_ID));
        int studentId = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
        int mkoId = cursor.getInt(cursor.getColumnIndex(MKO_ID));
        //String date = cursor.get(cursor.getColumnIndex(DATE));
        String grade = cursor.getString(cursor.getColumnIndex(GRADE));

        // Populate the DTO with the variables
        dto.setAnswerId(answerId);
        //dto.setDate(date);
        dto.setGrade(grade);
        dto.setMkoId(mkoId);
        dto.setQuestionId(questionId);
        dto.setStudentId(studentId);

        // Return the object
        return dto;
    }


    @Override
    public boolean update(AnswerDTO answer) throws Exception {
        return false;
    }

    @Override
    public void delete(AnswerDTO answer) throws Exception {

    }

    @Override
    public ArrayList<AnswerDTO> list() {

        // Declare the ArrayList
        ArrayList<AnswerDTO> alist = new ArrayList<AnswerDTO>();

        // Write the query
        String sql  = "select * from " + TABLE_NAME;

        // Run the query
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        // Move the cursor to the first result
        cursor.moveToFirst();

        // iterate over the cursor until it reaches the last row.
        // notice the ! which negates true to false.
        while(!cursor.isAfterLast()) {
            // populate plant from cursor.
            AnswerDTO dto = populateObjectFromCursor(cursor);

            // add to our collection.
            alist.add(dto);

            // move to the next result.
            cursor.moveToNext();
        }
        return alist;

    }

    public void onUpdate(SQLiteDatabase db) {

        //Run a DROP IF EXISTS statement to drop the ACCOUNTS table.
        //Invoke onCreate.

        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //drop the table if it exists
        this.onUpdate(sqLiteDatabase);

        // define the schema.
        String schema = "CREATE TABLE "
                + TABLE_NAME
                + " ("
                + PRIMARY_KEY
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUESTION_ID
                + " INTEGER, "
                + STUDENT_ID
                + " INTEGER, "
                + MKO_ID
                + " INTEGER, "
                + DATE
                + " TEXT, "
                + GRADE
                + " TEXT );";

        // create our table.
        sqLiteDatabase.execSQL(schema);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // Empty method from SQLiteOpenHelper
    }

}
