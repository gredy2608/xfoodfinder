package schronic.xfoodfinder;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by Gredy on 03-Jan-16.
 */
public class BookFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.getDialog().setTitle("PESAN SEKARANG");
        return inflater.inflate(R.layout.booking_resto_layout,null);
    }
}
