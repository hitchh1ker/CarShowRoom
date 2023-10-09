package com.example.carshowrooms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {

    private List<Cars> cars;
    private LayoutInflater inflater;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public CarsAdapter(Context context, List<Cars> cars) {
        this.cars = cars;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cars car = cars.get(position);

        holder.imageView.setImageResource(car.getImageCar());
        holder.carView.setText(car.getCar());
        holder.amountView.setText(String.valueOf(car.getAmount()));

        holder.addCar.setOnClickListener(v -> {
            int count = car.getAmount() + 1;
            car.setAmount(count);
            holder.amountView.setText(String.valueOf(count));
        });

        holder.deleteCar.setOnClickListener(v -> {
            int count = car.getAmount() - 1;
            if (count < 0) count = 0;
            car.setAmount(count);
            holder.amountView.setText(String.valueOf(count));
        });

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView carView;
        TextView amountView;
        Button addCar;
        Button deleteCar;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageCar);
            carView = itemView.findViewById(R.id.nameCar);
            amountView = itemView.findViewById(R.id.amountCar);
            addCar = itemView.findViewById(R.id.addCar);
            deleteCar = itemView.findViewById(R.id.deleteCar);
        }
    }
}
