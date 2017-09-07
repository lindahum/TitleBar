# TitleBar
自定义组件--标题栏

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
      compile 'com.github.lindahum:TitleBar:1.0.0'
  }
```

## 使用

xml文件中添加
```
  <com.milinda.titlebar.TitleBar
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      app:TitleBarContent="标题"
      app:TitleBarEditContent="编辑"
      app:TitleBarType="0"
      />
```

### (1).设置标题栏标题内容

一：通过属性TitleBarContent来设置

二：
```
  TitleBar titleBar=(TitleBar) findViewById(R.id.titleBar);
  titleBar.setTitleContent("标题栏");
```

### (2).设置标题栏编辑按钮内容

一：通过属性TitleBarEditContent来设置

二：
```
  TitleBar titleBar=(TitleBar) findViewById(R.id.titleBar);
  titleBar.setEditContent("编辑");
```

### (3).设置标题栏类型

通过属性TitleBarType来设置

0==>默认状态，有返回与编辑按钮

1==>没有返回与编辑按钮

2==>没有编辑按钮

3==>没有返回按钮




## 持续更新。。。