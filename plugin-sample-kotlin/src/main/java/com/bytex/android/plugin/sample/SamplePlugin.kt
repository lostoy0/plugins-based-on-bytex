package com.bytex.android.plugin.sample

import com.android.build.gradle.AppExtension
import com.ss.android.ugc.bytex.common.CommonPlugin
import com.ss.android.ugc.bytex.common.TransformConfiguration
import com.ss.android.ugc.bytex.common.visitor.ClassVisitorChain
import com.ss.android.ugc.bytex.transformer.TransformEngine
import org.gradle.api.Project

class SamplePlugin: CommonPlugin<SampleExtension, SampleContext>() {

    override fun getContext(
        project: Project?,
        android: AppExtension?,
        extension: SampleExtension?
    ): SampleContext {
        return SampleContext(project, android, extension)
    }

    override fun beforeTransform(engine: TransformEngine) {
        super.beforeTransform(engine)
        println("plugin-sample-kotlin --------> beforeTransform")
    }

    override fun afterTransform(engine: TransformEngine) {
        super.afterTransform(engine)
        println("plugin-sample-kotlin --------> afterTransform")
    }

    override fun transform(relativePath: String, chain: ClassVisitorChain): Boolean {
        //我们需要修改字节码，所以需要注册一个ClassVisitor
        //We need to modify the bytecode, so we need to register a ClassVisitor
        println("plugin-sample-kotlin --------> transform relativePath: $relativePath")
        chain.connect(SampleClassVisitor(extension))
        return super.transform(relativePath, chain)
    }

    override fun transformConfiguration(): TransformConfiguration {
        return object : TransformConfiguration {

            override fun isIncremental(): Boolean {
                //插件默认是增量的，如果插件不支持增量，需要返回false
                //The plugin is incremental by default.It should return false if incremental is not supported by the plugin
                return true
            }
        }
    }
}
