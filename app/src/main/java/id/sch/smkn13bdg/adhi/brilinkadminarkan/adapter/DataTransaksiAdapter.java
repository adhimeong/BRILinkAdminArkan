package id.sch.smkn13bdg.adhi.brilinkadminarkan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import id.sch.smkn13bdg.adhi.brilinkadminarkan.R;
import id.sch.smkn13bdg.adhi.brilinkadminarkan.getset.DataTransaksiController;

/**
 * Created by adhi on 24/08/18.
 */

public class DataTransaksiAdapter extends ArrayAdapter<DataTransaksiController> implements View.OnClickListener {

    private List<DataTransaksiController> data;

    Context mContext;

    private static class ViewHolder {
        TextView idtransaksi;
        TextView nokartu;
        TextView rektujuan;
        TextView nominal;
        TextView jenis;
        TextView bank;
    }

    public DataTransaksiAdapter(List<DataTransaksiController> data, Context context) {
        super(context, R.layout.listdatatransaksi, data);
        this.data = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataTransaksiController data = getItem(position);

        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listdatatransaksi, parent, false);

            viewHolder.idtransaksi = (TextView) convertView.findViewById(R.id.listpointid);
            viewHolder.nokartu = (TextView) convertView.findViewById(R.id.listtransnokartu);
            viewHolder.nominal = (TextView) convertView.findViewById(R.id.listtransnominal);
            viewHolder.rektujuan = (TextView) convertView.findViewById(R.id.listpointtanggal);
            viewHolder.bank = (TextView) convertView.findViewById(R.id.listpointwaktu);
            viewHolder.jenis = (TextView) convertView.findViewById(R.id.listpointadmin);

            result = convertView;

            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;

        }

        viewHolder.idtransaksi.setText(String.valueOf(data.getId_tansaksi()));
        viewHolder.nokartu.setText(String.valueOf(data.getNo_kartu()));
        viewHolder.nominal.setText(String.valueOf(data.getNominal()));
        viewHolder.rektujuan.setText(String.valueOf(data.getRek_tujuan()));
        viewHolder.bank.setText(String.valueOf(data.getBank()));
        viewHolder.jenis.setText(String.valueOf(data.getJenis()));

        return convertView;
    }

    @Override
    public void onClick(View view) {

    }
}
