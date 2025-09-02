package com.example.work.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.work.R;

import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewModel> {

    private Context myContext;
    private List<ServiceModel> myServiceProviderListModel;
    private OnClickListeners myListener;


    public ServicesAdapter(Context myContext, List<ServiceModel> myServiceProviderListModel) {
        this.myContext = myContext;
        this.myServiceProviderListModel = myServiceProviderListModel;
    }

    public void filterList(List<ServiceModel> filterTheList){
        myServiceProviderListModel = filterTheList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ServicesAdapter.ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myLayoutInflater = LayoutInflater.from(parent.getContext());
        View myView = myLayoutInflater.inflate(R.layout.service_category_layout, parent, false);
        return new ViewModel(myView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ViewModel holder, int position) {
      ServiceModel getServiceModel = myServiceProviderListModel.get(position);

        holder.myServices.setText(getServiceModel.getServices());

        holder.itemView.setOnClickListener(view -> {
            if(myListener != null){
                myListener.handleServiceTypeClicked(position, getServiceModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(myServiceProviderListModel == null)
            return 0;
        return myServiceProviderListModel.size();
    }

    public void setServiceTypeOnclickListener(OnClickListeners myListener){
        this.myListener = myListener;
        notifyDataSetChanged();
    }

    public interface OnClickListeners {
        void handleServiceTypeClicked(int position, ServiceModel model);
    }
    public class ViewModel extends RecyclerView.ViewHolder {

        private TextView myServices;
        public ViewModel(@NonNull View itemView) {
            super(itemView);

            myServices = itemView.findViewById(R.id.tv_services);
        }
    }
}
