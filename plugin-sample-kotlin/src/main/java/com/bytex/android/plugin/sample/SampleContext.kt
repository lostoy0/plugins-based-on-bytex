package com.bytex.android.plugin.sample

import com.android.build.gradle.AppExtension
import com.ss.android.ugc.bytex.common.BaseContext
import org.gradle.api.Project

class SampleContext(project: Project?, android: AppExtension?, extension: SampleExtension?) :
    BaseContext<SampleExtension>(project, android, extension) {
}
