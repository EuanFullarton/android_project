package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class UserListActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_users);
//
//        UserList userList = new UserList();
//        ArrayList<User> list = userList.getUserList();
//
//        UserListAdapter userListAdapter = new UserListAdapter(this, list);
//
//        ListView listView = (ListView) findViewById(R.id.user_list);
//        listView.setAdapter(userListAdapter);
//    }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_users);

            DatabaseHandler db = new DatabaseHandler(this);

            /**
             * CRUD Operations
             * */
            // Inserting Contacts
            Log.d("Insert: ", "Inserting ..");
            db.addUser(new User("Ravi"));
            db.addUser(new User("Srinivas"));
            db.addUser(new User("Tommy"));
            db.addUser(new User("Karthik"));

            // Reading all contacts
            Log.d("Reading: ", "Reading all contacts..");
            List<User> users = db.getAllUsers();

            for (User ur : users) {
                String log = "Id: "+ur.getId()+" ,Name: " + ur.getName();
                // Writing Contacts to log
                Log.d("Name: ", log);
            }
        }

    public void onResume() {
        super.onResume();
        UserList userList = new UserList();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

//        if(extras != null) {
//            String user_name = extras.getString("name");
//            userList.addNewUser(user_name);
//            ArrayList<User> list = userList.getUserList();
//            UserListAdapter userListAdapter = new UserListAdapter(this, list);
//            ListView listView = (ListView) findViewById(R.id.user_list);
//            listView.setAdapter(userListAdapter);
        }

    public void getUser(View listItem) {
        User user = (User) listItem.getTag();
        Log.d("Name: ", user.getName());
    }

    public void addNewUserButtonClicked(View button){

        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }

//    public interface SpinnerAdapter extends Adapter {
//
//        Spinner spinner1 = (Spinner) findViewById(R.id.select_user_1);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner1.setAdapter(adapter);
//    }

}
