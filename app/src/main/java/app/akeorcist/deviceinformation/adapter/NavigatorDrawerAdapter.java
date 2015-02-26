package app.akeorcist.deviceinformation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.Utilities.AnimateUtils;

/**
 * Created by Ake on 2/26/2015.
 */
public class NavigatorDrawerAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] arrMenuList;
    private int[] arrIconList;
    private int checkedPosition = -1;
    private View[] viewMenuList;

    public NavigatorDrawerAdapter(Context context, String[] arrMenuList, int[] arrIconList) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrMenuList = arrMenuList;
        this.arrIconList = arrIconList;
        viewMenuList = new View[arrMenuList.length];
    }

    public void setItemChecked(int position) {
        this.checkedPosition = position;
        setLayoutChecked(position);
    }

    private void setLayoutChecked(int position) {
        for(int i = 0 ; i < viewMenuList.length ; i++) {
            setLayoutPressed(viewMenuList[i], (i == position) ? true : false);
        }
    }

    private void setLayoutPressed(View view, boolean state) {
        if (view != null) {
            TextView tvMenuList = (TextView) view.findViewById(R.id.tv_menu_list);
            if (state) {
                tvMenuList.setTextColor(context.getResources().getColor(R.color.white));
                view.setBackgroundColor(context.getResources().getColor(R.color.dark_gray));
            } else {
                tvMenuList.setTextColor(context.getResources().getColor(R.color.dark_gray));
                view.setBackgroundResource(R.drawable.selector_menu);
            }
        }
    }

    @Override
    public int getCount() {
        return arrMenuList.length;
    }

    @Override
    public Object getItem(int position) {
        return arrMenuList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.view_row_menu_navigator_drawer, null, false);
            viewMenuList[position] = convertView;
        }

        ImageView ivMenuList = (ImageView) convertView.findViewById(R.id.iv_menu_list);
        ivMenuList.setImageResource(arrIconList[position]);

        TextView tvMenuList = (TextView) convertView.findViewById(R.id.tv_menu_list);
        tvMenuList.setText(arrMenuList[position]);

        if(checkedPosition == position) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.dark_gray));
            tvMenuList.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            convertView.setBackgroundResource(R.drawable.selector_menu);
            tvMenuList.setTextColor(context.getResources().getColor(R.color.dark_gray));
        }

        return convertView;
    }
}
