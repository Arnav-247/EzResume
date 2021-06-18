package com.codechef.ezresume.DataInput;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codechef.ezresume.R;

public class DataInputFragment extends Fragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "layoutID";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private int layoutID;
    private String mParam2;

    RecyclerView recyclerView;

    public DataInputFragment()
    {
        // Required empty public constructor
    }

    public static DataInputFragment newInstance(int layoutID, String param2)
    {
        DataInputFragment fragment = new DataInputFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, layoutID);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            layoutID = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_input, container, false);
    }


    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_data_input);

    }
}