package com.tairraos.xmatrix.family.model;

import com.tairraos.xmatrix.family.FamilyManager;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;

import java.util.List;

public class FamilyAddModel implements IFamilyAddModel {

    public static final String TAG = FamilyAddModel.class.getSimpleName();

    @Override
    public void createHome(String homeName,
                           List<String> roomList,
                           ITuyaHomeResultCallback callback) {
        FamilyManager.getInstance().createHome(homeName, roomList, callback);
    }

}
