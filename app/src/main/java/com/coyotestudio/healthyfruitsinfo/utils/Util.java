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

    public static void createShareIntent(Context context) {
        //Todo Modificar para que posteriormente se comparta con la info correspondiente
        String shareSubject = "Come rico y sano =)";
        String shareMessage = "Te reto a vivir de una manera mas sana. Consume frutas, verduras jugos y comida" +
                " que te haran sentir bien. \n=)\n\n" +
                "¡Healthy Fruits! Proximamente sitio web!!";


        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSubject);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, "Compartir por:"));

    }

}
