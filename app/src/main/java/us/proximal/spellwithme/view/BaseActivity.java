package us.proximal.spellwithme.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import us.proximal.spellwithme.R;

public class BaseActivity extends Activity {

    //Define static fields for the int value of the subclass Activities
    private static final int MENU_OPTION_1 = 1;
    protected static final int MENU_OPTION_2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //Menu item for Login Page (groupId, itemId, order, title)
        menu.add(0, MENU_OPTION_1, Menu.NONE, getString(R.string.title_activity_read));
        //Menu item for Create User (groupId, itemId, order, title)
        menu.add(0, MENU_OPTION_2, Menu.NONE, getString(R.string.title_activity_spell));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //call superclass method
        super.onOptionsItemSelected(item);
        //evaluate the item id and call the method to load the activity
        switch (item.getItemId()) {
            case MENU_OPTION_1:
                openOptionOne();
                break;
            case MENU_OPTION_2:
                openOptionTwo();
                break;
        }
        return true;
    }


    private void openOptionOne() {
        // declare the intent
        Intent intent = new Intent(BaseActivity.this, Read.class);
        // act on the intent
        startActivity(intent);
    }

    private void openOptionTwo() {
        // declare the intent
        Intent intent = new Intent(BaseActivity.this, Spell.class);
        // act on the intent
        startActivity(intent);

    }


}