package com.example.myselfapp.ui.daily;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myselfapp.databinding.FragmentDailyBinding;
import com.example.myselfapp.databinding.FragmentMusicBinding;
import com.example.myselfapp.ui.music.MusicViewModel;

public class DailyFragment extends Fragment {

    private DailyViewModel dailyViewModel;
    private FragmentDailyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dailyViewModel =
                new ViewModelProvider(this).get(DailyViewModel.class);

        binding = FragmentDailyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDaily;
        dailyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}