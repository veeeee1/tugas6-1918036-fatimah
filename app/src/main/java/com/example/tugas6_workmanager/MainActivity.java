package com.example.tugas6_workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nama =
                (EditText)findViewById(R.id.input_nama);
        final EditText usia =
                (EditText)findViewById(R.id.input_usia);
        final EditText jenis =
                (EditText)findViewById(R.id.input_jenis);
        final EditText visi =
                (EditText)findViewById(R.id.input_visi);

        final TextView nama_t =
                (TextView)findViewById(R.id.output_nama);
        final TextView usia_t =
                (TextView)findViewById(R.id.output_usia);
        final TextView jenis_t =
                (TextView)findViewById(R.id.output_jenis);
        final TextView visi_t =
                (TextView)findViewById(R.id.output_visi);

        final Button daftar = (Button)findViewById(R.id.btn_daftar);

        final OneTimeWorkRequest request = new
                OneTimeWorkRequest.Builder(MyWorker.class).build();
        findViewById(R.id.btn_daftar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance().enqueueUniqueWork("Notifikasi", ExistingWorkPolicy.REPLACE, request);

                String nama1 = nama.getText().toString();
                String usia1 = usia.getText().toString();
                String jenis1 = jenis.getText().toString();
                String visi1 = visi.getText().toString();

                nama_t.setText(nama1);
                usia_t.setText(usia1);
                jenis_t.setText(jenis1);
                visi_t.setText(visi1);
            }
        });
    }
}