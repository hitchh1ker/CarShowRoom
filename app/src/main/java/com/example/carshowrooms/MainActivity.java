package com.example.carshowrooms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cars> selectedCars = new ArrayList<>();
    ArrayList<Cars> cars = new ArrayList<>();
    RecyclerView recyclerView;
    CarsAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.carList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        carAdapter = new CarsAdapter(this, cars);
        recyclerView.setAdapter(carAdapter);

        carAdapter.notifyDataSetChanged();

        carAdapter.setOnItemClickListener((position) -> {
            Cars selectedCar = cars.get(position);
            Toast.makeText(getApplicationContext(), "Была выбрана машина: " + selectedCar.getCar(), Toast.LENGTH_SHORT).show();

            if (selectedCars.contains(selectedCar))
                selectedCars.remove(selectedCar);
            else
                selectedCars.add(selectedCar);
        });
        cars.add(new Cars ("BMW M3", 1, R.drawable.m3));
        cars.add(new Cars ("BMW M4", 1, R.drawable.m4));
        cars.add(new Cars ("BMW M5 F90", 1, R.drawable.f90));
        cars.add(new Cars ("Lexus ES 250", 1, R.drawable.es250));
    }

    public void add(View view) {
        EditText carName = findViewById(R.id.carName);
        EditText amountCar = findViewById(R.id.amountCar);
        String name = carName.getText().toString();
        int amountItem = Integer.parseInt(String.valueOf(amountCar.getText()));
        Cars carItem = new Cars(name, amountItem, R.drawable.e63);
        if (carItem != null) {
            cars.add(carItem);
            carName.setText("");
            amountCar.setText("");
            carAdapter.notifyDataSetChanged();
        }
    }

    public void remove(View view) {
        cars.removeAll(selectedCars);
        selectedCars.clear();
        carAdapter.notifyDataSetChanged();
    }
}
