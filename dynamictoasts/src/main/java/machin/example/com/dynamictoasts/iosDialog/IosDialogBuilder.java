package machin.example.com.dynamictoasts.iosDialog;

import android.content.Context;
import android.graphics.Typeface;

public class IosDialogBuilder {
    private Typeface tf;
    private boolean bold,cancelable;
    private String title, subtitle, okLabel, koLabel;
    private Context context;
    private IosDialogListener positiveListener;
    private IosDialogListener negativeListener;

    public IosDialogBuilder(Context context) {
        this.context = context;
    }

    public IosDialogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public IosDialogBuilder setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public IosDialogBuilder setBoldPositiveLabel(boolean bold) {
        this.bold = bold;
        return this;
    }

    public IosDialogBuilder setFont(Typeface font) {
        this.tf=font;
        return this;
    }
    public IosDialogBuilder setCancelable(boolean cancelable){
        this.cancelable=cancelable;
        return this;
    }

    public IosDialogBuilder setNegativeListener(String koLabel,IosDialogListener listener) {
        this.negativeListener=listener;
        this.koLabel=koLabel;
        return this;
    }

    public IosDialogBuilder setPositiveListener(String okLabel,IosDialogListener listener) {
        this.positiveListener = listener;
        this.okLabel=okLabel;
        return this;
    }

    public IosDialog build(){
        IosDialog dialog = new IosDialog(context,title,subtitle, bold, tf,cancelable);
        dialog.setNegative(koLabel,negativeListener);
        dialog.setPositive(okLabel,positiveListener);
        return dialog;
    }

}
