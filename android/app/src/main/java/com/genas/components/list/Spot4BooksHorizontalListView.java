package com.genas.components.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import java.util.List;

import static java.lang.Math.abs;

/**
 * Created by henadzistoma on 11/3/16.
 */

public class Spot4BooksHorizontalListView extends RecyclerView{

    Spot4BooksHorizontalViewItemListener listener;
    LinearLayoutManager layoutManager;
    public static final int ELEMENT_COUNT = 3000;
    private float glolalOffcetWidth;


    public Spot4BooksHorizontalListView(Context context, Spot4BooksHorizontalViewItemListener listener) {
        super(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        this.setLayoutParams(params);
        layoutManager  = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        this.setLayoutManager(layoutManager);
        glolalOffcetWidth = 0;
        this.setBackgroundColor(0xffffffff);
        this.listener = listener;
        this.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                synchronized (this) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        processScrollToPositionAndAdditionalOffcet(recyclerView);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                glolalOffcetWidth += dx;
            }
        });
        this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Spot4BooksHorizontalListView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int offset = Spot4BooksHorizontalListView.this.getWidth()/2 - SimpleAdapter.INITIAL_WIDTH/2;
                glolalOffcetWidth += offset;
                processScrollToPositionAndAdditionalOffcet(Spot4BooksHorizontalListView.this);
            }
        });
    }

    public void setAdapter(List<SimpleItem> dataset) {
        SimpleAdapter adapter = new SimpleAdapter(dataset, listener);
        this.setAdapter(adapter);
        int datasetSize = dataset.size();
        int startPosition = (ELEMENT_COUNT/2) - (ELEMENT_COUNT/2) % datasetSize;
        glolalOffcetWidth = startPosition*SimpleAdapter.INITIAL_WIDTH;
        this.scrollToPosition(startPosition);
    }

    private void processScrollToPositionAndAdditionalOffcet(RecyclerView recyclerView) {
        int calculatedPosition = Math.round(glolalOffcetWidth / SimpleAdapter.INITIAL_WIDTH);
        if (calculatedPosition == -1) {
            calculatedPosition = 0;
        } else if (calculatedPosition >= recyclerView.getAdapter().getItemCount() - 2) {
            calculatedPosition--;
        }
        scrollRecyclerToPosition(recyclerView, calculatedPosition);
    }

    private void scrollRecyclerToPosition(RecyclerView recyclerView, int expectedPosition) {
        float targetScrollPos = expectedPosition * SimpleAdapter.INITIAL_WIDTH;
        float missingPx = targetScrollPos - glolalOffcetWidth;
        if (missingPx != 0) {
            recyclerView.smoothScrollBy((int) missingPx, 0);
        }
    }

}
