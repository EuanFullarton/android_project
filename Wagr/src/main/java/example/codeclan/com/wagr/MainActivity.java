package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDatabaseHandler db = new UserDatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Bets
        Log.d("Insert: ", "Inserting ..");


        // Reading all contacts
        Log.d("Reading: ", "Reading all bets..");
        ArrayList<Bet> bets = db.getAllBets();

        for (Bet bt : bets) {
            String log = "Id: " + bt.getId() + " ,Details: " + bt.getDetails() + " ,Resolved On: " + bt.getResolvedOn() +
                    " ,Placed On: " + bt.getBetPlacedOn() + " ,Stake: " + bt.getStake();
            // Writing Bets to log
            Log.d("Details: ", log);
            Log.d("Resolved On: ", log);
            Log.d("Placed On: ", log);
            Log.d("Stake: ", log);
        }

        MainListAdapter mainListAdapter = new MainListAdapter(this, bets);

        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setAdapter(mainListAdapter);
    }

    public void viewResolvedBetsButtonClicked(View button) {

        Intent intent = new Intent(this, ResolvedBetsActivity.class);
        startActivity(intent);
    }

    public void usersButtonClicked(View button) {

        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

    public void newBetButtonClicked(View button) {

        Intent intent = new Intent(this, NewBetActivity.class);
        startActivity(intent);
    }
}




//        public void getUser(View listItem) {
//            User user = (User) listItem.getTag();
//            Log.d("Name: ", user.getName());
//
//            Intent intent = new Intent(this, UserCRUDActivity.class);
//            startActivity(intent);
//        }
//
//        public void addNewUserButtonClicked(View button){
//
//            Intent intent = new Intent(this, NewUserActivity.class);
//            startActivity(intent);
//        }

