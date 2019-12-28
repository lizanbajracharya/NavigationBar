package com.example.navigationbar.ui.RecylcerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationbar.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView=root.findViewById(R.id.recyclerView);

        //Generate contact list in recyclerview
        List<Contacts> contactsList=new ArrayList<>();
        contactsList.add(new Contacts("Screenshot1","9860170437",R.drawable.ic_launcher_background));
        contactsList.add(new Contacts("Screenshot1","9860170437",R.drawable.ic_launcher_foreground));
        contactsList.add(new Contacts("Screenshot1","9860170437",R.drawable.ic_launcher_background));

        ContactAdapter contactsAdapter=new ContactAdapter(getActivity(),contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }
}