# 🚀 立即上传GitHub - 操作指南

## 第1步：创建GitHub仓库（2分钟）

### 1.1 访问GitHub
打开浏览器，访问：https://github.com/new

### 1.2 填写仓库信息
```
Repository name: vieo-webview-android
Description: Android WebView app for https://vieo.qzz.io/ with TV support
✅ Public (必须选择，免费Actions)
✅ Add a README file
```

### 1.3 创建仓库
点击绿色按钮 "Create repository"

---

## 第2步：上传项目文件（3分钟）

### 2.1 准备上传
在新创建的仓库页面，点击 "uploading an existing file"

### 2.2 选择要上传的文件
**必须上传的文件和文件夹：**

```
📁 .github/                    ← 自动编译配置
📁 app/                        ← 应用源码
📁 gradle/                     ← 构建工具
📄 .gitignore                  ← Git配置
📄 build.gradle                ← 项目构建
📄 gradle.properties           ← Gradle配置
📄 gradlew                     ← Linux构建脚本
📄 gradlew.bat                 ← Windows构建脚本
📄 settings.gradle             ← 项目设置
📄 README.md                   ← 项目说明
📄 所有 .md 说明文件
```

### 2.3 拖拽上传
1. 选择所有文件和文件夹
2. 拖拽到GitHub网页的上传区域
3. 等待上传完成

### 2.4 提交更改
```
Commit message: Add Vieo WebView Android App with TV support
Description: Complete Android project with GitHub Actions auto-build
```
点击 "Commit changes"

---

## 第3步：监控自动编译（5-10分钟）

### 3.1 查看Actions
1. 上传完成后，点击仓库顶部的 "Actions" 标签
2. 会看到 "Build Android APK" 工作流正在运行
3. 点击进入查看详细进度

### 3.2 编译过程
GitHub会自动执行：
```
🔄 Setting up JDK 17
🔄 Setup Android SDK  
🔄 Cache Gradle packages
🔄 Grant execute permission for gradlew
🔄 Build Debug APK
🔄 Build Release APK
🔄 Upload APK artifacts
🔄 Create Release
```

### 3.3 等待完成
- ✅ 绿色勾号 = 编译成功
- ❌ 红色叉号 = 编译失败（查看日志）

---

## 第4步：下载APK（1分钟）

### 方法A：从Releases下载（推荐）
1. 点击仓库右侧的 "Releases"
2. 下载最新版本的 `app-debug.apk`

### 方法B：从Actions下载
1. 在Actions页面点击完成的构建任务
2. 滚动到底部 "Artifacts" 区域
3. 下载 `vieo-webview-debug`
4. 解压得到APK文件

---

## 第5步：安装到Android TV（2分钟）

### 方法1：ADB安装
```bash
adb install app-debug.apk
```

### 方法2：U盘安装
1. 将APK复制到U盘
2. 在TV上使用文件管理器打开APK
3. 允许安装未知来源应用

---

## 🎉 完成！

现在你的Android TV上就有了Vieo应用！

## 📞 遇到问题？

如果任何步骤遇到问题，请告诉我具体的错误信息！