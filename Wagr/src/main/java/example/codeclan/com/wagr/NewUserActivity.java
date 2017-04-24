package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
//        userList = (ListView)findViewById(R.id.user_list);

        String user_name = newUser.getText().toString();

//        userList.setText(newUser);
//        SavedUserPreferences.setStoredText(this, newUser);

        Intent intent = new Intent(this, UserListActivity.class);
        intent.putExtra("name", user_name);
        startActivity(intent);

    }

}
