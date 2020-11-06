package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int jumlah = 0;
    EditText namaEditText;
    String nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view) {
        jumlah = jumlah + 1;
        display(jumlah);
    }

    public void decrement(View view) {
        if (jumlah > 0 == false) {
        } else {
            jumlah = jumlah - 1;
            display(jumlah);
        }
    }
    public void submitOrder(View view) {
        CheckBox iwatchphoneCheckbox = (CheckBox) findViewById(R.id.iwatchphone_checkbox);
        CheckBox earphoneCheckbox = (CheckBox) findViewById(R.id.earphone_checkbox);
        namaEditText = (EditText) findViewById(R.id.edit_nama);

        boolean hasondeonde = iwatchphoneCheckbox.isChecked();
        boolean hasmolen = earphoneCheckbox.isChecked();
        nama = namaEditText.getText().toString();

        int price = calculatePrice(hasondeonde, hasmolen);

        String priceMessage = "Apa Tambah Lagi?? ...\n";
        priceMessage = priceMessage + "\nBeli : "+ jumlah + " Unit" +
                "\nIwatchphone: " + hasondeonde +
                "\nEarphone: " + hasmolen +
                "\nTotal Pembelian Rp: "+ price +
                "\n\nTerima Kasih, " + nama;

        displayMessage(priceMessage);
    }

    private int calculatePrice(boolean addhasiwatchphone, boolean addhasearphone) {
        int hargaawal = 1000000;
        int harga = 0;

        if(addhasiwatchphone){
            hargaawal = hargaawal + 600000;
        }
        if(addhasearphone){
            hargaawal = hargaawal + 200000;
        }
        return harga = jumlah * hargaawal;
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.harga_text_view);
        priceTextView.setText(message);
    }

    private void display(int number) {
        TextView jumlahTextView = (TextView) findViewById(R.id.jumlah_text_view);
        jumlahTextView.setText("" + number + " unit");
    }

    private void displayHarga(int number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        TextView hargaTextView = (TextView) findViewById(R.id.harga_text_view);
        hargaTextView.setText(formatRupiah.format(number));
    }
}