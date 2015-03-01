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
import app.akeorcist.deviceinformation.holder.FeatureDataHolder;
import app.akeorcist.deviceinformation.manager.FeatureManager;
import app.akeorcist.deviceinformation.model.FeatureData;

public class FeatureCardAdapter extends RecyclerView.Adapter<FeatureDataHolder> {
    private Context context;
    private String featureType;

    public FeatureCardAdapter(Context context, String featureType) {
        this.context = context;
        this.featureType = featureType;
    }

    public FeatureDataHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_row_feature_card, viewGroup, false);
        return new FeatureDataHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeatureDataHolder viewHolder, int position) {
        FeatureData featureData = null;
        if(featureType.equals(Features.SUPPORTED_FEATURES))
            featureData = FeatureManager.getSupportFeature(position);
        else if(featureType.equals(Features.UNSUPPORTED_FEATURES))
            featureData = FeatureManager.getUnsupportFeature(position);
        viewHolder.tvFeatureTitle.setText(featureData.getName());
        viewHolder.tvFeaturePackage.setText(featureData.getPackage());
    }

    @Override
    public int getItemCount() {
        if(featureType.equals(Features.SUPPORTED_FEATURES))
            return FeatureManager.getSupportFeatureCount();
        else if(featureType.equals(Features.UNSUPPORTED_FEATURES))
            return FeatureManager.getUnsupportFeatureCount();
        return 0;
    }
}
