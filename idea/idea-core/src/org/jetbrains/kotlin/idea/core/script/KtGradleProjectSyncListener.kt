/*
 * Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.core.script

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListenerAdapter
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskType

class KtGradleProjectSyncListener : ExternalSystemTaskNotificationListenerAdapter() {
    override fun onEnd(id: ExternalSystemTaskId) {
        if (id.type == ExternalSystemTaskType.RESOLVE_PROJECT) {
            id.findProject()?.let { project ->
                ServiceManager.getService(project, ScriptDependenciesUpdater::class.java).reloadModifiedScripts()
            }
        }
    }
}