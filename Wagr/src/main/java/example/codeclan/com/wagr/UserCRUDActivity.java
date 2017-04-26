package example.codeclan.com.wagr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by user on 24/04/2017.
 */

public class UserCRUDActivity extends AppCompatActivity {

    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_crud);

        userName = (TextView) findViewById(R.id.user_name);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("user_name");
        userName.setText(name);
    }

}

