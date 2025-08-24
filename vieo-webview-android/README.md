# Vieo WebView Android App

这是一个基于WebView的Android应用，用于访问 https://vieo.qzz.io/ 网站，同时支持手机、平板和Android TV。

## 功能特性

### 手机/平板版本 (MainActivity)
- 全屏WebView浏览体验
- 下拉刷新功能
- 进度条显示加载状态
- 支持返回键网页后退
- 自动处理网络错误

### Android TV版本 (TvActivity)
- 专为TV优化的界面设计
- 遥控器导航支持
- 自动注入CSS优化TV显示效果
- 焦点高亮显示
- 大字体和高对比度显示
- 专门的按键处理逻辑

## 技术特点

1. **双Activity架构**: 根据设备类型自动选择合适的Activity
2. **WebView优化**: 启用JavaScript、DOM存储等现代Web功能
3. **TV适配**: 专门的焦点处理和CSS注入
4. **网络处理**: 支持HTTP和HTTPS混合内容
5. **用户体验**: 加载状态提示和错误处理

## 构建说明

1. 确保安装了Android Studio和Android SDK
2. 打开项目并同步Gradle
3. 连接Android设备或启动模拟器
4. 点击运行按钮构建并安装应用

## 系统要求

- **最低Android版本**: Android 5.0 (API 21)
- **目标Android版本**: Android 14 (API 34)
- **权限需求**: 
  - INTERNET (网络访问)
  - ACCESS_NETWORK_STATE (网络状态检查)

## TV支持

应用支持Android TV，会在TV设备上显示专门的TV启动器图标。TV版本包含以下优化：

- 遥控器方向键导航
- 确认键(ENTER/DPAD_CENTER)选择
- 返回键网页后退
- 菜单键刷新页面
- 自动CSS注入优化显示效果

## 文件结构

```
app/
├── src/main/
│   ├── java/com/vieo/webview/
│   │   ├── MainActivity.kt          # 手机/平板主Activity
│   │   └── TvActivity.kt           # TV专用Activity
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml   # 手机/平板布局
│   │   │   └── activity_tv.xml     # TV布局
│   │   ├── values/
│   │   │   ├── colors.xml          # 颜色定义
│   │   │   ├── strings.xml         # 字符串资源
│   │   │   └── themes.xml          # 主题样式
│   │   └── mipmap-*/               # 应用图标
│   └── AndroidManifest.xml         # 应用配置
└── build.gradle                    # 构建配置
```

## 使用说明

1. 安装应用后，在手机上会显示"Vieo"图标
2. 在Android TV上会在TV启动器中显示应用
3. 打开应用后会自动加载 https://vieo.qzz.io/ 网站
4. 在手机上可以使用触摸操作和下拉刷新
5. 在TV上使用遥控器进行导航操作