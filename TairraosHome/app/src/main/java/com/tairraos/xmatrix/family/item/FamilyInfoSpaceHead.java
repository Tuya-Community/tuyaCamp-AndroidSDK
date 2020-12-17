package com.tairraos.xmatrix.family.item;

import com.tairraos.xmatrix.R;
import com.tairraos.xmatrix.family.recyclerview.item.BaseHead;
import com.tairraos.xmatrix.family.recyclerview.item.BaseViewHolder;

public class FamilyInfoSpaceHead extends BaseHead<String> {

    public FamilyInfoSpaceHead() {
        super("");
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recyler_family_info_space_head;
    }

    @Override
    public void onReleaseViews(BaseViewHolder holder, int sectionKey, int sectionHeadPosition) {

    }

    @Override
    public void onSetViewsData(BaseViewHolder holder, int sectionKey, int sectionHeadPosition) {

    }
}
