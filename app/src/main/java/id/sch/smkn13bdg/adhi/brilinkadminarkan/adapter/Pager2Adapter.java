package id.sch.smkn13bdg.adhi.brilinkadminarkan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.sch.smkn13bdg.adhi.brilinkadminarkan.AntrianTransaksiFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.BatalTransaksiFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.BerhasilFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.GagalTransaksiFragment;

/**
 * Created by adhi on 24/08/18.
 */

public class Pager2Adapter extends FragmentStatePagerAdapter {

    private int number_tabs;

    public Pager2Adapter(FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    //Mengembalikan Fragment yang terkait dengan posisi tertentu
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AntrianTransaksiFragment();
            case 1:
                return new GagalTransaksiFragment();
            case 2:
                return new BatalTransaksiFragment();
            case 3:
                return new BerhasilFragment();
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
