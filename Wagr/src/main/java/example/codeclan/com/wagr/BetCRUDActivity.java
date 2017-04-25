package example.codeclan.com.wagr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 25/04/2017.
 */

public class BetCRUDActivity extends AppCompatActivity {

    private TextView user1;
    private TextView user2;
    private TextView details;
    private TextView resolvedOn;
    private TextView betPlacedOn;
    private TextView stake;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet_crud);

        user1 = (TextView) findViewById(R.id.view_user1);
        user2 = (TextView) findViewById(R.id.view_user2);
        details = (TextView) findViewById(R.id.view_details);
        resolvedOn = (TextView) findViewById(R.id.view_resolvedOn);
        betPlacedOn = (TextView) findViewById(R.id.view_betPlacedOn);
        stake = (TextView) findViewById(R.id.view_stake);
    }

}
