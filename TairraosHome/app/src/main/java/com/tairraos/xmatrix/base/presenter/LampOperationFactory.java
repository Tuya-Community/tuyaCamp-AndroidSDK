package com.tairraos.xmatrix.base.presenter;


import com.tairraos.xmatrix.base.bean.RgbBean;

/**
 * Created by letian on 15/12/10.
 */
public interface LampOperationFactory {
    void showOperationView();

    void hideOperationView();

    void updateOperationView(RgbBean rgbBean);


}
