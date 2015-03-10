package app.akeorcist.deviceinformation.adapter;

/**
 * Created by Akexorcist on 2/27/15 AD.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.constants.Data;
import app.akeorcist.deviceinformation.data.device.HardwareManager;
import app.akeorcist.deviceinformation.model.SimpleData;
import app.akeorcist.deviceinformation.holder.HardwareDataHolder;

public class HardwearCardAdapter extends RecyclerView.Adapter<HardwareDataHolder> {
    private Context context;

    public HardwearCardAdapter(Context context) {
        this.context = context;
    }

    public HardwareDataHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_row_hardware_card, viewGroup, false);
        return new HardwareDataHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HardwareDataHolder viewHolder, int position) {
        viewHolder.layoutHardwareCard.removeAllViews();

        ArrayList<SimpleData> arrData = null;
        if(position == Data.DATA_ANDROID) {
            arrData = HardwareManager.getAndroidDataList();
            viewHolder.tvCardHeader.setText(Data.TITLE_ANDROID);
        } else if(position == Data.DATA_BUILD) {
            arrData = HardwareManager.getBuildDataList();
            viewHolder.tvCardHeader.setText((Data.TITLE_BUILD));
        } else if(position == Data.DATA_COMMUNICATION) {
            arrData = HardwareManager.getCommunicationDataList();
            viewHolder.tvCardHeader.setText((Data.TITLE_COMMUNICATION));
        } else if(position == Data.DATA_CPU) {
            arrData = HardwareManager.getCpuDataList();
            viewHolder.tvCardHeader.setText((Data.TITLE_CPU));
        } else if(position == Data.DATA_GPU) {
            arrData = HardwareManager.getGpuDataList();
            viewHolder.tvCardHeader.setText((Data.TITLE_GPU));
        } else if(position == Data.DATA_MEMORY) {
            arrData = HardwareManager.getMemoryDataList();
            viewHolder.tvCardHeader.setText((Data.TITLE_MEMORY));
        } else if(position == Data.DATA_STORAGE) {
            arrData = HardwareManager.getStorageDataList();
            viewHolder.tvCardHeader.setText((Data.TITLE_STORAGE));
        }

        for(int i = 0 ; i < arrData.size() ; i++) {
            Context context = viewHolder.layoutHardwareCard.getContext();
            View dataView = LayoutInflater.from(context).inflate(R.layout.view_row_hardware_card_detail, null, false);
            TextView tvTitle = (TextView) dataView.findViewById(R.id.tv_title);
            tvTitle.setText(arrData.get(i).getTitle());

            TextView tvDetail = (TextView) dataView.findViewById(R.id.tv_detail);
            String strDetail = arrData.get(i).getDetail();
            tvDetail.setText((strDetail.equals("") ? "-" : strDetail));

            viewHolder.layoutHardwareCard.addView(dataView);
        }
    }

    @Override
    public int getItemCount() {
        return HardwareManager.getHardwareDataCount();
    }
}
