package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veena.scenario1app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewClickFragment extends Fragment {
    private String text = "";


    public static RecyclerViewClickFragment newInstance(String value) {
        RecyclerViewClickFragment recyclerViewClickFragment = new RecyclerViewClickFragment();
        recyclerViewClickFragment.text = value;
        return recyclerViewClickFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view_click, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text);
        Log.d("RecyclerView",text);
        if (text != null) {
            textView.setText(text);
        }
        return view;
    }

}
