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

import com.smarthair.forever.payahita.adapters.SchoolAdapter;
import com.smarthair.forever.payahita.models.SchoolModel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private ViewFlipper fp ;
    private RecyclerView mRecyclerView;
    private SchoolAdapter adapter;
    private List<SchoolModel> modelList;
    private String ph_no=null;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 100;


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        fp = (ViewFlipper)view.findViewById(R.id.flip);
        fp.startFlipping();
        fp.setAutoStart(true);
        fp.setFlipInterval(3000);
        fp.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        fp.setOutAnimation(getActivity(),android.R.anim.slide_out_right);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_school);
        modelList = new ArrayList<>();
        adapter = new SchoolAdapter(modelList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);

        SchoolAdapter.OnItemClickListener onItemClickListener = new SchoolAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postition) {
                String[] phone = getResources().getStringArray(R.array.school_phone);
                StringTokenizer stringTokenizer = new StringTokenizer(phone[postition],",");
                String call_phone = stringTokenizer.nextToken();
                Toast.makeText(getContext(),call_phone,Toast.LENGTH_LONG).show();

            }
    };
        adapter.setOnItemClickListener(onItemClickListener);
        mRecyclerView.setAdapter(adapter);
        setdata();

        return view;
    }

    private void setdata() {
        String[] name =getResources().getStringArray(R.array.school_name);
        String[] location = getResources().getStringArray(R.array.school_location);
        String[] founder = getResources().getStringArray(R.array.founder);
        String[] phone = getResources().getStringArray(R.array.school_phone);
        String[] description =getResources().getStringArray(R.array.school_description);
            SchoolModel model;
            for (int i=0;i<name.length;i++){
                model = new SchoolModel(name[i],location[i],founder[i],phone[i],description[i]);
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
