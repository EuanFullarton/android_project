package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewUserActivity extends AppCompatActivity {

    EditText newUser;
    ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }

    public void submitNewUserButtonClicked(View button){
        newUser = (EditText)findViewById(R.id.new_user_name);

        String user_name = newUser.getText().toString();
        User new_user = new User(user_name);

        DatabaseHandler db = new DatabaseHandler(this);
        db.addUser(new_user);

        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);

    }

}
