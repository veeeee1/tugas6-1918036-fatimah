package com.example.tugas6_workmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        displayNotification("Selamat anda telah terdaftar","MOHON TUNGGU INFO LEBIH LANJUT DI INSTAGRAM @KONOHA_GKR");
        return Result.success();
    }
    public void displayNotification(String task, String desc){
        NotificationManager manager =
                (NotificationManager)
                        getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("terserah", "test123", NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "terserah")
                .setContentTitle(task)
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        manager.notify(1, builder.build());
    }
}