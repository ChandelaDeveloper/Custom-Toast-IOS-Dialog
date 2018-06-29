# Custom-Toast-IOS-Dialog

Customized Toast /iOS dialog

To get a Git project into your build:

Into build.gradle of app :

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
Step 2. Add the dependency

dependencies {
        implementation 'com.github.PrashantSignity:Custom-Toast-IOS-Dialog:1.01'
}
For maven dependency:

Step 1. Add the JitPack repository to your build file


jitpack. I
https://jitpack.io

Step 2. Add the dependency

<dependency>
    <groupId>com.github.PrashantSignity</groupId>
    <artifactId>Custom-Toast-IOS-Dialog</artifactId>
    <version>1.01</version>
</dependency>
How to Use for toast:
For Default Toast:

DynamicToast.defaultToast(this,"Message on toast", Gravity.CENTER, DynamicToast.LENGTH_SHORT);
For Custom Toast:

DynamicToast.customColorToast(this,"Message on toast", Gravity.CENTER, DynamicToast.LENGTH_SHORT,R.color.blue,R.drawable.ic_info,DynamicToast.ERROR);
For IosDialog in Android:

new IosDialogBuilder(activity) .setTitle("Title") .setSubtitle("SubTitle") .setBoldPositiveLabel(true) .setCancelable(false) .setFont(Typeface font) .setNegativeListener("lable",(IosDialog diaog)->{dialog.dismiss();}) .setPositiveListener("lable",dialog -> {dialog.dismiss();}).build().show();
