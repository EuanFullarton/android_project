package example.codeclan.com.wagr;

import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by user on 24/04/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserListDB";
    private static final String TABLE_USERS = "users";

    private static final String KEY_ID = "id";

}
