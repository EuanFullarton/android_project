package example.codeclan.com.wagr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 26/04/2017.
 */

public class ViewResolvedBetActivity extends AppCompatActivity {

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
            setContentView(R.layout.activity_view_resolved_bet);

            betId = (TextView) findViewById(R.id.resolved_bet_id);
            user1 = (TextView) findViewById(R.id.view_resolved_user1);
            user2 = (TextView) findViewById(R.id.view_resolved_user2);
            details = (TextView) findViewById(R.id.view_resolved_details);
            resolvedOn = (TextView) findViewById(R.id.view_resolvedOn_date);
            placedOn = (TextView) findViewById(R.id.view_resolved_betPlacedOn);
            stake = (TextView) findViewById(R.id.view_resolved_stake);

            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            String bet_id = extras.getString("bet_id");
            String bet_user1 = extras.getString("bet_user1");
            String bet_user2 = extras.getString("bet_user2");
            String bet_details = extras.getString("bet_details");
            String bet_resolved_on = extras.getString("bet_resolved_on");
            String bet_placed_on = extras.getString("bet_placed_on");
            String bet_stake = extras.getString("bet_stake");

            ResolvedBetDatabaseHandler db = new ResolvedBetDatabaseHandler(this);
            int int_Id = Integer.parseInt(bet_id);

            Bet find_bet = db.getResolvedBet(int_Id);

            betId.setText(bet_id);
            user1.setText(bet_user1);
            user2.setText(bet_user2);
            details.setText(bet_details);
            resolvedOn.setText(find_bet.getNiceDateFormat(find_bet.getResolvedOn()));
            placedOn.setText(find_bet.getNiceDateFormat(find_bet.getBetPlacedOn()));
            stake.setText(bet_stake);
        }

        public void deleteResolvedBetButtonClicked(View button){

            betId = (TextView) findViewById(R.id.resolved_bet_id);

            String bet_id = betId.getText().toString();

            int int_Id = Integer.parseInt(bet_id);

            ResolvedBetDatabaseHandler db = new ResolvedBetDatabaseHandler(this);
            Bet bet_to_delete = db.getResolvedBet(int_Id);

            db.deleteResolvedBet(bet_to_delete);

            Intent intent = new Intent(this, ResolvedBetsActivity.class);
            startActivity(intent);
        }
}
