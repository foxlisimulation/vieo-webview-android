package com.vieo.webview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.vieo.webview.databinding.ActivityTvBinding

class TvActivity : FragmentActivity() {
    
    private lateinit var binding: ActivityTvBinding
    private val targetUrl = "https://vieo.qzz.io/"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupWebView()
        loadWebsite()
    }
    
    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        binding.webView.apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
                builtInZoomControls = false // TV通常不需要缩放控件
                displayZoomControls = false
                setSupportZoom(false)
                cacheMode = WebSettings.LOAD_DEFAULT
                allowFileAccess = true
                allowContentAccess = true
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                
                // TV优化设置
                setRenderPriority(WebSettings.RenderPriority.HIGH)
                cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
            }
            
            // 设置焦点处理，适配TV遥控器
            isFocusable = true
            isFocusableInTouchMode = true
            requestFocus()
            
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    binding.progressBar.visibility = View.VISIBLE
                    binding.loadingText.visibility = View.VISIBLE
                    binding.loadingText.text = "正在加载..."
                }
                
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBar.visibility = View.GONE
                    binding.loadingText.visibility = View.GONE
                    
                    // 注入CSS来优化TV显示
                    view?.evaluateJavascript("""
                        (function() {
                            var style = document.createElement('style');
                            style.innerHTML = `
                                * { 
                                    cursor: none !important; 
                                }
                                body { 
                                    zoom: 1.2; 
                                    font-size: 120% !important;
                                }
                                a, button, input, select, textarea {
                                    outline: 3px solid #007bff !important;
                                    outline-offset: 2px !important;
                                }
                                a:focus, button:focus, input:focus, select:focus, textarea:focus {
                                    outline: 3px solid #ff6b35 !important;
                                    outline-offset: 2px !important;
                                    background-color: rgba(255, 107, 53, 0.1) !important;
                                }
                            `;
                            document.head.appendChild(style);
                        })();
                    """.trimIndent(), null)
                }
                
                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    super.onReceivedError(view, request, error)
                    binding.progressBar.visibility = View.GONE
                    binding.loadingText.visibility = View.VISIBLE
                    binding.loadingText.text = "网络连接错误，请检查网络设置"
                    Toast.makeText(this@TvActivity, "网络连接错误", Toast.LENGTH_LONG).show()
                }
                
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return false
                }
            }
            
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    binding.progressBar.progress = newProgress
                }
            }
        }
    }
    
    private fun loadWebsite() {
        binding.webView.loadUrl(targetUrl)
    }
    
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK, KeyEvent.KEYCODE_ESCAPE -> {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                    return true
                }
            }
            KeyEvent.KEYCODE_MENU -> {
                binding.webView.reload()
                return true
            }
            KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER -> {
                // 让WebView处理确认键
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }
    
    override fun onDestroy() {
        binding.webView.destroy()
        super.onDestroy()
    }
}