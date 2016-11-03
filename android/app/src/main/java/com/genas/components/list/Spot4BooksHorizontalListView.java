package com.genas.components.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

/**
 * Created by henadzistoma on 11/3/16.
 */

public class Spot4BooksHorizontalListView extends RecyclerView {

    public Spot4BooksHorizontalListView(Context context) {
        super(context);
        LinearLayoutManager layoutManager  = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        this.setLayoutManager(layoutManager);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(params);
        SimpleAdapter adapter = new SimpleAdapter();
        this.setAdapter(adapter);
        this.setBackgroundColor(0xffffffff);
    }

}
