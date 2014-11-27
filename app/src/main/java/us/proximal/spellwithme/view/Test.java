package us.proximal.spellwithme.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import us.proximal.spellwithme.R;
import us.proximal.spellwithme.model.dao.WordsDAO;
import us.proximal.spellwithme.model.def.IWordsDAO;
import us.proximal.spellwithme.model.dto.WordDTO;
import us.proximal.spellwithme.model.prime.PrimeWords;

public class Test extends BaseActivity {

    Button btnPrimeWords;
    Button btnMakeDatabase;
    Button btnToastWord;
    Button btnDeleteTable;

    //give the UI a service object
    PrimeWords prime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        prime = new PrimeWords();

        //instantiate the buttons in the onCreate method
        btnPrimeWords = (Button) findViewById(R.id.buttonPrimeWords);
        btnMakeDatabase = (Button) findViewById(R.id.buttonMakeDatabase);
        btnToastWord = (Button) findViewById(R.id.buttonToastWord);
        btnDeleteTable = (Button) findViewById(R.id.buttonDeleteTable);

        //attach onClick listener to the button object
        btnMakeDatabase.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View currentView) {
                                                   makeDatabase();
                                               }
                                           }
        );

        //attach onClick listener to the button object
        btnPrimeWords.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View currentView) {
                                                 primeWords();
                                             }
                                         }
        );

        //attach onClick listener to the button object
        btnToastWord.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View currentView) {
                                                toastWord();
                                            }
                                        }
        );

        //attach onClick listener to the button object
        btnDeleteTable.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View currentView) {
                                                deleteTable();
                                            }
                                        }
        );
    }

    public void makeDatabase(){
        WordDTO word = new WordDTO();
        word.setWord("blank");
        IWordsDAO dao = new WordsDAO(this);
        dao.create(word);
        try {
            dao.read("blank");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void toastWord(){
        IWordsDAO dao = new WordsDAO(this);
        WordDTO word = new WordDTO();
        String toast;


        ArrayList<WordDTO> words = dao.list();
        int count = words.size();

        int rand = (int) (count * Math.random());

        try {
            //word.setWord(dao.read("the").getWord());
            word.setWord(dao.read(rand).getWord());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "The word is: " + word.getWord(), Toast.LENGTH_LONG).show();



    }

    public void primeWords(){
        Toast.makeText(getApplicationContext(), "Here we go...", Toast.LENGTH_LONG).show();

        //send the service object this ui object
        prime.fillTheDatabaseWithWords(this);

        Toast.makeText(getApplicationContext(), "Call to prime done!", Toast.LENGTH_LONG).show();

    }

    public void deleteTable(){
        IWordsDAO dao = new WordsDAO(this);
        ArrayList<WordDTO> words = dao.list();
        int count = words.size();

        Toast.makeText(getApplicationContext(), "There are " + count + " words in the words table.", Toast.LENGTH_LONG).show();

    }
//
//
//    private void querySetGetGo() {
//        System.out.println("START querySetGetGo()");
//
//        //ProximalRestClient.get("statuses/public_timeline.json", null, new JsonHttpResponseHandler() {
//        SetGetGoClient.get("", null, new JsonHttpResponseHandler() {
//
//            @Override
//            public void onFailure(int statusCode,
//                                  org.apache.http.Header[] headers,
//                                  java.lang.Throwable throwable,
//                                  org.json.JSONObject errorResponse) {
//                System.out.println("fail 1");
//
//            }
//
//            @Override
//            public void onFailure(int statusCode,
//                                  org.apache.http.Header[] headers,
//                                  java.lang.Throwable throwable,
//                                  org.json.JSONArray errorResponse) {
//                System.out.println("fail 2");
//
//            }
//
//            @Override
//            public void onFailure(int statusCode,
//                                  org.apache.http.Header[] headers,
//                                  java.lang.String responseString,
//                                  java.lang.Throwable throwable) {
//                System.out.println("fail 3");
//
//            }
//
//            @Override
//            public final void onFailure(int statusCode,
//                                        org.apache.http.Header[] headers,
//                                        byte[] responseBytes,
//                                        java.lang.Throwable throwable) {
//                System.out.println("Status code: " + statusCode);
//                System.out.println("Throwable: " + throwable.toString());
//                for (int i = 0; i < headers.length; i++) {
//                    System.out.println("Header: " + headers[i]);
//
//                }
//
//
//            }
//
//            @Override
//            public void onSuccess(int statusCode,
//                                  org.apache.http.Header[] headers,
//                                  java.lang.String responseString) {
//                System.out.println("success 1");
//                System.out.println("Status code: " + statusCode);
//                for (int i = 0; i < headers.length; i++) {
//                    System.out.println("Header: " + headers[i]);
//
//                }
//                System.out.println("Response string: " + responseString);
//
//
//                txtWord.setText(responseString);
//
//
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                // If the response is JSONObject instead of expected JSONArray
//                System.out.println("JSONObject success");
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
//
//                System.out.println("JSONArray success");
//
//                try {
//
//                    // Pull out the first event on the public timeline
//                    JSONObject firstEvent = (JSONObject) timeline.get(0);
//                    String tweetText = firstEvent.getString("text");
//
//                    // Do something with the response
//                    System.out.println(tweetText);
//
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//
//        });
//
//        System.out.println("END getPublicTimeLine()");
//
//    }
//
//
//    private void giveMeWord(){
//        WordDTO word;
//        word = service.getNewWord();
//
//        txtWord.setText(word.getWord());
//
//    }
//
//    private void giveMeWord(int level){
//        WordDTO word;
//
//        //word = service.getNewWord(level);
//
//        //txtWord.setText(word.getWord());
//
//    }
//
//    private void queryBooks(String searchString) {
//
//        // Prepare your search string to be put in a URL
//        // It might have reserved characters or something
//        String urlString = "";
//        try {
//            urlString = URLEncoder.encode(searchString, "UTF-8");
//
//        } catch (UnsupportedEncodingException e) {
//
//            // if this fails for some reason, let the user know why
//            e.printStackTrace();
//            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//
//        // Create a client to perform networking
//        AsyncHttpClient client = new AsyncHttpClient();
//
//        // Have the client get a JSONArray of data
//        // and define how to respond
//        client.get(QUERY_URL + urlString,
//                new JsonHttpResponseHandler() {
//
//                    @Override
//                    public void onSuccess(JSONObject jsonObject) {
//                        // Display a "Toast" message
//                        // to announce your success
//                        Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
//
//                        // 8. For now, just log results
//                        Log.d("omg android", jsonObject.toString());
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
//                        // Display a "Toast" message
//                        // to announce the failure
//                        Toast.makeText(getApplicationContext(), "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();
//
//                        // Log error message
//                        // to help solve any problems
//                        Log.e("omg android", statusCode + " " + throwable.getMessage());
//                    }
//
//                });
//    }
//
//
//    private void queryHeroku(String what) {
//
//        AsyncHttpClient client = new AsyncHttpClient();
//
//        client.get(HEROKU_URL, new AsyncHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//
//                System.out.println("HELLO");
//
//                System.out.println("Status code: " + statusCode);
//
//                for (int i=0;i<headers.length;i++){
//                    System.out.println("Headers: " + headers[i]);
//                }
//
//                for (int j=0;j<responseBody.length;j++){
//                    System.out.println("Response body: " + responseBody[j]);
//
//                }
//
//                System.out.println(responseBody.toString());
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable
//                    error)
//            {
//                error.printStackTrace(System.out);
//            }
//
//        });
//
//    }
//
//    private void queryGoogle(){
//
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get("http://www.google.com", new AsyncHttpResponseHandler() {
//
//            @Override
//            public void onStart() {
//                // called before request is started
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
//                // called when response HTTP status is "200 OK"
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
//                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
//            }
//
//            //@Override
//            public void onRetry(int retryNo) {
//                // called when request is retried
//            }
//        });
//
//    }
//
//    public void getPublicTimeline() throws JSONException {
//        System.out.println("START getPublicTimeLine()");
//
//        //ProximalRestClient.get("statuses/public_timeline.json", null, new JsonHttpResponseHandler() {
//        ProximalRestClient.get("", null, new JsonHttpResponseHandler() {
//
//            @Override
//            public void onFailure(int statusCode,
//                                  org.apache.http.Header[] headers,
//                                  java.lang.Throwable throwable,
//                                  org.json.JSONObject errorResponse) {
//                System.out.println("fail 1");
//
//            }
//
//            @Override
//            public void onFailure(int statusCode,
//                                  org.apache.http.Header[] headers,
//                                  java.lang.Throwable throwable,
//                                  org.json.JSONArray errorResponse) {
//                System.out.println("fail 2");
//
//            }
//
//            @Override
//            public void onFailure(int statusCode,
//                                  org.apache.http.Header[] headers,
//                                  java.lang.String responseString,
//                                  java.lang.Throwable throwable) {
//                System.out.println("fail 3");
//
//            }
//
//            @Override
//            public final void onFailure(int statusCode,
//                                        org.apache.http.Header[] headers,
//                                        byte[] responseBytes,
//                                        java.lang.Throwable throwable) {
//                System.out.println("Status code: " + statusCode);
//                System.out.println("Throwable: " + throwable.toString());
//                for (int i = 0; i < headers.length; i++) {
//                    System.out.println("Header: " + headers[i]);
//
//                }
//
//
//            }
//
//            @Override
//            public void onSuccess(int statusCode,
//                                  org.apache.http.Header[] headers,
//                                  java.lang.String responseString) {
//                System.out.println("success 1");
//                System.out.println("Status code: " + statusCode);
//                for (int i = 0; i < headers.length; i++) {
//                    System.out.println("Header: " + headers[i]);
//
//                }
//                System.out.println("Response string: " + responseString);
//
//
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                // If the response is JSONObject instead of expected JSONArray
//                System.out.println("JSONObject success");
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
//
//                System.out.println("JSONArray success");
//
//                try {
//
//                    // Pull out the first event on the public timeline
//                    JSONObject firstEvent = (JSONObject) timeline.get(0);
//                    String tweetText = firstEvent.getString("text");
//
//                    // Do something with the response
//                    System.out.println(tweetText);
//
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//
//        });
//
//        System.out.println("END getPublicTimeLine()");
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.welcome, menu);
//        return true;
//    }

}
