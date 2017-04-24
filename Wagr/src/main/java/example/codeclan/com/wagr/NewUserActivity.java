package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }

    public void submitNewUserButtonClicked(View button){
        //TODO find out how to pass the below value to the UserList ArrayList.

        String user_name = findViewById(R.id.new_user_name).toString();

        Intent intent = new Intent(this, UserListActivity.class);
        intent.putExtra("name", user_name);
        startActivity(intent);
    }

}
