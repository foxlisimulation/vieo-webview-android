# 📤 GitHub上传指南

## 🚀 快速上传步骤

### 第1步：创建GitHub仓库
1. 访问 https://github.com/new
2. 填写信息：
   - Repository name: `vieo-webview-android`
   - Description: `Android WebView app for https://vieo.qzz.io/ with TV support`
   - 选择 **Public** (重要！免费GitHub Actions需要公开仓库)
   - 勾选 "Add a README file"
3. 点击 "Create repository"

### 第2步：上传项目文件
1. 在新仓库页面点击 "uploading an existing file"
2. 选择 `new` 文件夹中的所有文件和文件夹
3. 拖拽到GitHub网页的上传区域
4. 提交信息：`Add Vieo WebView Android App`
5. 点击 "Commit changes"

### 第3步：等待自动编译
1. 上传完成后，点击 "Actions" 标签
2. 查看 "Build Android APK" 工作流运行状态
3. 等待5-10分钟编译完成（显示绿色✅）

### 第4步：下载APK
**方法A：从Releases下载**
1. 点击仓库右侧的 "Releases"
2. 下载最新版本的 `app-debug.apk`

**方法B：从Actions下载**
1. 在Actions页面点击完成的构建任务
2. 滚动到底部 "Artifacts" 区域
3. 下载 `vieo-webview-debug`

## ✅ 成功标志

编译成功后你会看到：
- Actions页面显示绿色勾号
- Releases页面有新版本
- 可以下载APK文件（约2-5MB）

## 📱 安装到Android TV

```bash
adb install app-debug.apk
```

## 🔄 更新应用

1. 修改源码文件
2. 重新上传到GitHub
3. GitHub自动编译新版本
4. 下载新APK覆盖安装

## ❗ 重要提醒

- 仓库必须选择 "Public" 才能使用免费GitHub Actions
- 确保所有文件都正确上传
- 编译需要5-10分钟，请耐心等待