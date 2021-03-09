/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 10:10
 * Description:
 */

package com.qtimes.jetpackdemo.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.qtimes.jetpackdemo.viewmodel.base.IViewModelAction;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import static com.qtimes.jetpackdemo.event.base.BaseActionEvent.EVENT_DISMISS_LOADING_DIALOG;
import static com.qtimes.jetpackdemo.event.base.BaseActionEvent.EVENT_FINISH;
import static com.qtimes.jetpackdemo.event.base.BaseActionEvent.EVENT_FINISH_WITH_RESULT_OK;
import static com.qtimes.jetpackdemo.event.base.BaseActionEvent.EVENT_SHOW_LOADING_DIALOG;
import static com.qtimes.jetpackdemo.event.base.BaseActionEvent.EVENT_SHOW_TOAST;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    protected Context mContext;
    protected ViewDataBinding mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        if (mDataBinding != null) {
            mDataBinding.setLifecycleOwner(this);//建立双向绑定的关键
        }
        getViewModelAndObserveEvent();
        bindingSetViewModels();
    }

    //获取布局文件id
    protected abstract int getLayoutId();

    //ViewDataBinding set model
    protected abstract void bindingSetViewModels();

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
            action.getActionLiveData().observe(this, baseActionEvent -> {
                switch (baseActionEvent.getAction()) {
                    case EVENT_SHOW_LOADING_DIALOG:
                        startLoading(baseActionEvent.getMessage());
                        break;
                    case EVENT_DISMISS_LOADING_DIALOG:
                        dismissLoading();
                        break;
                    case EVENT_SHOW_TOAST:
                        showToast(baseActionEvent.getMessage());
                    case EVENT_FINISH:
                        finish();
                        break;
                    case EVENT_FINISH_WITH_RESULT_OK: {
                        setResult(RESULT_OK);
                        finish();
                        break;
                    }
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
            mProgressDialog = new ProgressDialog(this);
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 吐司
     *
     * @param message  msg
     * @param duration duration
     */
    protected void showToast(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoading();
    }
}
