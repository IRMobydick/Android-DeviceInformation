package app.akeorcist.deviceinformation.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.akeorcist.deviceinformation.R;

/**
 * Created by Akexorcist on 2/27/15 AD.
 */
public class SensorDataHolder extends RecyclerView.ViewHolder {
    public TextView tvName;
    public TextView tvVendor;
    public TextView tvType;
    public TextView tvVersion;
    public TextView tvPower;
    public TextView tvMaxRange;
    public TextView tvResolution;
    public TextView tvMinDelay;
    public TextView tvMaxDelay;
    public TextView tvFifoReserved;
    public TextView tvFifoMax;
    public Button btnSensorInfo;

    public SensorDataHolder(View view) {
        super(view);
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvVendor = (TextView) view.findViewById(R.id.tv_vendor);
        tvType = (TextView) view.findViewById(R.id.tv_type);
        tvVersion = (TextView) view.findViewById(R.id.tv_version);
        tvPower = (TextView) view.findViewById(R.id.tv_power);
        tvMaxRange = (TextView) view.findViewById(R.id.tv_max_range);
        tvResolution = (TextView) view.findViewById(R.id.tv_resolution);
        tvMinDelay = (TextView) view.findViewById(R.id.tv_min_delay);
        tvMaxDelay = (TextView) view.findViewById(R.id.tv_max_delay);
        tvFifoReserved = (TextView) view.findViewById(R.id.tv_fifo_reserved_event);
        tvFifoMax = (TextView) view.findViewById(R.id.tv_fifo_max_event);
        btnSensorInfo = (Button) view.findViewById(R.id.btn_sensor_info);
    }
}
