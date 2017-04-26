package example.codeclan.com.wagr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 25/04/2017.
 */

public class BetCRUDActivity extends AppCompatActivity {

    private TextView id;
    private TextView user1;
    private TextView user2;
    private TextView details;
    private TextView resolvedOn;
    private TextView placedOn;
    private TextView stake;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet_crud);

        id = (TextView) findViewById(R.id.bet_id);
        user1 = (TextView) findViewById(R.id.view_user1);
        user2 = (TextView) findViewById(R.id.view_user2);
        details = (TextView) findViewById(R.id.view_details);
        resolvedOn = (TextView) findViewById(R.id.view_resolvedOn);
        placedOn = (TextView) findViewById(R.id.view_betPlacedOn);
        stake = (TextView) findViewById(R.id.view_stake);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String bet_id = extras.getString("bet_id");
        String bet_user1 = extras.getString("bet_user1");
        String bet_user2 = extras.getString("bet_user2");
        String bet_details = extras.getString("bet_details");
        String bet_resolved_on = extras.getString("bet_resolved_on");
        String bet_placed_on = extras.getString("bet_placed_on");
        String bet_stake = extras.getString("bet_stake");

        BetDatabaseHandler db = new BetDatabaseHandler(this);
        int int_Id = Integer.parseInt(bet_id);

        Bet find_bet = db.getBet(int_Id);

        id.setText(bet_id);
        user1.setText(bet_user1);
        user2.setText(bet_user2);
        details.setText(bet_details);
        resolvedOn.setText(find_bet.getNiceDateFormat());
        placedOn.setText(find_bet.getNiceDateFormat());
        stake.setText(bet_stake);
    }

}
