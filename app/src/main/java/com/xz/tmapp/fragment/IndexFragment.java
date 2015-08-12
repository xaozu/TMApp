package com.xz.tmapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.xz.tmapp.R;
import com.xz.tmapp.utils.ToastUtils;

import java.util.HashMap;

import butterknife.InjectView;

/**
 * Created by xaozu on 15/8/11.
 * <p/>
 * 首页
 */
public class IndexFragment extends BaseFragment {

    @InjectView(R.id.slider)
    SliderLayout slider;
    @InjectView(R.id.custom_indicator)
    PagerIndicator customIndicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_index;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("0",R.drawable.avd_img);
        file_maps.put("1", R.drawable.avd_img);
        file_maps.put("2", R.drawable.avd_img);
        file_maps.put("3", R.drawable.avd_img);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView baseSliderView) {
                            ToastUtils.showShort(baseSliderView.getBundle().get("extra")+"");
                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setPresetTransformer("Stack");

    }


}
