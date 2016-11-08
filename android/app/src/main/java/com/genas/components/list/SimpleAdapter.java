package com.genas.components.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.genas.R;
import com.genas.components.manager.ContextHolder;
import com.genas.components.manager.GlobalUtil;
import com.genas.components.manager.ImageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henadzistoma on 11/3/16.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    private List<SimpleItem> mDataset;

    private static final int INITIAL_WIDTH = 200;
    private static final int INITIAL_HEIGHT= 300;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout mLayout;
        public ViewHolder(LinearLayout v) {
            super(v);
            mLayout = v;
        }

        public void setLayutParams(LinearLayout.LayoutParams params) {
            mLayout.setLayoutParams(params);
        }

        public void setImage(String url, SimpleAdapter adapter) {
            ImageView imageCover = (ImageView) mLayout.findViewById(R.id.itemImageID);
            imageCover.setTag(R.id.tagImageURL, url);
            imageCover.setTag(R.id.tagImageViewWidth, GlobalUtil.convertDpiToPixels(ContextHolder.getInstance().getContext(),100));
            ImageManager.getInstance().setImage(url,imageCover,adapter);
        }
    }


     public SimpleAdapter(List<SimpleItem> dataset) {
         mDataset = dataset;
    }

    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LinearLayout rootView = new LinearLayout(parent.getContext());
        rootView.setBackgroundColor(0xffff00ff);

        ImageView imageCover = new ImageView(parent.getContext());

        imageCover.setId(R.id.itemImageID);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(INITIAL_WIDTH,INITIAL_HEIGHT);
        rootView.addView(imageCover, params);

        SimpleAdapter.ViewHolder holder = new SimpleAdapter.ViewHolder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleAdapter.ViewHolder holder, int position) {
        SimpleItem item = mDataset.get(position % mDataset.size());
        //SimpleItem item = mDataset.get(position);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(INITIAL_WIDTH,INITIAL_HEIGHT);
        params.setMargins(15,5,15,5);
        holder.setLayutParams(params);
        holder.setImage(item.getUrl(), this);
    }

    public final void setBitmap(final String url, final Bitmap bitmap, final ImageView view) {
        if (view!=null) {
            view.post(new Runnable() {
                @Override
                public void run() {
                    if (view.getTag(R.id.tagImageURL) != null && view.getTag(R.id.tagImageURL).toString().equals(url)) {
                        ImageManager.hideLoading(view);
                        view.setImageBitmap(bitmap);
                    }
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;

    }
}
