package app.akeorcist.deviceinformation.adapter;

/**
 * Created by Akexorcist on 2/27/15 AD.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.holder.SensorDataHolder;
import app.akeorcist.deviceinformation.manager.SensorListManager;
import app.akeorcist.deviceinformation.model.SensorData;

public class SensorCardAdapter extends RecyclerView.Adapter<SensorDataHolder> {
    private Context context;
    private OnSensorInfoClickListener listener;

    public SensorCardAdapter(Context context) {
        this.context = context;
    }

    public SensorDataHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_row_sensor_card, viewGroup, false);
        return new SensorDataHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SensorDataHolder viewHolder, final int position) {
        SensorData sensor = SensorListManager.getSensorData(position);
        viewHolder.ivSensor.setImageResource(sensor.getImageResId());
        viewHolder.tvName.setText(sensor.getName());
        viewHolder.tvVendor.setText(sensor.getVendor());
        viewHolder.tvType.setText(sensor.getType());
        viewHolder.tvVersion.setText(sensor.getVersion());
        viewHolder.tvPower.setText(sensor.getPower());
        viewHolder.tvMaxRange.setText(sensor.getMaxRange());
        viewHolder.tvResolution.setText(sensor.getResolution());
        viewHolder.tvMinDelay.setText(sensor.getMinDelay());
        viewHolder.tvMaxDelay.setText(sensor.getMaxDelay());
        viewHolder.tvFifoReserved.setText(sensor.getFifoReserved());
        viewHolder.tvFifoMax.setText(sensor.getFifoMax());
        if(!sensor.getType().equals("Unknown")) {
            viewHolder.btnSensorInfo.setVisibility(View.VISIBLE);
            viewHolder.btnSensorInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.onClick(v, position);
                }
            });
        } else {
            viewHolder.btnSensorInfo.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return SensorListManager.getSensorDataCount();
    }

    public void setOnSensorInfoClickListener(OnSensorInfoClickListener listener) {
        this.listener = listener;
    }

    public interface OnSensorInfoClickListener {
        public void onClick(View v, int position);
    }
}
