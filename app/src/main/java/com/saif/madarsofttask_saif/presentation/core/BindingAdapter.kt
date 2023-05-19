package com.saif.madarsofttask_saif.presentation.core

import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.saif.madarsofttask_saif.R
import com.saif.madarsofttask_saif.domain.core.enums.Gender



@BindingAdapter("genderText")
fun EditText.setGenderText(gender: Gender?) {
    setText(
        if (gender == null)
            ""
        else
            context.getString(
            if (gender == Gender.Male) R.string.male
            else
                R.string.female
        )
    )
}