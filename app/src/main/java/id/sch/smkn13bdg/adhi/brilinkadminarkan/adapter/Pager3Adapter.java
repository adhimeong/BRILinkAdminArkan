package id.sch.smkn13bdg.adhi.brilinkadminarkan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.sch.smkn13bdg.adhi.brilinkadminarkan.modullaporan.LaporanMingguanFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.modullaporan.LaporanHarianFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.modullaporan.LaporanTahunFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.modultransaksi.AntrianTransaksiFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.modultransaksi.BatalTransaksiFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.modultransaksi.BerhasilTransaksiFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.modultransaksi.GagalTransaksiFragment;

/**
 * Created by adhi on 24/08/18.
 */

public class Pager3Adapter extends FragmentStatePagerAdapter {

    private int number_tabs;

    public Pager3Adapter(FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    //Mengembalikan Fragment yang terkait dengan posisi tertentu
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LaporanHarianFragment();
            case 1:
                return new LaporanMingguanFragment();
            case 2:
                return new LaporanTahunFragment();
            default:
                return null;
        }
    }

    //Mengembalikan jumlah tampilan yang tersedia.
    @Override
    public int getCount() {
        return number_tabs;
    }
}
