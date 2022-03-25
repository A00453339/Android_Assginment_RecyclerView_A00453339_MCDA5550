package com.example.class_work;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class HotelListFragment extends Fragment {

    View view;
    TextView headingTextView;
    ProgressBar progressBar;
    List<HotelListData> userListResponseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.hotel_list_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        headingTextView=view.findViewById(R.id.heading_text_view);

        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String numberOfGuests = getArguments().getString("number of guests");

        //Set up the header
        headingTextView.setText("Welcome user, displaying hotel for " + numberOfGuests + " guests staying from " + checkInDate +
                " to " + checkOutDate);
        headingTextView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        headingTextView.setBackgroundColor(Color.CYAN
        );

        // Set up the RecyclerView
        ArrayList<HotelListData> hotelListData = initHotelListData();
        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), hotelListData);
        recyclerView.setAdapter(hotelListAdapter);


    }

    public ArrayList<HotelListData> initHotelListData() {
        ArrayList<HotelListData> list = new ArrayList<>();

        list.add(new HotelListData("Halifax Regional Hotel", "2000$", "true"));
        list.add(new HotelListData("Hotel Pearl", "500$", "false"));
        list.add(new HotelListData("Hotel Amano", "800$", "true"));
        list.add(new HotelListData("San Jones", "250$", "false"));
        list.add(new HotelListData("Halifax Regional Hotel", "2000$", "true"));
        list.add(new HotelListData("Hotel Pearl", "500$", "false"));
        list.add(new HotelListData("Hotel Amano", "800$", "true"));
        list.add(new HotelListData("San Jones1", "250$", "false"));
        list.add(new HotelListData("San Jones2", "250$", "false"));
        list.add(new HotelListData("San Jones3", "250$", "false"));
        list.add(new HotelListData("San Jones4", "250$", "false"));
        list.add(new HotelListData("San Jones5", "250$", "false"));
        list.add(new HotelListData("San Jones6", "250$", "false"));
        list.add(new HotelListData("San Jones7", "250$", "false"));
        list.add(new HotelListData("San Jones8", "250$", "false"));
        list.add(new HotelListData("San Jones9", "250$", "false"));
        list.add(new HotelListData("San Jones10", "250$", "false"));

        return list;
    }

//    private void getHotelsListsData() {
//        progressBar.setVisibility(View.VISIBLE);
//        Api.getClient().getHotelsLists(new Callback<List<HotelListData>>() {
//            @Override
//            public void success(List<HotelListData> userListResponses, Response response) {
//                // in this method we will get the response from API
//                userListResponseData = userListResponses;
//
//
//                // Set up the RecyclerView
//                setupRecyclerView();
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                // if error occurs in network transaction then we can get the error in this method.
//                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }

//    private void setupRecyclerView() {
//        progressBar.setVisibility(View.GONE);
//        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(), userListResponseData);
//        recyclerView.setAdapter(hotelListAdapter);
//
//        //Bind the click listener
//        hotelListAdapter.setClickListener(this);
//    }


//    @Override
//    public void onClick(View view, int position) {
//        HotelListData hotelListData = userListResponseData.get(position);
//
//        String hotelName = hotelListData.getHotel_name();
//        String price = hotelListData.getPrice();
//        String availability = hotelListData.getAvailability();
//
//        Bundle bundle = new Bundle();
//        bundle.putString("hotel name", hotelName);
//        bundle.putString("hotel price", price);
//        bundle.putString("hotel availability", availability);
//
//        HotelGuestDetailsFragment hotelGuestDetailsFragment = new HotelGuestDetailsFragment();
//        hotelGuestDetailsFragment.setArguments(bundle);
//
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.remove(HotelsListFragment.this);
//        fragmentTransaction.replace(R.id.main_layout, hotelGuestDetailsFragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commitAllowingStateLoss();
//
//    }

}
