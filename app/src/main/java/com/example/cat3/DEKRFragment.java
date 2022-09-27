package com.example.cat3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DEKRFragment extends Fragment {

    RecyclerView rvMain;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMain = getActivity().findViewById(R.id.rvMain3);
        rvMain.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rvMain.setAdapter(new Rv3Adapter());
    }


    class DHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView txt;

        public DHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ivMain);
            txt = itemView.findViewById(R.id.tvTittle);
        }

        public ImageView getImg() {
            return img;
        }

        public TextView getTxt() {
            return txt;
        }

    }

    class Rv3Adapter extends RecyclerView.Adapter<DHolder> {
        private Object[][] data = {{R.drawable.cat2, "CAT 1"},
                {R.drawable.cat3, "CAT 2"},
                {R.drawable.cat1, "CAT 3"}};


        public Rv3Adapter() {
            this.data = data;
        }


        @NonNull
        @Override
        public DHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_data, parent, false);
            return new DHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull DHolder holder, int position) {
            holder.getImg().setImageResource((Integer) data[position][0]);
//            Log.d("HELP", (String) data[position][1]);
            holder.getTxt().setText((String) data[position][1]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity().getApplicationContext(), "hey", Toast.LENGTH_SHORT).show();
                }
            });
        }


        @Override
        public int getItemCount() {
            return 3;
        }

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dekr, container, false);
    }
}
