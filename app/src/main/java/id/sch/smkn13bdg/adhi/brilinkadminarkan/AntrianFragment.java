package id.sch.smkn13bdg.adhi.brilinkadminarkan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AntrianFragment extends Fragment {


    public AntrianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_antrian, container, false);
        // Inflate the layout for this fragment
        return view;
    }

}
