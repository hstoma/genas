package com.genas.components.list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.genas.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henadzistoma on 11/3/16.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    private List<SimpleItem> mDataset;


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

        public void setLabelText(String text) {
            TextView textView = (TextView) mLayout.findViewById(R.id.itemLabelID);
            System.out.println("------------------------" + textView);
            textView.setText(text);
        }
    }

    public class SimpleItem {
        private String name;
        private int width;

        public SimpleItem(String name, int width) {
            this.name = name;
            this.width = width;
        }

        public String getName() {
            return name;
        }

        public int getWidth() {
            return width;
        }

    }

     public SimpleAdapter() {

         mDataset = new ArrayList<>();
         mDataset.add(new SimpleItem("Item 1", 375));
         mDataset.add(new SimpleItem("Item 2", 135));
         mDataset.add(new SimpleItem("Item 3", 395));
         mDataset.add(new SimpleItem("Item 4", 160));
         mDataset.add(new SimpleItem("Item 5", 300));
         mDataset.add(new SimpleItem("Item 6", 275));
         mDataset.add(new SimpleItem("Item 7", 405));
         mDataset.add(new SimpleItem("Item 8", 380));
         mDataset.add(new SimpleItem("Item 9", 360));


    }

    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LinearLayout rootView = new LinearLayout(parent.getContext());
        rootView.setBackgroundColor(0xffff00ff);

        TextView labelText = new TextView(parent.getContext());

        labelText.setId(R.id.itemLabelID);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        labelText.setLayoutParams(params);
        rootView.addView(labelText);

        SimpleAdapter.ViewHolder holder = new SimpleAdapter.ViewHolder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleAdapter.ViewHolder holder, int position) {
        SimpleItem item = mDataset.get(position);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(item.getWidth(),LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(15,5,15,5);
        holder.setLayutParams(params);
        holder.setLabelText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
