package com.vanniktech.lintrules.android

import com.android.SdkConstants.AAPT_URI
import com.android.SdkConstants.ANDROID_URI
import com.android.SdkConstants.AUTO_URI
import com.android.SdkConstants.TOOLS_URI
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.LayoutDetector
import com.android.tools.lint.detector.api.Scope.Companion.RESOURCE_FILE_SCOPE
import com.android.tools.lint.detector.api.Severity.WARNING
import com.android.tools.lint.detector.api.XmlContext
import org.w3c.dom.Element

private val POSSIBLE_URIS = setOf(ANDROID_URI, TOOLS_URI, AUTO_URI, AAPT_URI)

@JvmField val ISSUE_SUPERFLUOUS_NAME_SPACE = Issue.create("SuperfluousNameSpace", "A namespace was re-declared.",
    "A namespace was re-declared.", Category.CORRECTNESS, 6, WARNING,
    Implementation(SuperfluousNameSpaceDetector::class.java, RESOURCE_FILE_SCOPE))

class SuperfluousNameSpaceDetector : LayoutDetector() {
  override fun getApplicableElements() = ALL

  override fun visitElement(context: XmlContext, element: Element) {
    if (element.parentNode.parentNode != null) {
      (0 until element.attributes.length)
          .map { element.attributes.item(it) }
          .filter { attribute -> POSSIBLE_URIS.any { attribute.toString().contains(it) } }
          .forEach { context.report(ISSUE_SUPERFLUOUS_NAME_SPACE, it, context.getLocation(it), "This name space is already declared and hence not needed.") }
    }
  }
}