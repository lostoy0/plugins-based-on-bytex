package com.bytex.android.plugin.sample;

import com.ss.android.ugc.bytex.common.visitor.BaseClassVisitor;

public class SampleClassVisitor extends BaseClassVisitor {

    private SampleExtension extension;

    public SampleClassVisitor(SampleExtension extension) {
        this.extension = extension;
    }

    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
    }
}
