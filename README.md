# アーキテクトコンポーネント
- DataBinding
- LiveData
- include

# Layout
・ activity_main.xml
~~~xml
<?xml version="1.0" encoding="utf-8"?>
<layout>
    <android.support.constraint.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <include layout="@layout/content_main" android:id="@+id/content_main_binding" />

    </android.support.constraint.ConstraintLayout>
</layout>
~~~  
・ content_main.xml
~~~xml
<?xml version="1.0" encoding="utf-8"?>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools" >

    <data>
        <variable name="viewModel" type="com.nambry.android.androidcalculatorapp.viewmodels.CalculatorViewModel" />
    </data>

    <android.support.constraint.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
	    ・・・
    </android.support.constraint.ConstraintLayout>

</layout>
~~~  
・ MainActivity.java
~~~java
public class MainActivity extends AppCompatActivity {
    private CalculatorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
	// <include layout="..." android:id="@+id/content_main_binding />のidからcontentMainBindingが参照できるようになる
        ContentMainBinding contentMainBinding = activityMainBinding.contentMainBinding;

        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel.class);
        contentMainBinding.setViewModel(viewModel);
        contentMainBinding.setLifecycleOwner(this);
    }
}
~~~
