package com.vanniktech.lintrules.android

import com.vanniktech.lintrules.android.InvalidSingleLineCommentDetector.ISSUE_INVALID_SINGLE_LINE_COMMENT
import com.vanniktech.lintrules.android.MatchingMenuIdDetector.ISSUE_MATCHING_MENU_ID
import com.vanniktech.lintrules.android.MatchingViewIdDetector.ISSUE_MATCHING_VIEW_ID
import com.vanniktech.lintrules.android.ShouldUseStaticImportDetector.ISSUE_SHOULD_USE_STATIC_IMPORT
import com.vanniktech.lintrules.android.SuperfluousMarginDeclarationDetector.ISSUE_SUPERFLUOUS_MARGIN_DECLARATION
import com.vanniktech.lintrules.android.SuperfluousPaddingDeclarationDetector.ISSUE_SUPERFLUOUS_PADDING_DECLARATION
import com.vanniktech.lintrules.android.WrongConstraintLayoutUsageDetector.ISSUE_WRONG_CONSTRAINT_LAYOUT_USAGE

class IssueRegistry : com.android.tools.lint.client.api.IssueRegistry() {
  override fun getIssues() =
    AndroidDetector.getIssues()
      .toList()
      .plus(listOf(
        ISSUE_INVALID_IMPORT,
        ISSUE_WRONG_VIEW_ID_FORMAT,
        ISSUE_WRONG_MENU_ID_FORMAT,
        ISSUE_RAW_DIMEN,
        ISSUE_RAW_COLOR,
        ISSUE_SUPERFLUOUS_MARGIN_DECLARATION,
        ISSUE_SUPERFLUOUS_PADDING_DECLARATION,
        ISSUE_SHOULD_USE_STATIC_IMPORT,
        ISSUE_MATCHING_VIEW_ID,
        ISSUE_MATCHING_MENU_ID,
        ISSUE_INVALID_SINGLE_LINE_COMMENT,
        ISSUE_INVALID_STRING,
        ISSUE_DEFAULT_LAYOUT_ATTRIBUTE,
        ISSUE_WRONG_CONSTRAINT_LAYOUT_USAGE,
        ISSUE_MISSING_XML_HEADER,
        ISSUE_WRONG_TEST_METHOD_NAME,
        ISSUE_WRONG_LAYOUT_NAME,
        ISSUE_WRONG_ANNOTATION_ORDER,
        ISSUE_CONSTRAINT_LAYOUT_TOOLS_EDITOR_ATTRIBUTE_DETECTOR,
        ISSUE_SUPERFLUOUS_NAME_SPACE,
        ISSUE_XML_SPACING,
        ISSUE_NAMING_PATTERN,
        ISSUE_UNSUPPORTED_LAYOUT_ATTRIBUTE))
}
