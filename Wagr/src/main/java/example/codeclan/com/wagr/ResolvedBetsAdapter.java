package example.codeclan.com.wagr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 26/04/2017.
 */

public class ResolvedBetsAdapter extends ArrayAdapter<Bet> {

    public ResolvedBetsAdapter(Context context, ArrayList<Bet> bets) {
        super(context, 0, bets);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.bet_item, parent, false);
        }


        Bet currentBet = getItem(position);


        TextView user1 = (TextView) listItemView.findViewById(R.id.user1);
        user1.setText(currentBet.getUser1());

        TextView user2 = (TextView) listItemView.findViewById(R.id.user2);
        user2.setText(currentBet.getUser2());

        TextView details = (TextView) listItemView.findViewById(R.id.details);
        details.setText(currentBet.getDetails());

        TextView resolvedOn = (TextView) listItemView.findViewById(R.id.resolvedOn);
        resolvedOn.setText(currentBet.getNiceDateFormat(currentBet.getResolvedOn()));

        TextView betPlacedOn = (TextView) listItemView.findViewById(R.id.betPlacedOn);
        betPlacedOn.setText(currentBet.getNiceDateFormat(currentBet.getBetPlacedOn()));

        TextView stake = (TextView) listItemView.findViewById(R.id.stake);
        stake.setText(currentBet.getStake().toString());


        listItemView.setTag(currentBet);

        return listItemView;
    }
}
