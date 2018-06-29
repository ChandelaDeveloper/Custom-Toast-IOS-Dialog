package machin.example.com.dynamictoasts;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.content.ContextCompat.getColor;


public class DynamicToast {

    public static final int LENGTH_LONG = 4000, LENGTH_SHORT = 2000, LENGTH_AUTO = 1000;
    public static final int ERROR = 1, NORMAL = 2, SUCCESS = 3, WARNING = 4, INFO = 5, CUSTOM = 6;

    /**
     * Error type toast.
     *
     * @param activity
     * @param message
     * @param gravity
     * @param duration
     */
    public static void defaultToast(final Activity activity, String message, final int gravity, int duration) {
        final View view = (activity.getLayoutInflater().inflate(R.layout.toast_layout, null));

        ((TextView) view.findViewById(R.id.txtCustomToast)).setText(message);

        Drawable customBackground = getbackground(CUSTOM, view);
        customBackground.setColorFilter(getColor(view.getContext(), R.color.gray), PorterDuff.Mode.ADD);

        ((CardView) view.findViewById(R.id.cardView)).setBackground(customBackground);

        view.findViewById(R.id.customToastImg).setVisibility(View.VISIBLE);
        ((AppCompatImageView) view.findViewById(R.id.customToastImg)).setImageResource(R.drawable.ic_success);

        if (duration == LENGTH_AUTO) {
            duration = Utils.toastTime(message);
        }

        new CountDownTimer(Math.max(duration + 1000, 1000), 2000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long millisUntilFinished) {
                Toast toast = new Toast(activity);
                toast.setGravity(gravity, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
            }
        }.start();
    }

    /**
     * @param activity
     * @param message
     * @param gravity
     * @param duration
     * @param toastColor
     * @param icon
     * @param useFor
     */
    public static void customColorToast(final Activity activity, String message, final int gravity, int duration, @ColorRes int toastColor, @DrawableRes int icon, int useFor) {
        final View view = (activity.getLayoutInflater().inflate(R.layout.toast_layout, null));

        ((TextView) view.findViewById(R.id.txtCustomToast)).setText(message);

        Drawable customBackground = getbackground(useFor, view);
        customBackground.setColorFilter(getColor(view.getContext(), toastColor), PorterDuff.Mode.ADD);

        view.findViewById(R.id.customToastLyt).setBackground(customBackground);
        view.findViewById(R.id.cardView).setBackground(customBackground);

        view.findViewById(R.id.customToastImg).setVisibility(View.VISIBLE);

        ((AppCompatImageView) view.findViewById(R.id.customToastImg)).setImageResource(icon);

        if (duration == LENGTH_AUTO) {
            duration = Utils.toastTime(message);
        }

        new CountDownTimer(Math.max(duration + 1000, 1000), 2000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long millisUntilFinished) {
                Toast toast = new Toast(activity);
                toast.setGravity(gravity, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
            }
        }.start();
    }


    static Drawable getbackground(int useFor, View view) {
        Drawable customBackground = view.getResources().getDrawable(R.drawable.normal_toast__background);

        switch (useFor) {
            case NORMAL:
                customBackground = view.getResources().getDrawable(R.drawable.normal_toast__background);

                break;
            case ERROR:
                customBackground = view.getResources().getDrawable(R.drawable.error_toast__background);

                break;
            case SUCCESS:
                customBackground = view.getResources().getDrawable(R.drawable.success_toast__background);

                break;
            case INFO:
                customBackground = view.getResources().getDrawable(R.drawable.info_toast__background);

                break;
            case CUSTOM:
                customBackground = view.getResources().getDrawable(R.drawable.custom_toast__background);

                break;
            case WARNING:
                customBackground = view.getResources().getDrawable(R.drawable.warning_toast__background);

                break;

        }
        return customBackground;
    }


}
