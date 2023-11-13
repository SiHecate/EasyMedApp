package com.example.hastanerandevu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.SQLException;
import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Uygulama başladığında otomatik bağlantı yapılması amacıyla
        // onCreate içerisine database bağlantısı sağlandı.
        new TestConnectionTask().execute();
    }

    private class TestConnectionTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                Connection connection = DatabaseHelper.connect();
                DatabaseHelper.closeConnection(connection);

                return "Bağlantı başarılı!";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Bağlantı hatası: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            showResultMessage(result);
        }
    }

    private void showResultMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
