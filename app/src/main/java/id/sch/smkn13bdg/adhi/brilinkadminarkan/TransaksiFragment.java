package id.sch.smkn13bdg.adhi.brilinkadminarkan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransaksiFragment extends Fragment {

    EditText nokartu, notujuan, nominal;
    Spinner bank, jenistransaksi;
    Button btnproses, btnscan;

    public TransaksiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);

        bank = (Spinner) view.findViewById(R.id.spinnertransasibank);
        jenistransaksi = (Spinner) view.findViewById(R.id.spinnertransasijenistransaksi);
        nokartu = (EditText) view.findViewById(R.id.edittransaksinokartu);
        notujuan = (EditText)view.findViewById(R.id.edittransaksitujuan);
        nominal = (EditText) view.findViewById(R.id.edittransaksinominal);
        btnproses =(Button) view.findViewById(R.id.btntransasiproses);
        btnscan = (Button) view.findViewById(R.id.btntransaksiscan);

        jenistransaksi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "dipilih " + jenistransaksi.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "dipilih " + bank.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "PROSES BRO", Toast.LENGTH_LONG).show();
            }
        });


        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        // Inflate the layout for this fragment
        return view;

    }

}
