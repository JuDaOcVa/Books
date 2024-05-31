package com.judaocva.books.Miscellaneous;

import android.app.AlertDialog;
import android.content.Context;

public class GeneralMethods {
    private static LoadingDialog loadingDialog;

    public static void showAlert(String title, String message, Context context) {
        // show alert
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }

    public static void showLoadingDialog(Context context) {
        loadingDialog = new LoadingDialog(context);
        loadingDialog.show();
    }

    public static void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
}