package com.milinda.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
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
    private TextView tvTitleBack;
    //标题栏的底部分隔线
    private TextView tvTitleDivider;
    //标题栏的编辑按钮
    private TextView tvTitleEdit;
    //标题栏
    private RelativeLayout rlTltle;

    private LayoutInflater inflater;
    private Context context;

    //标题栏的背景颜色
    private int bgColor=0;
    //标题栏的内容字体颜色
    private int textColor=0;
    //标题栏的高度
    private int height=0;
    //标题栏的左右边距
    private int padding=0;
    //标题栏的标题的字体大小
    private float contentTextSize=0;
    //标题栏的编辑按钮的字体大小
    private float editTextSize=0;
    //标题栏的返回按钮图片
    private int backImgRes=0;
    //标题栏的编辑按钮的图片
    private int editImgRes=0;
    //标题栏的类型
    private int type=0;
    //标题栏的返回按钮的内容
    private String backContent="";
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
                            ContextCompat.getColor(context, R.color.white));

                }else if (attr == R.styleable.TitleBar_TitleBarTextColor) {
                    textColor = t.getColor(R.styleable.TitleBar_TitleBarTextColor,
                            ContextCompat.getColor(context, R.color.main_textcolor));

                }else if (attr == R.styleable.TitleBar_TitleBarHeight) {
                    height = t.getDimensionPixelOffset(R.styleable.TitleBar_TitleBarHeight,
                            getResources().getDimensionPixelOffset(R.dimen.titlebar_height));

                }else if (attr == R.styleable.TitleBar_TitleBarPadding) {
                    padding = t.getDimensionPixelOffset(R.styleable.TitleBar_TitleBarPadding,
                            getResources().getDimensionPixelOffset(R.dimen.default_padding_15));

                }else if (attr == R.styleable.TitleBar_TitleBarContentTextSize) {
                    contentTextSize = t.getDimension(R.styleable.TitleBar_TitleBarContentTextSize,
                            getResources().getDimension(R.dimen.default_text_size_20));

                }else if (attr == R.styleable.TitleBar_TitleBarEditTextSize) {
                    editTextSize = t.getDimension(R.styleable.TitleBar_TitleBarEditTextSize,
                            getResources().getDimension(R.dimen.default_text_size_14));

                }else if (attr == R.styleable.TitleBar_TitleBarBackImg) {
                    backImgRes = t.getResourceId(R.styleable.TitleBar_TitleBarBackImg,
                            R.drawable.ic_titlebar_back_black);

                }else if (attr == R.styleable.TitleBar_TitleBarEditImg) {
                    editImgRes = t.getResourceId(R.styleable.TitleBar_TitleBarEditImg, 0);

                } else if (attr == R.styleable.TitleBar_TitleBarType) {
                    type = t.getInteger(R.styleable.TitleBar_TitleBarType, 0);

                } else if (attr == R.styleable.TitleBar_TitleBarBackContent) {
                    backContent = t.getString(R.styleable.TitleBar_TitleBarBackContent);

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
        tvTitleBack=(TextView) view.findViewById(R.id.tv_title_back);
        tvTitleEdit=(TextView) view.findViewById(R.id.tv_title_edit);
        tvTitleDivider=(TextView) view.findViewById(R.id.tv_title_divider);
        rlTltle=(RelativeLayout) view.findViewById(R.id.rv_title);

        textColor = textColor==0?ContextCompat.getColor(context, R.color.main_textcolor):textColor;
        bgColor = bgColor==0?ContextCompat.getColor(context, R.color.white):bgColor;
        contentTextSize=contentTextSize==0?getResources().getDimensionPixelSize(R.dimen.default_text_size_20):contentTextSize;
        contentTextSize=contentTextSize/Utils.getDenity(getContext());
        editTextSize=editTextSize==0?getResources().getDimension(R.dimen.default_text_size_14):editTextSize;
        editTextSize=editTextSize/Utils.getDenity(getContext());
        padding=padding==0?getResources().getDimensionPixelOffset(R.dimen.default_padding_15):padding;
        height=height==0?getResources().getDimensionPixelOffset(R.dimen.titlebar_height):height;
        if(backImgRes==0)
            backImgRes=R.drawable.ic_titlebar_back_black;

        if(bgColor==ContextCompat.getColor(context, R.color.white)){
            tvTitleDivider.setVisibility(View.VISIBLE);
        }else{
            tvTitleDivider.setVisibility(View.GONE);
        }

        tvTitle.setText(titleContent);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,contentTextSize);
        tvTitle.setTextColor(textColor);

        tvTitleEdit.setText(editContent);
        tvTitleEdit.setTextSize(TypedValue.COMPLEX_UNIT_SP,editTextSize);
        tvTitleEdit.setTextColor(textColor);
        tvTitleEdit.setPadding(padding,0,padding,0);
        if(editImgRes>0)
            tvTitleEdit.setCompoundDrawablesWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), editImgRes, null),null,null,null);

        tvTitleBack.setText(backContent);
        tvTitleBack.setTextSize(TypedValue.COMPLEX_UNIT_SP,editTextSize);
        tvTitleBack.setTextColor(textColor);
        tvTitleBack.setPadding(padding,0,padding,0);
        tvTitleBack.setCompoundDrawablesWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), backImgRes, null),null,null,null);


        rlTltle.setBackgroundColor(bgColor);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,height);
        rlTltle.setLayoutParams(lp);
        switch (type){
            case TITLEBAR_TYPE_ALL:
                break;
            case TITLEBAR_TYPE_NO_BACK_EDIT:
                tvTitleBack.setVisibility(View.GONE);
                tvTitleEdit.setVisibility(View.GONE);
                break;
            case TITLEBAR_TYPE_NO_EDIT:
                tvTitleEdit.setVisibility(View.GONE);
                break;
            case TITLEBAR_TYPE_NO_BACK:
                tvTitleBack.setVisibility(View.GONE);
                break;
        }
        tvTitleBack.setOnClickListener(new OnClickListener() {
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
        tvTitleEdit.setOnClickListener(listener);
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
        tvTitleEdit.setText(content);
    }

    /**
     * 切换编辑按钮的状态
     * @param isEdit
     */
    public void setIsEdit(boolean isEdit){
        this.isEdit=isEdit;
        if(isEdit){
            tvTitleEdit.setText(context.getString(R.string.cancel));
        }else{
            tvTitleEdit.setText(context.getString(R.string.edit));
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
        tvTitleEdit.setVisibility(View.GONE);
    }
}
