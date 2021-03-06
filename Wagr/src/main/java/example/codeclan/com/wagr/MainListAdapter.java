package example.codeclan.com.wagr;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainListAdapter extends ArrayAdapter<Bet> {

        public MainListAdapter(Context context, ArrayList<Bet> bets) {
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

            Date today = new Date();
            resolvedOn.setTextColor(Color.GREEN);
            if (currentBet.getResolvedOn().compareTo(today) <= 0) {
                resolvedOn.setTextColor(Color.RED);
            }

            listItemView.setTag(currentBet);

            return listItemView;
        }

}
