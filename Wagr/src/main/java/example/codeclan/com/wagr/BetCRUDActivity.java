package example.codeclan.com.wagr;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Date;


public class BetCRUDActivity extends AppCompatActivity {

    private TextView betId;
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

        betId = (TextView) findViewById(R.id.bet_id);
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
        String bet_stake = extras.getString("bet_stake");

        BetDatabaseHandler db = new BetDatabaseHandler(this);
        int int_Id = Integer.parseInt(bet_id);

        Bet find_bet = db.getBet(int_Id);

        betId.setText(bet_id);
        user1.setText(bet_user1);
        user2.setText(bet_user2);
        details.setText(bet_details);
        resolvedOn.setText(find_bet.getNiceDateFormat(find_bet.getResolvedOn()));
        placedOn.setText(find_bet.getNiceDateFormat(find_bet.getBetPlacedOn()));
        stake.setText(bet_stake);

        Date today = new Date();
        resolvedOn.setTextColor(Color.GREEN);
        if (find_bet.getResolvedOn().compareTo(today) <= 0) {
            resolvedOn.setTextColor(Color.RED);
        }
    }

    public void resolveBetButtonClicked(View button){
        betId = (TextView) findViewById(R.id.bet_id);

        String bet_id = betId.getText().toString();

        int int_Id = Integer.parseInt(bet_id);


        ResolvedBetDatabaseHandler rdb = new ResolvedBetDatabaseHandler(this);

        BetDatabaseHandler db = new BetDatabaseHandler(this);
        Bet bet_to_resolve = db.getBet(int_Id);

        rdb.addResolvedBet(bet_to_resolve);
        db.deleteBet(bet_to_resolve);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void deleteBetButtonClicked(View button){

        betId = (TextView) findViewById(R.id.bet_id);

        String bet_id = betId.getText().toString();

        int int_Id = Integer.parseInt(bet_id);

        BetDatabaseHandler db = new BetDatabaseHandler(this);
        Bet bet_to_delete = db.getBet(int_Id);

        db.deleteBet(bet_to_delete);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
