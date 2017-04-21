package example.codeclan.com.wagr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 21/04/2017.
 */

public class UserListAdapter extends ArrayAdapter<User> {

    public UserListAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);
        }

        User currentUser = getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(currentUser.getName());

        listItemView.setTag(currentUser);

        return listItemView;
    }
}

