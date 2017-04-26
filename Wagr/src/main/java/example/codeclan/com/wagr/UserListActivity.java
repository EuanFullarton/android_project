package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_list);

            UserDatabaseHandler db = new UserDatabaseHandler(this);

            /**
             * CRUD Operations
             * */
            // Inserting Users
            Log.d("Insert: ", "Inserting ..");


            // Reading all Users
            Log.d("Reading: ", "Reading all users..");
            ArrayList<User> users = db.getAllUsers();

            for (User ur : users) {
                String log = "Id: "+ur.getId()+" ,Name: " + ur.getName();
                // Writing Users to log
                Log.d("Name: ", log);
            }

            UserListAdapter userListAdapter = new UserListAdapter(this, users);

            ListView listView = (ListView) findViewById(R.id.user_list);
            listView.setAdapter(userListAdapter);
        }


    public void userSelected(View listItem) {

        User user = (User) listItem.getTag();

        String id_string = Integer.toString(user.getId());

        //id passing as null?

        Log.d("Selected user: ", user.getName());
        Log.d("Selected id: ", id_string);

        Intent intent = new Intent(this, UserCRUDActivity.class);
        intent.putExtra("user_name", user.getName());
        intent.putExtra("user_id", id_string);
        startActivity(intent);
    }

    public void addNewUserButtonClicked(View button){

        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }

    public void homeButtonClicked(View button) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
