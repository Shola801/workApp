package com.example.work;

public class ServiceScreenModel {
    private String serviceProviderName;
    private int profileImageResId; // reference to drawable resource

    public ServiceScreenModel(String serviceProviderName, int profileImageResId) {
        this.serviceProviderName = serviceProviderName;
        this.profileImageResId = profileImageResId;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public int getProfileImageResId() {
        return profileImageResId;
    }

    public void setProfileImageResId(int profileImageResId) {
        this.profileImageResId = profileImageResId;
    }
}
