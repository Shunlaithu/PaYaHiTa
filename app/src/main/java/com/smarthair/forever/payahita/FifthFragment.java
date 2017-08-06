package com.smarthair.forever.payahita;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.smarthair.forever.payahita.adapters.AniAdapter;
import com.smarthair.forever.payahita.adapters.NarAdapter;
import com.smarthair.forever.payahita.adapters.PhoneAdapter;
import com.smarthair.forever.payahita.adapters.SchoolAdapter;
import com.smarthair.forever.payahita.models.AniModel;
import com.smarthair.forever.payahita.models.NarModel;
import com.smarthair.forever.payahita.models.PhoneModel;
import com.smarthair.forever.payahita.models.SchoolModel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * A simple {@link Fragment} subclass.
 */
public class FifthFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PhoneAdapter adapter;
    private List<PhoneModel> modelList;
    private String ph_no=null;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 100;


    public FifthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fifth, container, false);



        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_ph);
        modelList = new ArrayList<>();
        adapter = new PhoneAdapter(modelList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);

        PhoneAdapter.OnItemClickListener onItemClickListener = new PhoneAdapter.OnItemClickListener() {

            public void onItemClick(View view, int postition) {
                String[] phone = getResources().getStringArray(R.array.ph_ph);
                StringTokenizer stringTokenizer = new StringTokenizer(phone[postition],",");
                String call_phone = stringTokenizer.nextToken();
                makeCall(call_phone);

            }
        };
        adapter.setOnItemClickListener(onItemClickListener);
        mRecyclerView.setAdapter(adapter);
        setdata();

        return view;
    }

    private void setdata() {
        String[] name =getResources().getStringArray(R.array.ph_name);
        String[] phone = getResources().getStringArray(R.array.ph_ph);

        PhoneModel model;
        for (int i=0;i<name.length;i++){
            model = new PhoneModel(name[i],phone[i]);
            modelList.add(model);
        }
    }

    protected void makeCall(String number) {
        number.replaceAll(" ", "");
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            this.ph_no = number;

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);

            return;
        }
        startActivity(intent);
    }

}
