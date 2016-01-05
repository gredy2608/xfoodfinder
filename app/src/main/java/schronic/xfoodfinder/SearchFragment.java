package schronic.xfoodfinder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Gredy on 02-Jan-16.
 */
public class SearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_fragment,container,false);

        ListView lv = (ListView)rootView.findViewById(R.id.searchRestaurantListView);

        RestoListAdapter adapter = new RestoListAdapter(rootView.getContext(),SearchFragment.generateListResto());

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                FragmentManager fm = getFragmentManager();

                FragmentTransaction ft = fm.beginTransaction();

                RestoDetailFragment res_detailFragment = new RestoDetailFragment();

                ft.replace(R.id.fragment_main_container, res_detailFragment);

                ft.addToBackStack("resto_detail");

                ft.commit();
            }
        });

        return rootView;
    }

    public static ArrayList<RestoList> generateListResto(){
        ArrayList<RestoList> rl = new ArrayList<RestoList>();
        rl.add(0,new RestoList("Resto A","Jl. ABC no. 1","Indonesia","Rp 20.000 - 50.000","1 km",5));
        rl.add(1,new RestoList("Resto B","Jl. ABC no. 2","Barat","Rp 50.000 - 100.000","3 km",3));
        rl.add(2,new RestoList("Resto C","Jl. ABC no. 3","Korea","Rp 100.000 - 200.000","8 km",2));

        return rl;
    }
}
