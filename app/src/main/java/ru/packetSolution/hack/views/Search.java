package ru.packetSolution.hack.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import ru.packetSolution.hack.databinding.ViewInputFieldBinding;
import ru.packetSolution.hack.databinding.ViewSearchBinding;

public class Search extends RelativeLayout {

    ViewSearchBinding binding;
    public Search(Context context) {
        super(context);
        initView();
    }

    public Search(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView(){
        binding = ViewSearchBinding.inflate(LayoutInflater.from(getContext()), this, true);

    }
}
