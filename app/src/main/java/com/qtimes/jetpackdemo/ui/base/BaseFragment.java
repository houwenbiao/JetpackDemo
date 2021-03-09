/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 11:05
 * Description:BaseFragment
 */

package com.qtimes.jetpackdemo.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qtimes.jetpackdemo.viewmodel.base.IViewModelAction;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import static com.qtimes.jetpackdemo.event.base.BaseActionEvent.EVENT_DISMISS_LOADING_DIALOG;
import static com.qtimes.jetpackdemo.event.base.BaseActionEvent.EVENT_SHOW_LOADING_DIALOG;
import static com.qtimes.jetpackdemo.event.base.BaseActionEvent.EVENT_SHOW_TOAST;

public abstract class BaseFragment extends Fragment {

    private ProgressDialog mProgressDialog;
    public ViewDataBinding mDataBinding;
    protected NavController mNavController;
    protected Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        mDataBinding = DataBindingUtil.inflate(
                inflater,
                getLayoutId(),
                container,
                false);
        mDataBinding.setLifecycleOwner(this);//建立双向绑定的关键
        return mDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        getViewModelAndObserveEvent();
        bindingSetViewModels();
    }

    //ViewDataBinding set model
    protected abstract void bindingSetViewModels();

    //获取布局文件id
    protected abstract int getLayoutId();

    //初始化单个ViewModel
    protected abstract ViewModel initViewModel();

    //初始化ViewModels
    protected List<ViewModel> initViewModels() {
        return null;
    }

    /**
     * 获取ViewModel
     */
    private void getViewModelAndObserveEvent() {
        List<ViewModel> viewModels = initViewModels();
        if (viewModels != null && viewModels.size() > 0) {
            viewModels.forEach(this::observeViewModelEvent);
        } else {
            ViewModel viewModel = initViewModel();
            observeViewModelEvent(viewModel);
        }
    }

    /**
     * 监听ViewModel中的ActionEvent
     *
     * @param viewModel vm
     */
    private void observeViewModelEvent(ViewModel viewModel) {
        if (viewModel == null) {
            return;
        }

        if (viewModel instanceof IViewModelAction) {
            IViewModelAction action = (IViewModelAction) viewModel;
            action.getActionLiveData().observe(getViewLifecycleOwner(), baseActionEvent -> {
                switch (baseActionEvent.getAction()) {
                    case EVENT_SHOW_LOADING_DIALOG:
                        startLoading(baseActionEvent.getMessage());
                        break;
                    case EVENT_DISMISS_LOADING_DIALOG:
                        dismissLoading();
                        break;
                    case EVENT_SHOW_TOAST:
                        showToast(baseActionEvent.getMessage());
                        break;
                    default:
                        break;
                }
            });
        }
    }


    /**
     * 显示loading Dialog
     *
     * @param message msg
     */
    protected void startLoading(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
        mProgressDialog.setTitle(message);
        mProgressDialog.show();
    }

    /**
     * 隐藏loading dialog
     */
    protected void dismissLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * 吐司
     *
     * @param message msg
     */
    protected void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 吐司
     *
     * @param message  msg
     * @param duration duration
     */
    protected void showToast(String message, int duration) {
        Toast.makeText(mContext, message, duration).show();
    }
}
