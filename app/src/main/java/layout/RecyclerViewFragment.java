package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veena.scenario1app.R;
import com.veena.scenario1app.adapter.HorizontalAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView horizontal_recycler_view;
    private ArrayList<String> horizontalList;
    private HorizontalAdapter horizontalAdapter;


    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recycler_view, container, false);

        horizontal_recycler_view= (RecyclerView) view.findViewById(R.id.horizontal_recycler_view);

        horizontalList=new ArrayList<>();
        horizontalList.add("Item 1");
        horizontalList.add("Item 2");
        horizontalList.add("Item 3");
        horizontalList.add("Item 4");
        horizontalList.add("Item 5");


        horizontalAdapter=new HorizontalAdapter(getActivity(), horizontalList);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);
        DividerItemDecoration dec = new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL);
        horizontal_recycler_view.addItemDecoration(dec);


        return view;
    }
}
