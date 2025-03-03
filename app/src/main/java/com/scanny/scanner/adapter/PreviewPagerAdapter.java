package com.scanny.scanner.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.github.chrisbanes.photoview.PhotoView;
import com.scanny.scanner.R;
import com.scanny.scanner.models.DBModel;

import java.util.ArrayList;

public class PreviewPagerAdapter extends PagerAdapter {
    private Activity activity;
    private ArrayList<DBModel> arrayList;
    private LayoutInflater layoutInflater;

    public PreviewPagerAdapter(Activity activity2, ArrayList<DBModel> arrayList2) {
        activity = activity2;
        arrayList = arrayList2;
        layoutInflater = (LayoutInflater) activity2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = layoutInflater.inflate(R.layout.viewpager_item, viewGroup, false);
        ((RequestBuilder) Glide.with(activity).load(arrayList.get(i).getGroup_doc_img()).placeholder(R.color.bg_color)).into((ImageView) (PhotoView) inflate.findViewById(R.id.book_page));
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((RelativeLayout) obj);
    }
}
