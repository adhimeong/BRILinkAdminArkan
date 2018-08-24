package id.sch.smkn13bdg.adhi.brilinkadminarkan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_transaksi:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ListTransaksiFragment()).commit();
                    return true;
                case R.id.navigation_hadiah:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HadiahFragment()).commit();
                    return true;
                case R.id.navigation_laporan:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new LaporanFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ListTransaksiFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
