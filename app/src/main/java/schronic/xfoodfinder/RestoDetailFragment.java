package schronic.xfoodfinder;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;

/**
 * Created by Gredy on 03-Jan-16.
 */
public class RestoDetailFragment extends Fragment{

    String[] menu_list = {"Info","Menu","Review","Direction","Gallery"};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.resto_detail_fragment,container,false);

        rootView.findViewById(R.id.detail_info_extend).setVisibility(View.GONE);
        rootView.findViewById(R.id.detail_gallery_extend).setVisibility(View.GONE);
        rootView.findViewById(R.id.detail_direction_extend).setVisibility(View.GONE);
        rootView.findViewById(R.id.detail_review_extend).setVisibility(View.GONE);
        rootView.findViewById(R.id.detail_menu_extend).setVisibility(View.GONE);

        RatingBar rb = (RatingBar)rootView.findViewById(R.id.ratingbar_review);

        Drawable drawable = rb.getProgressDrawable();
        drawable.setColorFilter(Color.parseColor("#ffa516"), PorterDuff.Mode.SRC_ATOP);

        //ArrayAdapter<String> ad = new ArrayAdapter<String>(rootView.getContext(),R.layout.menu_layout,R.id.menu_label,menu_list);

        //ListView lv = (ListView)rootView.findViewById(R.id.menu_list_detail);
        //lv.setAdapter(ad);

        return rootView;
    }

    public void onClickInfo(View view){

    }
}
