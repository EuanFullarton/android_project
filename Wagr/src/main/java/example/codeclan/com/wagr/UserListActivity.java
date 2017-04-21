package example.codeclan.com.wagr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        UserList userList = new UserList();
        ArrayList<User> list = userList.getList();

        UserListAdapter userListAdapter = new UserListAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.user_list);
        listView.setAdapter(userListAdapter);
    }

    public void getUser(View listItem) {
        User user = (User) listItem.getTag();
        Log.d("Name: ", user.getName());
    }
}
