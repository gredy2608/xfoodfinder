package schronic.xfoodfinder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Gredy on 03-Jan-16.
 */
public class HomeFragment extends Fragment{
    int jenis = 0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home1_fragment,container,false);

        TextView tv = (TextView)view.findViewById(R.id.titleRestoList);

        if(jenis == 0){
            tv.setText("REKOMENDASI");
        }
        else if(jenis == 1){
            tv.setText("TERBARU");
        }
        else if(jenis == 2){
            tv.setText("Makanan Barat");
        }
        else if(jenis == 3){
            tv.setText("Makanan Chinese");
        }
        else if(jenis == 4){
            tv.setText("Makanan Jepang");
        }
        else if(jenis == 5){
            tv.setText("Makanan Indonesia");
        }
        else if(jenis == 6){
            tv.setText("Makanan Korea");
        }

        ListView lv = (ListView)view.findViewById(R.id.rekomendasi_list);

        RestoListAdapter adapter = new RestoListAdapter(view.getContext(),SearchFragment.generateListResto());

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                FragmentManager fm = getFragmentManager();

                FragmentTransaction ft = fm.beginTransaction();

                RestoDetailFragment res_detailFragment = new RestoDetailFragment();

                ft.replace(R.id.fragment_main_container,res_detailFragment);

                ft.addToBackStack("resto_detail");

                ft.commit();
            }
        });

        return view;
    }
}
