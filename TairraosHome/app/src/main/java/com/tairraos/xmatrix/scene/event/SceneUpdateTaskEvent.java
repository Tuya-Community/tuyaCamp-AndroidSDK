package com.tairraos.xmatrix.scene.event;

import com.tairraos.xmatrix.scene.event.model.SceneUpdateTaskModel;

/**
 * create by nielev on 2019-10-29
 */
public interface SceneUpdateTaskEvent {
    void onEvent(SceneUpdateTaskModel model);
}
