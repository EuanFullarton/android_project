package example.codeclan.com.wagr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NewBetActivity extends AppCompatActivity {

    Spinner newUser1;
    Spinner newUser2;
    EditText newDetails;
    CalendarView newResolvedOn;
    EditText newStake;
    long currentSelectedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bet);

        newResolvedOn = (CalendarView) findViewById(R.id.input_resolution_date);
        currentSelectedDate = 0;

        newResolvedOn.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                currentSelectedDate = new Date(year, month, dayOfMonth).getTime();
            }
        });
    }

    public void submitNewBetButtonClicked(View button){
        newUser1 = (Spinner)findViewById(R.id.select_user_1);
        newUser2 = (Spinner)findViewById(R.id.select_user_2);
        newDetails = (EditText)findViewById(R.id.input_bet_details);

        newStake = (EditText)findViewById(R.id.input_stake);

        String user1 = newUser1.getSelectedItem().toString();
        String user2 = newUser2.getSelectedItem().toString();
        String details = newDetails.getText().toString();
        Date resolvedOn = new Date(currentSelectedDate);
        Date betPlacedOn = new Date();

        int stake = Integer.parseInt(newStake.getText().toString());

        Bet new_bet = new Bet(user1, user2, details, resolvedOn, betPlacedOn, stake);

        BetDatabaseHandler db = new BetDatabaseHandler(this);
        db.addBet(new_bet);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

