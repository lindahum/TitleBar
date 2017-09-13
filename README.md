# TitleBar

自定义组件--标题栏

[![](https://jitpack.io/v/lindahum/TitleBar.svg)](https://jitpack.io/#lindahum/TitleBar)

## 效果图

<img width="360" height="640" src="https://github.com/lindahum/TitleBar/raw/master/screenshots/main.png"/>

## 引入

Project的build.gradle文件中添加
```
  allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
  }
```

app的build.gradle文件中添加
```
  dependencies {
      compile 'com.github.lindahum:TitleBar:1.0.1'
  }
```

## 使用

xml文件中添加
```
    <com.milinda.titlebar.TitleBar
      android:id="@+id/titleBar"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      app:TitleBarContent="标题"
      app:TitleBarType="0"
      app:TitleBarBackgroundColor="@color/colorPrimary"
      app:TitleBarContentTextColor="@color/white"
      app:TitleBarEditTextColor="@color/white"
      app:TitleBarBackImg="@drawable/ic_back_white"
      />
```

### (1).设置标题栏背景颜色

通过属性TitleBarBackgroundColor来设置(color资源)

### (2).设置标题栏中间标题组件内容字体颜色

通过属性TitleBarContentTextColor来设置(color资源)

### (3).设置标题栏右边编辑与左边返回组件内容字体颜色

通过属性TitleBarEditTextColor来设置(color资源)

### (3).设置标题栏高度

通过属性TitleBarHeight来设置(dimen资源)

### (4).设置标题栏右边编辑与左边返回组件的左右边距

通过属性TitleBarPadding来设置(dimen资源)

### (5).设置标题栏中间标题组件内容字体大小

通过属性TitleBarContentTextSize来设置(dimen资源)

### (6).设置标题栏右边编辑与左边返回组件内容字体大小

通过属性TitleBarEditTextSize来设置(dimen资源)

### (7).设置标题栏左边返回组件的左边图片

通过属性TitleBarBackImg来设置(图片资源)

### (8).设置标题栏右边编辑组件的左边图片

通过属性TitleBarEditImg来设置(图片资源)

### (9).设置标题栏左边返回组件内容

通过属性TitleBarBackContent来设置(String类型)

### (10).设置标题栏中间标题组件内容

一：通过属性TitleBarContent来设置(String类型)

二：
```
  TitleBar titleBar=(TitleBar) findViewById(R.id.titleBar);
  titleBar.setTitleContent("标题栏");
```

### (11).设置标题栏右边编辑组件内容

一：通过属性TitleBarEditContent来设置(String类型)

二：
```
  TitleBar titleBar=(TitleBar) findViewById(R.id.titleBar);
  titleBar.setEditContent("编辑");
```

### (12).设置标题栏类型

通过属性TitleBarType来设置(int类型)

0==>默认状态，有返回与编辑按钮

1==>没有返回与编辑按钮

2==>没有编辑按钮

3==>没有返回按钮




## 持续更新。。。
