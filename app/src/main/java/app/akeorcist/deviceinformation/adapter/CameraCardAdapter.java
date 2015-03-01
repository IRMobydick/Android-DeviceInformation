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
import app.akeorcist.deviceinformation.constants.Features;
import app.akeorcist.deviceinformation.holder.CameraDataHolder;
import app.akeorcist.deviceinformation.holder.FeatureDataHolder;
import app.akeorcist.deviceinformation.manager.CameraManager;
import app.akeorcist.deviceinformation.manager.FeatureManager;
import app.akeorcist.deviceinformation.model.FeatureData;

public class CameraCardAdapter extends RecyclerView.Adapter<CameraDataHolder> {
    private int position;

    public CameraCardAdapter(int position) {
        this.position = position;
    }

    public CameraDataHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_row_camera_card, viewGroup, false);
        return new CameraDataHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CameraDataHolder viewHolder, int position) {
        viewHolder.tvFeatureTitle.setText(featureData.getName());
        viewHolder.tvFeaturePackage.setText(featureData.getPackage());
    }

    @Override
    public int getItemCount() {
        return CameraManager.getCameraDataCount(position);
    }
}
