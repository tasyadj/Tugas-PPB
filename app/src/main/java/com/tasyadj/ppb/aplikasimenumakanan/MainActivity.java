package com.tasyadj.ppb.aplikasimenumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MakananAdapter.OnMakananListener {

    private RecyclerView recMakanan;
    private ArrayList<Makanan> listMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recMakanan = findViewById(R.id.rec_makanan);
        initData();

        recMakanan.setAdapter(new MakananAdapter(listMakanan));
        recMakanan.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData(){
        this.listMakanan = new ArrayList<>();
        listMakanan.add(new Makanan("Katsu", "Chicken Katsu", 25000, R.drawable.katsu));
        listMakanan.add(new Makanan("Ramen", "Ramen Telur", 18000, R.drawable.ramen));
        listMakanan.add(new Makanan("Toppoki", "Toppoki Mozarella", 17000, R.drawable.toppoki));
    }

    @Override
    public void onMakananListener(Intent intent) {
//        Log.e("Data: ", intent.getStringExtra("makanan"));
        Bundle bundle = getIntent().getExtras();
        Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
//        intent1.putExtra("makanan", bundle.getString("makanan"));
//        intent1.putExtra("harga", bundle.getInt("harga"));
//        intent1.putExtra("deskripsi", bundle.getString("deskripsi"));
//        intent1.putExtra("idGambar", bundle.getInt("idGambar"));
        intent1.putExtra("makanan", intent.getStringExtra("makanan"));
        intent1.putExtra("harga", intent.getIntExtra("harga", 0));
        intent1.putExtra("deskripsi", intent.getStringExtra("deskripsi"));
        intent1.putExtra("idGambar", intent.getIntExtra("idGambar", 0));
        startActivity(intent1);
    }
}