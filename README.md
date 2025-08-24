# Vieo WebView Android App

这是一个基于WebView的Android应用，用于访问 https://vieo.qzz.io/ 网站，同时支持手机、平板和Android TV。

## 🚀 快速开始

### 方法1：GitHub自动编译（推荐）
1. 将 `new` 文件夹中的所有内容上传到GitHub仓库
2. GitHub Actions会自动编译生成APK
3. 在Releases或Actions中下载APK文件

### 方法2：本地编译
1. 用Android Studio打开项目
2. 等待Gradle同步完成
3. 点击 Build → Build APK(s)

## 📱 功能特性

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

## 🔧 技术特点

1. **双Activity架构**: 根据设备类型自动选择合适的Activity
2. **WebView优化**: 启用JavaScript、DOM存储等现代Web功能
3. **TV适配**: 专门的焦点处理和CSS注入
4. **网络处理**: 支持HTTP和HTTPS混合内容
5. **用户体验**: 加载状态提示和错误处理

## 📋 系统要求

- **最低Android版本**: Android 5.0 (API 21)
- **目标Android版本**: Android 14 (API 34)
- **权限需求**: 
  - INTERNET (网络访问)
  - ACCESS_NETWORK_STATE (网络状态检查)

## 📺 Android TV 安装方法

### 方法1：ADB安装（推荐）
```bash
# 启用Android TV的开发者选项和USB调试
adb install app-debug.apk
```

### 方法2：文件管理器安装
1. 将APK文件复制到U盘
2. 在Android TV上使用文件管理器打开APK文件
3. 允许安装未知来源应用

## 🎮 TV遥控器操作

- **方向键**: 网页导航
- **确认键(ENTER/OK)**: 点击选中元素
- **返回键**: 网页后退
- **菜单键**: 刷新页面

## 📁 项目结构

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

## 🔄 更新应用

1. 修改源码后重新上传到GitHub
2. GitHub会自动重新编译
3. 下载新的APK覆盖安装

## ❓ 常见问题

### Q: 应用无法安装？
A: 确保Android TV允许安装未知来源应用

### Q: 网页显示异常？
A: 检查网络连接，或尝试刷新页面

### Q: TV遥控器无法操作？
A: 确保使用的是标准Android TV遥控器

## 📄 开源协议

本项目基于MIT协议开源。