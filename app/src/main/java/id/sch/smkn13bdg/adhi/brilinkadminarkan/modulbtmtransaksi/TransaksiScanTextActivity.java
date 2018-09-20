package id.sch.smkn13bdg.adhi.brilinkadminarkan.modulbtmtransaksi;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.barcode.Barcode;

import id.sch.smkn13bdg.adhi.brilinkadminarkan.R;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.ScanTextActivity;

public class TransaksiScanTextActivity extends AppCompatActivity {

    FloatingActionButton scantxt;
    public static final int REQUEST_CODE = 100;
    public static final int PERMISSION_REQUEST = 200;
    private EditText result;
    EditText nokartu, norek, nominal, penerima, bank;
    Button generate;
    LinearLayout form;

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
        generate = (Button) findViewById(R.id.btntransaksigenerate);
        form = (LinearLayout) findViewById(R.id.formtransaksi);

        result = (EditText) findViewById(R.id.result);
        scantxt = (FloatingActionButton)findViewById(R.id.fabtransaksiscanantrian);
        scantxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScanTextActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hasil = result.getText().toString();
                String[] separated = hasil.split("\n");
                final String kartutxt = separated[0];
                final String norektxt = separated[1];
                final String nomaltxt = separated[2];
                final String penerimatxt = separated[3];
                final String banktxt = separated[4];

                nokartu.setText(kartutxt);
                norek.setText(norektxt);
                nominal.setText(nomaltxt);
                penerima.setText(penerimatxt);
                bank.setText(banktxt);

                form.setVerticalGravity(View.VISIBLE);
                scantxt.setVisibility(View.INVISIBLE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                final String camtext = data.getStringExtra("camtext");
                result.post(new Runnable() {

                    @Override
                    public void run() {
                        result.setText(camtext);
                    }
                });
            }
        }
    }
}
