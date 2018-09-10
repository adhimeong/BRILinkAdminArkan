package id.sch.smkn13bdg.adhi.brilinkadminarkan.modulnavpengguna;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import id.sch.smkn13bdg.adhi.brilinkadminarkan.R;

public class PenggunaDetailActivity extends Activity {

    String nokartu;
    TextView nokartutxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengguna_detail);

        //ambil data dari fragment
        nokartu = getIntent().getStringExtra("nokartu");

        nokartutxt = (TextView) findViewById(R.id.penggunadetailnokatu);
        nokartutxt.setText(nokartu);
    }
}
