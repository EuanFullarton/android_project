package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewUserActivity extends AppCompatActivity {

    EditText newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }

    public void submitNewUserButtonClicked(View button){
        newUser = (EditText)findViewById(R.id.new_user_name);

        String user_name = newUser.getText().toString();

        Intent intent = new Intent(this, UserListActivity.class);
        intent.putExtra("name", user_name);
        startActivity(intent);
    }

}
