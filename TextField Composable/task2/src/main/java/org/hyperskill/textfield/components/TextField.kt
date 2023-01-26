package org.hyperskill.textfield.components

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape =
        MaterialTheme.shapes.small.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
) {
    val errorIndicatorColor = colors.indicatorColor(
        enabled = true,
        isError = true,
        interactionSource = interactionSource
    ).value
    val disabledIndicatorColor = colors.indicatorColor(
        enabled = false,
        isError = false,
        interactionSource = interactionSource
    ).value
    val focusedIndicatorColor = colors.indicatorColor(
        enabled = true,
        isError = false,
        interactionSource = interactionSource
    ).value

    androidx.compose.material3.TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .testTag("TextField")
            .semantics {
//            semTextFieldValue = value
                semString = value
                semLeadingIcon = leadingIcon
                semErrorIndicatorColor = errorIndicatorColor
                semDisabledIndicatorColor = disabledIndicatorColor
                semFocusedIndicatorColor = focusedIndicatorColor
                semUnfocusedIndicatorColor = focusedIndicatorColor
                semShape = shape
            },
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}


@Composable
fun TextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape =
        MaterialTheme.shapes.small.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
) {
    val errorIndicatorColor = colors.indicatorColor(
        enabled = true,
        isError = true,
        interactionSource = interactionSource
    ).value
    val disabledIndicatorColor = colors.indicatorColor(
        enabled = false,
        isError = false,
        interactionSource = interactionSource
    ).value
    val focusedIndicatorColor = colors.indicatorColor(
        enabled = true,
        isError = false,
        interactionSource = interactionSource
    ).value

    androidx.compose.material3.TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .testTag("TextField")
            .semantics {
                semTextFieldValue = value.text
//                semString = value
                semLeadingIcon = leadingIcon
                semErrorIndicatorColor = errorIndicatorColor
                semDisabledIndicatorColor = disabledIndicatorColor
                semFocusedIndicatorColor = focusedIndicatorColor
                semUnfocusedIndicatorColor = focusedIndicatorColor
                semShape = shape
            },
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}

