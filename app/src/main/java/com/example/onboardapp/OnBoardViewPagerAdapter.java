package com.example.onboardapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class OnBoardViewPagerAdapter extends PagerAdapter {


    Context context;
    List<OnBoardScreenItemModel> screenList;

    public OnBoardViewPagerAdapter(Context context, List<OnBoardScreenItemModel> screenList) {
        this.context = context;
        this.screenList = screenList;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_screen_content_onboard, null);

        TextView customObH = view.findViewById(R.id.idTVCustomOBContentH);
        TextView customObSh = view.findViewById(R.id.idTVCustomOBContentSH);
        ImageView customObIv = view.findViewById(R.id.idIVCustomOBContent);

        OnBoardScreenItemModel model = screenList.get(position);
        customObH.setText(model.getHeading());
        customObSh.setText(model.getSub_heading());
        customObIv.setImageResource(model.getImageId());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return screenList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
