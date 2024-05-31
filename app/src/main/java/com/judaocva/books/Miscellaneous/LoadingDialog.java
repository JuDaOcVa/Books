package com.judaocva.books.Miscellaneous;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.judaocva.books.R;

import java.util.Objects;

public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        setContentView(view);
    }
}