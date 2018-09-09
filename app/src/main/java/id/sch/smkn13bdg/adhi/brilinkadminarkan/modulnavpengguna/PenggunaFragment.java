package id.sch.smkn13bdg.adhi.brilinkadminarkan.modulnavpengguna;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smkn13bdg.adhi.brilinkadminarkan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PenggunaFragment extends Fragment {


    public PenggunaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pengguna, container, false);
        // Inflate the layout for this fragment
        return view;
    }

}
