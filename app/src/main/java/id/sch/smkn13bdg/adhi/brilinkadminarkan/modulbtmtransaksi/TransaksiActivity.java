package id.sch.smkn13bdg.adhi.brilinkadminarkan.modulbtmtransaksi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;

import faranjit.currency.edittext.CurrencyEditText;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.R;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.ScanCardActivity;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.volley.Server;

public class TransaksiActivity extends AppCompatActivity {

    private ProgressDialog pd;

    public static final int REQUEST_CODE = 100;
    public static final int PERMISSION_REQUEST = 200;

    String urldata = "app/prosestransaksi.php";
    String url = Server.url_server +urldata;

    String urldata1 = "app/cektarif.php";
    String url1 = Server.url_server +urldata1;

    EditText editnokartu, editnotujuan, editpenerima, editbank, editmanual;
    TextView txttarif;
    CurrencyEditText editnominal;
    Button btnscan, btntarif, btnproses;
    String jenistransaksi, kodebank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        //ambil data dari list jenis transaksi
        jenistransaksi = getIntent().getStringExtra("jenistransaksi");

        //permisi kamera
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        }

        editnokartu = (EditText) findViewById(R.id.edittransaksinokartu);
        editnotujuan = (EditText) findViewById(R.id.edittransaksitujuan);
        editnominal = (CurrencyEditText)findViewById(R.id.edittransaksinominal);
        editpenerima = (EditText)findViewById(R.id.edittransaksipenerima);
        editbank = (EditText)findViewById(R.id.edittransaksibank);
        editmanual = (EditText)findViewById(R.id.edittransaksitarif);
        txttarif = (TextView) findViewById(R.id.txttransaksitarif);
        btntarif = (Button) findViewById(R.id.btntransaksiloadtarif);
        btnscan = (Button) findViewById(R.id.btntransaksiscan);
        btnproses = (Button)findViewById(R.id.btntransasiproses);

        Log.d("jenis", jenistransaksi);

        switch (jenistransaksi){
            case "Transfer BRI":
                editbank.setText("BANK BRI");
                kodebank = "002";
                break;
            case  "Transfer Bank Lain":

                break;
            case  "Tarik Tunai":
                editnotujuan.setHint("Nomor Rekening");
                editpenerima.setHint("Pemilik Nomor Rekening");
                break;
            case "Pulsa & Paket Data":
                editnotujuan.setHint("Nomor Ponsel");
                editpenerima.setVisibility(View.GONE);
                editbank.setVisibility(View.GONE);
                break;
            case "BPJS Kesehatan":
                editnotujuan.setHint("Nomor BPJS");
                editbank.setVisibility(View.GONE);
                editpenerima.setVisibility(View.GONE);
                editnominal.setVisibility(View.GONE);
                break;

            case "PLN":
                editnotujuan.setHint("Nomor Pelanggan PLN");
                editbank.setVisibility(View.GONE);
                editpenerima.setVisibility(View.GONE);
                editnominal.setVisibility(View.GONE);
                break;
            case "Cicilan":
                editnotujuan.setHint("Nomor Pelanggan");
                editbank.setVisibility(View.GONE);
                editpenerima.setVisibility(View.GONE);
                editnominal.setVisibility(View.GONE);
                break;
            case "Transaksi Lainnya":

                break;
        }



        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ScanCardActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

        btntarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                final Barcode barcode = data.getParcelableExtra("barcode");
                editnokartu.post(new Runnable() {

                    @Override
                    public void run() {
                        editnokartu.setText(barcode.displayValue);
                    }
                });
            }
        }
    }
}
