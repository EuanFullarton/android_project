package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ResolvedBetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolved_bets);

    ResolvedBetDatabaseHandler db = new ResolvedBetDatabaseHandler(this);

    ArrayList<Bet> bets = db.getAllResolvedBets();

    for (Bet bt : bets) {
        String log = "Id: " + bt.getId() + " ,User1: " + bt.getUser1() + " ,User2: " + bt.getUser2() + " ,Details: " + bt.getDetails() + " ,Resolved On: " + bt.getResolvedOn() +
                " ,Placed On: " + bt.getBetPlacedOn() + " ,Stake: " + bt.getStake();
        // Writing Bets to log
        Log.d("Bet: ", log);
    }

    ResolvedBetsAdapter resolvedBetsAdapter = new ResolvedBetsAdapter(this, bets);

    ListView listView = (ListView) findViewById(R.id.resolved_bet_list);
    listView.setAdapter(resolvedBetsAdapter);
}

    public void betSelected(View listItem) {

        Bet bet = (Bet) listItem.getTag();

        String id_string = Integer.toString(bet.getId());

        Log.d("Selected id: ", id_string);
        Log.d("Selected user1: ", bet.getUser1());
        Log.d("Selected user2: ", bet.getUser2());
        Log.d("Selected bet details: ", bet.getDetails());
        Log.d("Selected resolvedOn: ", bet.getResolvedOn().toString());
        Log.d("Selected placedOn: ", bet.getBetPlacedOn().toString());
        Log.d("Selected stake: ", bet.getStake().toString());

        Intent intent = new Intent(this, ViewResolvedBetActivity.class);
        intent.putExtra("bet_id", id_string);
        intent.putExtra("bet_user1", bet.getUser1());
        intent.putExtra("bet_user2", bet.getUser2());
        intent.putExtra("bet_details", bet.getDetails());
        intent.putExtra("bet_resolved_on", bet.getResolvedOn().toString());
        intent.putExtra("bet_placed_on", bet.getBetPlacedOn().toString());
        intent.putExtra("bet_stake", bet.getStake().toString());
        startActivity(intent);

    }
}
