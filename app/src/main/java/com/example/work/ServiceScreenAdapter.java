package com.example.work;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.work.R;

import java.util.List;

public class ServiceScreenAdapter extends RecyclerView.Adapter<ServiceScreenAdapter.ServiceScreenViewHolder> {
    private Context context;
    private List<ServiceScreenModel> serviceScreenModelList;
    private OnClickListeners myListener;

    public ServiceScreenAdapter(Context context, List<ServiceScreenModel> serviceScreenModelList) {
        this.context = context;
        this.serviceScreenModelList = serviceScreenModelList;
    }

    public void filterList(List<ServiceScreenModel> filterTheList){
        serviceScreenModelList = filterTheList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServiceScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_person_layout, parent, false);
        return new ServiceScreenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceScreenViewHolder holder, int position) {
        ServiceScreenModel model = serviceScreenModelList.get(position);

        holder.profileName.setText(model.getServiceProviderName());
        holder.profileImage.setImageResource(model.getProfileImageResId());

        holder.button1.setOnClickListener(v -> {
            if (myListener != null) myListener.onFirstButtonClicked(position, model);
        });

        holder.button2.setOnClickListener(v -> {
            if (myListener != null) myListener.onSecondButtonClicked(position, model);
        });
    }

    @Override
    public int getItemCount() {
        if (serviceScreenModelList == null)
            return 0;
        return serviceScreenModelList.size();
    }

    public void setOnClickListeners(OnClickListeners listener) {
        this.myListener = listener;
        notifyDataSetChanged();
    }

    public interface OnClickListeners {
        void onFirstButtonClicked(int position, ServiceScreenModel model);

        void onSecondButtonClicked(int position, ServiceScreenModel model);
    }

    public static class ServiceScreenViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView profileName;
        Button button1, button2;

        public ServiceScreenViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.ci_person);
            profileName = itemView.findViewById(R.id.tv_search_name);
            button1 = itemView.findViewById(R.id.button_black);
            button2 = itemView.findViewById(R.id.button_blue);
        }
    }
}