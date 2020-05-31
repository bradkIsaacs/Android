package bradley.codebreakers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HistoryAdaptor extends ArrayAdapter<History> {

    private Context mContext;
    int mResource;

    public HistoryAdaptor(Context context, int resource, List<History> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String[] guess = getItem(position).getGuess();
        int correct = getItem(position).getCorrect();
        int incorrect = getItem(position).getIncorrect();
        History pre = new History(guess, correct, incorrect);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tv1 = convertView.findViewById(R.id.adapter_tv1);
        TextView tv2 = convertView.findViewById(R.id.adapter_tv2);
        TextView tv3 = convertView.findViewById(R.id.adapter_tv3);

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < guess.length; i++) {
            temp.append(guess[i] + " ");
        }

        tv1.setText(temp);
        tv2.setText("" + correct + " digit(s) are placed correctly");
        tv3.setText("" + incorrect + " digit(s) are out of place");

        return convertView;
    }
}
