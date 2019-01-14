package com.coyotestudio.healthyfruitsinfo.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Util {


    public static void sendEmail(Context context) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:carlos.medj@gmail.com"));
        context.startActivity(emailIntent);

    }

}
