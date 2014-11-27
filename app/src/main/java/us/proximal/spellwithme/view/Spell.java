package us.proximal.spellwithme.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import us.proximal.spellwithme.R;
import us.proximal.spellwithme.controller.def.IWordsService;
import us.proximal.spellwithme.controller.svc.WordsService;

public class Spell extends BaseActivity {

    Button btnCorrect;
    Button btnIncorrect;
    TextView txtWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell);

        //Intialize ui objects
        btnCorrect = (Button) findViewById(R.id.buttonSpellIncorrect);
        btnIncorrect = (Button) findViewById(R.id.buttonSpellCorrect);
        txtWord = (TextView) findViewById(R.id.textSpellWord);

        //Set the spelling word
        setSpellingWord();

        //attach onClick listener to the button object
        btnCorrect.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View currentView) {
                                                   answerCorrect();
                                               }
                                           }
        );

        //attach onClick listener to the button object
        btnIncorrect.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View currentView) {
                                                   answerIncorrect();
                                               }
                                           }
        );

    }

    public void answerCorrect(){
        makeToast("correct");
        setSpellingWord();
    }

    public void answerIncorrect(){
        makeToast("incorrect");
        setSpellingWord();
    }

    public void makeToast(String toast){


        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();


    }

    public void setSpellingWord(){
        IWordsService service = new WordsService(this);

        txtWord.setText(service.getRandomWord().getWord());


    }
}
