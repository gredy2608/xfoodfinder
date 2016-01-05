package schronic.xfoodfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gredy on 03-Jan-16.
 */
public class RestoListAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private ArrayList<RestoList> restoList;

    public RestoListAdapter(Context photosFragment, ArrayList<RestoList> results){
        restoList = results;
        mInflater = LayoutInflater.from(photosFragment);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return restoList.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return restoList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.resto_list_layout,null,false);
            holder = new ViewHolder();
            holder.txtname = (TextView) convertView.findViewById(R.id.nama_resto_label);
            holder.txtjenis = (TextView) convertView.findViewById(R.id.jenis_resto);
            holder.txtaddress = (TextView) convertView.findViewById(R.id.alamat_resto);
            holder.txtprice = (TextView) convertView.findViewById(R.id.price_range_resto);
            holder.txtdistance = (TextView) convertView.findViewById(R.id.resto_distance_list);

            holder.rate1 = (ImageView)convertView.findViewById(R.id.star1);
            holder.rate2 = (ImageView)convertView.findViewById(R.id.star2);
            holder.rate3 = (ImageView)convertView.findViewById(R.id.star3);
            holder.rate4 = (ImageView)convertView.findViewById(R.id.star4);
            holder.rate5 = (ImageView)convertView.findViewById(R.id.star5);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtname.setText(restoList.get(position).name);
        holder.txtaddress.setText(restoList.get(position).address);
        holder.txtjenis.setText(restoList.get(position).jenis);
        holder.txtprice.setText(restoList.get(position).price);
        holder.txtdistance.setText(restoList.get(position).distance);

        if(restoList.get(position).rate == 1){
            holder.rate1.setVisibility(View.VISIBLE);
        }
        else if(restoList.get(position).rate == 2){
            holder.rate1.setVisibility(View.VISIBLE);
            holder.rate2.setVisibility(View.VISIBLE);
        }
        else if(restoList.get(position).rate == 3){
            holder.rate1.setVisibility(View.VISIBLE);
            holder.rate2.setVisibility(View.VISIBLE);
            holder.rate3.setVisibility(View.VISIBLE);
        }
        else if(restoList.get(position).rate == 4){
            holder.rate1.setVisibility(View.VISIBLE);
            holder.rate2.setVisibility(View.VISIBLE);
            holder.rate3.setVisibility(View.VISIBLE);
            holder.rate4.setVisibility(View.VISIBLE);
        }
        else if(restoList.get(position).rate == 5){
            holder.rate1.setVisibility(View.VISIBLE);
            holder.rate2.setVisibility(View.VISIBLE);
            holder.rate3.setVisibility(View.VISIBLE);
            holder.rate4.setVisibility(View.VISIBLE);
            holder.rate5.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    static class ViewHolder{
        TextView txtname, txtjenis,txtaddress,txtprice,txtdistance;
        ImageView rate1,rate2,rate3,rate4,rate5;
    }
}
