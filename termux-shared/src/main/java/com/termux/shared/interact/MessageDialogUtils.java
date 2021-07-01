package com.termux.shared.interact;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.termux.shared.R;

public class MessageDialogUtils {

    /**
     * Show a message in a dialog
     *
     * @param context The {@link Context} to use to start the dialog. An {@link Activity} {@link Context}
     *                must be passed, otherwise exceptions will be thrown.
     * @param titleText The title text of the dialog.
     * @param messageText The message text of the dialog.
     * @param onDismiss The {@link DialogInterface.OnDismissListener} to run when dialog is dismissed.
     */
    public static void showMessage(Context context, String titleText, String messageText, final DialogInterface.OnDismissListener onDismiss) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog)
            .setPositiveButton(android.R.string.ok, null);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view = inflater.inflate(R.layout.dialog_show_message, null);
        if (view != null) {
            builder.setView(view);

            TextView titleView = view.findViewById(R.id.dialog_title);
            if (titleView != null)
                titleView.setText(titleText);

            TextView messageView = view.findViewById(R.id.dialog_message);
            if (messageView != null)
                messageView.setText(messageText);
        }

        if (onDismiss != null)
            builder.setOnDismissListener(onDismiss);

        builder.show();
    }

    public static void exitAppWithErrorMessage(Context context, String titleText, String messageText) {
        showMessage(context, titleText, messageText, dialog -> System.exit(0));
    }

}
