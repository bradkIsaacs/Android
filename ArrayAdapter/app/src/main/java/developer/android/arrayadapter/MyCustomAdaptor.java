package developer.android.arrayadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class MyCustomAdaptor extends BaseAdapter {

    private Context mContext;
    private List<BoardGame> mGameList;

    public MyCustomAdaptor(Context mContext, List<BoardGame> mGameList) {
        this.mContext = mContext;
        this.mGameList = mGameList;
    }

    @Override
    public int getCount() {
        return mGameList.size();
    }

    @Override
    public Object getItem(int i) {
        return mGameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.game_list, null);
        TextView tvName = (TextView)v.findViewById(R.id.game_name);
        TextView tvPlayers = (TextView)v.findViewById(R.id.game_player);
        tvName.setText(mGameList.get(i).getName());
        tvPlayers.setText(String.valueOf(mGameList.get(i).getMin_player()) + "-" + String.valueOf(mGameList.get(i).getMax_player()) + " Players");
        return v;
    }
}
