package com.nambry.android.androidcalculatorapp.views;

import android.arch.lifecycle.ViewModelProviders;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nambry.android.androidcalculatorapp.R;
import com.nambry.android.androidcalculatorapp.databinding.ActivityMainBinding;
import com.nambry.android.androidcalculatorapp.databinding.ContentMainBinding;
import com.nambry.android.androidcalculatorapp.viewmodels.CalculatorViewModel;

public class MainActivity extends AppCompatActivity {
    private CalculatorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ContentMainBinding contentMainBinding = activityMainBinding.contentMainBinding;

        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel.class);
        contentMainBinding.setViewModel(viewModel);
        contentMainBinding.setLifecycleOwner(this);
    }
}
