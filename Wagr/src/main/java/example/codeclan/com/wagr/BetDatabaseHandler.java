package example.codeclan.com.wagr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 25/04/2017.
 */

public class BetDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BetListDB";
    private static final String TABLE_BETS = "bets";

    private static final String KEY_ID = "id";
    private static final String KEY_USER1 = "user1";
    private static final String KEY_USER2 = "user2";
    private static final String DETAILS = "details";
    private static final String RESOLVED_ON = "resolvedOn";
    private static final String BET_PLACED_ON = "betPlacedOn";
    private static final String STAKE = "stake";


    public BetDatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BETS);
        String CREATE_BETS_TABLE = "CREATE TABLE " + TABLE_BETS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USER1 + " TEXT," + KEY_USER2 + " TEXT," + DETAILS + " TEXT,"
                + RESOLVED_ON + " TEXT," + BET_PLACED_ON + " TEXT," + STAKE + " TEXT" + ")";

        db.execSQL(CREATE_BETS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BETS);
        onCreate(db);
    }


    public void addBet(Bet bet){
        SQLiteDatabase db = this.getWritableDatabase();

        Date placedOn = bet.getBetPlacedOn();

        ContentValues values = new ContentValues();
        values.put(KEY_USER1, bet.getUser1());
        values.put(KEY_USER2, bet.getUser2());
        values.put(DETAILS, bet.getDetails());
        values.put(RESOLVED_ON, bet.getResolvedOn().toString());
        values.put(BET_PLACED_ON, bet.getBetPlacedOn().toString());
        values.put(STAKE, bet.getStake());

        db.insert(TABLE_BETS, null, values);
        db.close();
    }


    public Bet getBet(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BETS, new String[] { KEY_ID,
                        KEY_USER1, KEY_USER2, DETAILS, RESOLVED_ON, BET_PLACED_ON, STAKE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Date date = new Date(cursor.getString(4));
        Date date2 = new Date(cursor.getString(5));

        Bet bet = new Bet(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                date, date2, Integer.parseInt(cursor.getString(6)));
        return bet;
    }


    public ArrayList<Bet> getAllBets(){
        ArrayList<Bet> betList = new ArrayList<Bet>();
        String selectQuery = "SELECT  * FROM " + TABLE_BETS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Date date = new Date(cursor.getString(4));
                Date date2 = new Date(cursor.getString(5));
                
                Bet bet = new Bet();
                bet.setId(Integer.parseInt(cursor.getString(0)));
                bet.setUser1(cursor.getString(1));
                bet.setUser2(cursor.getString(2));
                bet.setDetails(cursor.getString(3));
                bet.setResolvedOn(date);
                bet.setBetPlacedOn(date2);
                bet.setStake(Integer.parseInt(cursor.getString(6)));
                betList.add(bet);
            } while (cursor.moveToNext());
        }

        return betList;
    }

//
//    public int updateBet(Bet bet){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_USER1, bet.getUser1());
//        values.put(KEY_USER2, bet.getUser2());
//        values.put(DETAILS, bet.getDetails());
//        values.put(RESOLVED_ON, bet.getResolvedOn().toString());
//        values.put(BET_PLACED_ON, bet.getBetPlacedOn().toString());
//        values.put(STAKE, bet.getStake());
//
//        return db.update(TABLE_BETS, values, KEY_ID + " = ?",
//                new String[] { String.valueOf(bet.getId()) });
//    }


    public void deleteBet(Bet bet){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BETS, KEY_ID + " = ?",
                new String[] { String.valueOf(bet.getId()) });
        db.close();
    }


//    public void deleteAllBets(){
//        ArrayList<Bet> betList = new ArrayList<Bet>();
//        String deleteQuery = "DELETE FROM " + TABLE_BETS;
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL(deleteQuery);
//        db.close();
//    }

}


