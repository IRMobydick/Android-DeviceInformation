package app.akeorcist.deviceinformation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.manager.HardwareManager;
import app.akeorcist.deviceinformation.model.Data;

/**
 * Created by Ake on 2/26/2015.
 */
public class HardwareCardAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public HardwareCardAdapter(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return HardwareManager.getHardwareDataCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.view_row_hardware_card, parent, false);
        }

        convertView.setEnabled(false);

        ArrayList<Data> arrData = null;
        TextView tvCardHeader = (TextView) convertView.findViewById(R.id.tv_card_header);
        if(position == Data.DATA_ANDROID) {
            arrData = HardwareManager.getAndroidDataList();
            tvCardHeader.setText(Data.TITLE_ANDROID);
        } else if(position == Data.DATA_BUILD) {
            arrData = HardwareManager.getBuildDataList();
            tvCardHeader.setText((Data.TITLE_BUILD));
        } else if(position == Data.DATA_COMMUNICATION) {
            arrData = HardwareManager.getCommunicationDataList();
            tvCardHeader.setText((Data.TITLE_COMMUNICATION));
        } else if(position == Data.DATA_CPU) {
            arrData = HardwareManager.getCpuDataList();
            tvCardHeader.setText((Data.TITLE_CPU));
        } else if(position == Data.DATA_GPU) {
            arrData = HardwareManager.getGpuDataList();
            tvCardHeader.setText((Data.TITLE_GPU));
        } else if(position == Data.DATA_MEMORY) {
            arrData = HardwareManager.getMemoryDataList();
            tvCardHeader.setText((Data.TITLE_MEMORY));
        } else if(position == Data.DATA_STORAGE) {
            arrData = HardwareManager.getStorageDataList();
            tvCardHeader.setText((Data.TITLE_STORAGE));
        }

        LinearLayout layoutHardwareCard = (LinearLayout) convertView.findViewById(R.id.layout_content);
        layoutHardwareCard.removeAllViews();

        for(int i = 0 ; i < arrData.size() ; i++) {
            View dataView = inflater.inflate(R.layout.view_row_hardware_card_detail, null, false);

            TextView tvTitle = (TextView) dataView.findViewById(R.id.tv_title);
            tvTitle.setText(arrData.get(i).getTitle());

            TextView tvDetail = (TextView) dataView.findViewById(R.id.tv_detail);
            String strDetail = arrData.get(i).getDetail();
            tvDetail.setText((strDetail.equals("") ? "-" : strDetail));

            layoutHardwareCard.addView(dataView);
        }

        return convertView;
    }
}
