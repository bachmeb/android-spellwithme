package us.proximal.spellwithme;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Welcome extends Activity {


    Button btnGotIt;
    Button btnMissedIt;
    TextView txtWord;
    EditText txtVocabulary;
    EditText txtScore;

    WordServiceStub service;

    private static final String QUERY_URL = "http://openlibrary.org/search.json?q=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //call the super class constructor
        super.onCreate(savedInstanceState);
        //grab the resource xml
        setContentView(R.layout.activity_welcome);


        //instantiate the word service
        service = new WordServiceStub();

        //instantiate the buttons in the onCreate method
        btnGotIt = (Button) findViewById(R.id.buttonGotIt);
        btnMissedIt = (Button) findViewById(R.id.buttonMissedIt);
        txtWord = (TextView) findViewById(R.id.textWord);


        //attach onClick listeners to the button objects
        btnGotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View currentView) {

                //persist the score

                //get a new word
                giveMeWord();



            } //end onClick
        } // end setOnClickListener
        ); //end new View.OnClickListener()


        //attach onClick listeners to the button objects
        btnMissedIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View currentView) {

                //persist the score

                //get a new word
                queryBooks("apple");



            } //end onClick
        } // end setOnClickListener
        ); //end new View.OnClickListener()




    }


    private void giveMeWord(){
        WordDTO word;
        word = service.getNewWord();

        txtWord.setText(word.getWord());

    }

    private void giveMeWord(int level){
        WordDTO word;

        //word = service.getNewWord(level);

        //txtWord.setText(word.getWord());

    }

    private void queryBooks(String searchString) {

        // Prepare your search string to be put in a URL
        // It might have reserved characters or something
        String urlString = "";
        try {
            urlString = URLEncoder.encode(searchString, "UTF-8");
        } catch (UnsupportedEncodingException e) {

            // if this fails for some reason, let the user know why
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        // Create a client to perform networking
        AsyncHttpClient client = new AsyncHttpClient();

        // Have the client get a JSONArray of data
        // and define how to respond
        client.get(QUERY_URL + urlString,
                new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(JSONObject jsonObject) {
                        // Display a "Toast" message
                        // to announce your success
                        Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();

                        // 8. For now, just log results
                        Log.d("omg android", jsonObject.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                        // Display a "Toast" message
                        // to announce the failure
                        Toast.makeText(getApplicationContext(), "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();

                        // Log error message
                        // to help solve any problems
                        Log.e("omg android", statusCode + " " + throwable.getMessage());
                    }

                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
