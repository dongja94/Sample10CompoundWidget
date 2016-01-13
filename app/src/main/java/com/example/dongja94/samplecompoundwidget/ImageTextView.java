package com.example.dongja94.samplecompoundwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dongja94 on 2016-01-13.
 */
public class ImageTextView extends FrameLayout {
    public ImageTextView(Context context) {
        super(context);
        init(null);
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    ImageView iconView;
    TextView titleView;
    ImageTextData data;

    public interface OnImageClickListener {
        public void onImageClick(ImageTextView view, ImageTextData data);
    }
    OnImageClickListener mListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mListener = listener;
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.view_image_text, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        titleView = (TextView)findViewById(R.id.text_title);

        iconView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageClick(ImageTextView.this, data);
                }
            }
        });

        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ImageTextView);

            data = new ImageTextData();
            data.title = ta.getText(R.styleable.ImageTextView_ttl).toString();
            data.iconId = ta.getResourceId(R.styleable.ImageTextView_android_src, 0);
            setImageTextData(data);

            ta.recycle();
        }
    }

    public void setImageTextData(ImageTextData data) {
        this.data = data;
        iconView.setImageResource(data.iconId);
        titleView.setText(data.title);
    }

    public void setTitle(String title) {
        if (data == null) {
            data = new ImageTextData();
        }
        data.title = title;
        titleView.setText(title);
    }
}
