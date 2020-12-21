package com.tairraos.xmatrix.device;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
//import android.transition.TransitionManager;
//import android.view.ViewGroup;

import com.tairraos.xmatrix.R;
import com.tairraos.xmatrix.base.activity.BaseActivity;
import com.tairraos.xmatrix.base.bean.ColorBean;
import com.tairraos.xmatrix.base.presenter.LampPresenter;
import com.tairraos.xmatrix.base.utils.AnimationUtil;
import com.tairraos.xmatrix.base.view.ILampView;
import com.tairraos.xmatrix.base.widget.ColorPicker;
import com.tairraos.xmatrix.base.widget.LampView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LampActivity extends BaseActivity implements ILampView {

    private static final String TAG = "LampActivity";
    protected LampPresenter mLampPresenter;


    @BindView(R.id.activity_lamp_container)
    public View mLampContainer;

    @BindView(R.id.picker)
    public LampView mLampView;

    @BindView(R.id.iv_lamp_close)
    public ImageView mLampSwitchButton;

    @BindView(R.id.iv_lamp_light)
    public ImageView mLampCloseLight;

    @BindView(R.id.tv_lamp_operationTip)
    public TextView mLampViewTip;

    @BindView(R.id.tv_lamp_color_mode)
    public TextView mLampModeViewTip;

    @BindView(R.id.fl_lamp_white_operation)
    public View mOperationView;

    @BindView(R.id.action_scene_1)
    public TextView action_scene_1;

    @BindView(R.id.action_scene_2)
    public TextView action_scene_2;

    @BindView(R.id.action_scene_3)
    public TextView action_scene_3;

    @BindView(R.id.action_scene_4)
    public TextView action_scene_4;

    @BindView(R.id.action_scene_5)
    public TextView action_scene_5;

    @BindView(R.id.action_scene_6)
    public TextView action_scene_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp);

        initToolbar();
        initMenu();
        initView();
        initPresenter();
    }

    private void initView() {
        ButterKnife.bind(this);
    }

    protected void initPresenter() {
        mLampPresenter = new LampPresenter(this, this, getIntent().getStringExtra(SwitchActivity.INTENT_DEVID));
    }

    protected void initMenu() {
        setDisplayHomeAsUpEnabled();
    }

    @Override
    public void showLampView() {
//        final ViewGroup transitionsBackground = (ViewGroup)findViewById(R.id.activity_lamp_container);
        if (mLampView.getVisibility() != View.VISIBLE) {
            mLampView.setVisibility(View.VISIBLE);
        }
        mLampSwitchButton.setImageResource(R.drawable.transpant_bg);
        if (mLampCloseLight.getVisibility() != View.GONE) {
            mLampCloseLight.setVisibility(View.GONE);
        }
        if (mLampModeViewTip.getVisibility() != View.GONE) {
            mLampModeViewTip.setVisibility(View.GONE);
        }
        if (mLampViewTip.getVisibility() != View.VISIBLE) {
            mLampViewTip.setVisibility(View.VISIBLE);
        }
        mLampViewTip.setText(R.string.lamp_close_tip);
        mLampViewTip.setTextColor(0x99000000);

//        TransitionManager.beginDelayedTransition((ViewGroup)mLampContainer);
        mLampContainer.setBackground(getResources().getDrawable(R.drawable.background));
    }

    @Override
    public void hideLampView() {
        if (mLampView.getVisibility() != View.GONE) {
            mLampView.setVisibility(View.GONE);
        }
        mLampSwitchButton.setImageResource(R.drawable.ty_lamp_wick_line);
        mLampCloseLight.setVisibility(View.VISIBLE);
        mLampViewTip.setVisibility(View.VISIBLE);
        mLampViewTip.setText(R.string.lamp_open_tip);
        mLampViewTip.setTextColor(0x99FFFFFF);
        mLampContainer.setBackground(getResources().getDrawable(R.drawable.bg_lamp));
        if (mLampModeViewTip.getVisibility() != View.GONE) {
            mLampModeViewTip.setVisibility(View.GONE);
        }
        mLampPresenter.hideOperation();
        mOperationView.setVisibility(View.GONE);
    }


    @Override
    public int getLampColor() {
        return mLampView.getColor();
    }

    @Override
    public int getLampOriginalColor() {
        return mLampView.getOriginalColor();
    }

    @Override
    public void setLampColor(int color) {
        mLampView.setColor(color);
    }

    @Override
    public void setLampColorWithNoMove(int color) {
        mLampView.setColorWithNoAngle(color, ColorPicker.S_RESPONING);
    }

    @Override
    public void showOperationView() {
        mOperationView.setVisibility(View.VISIBLE);
        AnimationUtil.translateView(mOperationView, Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 1f,
            Animation.RELATIVE_TO_SELF, 0f, 300, false, null);
    }


    @Override
    public void sendLampColor(ColorBean bean) {
        mLampPresenter.syncColorToLamp(bean);
    }


    @OnClick(R.id.iv_lamp_close)
    public void onLampClick() {
        mLampPresenter.onClickLampSwitch();
    }

    @OnClick(R.id.action_scene_1)
    public void action_scene_1() {
        mLampPresenter.onScene1Active();
    }
    @OnClick(R.id.action_scene_2)
    public void action_scene_2() {
        mLampPresenter.onScene2Active();
    }
    @OnClick(R.id.action_scene_3)
    public void action_scene_3() {
        mLampPresenter.onScene3Active();
    }
    @OnClick(R.id.action_scene_4)
    public void action_scene_4() {
        mLampPresenter.onScene4Active();
    }
    @OnClick(R.id.action_scene_5)
    public void action_scene_5() {
        mLampPresenter.onScene5Active();
    }
    @OnClick(R.id.action_scene_6)
    public void action_scene_6() {
        mLampPresenter.onScene6Active();
    }

    @OnClick(R.id.ll_lamp_bottom_operation)
    public void onClickArrawUp() {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mLampPresenter.onDestroy();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
