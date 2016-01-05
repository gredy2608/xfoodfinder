package schronic.xfoodfinder;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gredy on 04-Jan-16.
 */
public class RateFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.getDialog().setTitle("Nilai Tempat Ini");
        return inflater.inflate(R.layout.rating_resto_layout,null);
    }
}
