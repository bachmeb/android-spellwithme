package us.proximal.spellwithme.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import us.proximal.spellwithme.R;


public class Welcome extends BaseActivity {

    Button btnRead;
    Button btnSpell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //call the super class constructor
        super.onCreate(savedInstanceState);
        //grab the resource xml
        setContentView(R.layout.activity_welcome);

        //instantiate the buttons in the onCreate method
        btnSpell = (Button) findViewById(R.id.buttonWelcomeSpell);
        btnRead = (Button) findViewById(R.id.buttonWelcomeRead);


        //attach onClick listener to the button object
        btnSpell.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View currentView) {

                                            // declare the intent
                                            Intent intent = new Intent(currentView.getContext(), Spell.class);
                                            // act on the intent
                                            startActivity(intent);

                                        }
                                    }
        );

        //attach onClick listener to the button object
        btnRead.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View currentView) {

                                           // declare the intent
                                           Intent intent = new Intent(currentView.getContext(), Read.class);
                                           // act on the intent
                                           startActivity(intent);

                                       }
                                   }
        );

    }


}
