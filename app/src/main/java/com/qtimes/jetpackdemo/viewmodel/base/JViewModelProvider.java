/**
 * Created with JackHou
 * Date: 2021/3/5
 * Time: 11:40
 * Description:
 */

package com.qtimes.jetpackdemo.viewmodel.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

public class JViewModelProvider {

    public static <T extends BaseViewModel> T get(@NonNull FragmentActivity activity,
                                                  @NonNull Class<T> clazz) {
        T t = new ViewModelProvider(activity).get(clazz);
        t.setLifecycleOwner(activity);
        return t;
    }

    public static <T extends BaseViewModel> T get(@NonNull Fragment fragment,
                                                  @NonNull Class<T> clazz) {
        T t = new ViewModelProvider(fragment).get(clazz);
        t.setLifecycleOwner(fragment);
        return t;
    }

    public static <T extends BaseViewModel> T get(@NonNull FragmentActivity activity,
                                                  @NonNull Class<T> clazz,
                                                  @Nullable NavController navController) {
        T t = new ViewModelProvider(activity).get(clazz);
        t.setLifecycleOwner(activity);
        t.setNavController(navController);
        return t;
    }

    public static <T extends BaseViewModel> T get(@NonNull Fragment fragment,
                                                  @NonNull Class<T> clazz,
                                                  @Nullable NavController navController) {
        T t = new ViewModelProvider(fragment).get(clazz);
        t.setLifecycleOwner(fragment);
        t.setNavController(navController);
        return t;
    }
}
