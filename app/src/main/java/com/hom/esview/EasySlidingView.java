package com.hom.esview;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by linhonghong on 2015/12/29.
 */
public abstract class EasySlidingView extends FrameLayout{

    private Context mContext;

    public void onAttach(View slidingView){

    }

    /**
     * Call when easySlidingView created. must override
     */
    public void onCreate(Context context){
        mContext = context;
//        this.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
//            @Override
//            public void onViewAttachedToWindow(View v) {
//
//            }
//
//            @Override
//            public void onViewDetachedFromWindow(View v) {
//
//            }
//        });
    }

    public EasySlidingView(Context context) {
        super(context);
        onCreate(context);
    }

    public EasySlidingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate(context);
    }

    public EasySlidingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate(context);
    }

    public final void setContentView(View view){
        afterSetContentView(view);
    }

    public final void setContentView(int resId){
        if(mContext == null){
            return;
        }
        View view = View.inflate(mContext, resId, null);
        afterSetContentView(view);
    }

    private void afterSetContentView(View view){
        this.addView(view);
    }

    public void attachToView(RelativeLayout view){
        this.onAttach(this);
        view.addView(this);
    }

}
