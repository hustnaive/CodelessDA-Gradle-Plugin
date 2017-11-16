package com.wepie.da;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;


public class DAgent {

    private static final String TAG = DAgent.class.getSimpleName();

    private static Activity getActivityFromView(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private static String getActivityNameFromView(View view) {
        Activity act = getActivityFromView(view);
        if(act != null) {
            return act.getClass().getName();
        }
        else return null;
    }

    private static String getViewPath(View view) {
        String viewType = view.getClass().getSimpleName();
        ViewParent parent = view.getParent();
        if( parent instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) parent;
            int index = vg.indexOfChild(view);
            return getViewPath((View)parent) +parent.getClass().getName()+ "["+index+"]";
        }
        else return parent.getClass().getSimpleName()+"[0]";
    }

    private static void track(View v, String evt) {
        Log.d(TAG, getActivityNameFromView(v) + "," + evt + "," + getViewPath(v) + "," + System.currentTimeMillis());
    }

    public static void onClick(View view) {
        track(view, "click");
    }

    public static void onClick(Object object, DialogInterface dialogInterface, int which) {

    }

    public static void onItemClick(Object object, AdapterView parent, View view, int position, long id) {

    }

    public static void onItemSelected(Object object, AdapterView parent, View view, int position, long id) {
        onItemClick(object, parent, view, position, id);
    }

    public static void onGroupClick(Object thisObject, ExpandableListView parent, View v, int groupPosition, long id) {

    }

    public static void onChildClick(Object thisObject, ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

    }

    public static void onStopTrackingTouch(Object thisObj, SeekBar seekBar) {

    }

    public static void onRatingChanged(Object thisObj, RatingBar ratingBar, float rating, boolean fromUser) {

    }

    public static void onCheckedChanged(Object object, RadioGroup radioGroup, int checkedId) {

    }

    public static void onCheckedChanged(Object object, CompoundButton button, boolean isChecked) {

    }


    public static void onFragmentResume(Object obj) {

    }

    public static void onFragmentPause(Object obj) {

    }

    private static boolean checkFragment(android.support.v4.app.Fragment paramFragment) {
        return true;
    }

    private static boolean checkFragment(android.app.Fragment paramFragment) {
        return true;
    }

    public static void setFragmentUserVisibleHint(Object fragmentObject, boolean isUserVisibleHint) {

    }

    public static void onFragmentHiddenChanged(Object fragment, boolean hidden) {
        setFragmentUserVisibleHint(fragment, !hidden);
    }

}
