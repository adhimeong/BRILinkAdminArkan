package id.sch.smkn13bdg.adhi.brilinkadminarkan;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class AntrianTransaksiFragment extends Fragment {


    public AntrianTransaksiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_antrian, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fabtransaksi);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new TransaksiFragment()).commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
