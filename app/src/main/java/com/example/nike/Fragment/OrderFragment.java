package com.example.nike.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nike.ChoxacnhanFragment;
import com.example.nike.R;
import com.example.nike.VPOrderAdapter;
import com.example.nike.dagiaoFragment;
import com.example.nike.dahuyFragment;
import com.example.nike.danggiaoFragment;
import com.google.android.material.tabs.TabLayout;


public class OrderFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        tabLayout= view.findViewById(R.id.tabOrders);
        viewPager=view.findViewById(R.id.viewPagerOrder);

        tabLayout.setupWithViewPager(viewPager);
        VPOrderAdapter vpOrderAdapter=new VPOrderAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpOrderAdapter.addFragment(new ChoxacnhanFragment(),"CHỜ XÁC NHẬN");
        vpOrderAdapter.addFragment(new danggiaoFragment(),"ĐANG GIAO");
        vpOrderAdapter.addFragment(new dagiaoFragment(),"ĐÃ GIAO");
        vpOrderAdapter.addFragment(new dahuyFragment(),"ĐÃ HỦY");
        viewPager.setAdapter(vpOrderAdapter);
        return view;
    }
}