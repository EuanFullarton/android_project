package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewResolvedBetsButtonClicked(View button){

        Intent intent = new Intent(this, ResolvedBetsActivity.class);
        startActivity(intent);
    }

    public void usersButtonClicked(View button){

        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

    public void newBetButtonClicked(View button){

        Intent intent = new Intent(this, NewBetActivity.class);
        startActivity(intent);
    }
}
