package example.codeclan.com.wagr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 24/04/2017.
 */

public class UserCRUDActivity extends AppCompatActivity {

    private EditText userName;
    private TextView userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_crud);

        userName = (EditText) findViewById(R.id.user_name);
        userId = (TextView) findViewById(R.id.user_id);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("user_name");
        String id = extras.getString("user_id");

        userName.setText(name);
        userId.setText(id);
    }

    public void editUserButtonClicked(View button){

        userName = (EditText) findViewById(R.id.user_name);
        userId = (TextView) findViewById(R.id.user_id);

        String newUserName = userName.getText().toString();
        String user_id = userId.getText().toString();

        int int_Id = Integer.parseInt(user_id);

        UserDatabaseHandler db = new UserDatabaseHandler(this);

        User user_to_edit = db.getUser(int_Id);

        user_to_edit.setName(newUserName);

        db.updateUser(user_to_edit);

        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);

    }

    public void deleteUserButtonClicked(View button){

        userId = (TextView) findViewById(R.id.user_id);

        String user_id = userId.getText().toString();

        int int_Id = Integer.parseInt(user_id);

        UserDatabaseHandler db = new UserDatabaseHandler(this);
        User user_to_delete = db.getUser(int_Id);

        db.deleteUser(user_to_delete);

        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

}

