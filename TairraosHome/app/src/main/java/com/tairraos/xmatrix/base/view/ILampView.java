package com.tairraos.xmatrix.base.view;


import com.tairraos.xmatrix.base.bean.ColorBean;

/**
 * Created by letian on 15/12/5.
 */
public interface ILampView {

    void showLampView();

    void hideLampView();

    int getLampColor();

    int getLampOriginalColor();

    void setLampColor(int color);

    void setLampColorWithNoMove(int color);

    /**
     * 显示操作栏背景
     */
    void showOperationView();

    void sendLampColor(ColorBean bean);

}
