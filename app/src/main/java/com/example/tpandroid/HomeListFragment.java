package com.example.tpandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class HomeListFragment extends ListFragment {
    public HomeListFragment () {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] list = new String[]{
                "ImageView",
                "TextView",
                "Touch",
                "Motion"
        };
        ListAdapter listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        setListAdapter(listAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        assert getFragmentManager() != null;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        switch (getListView().getItemAtPosition(position).toString()) {
            case "ImageView":
                ImageViewFragment imageViewFragment = new ImageViewFragment();
                fragmentTransaction.replace(R.id.container, imageViewFragment, "Image");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case "TextView":
                TextViewFragment textViewFragment = new TextViewFragment();
                fragmentTransaction.replace(R.id.container, textViewFragment, "Text");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case "Touch":
                TouchFragment touchFragment = new TouchFragment();
                fragmentTransaction.replace(R.id.container, touchFragment, "Touch");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case "Motion":
                MotionFragment motionFragment = new MotionFragment();
                fragmentTransaction.replace(R.id.container, motionFragment, "Motion");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
        super.onListItemClick(l, v, position, id);
    }
}
