package layout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.veena.scenario1app.R;


public class HorizontalScroll extends Fragment {

    public static HorizontalScroll newInstance() {
        return new HorizontalScroll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_horizontal_scroll, container, false);
        Button button1 = (Button) view.findViewById(R.id.button);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);

        View.OnClickListener buttonClickLIstener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button)v;
                String color = b.getText().toString();
                if ("RED".equals(color))
                    view.setBackgroundColor(Color.RED);
                else if ("YELLOW".equals(color))
                    view.setBackgroundColor(Color.YELLOW);
                else if ("GREEN".equals(color))
                    view.setBackgroundColor(Color.GREEN );
            }
        };
        button1.setOnClickListener(buttonClickLIstener);
        button2.setOnClickListener(buttonClickLIstener);
        button3.setOnClickListener(buttonClickLIstener);
        return view;
    }
}
