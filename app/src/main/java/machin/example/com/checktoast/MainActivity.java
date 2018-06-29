package machin.example.com.checktoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import machin.example.com.dynamictoasts.DynamicToast;
import machin.example.com.dynamictoasts.iosDialog.IosDialogBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new IosDialogBuilder(this)
                .setTitle("Yo Bro")
                .setSubtitle("No Bro")
                .setBoldPositiveLabel(true)
                .setCancelable(false)
                .setNegativeListener("NO NO",dialog->{dialog.dismiss();})
                .setPositiveListener("YO YO",dialog -> {
                    DynamicToast.customColorToast(this,"Message on toast", Gravity.CENTER, DynamicToast.LENGTH_SHORT,R.color.blue,R.drawable.ic_info,DynamicToast.ERROR);}).build().show();
    }
}
