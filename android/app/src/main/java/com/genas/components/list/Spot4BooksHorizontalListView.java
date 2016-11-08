package com.genas.components.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by henadzistoma on 11/3/16.
 */

public class Spot4BooksHorizontalListView extends RecyclerView{

    Spot4BooksHorizontalViewItemListener listener;

    public Spot4BooksHorizontalListView(Context context, Spot4BooksHorizontalViewItemListener listener) {
        super(context);
        LinearLayoutManager layoutManager  = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        this.setLayoutManager(layoutManager);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(params);

        this.setBackgroundColor(0xffffffff);
        this.listener = listener;
    }


    public void setAdapter(List<SimpleItem> dataset) {
        SimpleAdapter adapter = new SimpleAdapter(dataset, listener);
        this.setAdapter(adapter);
        int startPosition = (Integer.MAX_VALUE/2) % dataset.size();
        this.scrollToPosition(Integer.MAX_VALUE/2 - startPosition);
    }

}
