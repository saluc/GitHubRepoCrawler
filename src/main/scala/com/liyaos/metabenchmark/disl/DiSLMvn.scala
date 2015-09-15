package com.liyaos.metabenchmark.disl

/**
 * Created by lastland on 15/9/10.
 */
import java.io.File
import scala.sys.process._
import com.liyaos.metabenchmark.tools.ScriptInstaller

object DiSLMvn extends ScriptInstaller {
  def content =
    s"""|#!/bin/bash
        |export PATH="${DiSLConfig.installationDir}:$$PATH"
        |export JAVA_HOME="$${JAVA_HOME:-$$(/usr/libexec/java_home)}"
        |export JAVACMD="${DiSLConfig.installationDir}/java"
        |exec "${"which mvn".!!.stripLineEnd}" "$$@"
     """.stripMargin

  val dir = DiSLConfig.installationDir + "/mvn"

  def isInstalled = new File(dir).exists()

  def install() {
    install(dir, content)
  }
}
