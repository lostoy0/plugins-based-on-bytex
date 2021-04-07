package com.bytex.android.plugin.sample;

import com.android.build.gradle.AppExtension;
import com.ss.android.ugc.bytex.common.CommonPlugin;
import com.ss.android.ugc.bytex.common.TransformConfiguration;
import com.ss.android.ugc.bytex.common.visitor.ClassVisitorChain;
import com.ss.android.ugc.bytex.transformer.TransformEngine;

import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class SamplePlugin extends CommonPlugin<SampleExtension, SampleContext> {

    @Override
    protected SampleContext getContext(Project project, AppExtension android, SampleExtension extension) {
        return new SampleContext(project, android, extension);
    }

    @Override
    public void beforeTransform(@Nonnull @NotNull TransformEngine engine) {
        super.beforeTransform(engine);
        System.out.println("plugin-sample-java --------> beforeTransform");
    }

    @Override
    public void afterTransform(@Nonnull TransformEngine engine) {
        super.afterTransform(engine);
        System.out.println("plugin-sample-java --------> afterTransform");
    }

    @Override
    public boolean transform(@Nonnull String relativePath, @Nonnull ClassVisitorChain chain) {
        System.out.println("plugin-sample-java --------> transform relativePath: " + relativePath);
        chain.connect(new SampleClassVisitor(extension));
        return super.transform(relativePath, chain);
    }

    @Nonnull
    @Override
    public TransformConfiguration transformConfiguration() {
        return new TransformConfiguration() {

            @Override
            public boolean isIncremental() {
                return true;
            }
        };
    }
}