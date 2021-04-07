package com.bytex.android.plugin.sample;

import com.android.build.gradle.AppExtension;
import com.ss.android.ugc.bytex.common.BaseContext;

import org.gradle.api.Project;

public class SampleContext extends BaseContext<SampleExtension> {

    public SampleContext(Project project, AppExtension android, SampleExtension extension) {
        super(project, android, extension);
    }
}
