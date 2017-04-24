package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        UserList userList = new UserList();
        ArrayList<User> list = userList.getUserList();

        UserListAdapter userListAdapter = new UserListAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.user_list);
        listView.setAdapter(userListAdapter);
    }

    public void onResume() {
        super.onResume();
        UserList userList = new UserList();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if(extras != null) {
            String user_name = extras.getString("name");
            userList.addNewUser(user_name);
            ArrayList<User> list = userList.getUserList();
            UserListAdapter userListAdapter = new UserListAdapter(this, list);
            ListView listView = (ListView) findViewById(R.id.user_list);
            listView.setAdapter(userListAdapter);
        }
    }

    public void getUser(View listItem) {
        User user = (User) listItem.getTag();
        Log.d("Name: ", user.getName());
    }

    public void addNewUserButtonClicked(View button){

        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }

}
