package com.nambry.android.androidcalculatorapp.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;

import com.nambry.android.androidcalculatorapp.model.CalculatorLogic;

public class CalculatorViewModel extends ViewModel {
    private static final String TAG = CalculatorViewModel.class.getSimpleName();

    public MutableLiveData<String> count = new MutableLiveData<>();
    public CalculatorLogic logic = new CalculatorLogic();

    public CalculatorViewModel() {
        count.setValue("0");
    }


    /** 加算ボタン押下 */
    public void onClickAddBtn(View view) {
        Log.d(TAG, count.getValue());

        int result = logic.add(Integer.parseInt(count.getValue()));
        count.setValue(String.valueOf(result));
    }

    /** 減算ボタン押下 */
    public void onClickSubtractBtn(View view) {
        Log.d(TAG, count.getValue());

        int result = logic.subtract(Integer.parseInt(count.getValue()));
        count.setValue(String.valueOf(result));
    }
}
