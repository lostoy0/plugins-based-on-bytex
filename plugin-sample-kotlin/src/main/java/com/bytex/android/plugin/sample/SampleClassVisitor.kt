package com.bytex.android.plugin.sample

import com.ss.android.ugc.bytex.common.visitor.BaseClassVisitor

class SampleClassVisitor(val extension: SampleExtension): BaseClassVisitor() {

    override fun visitSource(source: String?, debug: String?) {
        super.visitSource(source, debug)
//        println("plugin-sample-kotlin --------> source: $source")
//        println("plugin-sample-kotlin --------> debug: $debug")
    }
}
