package com.milinda.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 作者:Milinda 邮件:Milinda.Hu@gmail.com
 * 创建时间:2017/9/7
 * 描述:我要做个千变万化的标题栏
 */

public class TitleBar extends RelativeLayout {

    //标题栏的内容
    private TextView tvTitle;
    //标题栏的返回按钮
    private Button btnTitleBack;
    //标题栏的编辑按钮
    private Button btnTitleEdit;
    //标题栏
    private RelativeLayout rvTltle;

    private LayoutInflater inflater;
    private Context context;

    //标题栏的背景颜色
    private int bgColor=0;
    //标题栏的类型
    private int type=0;
    //标题栏的编辑按钮的内容
    private String editContent="编辑";
    //标题栏的标题内容
    private String titleContent="标题";
    //标题栏是否处于编辑状态
    private boolean isEdit=false;

    //默认状态，有返回与编辑按钮
    private final int TITLEBAR_TYPE_ALL=0;
    //没有返回与编辑按钮
    private final int TITLEBAR_TYPE_NO_BACK_EDIT=1;
    //没有编辑按钮
    private final int TITLEBAR_TYPE_NO_EDIT=2;
    //没有返回按钮
    private final int TITLEBAR_TYPE_NO_BACK=3;

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init(attrs);
    }

    /**
     * 初始化自定义属性
     * @param attrs
     */
    public void init(AttributeSet attrs){
        TypedArray t = null;
        try{
            t = getContext().obtainStyledAttributes(attrs, R.styleable.TitleBar);
            int n = t.getIndexCount();
            for(int i=0;i<n;i++){
                int attr = t.getIndex(i);
                if (attr == R.styleable.TitleBar_TitleBarBackgroundColor) {
                    bgColor = t.getColor(R.styleable.TitleBar_TitleBarBackgroundColor,
                            ContextCompat.getColor(context, R.color.main_color));

                } else if (attr == R.styleable.TitleBar_TitleBarType) {
                    type = t.getInteger(R.styleable.TitleBar_TitleBarType, 0);

                } else if (attr == R.styleable.TitleBar_TitleBarEditContent) {
                    editContent = t.getString(R.styleable.TitleBar_TitleBarEditContent);

                } else if (attr == R.styleable.TitleBar_TitleBarContent) {
                    titleContent = t.getString(R.styleable.TitleBar_TitleBarContent);

                }
            }

        }finally{
            if(null!=t){
                t.recycle();
            }
        }
        initview(context);
    }

    /**
     * 初始化组件
     * @param context
     */
    private void initview(final Context context) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.include_titlebar, this);

        tvTitle=(TextView) view.findViewById(R.id.tv_title);
        btnTitleBack=(Button) view.findViewById(R.id.btn_title_back);
        btnTitleEdit=(Button) view.findViewById(R.id.btn_title_edit);
        rvTltle=(RelativeLayout) view.findViewById(R.id.rv_title);

        tvTitle.setText(titleContent);
        bgColor = bgColor==0?ContextCompat.getColor(context, R.color.main_color):bgColor;
        rvTltle.setBackgroundColor(bgColor);
        switch (type){
            case TITLEBAR_TYPE_ALL:
                btnTitleEdit.setText(editContent);
                break;
            case TITLEBAR_TYPE_NO_BACK_EDIT:
                btnTitleBack.setVisibility(View.GONE);
                btnTitleEdit.setVisibility(View.GONE);
                break;
            case TITLEBAR_TYPE_NO_EDIT:
                btnTitleEdit.setVisibility(View.GONE);
                break;
            case TITLEBAR_TYPE_NO_BACK:
                btnTitleEdit.setText(editContent);
                btnTitleBack.setVisibility(View.GONE);
                break;
        }
        btnTitleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)context).finish();
            }
        });
    }

    /**
     * 设置编辑按钮的点击事件
     * @param listener
     */
    public void setEditClickListener(OnClickListener listener){
        btnTitleEdit.setOnClickListener(listener);
    }

    /**
     * 设置标题内容
     * @param content
     */
    public void setTitleContent(String content){
        tvTitle.setText(content);
    }

    /**
     * 设置编辑按钮的内容
     * @param content
     */
    public void setEditContent(String content){
        btnTitleEdit.setText(content);
    }

    /**
     * 切换编辑按钮的状态
     * @param isEdit
     */
    public void setIsEdit(boolean isEdit){
        this.isEdit=isEdit;
        if(isEdit){
            btnTitleEdit.setText(context.getString(R.string.cancel));
        }else{
            btnTitleEdit.setText(context.getString(R.string.edit));
        }
    }

    /**
     * 获取编辑按钮的状态
     * @return
     */
    public boolean isEdit() {
        return isEdit;
    }

    /**
     * 切换标题栏状态
     */
    public void changType(){
        btnTitleEdit.setVisibility(View.GONE);
    }
}
