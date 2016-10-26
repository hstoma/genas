package com.genas.components.simple;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by henadzistoma on 10/25/16.
 */

public class SimpleLabelView extends LinearLayout{
    TextView label;
    public SimpleLabelView(Context context) {
        super(context);
        /*LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);*/
        label = new TextView(context);
        label.setTextColor(0xffff0000);
        //LayoutParams labelParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        this.addView(label);//, labelParams);
    }

    public void setLabelText(final String labelText) {
        if (label!=null) {
            label.setText(labelText);
        }
    }
}
