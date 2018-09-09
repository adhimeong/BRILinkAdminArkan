package id.sch.smkn13bdg.adhi.brilinkadminarkan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.sch.smkn13bdg.adhi.brilinkadminarkan.modulnavpoint.PointHariFragment;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.modulnavpoint.PointPengaturanFragment;

/**
 * Created by adhi on 08/09/18.
 */

public class PagerPointAdapter extends FragmentStatePagerAdapter {

    private int number_tabs;

    public PagerPointAdapter(FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    //Mengembalikan Fragment yang terkait dengan posisi tertentu
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PointHariFragment();
            case 1:
                return new PointPengaturanFragment();
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
