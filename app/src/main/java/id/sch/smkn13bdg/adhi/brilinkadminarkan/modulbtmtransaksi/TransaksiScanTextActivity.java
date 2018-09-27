package id.sch.smkn13bdg.adhi.brilinkadminarkan.modulbtmtransaksi;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;

import id.sch.smkn13bdg.adhi.brilinkadminarkan.R;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.ScanTextActivity;

public class TransaksiScanTextActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 100;
    public static final int PERMISSION_REQUEST = 200;
    EditText nokartu, norek, nominal, penerima, bank;
    Button btntarif, btnproses, btnscan;
    TextView tarifview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_scan_text);

        //permisi kamera
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        }

        nokartu = (EditText) findViewById(R.id.edittransaksinokartu);
        norek = (EditText) findViewById(R.id.edittransaksitujuan);
        nominal = (EditText) findViewById(R.id.edittransaksinominal);
        penerima = (EditText) findViewById(R.id.edittransaksipenerima);
        bank = (EditText) findViewById(R.id.edittransaksibank);
        btntarif = (Button) findViewById(R.id.btntransaksiloadtarif);
        btnproses = (Button) findViewById(R.id.btntransasiproses);
        btnscan =(Button) findViewById(R.id.btntransasiscan);
        tarifview = (TextView) findViewById(R.id.txtviewtransaksitarif);

        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScanTextActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        btntarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListBankTransaksiActivity.class);
                String nominaltxt = nominal.getText().toString();
                String banktxt = bank.getText().toString();
                intent.putExtra("nominal", nominaltxt);
                intent.putExtra("bank", banktxt);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {

                final String camtext = data.getStringExtra("camtext");
                final String tariftxt = data.getStringExtra("tarif");

                if (camtext != null){

                    btnscan.setText("SCAN ULANG");

                    String[] separated = camtext.split("\n");
                    String kartutxt = separated[0];
                    String norektxt = separated[1];
                    String nominaltxt = separated[2];
                    String penerimatxt = separated[3];
                    String banktxt = separated[4];

                    if (kartutxt != null){
                        String kartucor = kartutxt.replace("&", "8")
                                .replace("O", "0")
                                .replace("o", "0")
                                .replace("C", "0")
                                .replace("c", "0")
                                .replace("I", "1")
                                .replace("i", "1")
                                .replace(" ", "")
                                .replace("S", "5");
                        Log.d("kartucor", kartucor);
                        nokartu.setText(kartucor);
                    }else{
                        nokartu.setText("");
                    }

                    if (norektxt != null){
                        String norekcor = norektxt.replace("&", "8")
                                .replace("O", "0")
                                .replace("o", "0")
                                .replace("C", "0")
                                .replace("c", "0")
                                .replace("I", "1")
                                .replace("i", "1")
                                .replace(" ", "")
                                .replace("S", "5");
                        norek.setText(norekcor);
                    }else{
                        norek.setText("");
                    }

                    if (nominaltxt !=null){
                        String nominalcor = nominaltxt.replace("&", "8")
                                .replace("O", "0")
                                .replace("I", "1")
                                .replace(" ", "")
                                .replace("c", "0")
                                .replace("C", "0")
                                .replace("S", "5")
                                .replace("s", "5")
                                .replace("o", "0")
                                .replace("G", "6")
                                .replace(".", "");
                        nominal.setText(nominalcor);
                    }else{
                        nominal.setText("");
                    }

                    if (penerimatxt != null){
                        penerima.setText(penerimatxt);
                    }else{
                        penerima.setText("");
                    }

                    if (banktxt != null){
                        bank.setText(banktxt);
                    }else{
                        bank.setText("");
                    }


                }else if(tariftxt != null){

                   tarifview.setText(tariftxt);

                }
            }
        }
    }
}
