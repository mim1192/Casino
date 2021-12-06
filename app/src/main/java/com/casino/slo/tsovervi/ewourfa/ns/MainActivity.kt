package com.casino.slo.tsovervi.ewourfa.ns

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.net.URL


class MainActivity : AppCompatActivity() {
    var baseUrl = "https://wefefkoli.tech/wefe.php?kh=34&l=kl&we"
    var materialDesignFAM: FloatingActionMenu? = null

    var Wunderino: FloatingActionButton? = null
    var Bwin: FloatingActionButton? = null
    var Slottica: FloatingActionButton? = null
    var Leovegas: FloatingActionButton? = null
    var Wplay: FloatingActionButton? = null
    var contact: FloatingActionButton? = null
    var share: FloatingActionButton? = null
    var activity: Activity? = null
    private var progDailog: ProgressDialog? = null
    private val progressBar: ProgressDialog? = null
    private var webView: WebView? = null
    private var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*if (savedInstanceState != null)
            ((WebView) findViewById(R.id.webview)).restoreState(savedInstanceState.getBundle("webViewState"));*/
        /*if (savedInstanceState != null)
            ((WebView) findViewById(R.id.webview)).restoreState(savedInstanceState.getBundle("webViewState"));*/
        inIt()
        //progressBar = ProgressDialog.show(this, getResources().getString(R.string.player_wait), getResources().getString(R.string.loading));

        //  CompleteloadWebView();

        //progressBar = ProgressDialog.show(this, getResources().getString(R.string.player_wait), getResources().getString(R.string.loading));

        //  CompleteloadWebView();

        activity = this;

        progDailog = ProgressDialog.show(activity, "Loading", "Please wait...", true);
        progDailog!!.setCancelable(false);
        if (Build.VERSION.SDK_INT < 18) {
            webView!!.clearView();
        } else {
            webView!!.loadUrl("about:blank");
        }
        webView!!.settings.javaScriptEnabled = true
        webView!!.settings.setSaveFormData(false);
        webView!!.settings.setSavePassword(false);
        CookieManager.getInstance().setAcceptCookie(false)
        /*  webView!!.settings.setSupportZoom(true)
          webView!!.settings.builtInZoomControls = true
          webView!!.settings.textZoom
          webView!!.settings.displayZoomControls = true*/
        //   webView!!.settings.setUseWideViewPort(true);

        webView!!.setInitialScale(100)
        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                progDailog!!.show()
                if (url.contains("https://wefefkoli.tech/")) {

                    view.loadUrl(url)
                    return true

                } else {
                    progDailog!!.dismiss()
                    openBrowser(url);
                    return true
                }
            }

            override fun onPageFinished(view: WebView, url: String) {
                progDailog!!.dismiss()
            }
        }

        webView!!.loadUrl(baseUrl);

        /*   webView!!.settings.javaScriptEnabled = true
           webView!!.settings.setSaveFormData(false);
           webView!!.settings.setSavePassword(false);
           CookieManager.getInstance().setAcceptCookie(false)
           webView!!.settings.setSupportZoom(true)
           webView!!.settings.builtInZoomControls = true
           webView!!.settings.textZoom
           webView!!.settings.displayZoomControls = true
           *//*  webView!!.settings.setLoadWithOverviewMode(true);
          webView!!.settings.setUseWideViewPort(true);*//*

        webView!!.setInitialScale(100)

        webView!!.loadUrl(baseUrl)*/ // URL hardcoded


        Wunderino!!.setOnClickListener {
            webView!!.loadUrl("https://wefefkoli.tech/review11/review11.html?page=1");
            // openBrowser("https://wefefkoli.tech/review11/review11.html?page=1");
        }
        Bwin!!.setOnClickListener {
            webView!!.loadUrl("https://wefefkoli.tech/review11/review11.html?page=1");
            // openBrowser("https://wefefkoli.tech/review12/review12.html?page=1");
        }
        Slottica!!.setOnClickListener {
            webView!!.loadUrl("https://wefefkoli.tech/review13/review13.html?page=1");
        }


        Leovegas!!.setOnClickListener {
            webView!!.loadUrl("https://wefefkoli.tech/review14/review14.html?page=1");
            // openBrowser("https://wefefkoli.tech/review14/review14.html?page=1");
        }
        Wplay!!.setOnClickListener {
            webView!!.loadUrl("https://wefefkoli.tech/review12/review12.html?page=1");
            //openBrowser("https://wefefkoli.tech/review12/review12.html?page=1");

        }
        contact!!.setOnClickListener {


        }
        share!!.setOnClickListener {
            Clicked()
        }
    }

    fun Clicked() {
        /* ACTION_SEND: Deliver some data to someone else.
        createChooser (Intent target, CharSequence title): Here, target- The Intent that the user will be selecting an activity to perform.
            title- Optional title that will be displayed in the chooser.
        Intent.EXTRA_TEXT: A constant CharSequence that is associated with the Intent, used with ACTION_SEND to supply the literal data to be sent.
        */
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(
            Intent.EXTRA_TEXT,
            "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
        )
        sendIntent.type = "text/plain"
        startActivity(sendIntent)
    }

    private fun openBrowser(url_: String) {
        val uri: Uri = Uri.parse(url_) // missing 'http://' will cause crashed

        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun inIt() {
        webView = findViewById(R.id.webview)

        bottomNavigationView = findViewById(R.id.bottom_navigation) as BottomNavigationView
        materialDesignFAM = findViewById(R.id.material_design_android_floating_action_menu);
        Wunderino = findViewById(R.id.Wunderino);
        Bwin = findViewById(R.id.Bwin);
        Slottica = findViewById(R.id.Slottica);
        Wplay = findViewById(R.id.Wplay);
        contact = findViewById(R.id.contact);
        share = findViewById(R.id.share);
        Leovegas = findViewById(R.id.Leovegas);

    }

    private fun CompleteloadWebView() {
        webView!!.settings.javaScriptEnabled = true
        webView!!.settings.setSupportZoom(true)
        webView!!.settings.builtInZoomControls = true
        webView!!.settings.displayZoomControls = true
        webView!!.settings.loadsImagesAutomatically = true
        webView!!.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        /*cookies*/CookieManager.getInstance().setAcceptCookie(false)
        webView!!.settings.domStorageEnabled = true
        webView!!.settings.databaseEnabled = true
        webView!!.settings.allowFileAccess = true
        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldInterceptRequest(view: WebView, url: String): WebResourceResponse? {
                return if (url.startsWith("https://wefefkoli.tech")) {
                    if (progressBar!!.isShowing) {
                        progressBar.dismiss()
                    }
                    try {
                        val cu = URL(url)
                        val con = cu.openConnection()
                        val `is` = con.getInputStream()
                        WebResourceResponse(null, null, `is`)
                    } catch (e: Exception) {
                        // Log.e("HTTP", "unable to query " + queryUrl + ": " + e);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            WebResourceResponse(null, null, 404, e.localizedMessage, null, null)
                        } else {
                            TODO("VERSION.SDK_INT < LOLLIPOP")
                        }
                    }
                } else {
                    if (progressBar!!.isShowing) {
                        progressBar.dismiss()
                    }
                    super.shouldInterceptRequest(view, url)
                }
            }
        }
        webView!!.webChromeClient = WebChromeClient()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        //we fake some http url to allow xml http requests
        if (progressBar!!.isShowing) {
            progressBar.dismiss()
        }
        webView!!.loadUrl(baseUrl)
    }

    private fun CompleteloadWebView_() {
        webView!!.settings.javaScriptEnabled = true
        webView!!.settings.setSupportZoom(true)
        webView!!.settings.builtInZoomControls = true
        webView!!.settings.displayZoomControls = true
        webView!!.settings.loadsImagesAutomatically = true
        webView!!.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        /*cookies*/CookieManager.getInstance().setAcceptCookie(false)
        webView!!.settings.domStorageEnabled = true
        webView!!.settings.databaseEnabled = true
        webView!!.settings.allowFileAccess = true
        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldInterceptRequest(view: WebView, url: String): WebResourceResponse? {
                return if (url.startsWith("https://wefefkoli.tech")) {
                    if (progressBar!!.isShowing) {
                        progressBar.dismiss()
                    }
                    try {
                        val cu = URL(url)
                        val con = cu.openConnection()
                        val `is` = con.getInputStream()
                        WebResourceResponse(null, null, `is`)
                    } catch (e: Exception) {
                        // Log.e("HTTP", "unable to query " + queryUrl + ": " + e);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            WebResourceResponse(null, null, 404, e.localizedMessage, null, null)
                        } else {
                            TODO("VERSION.SDK_INT < LOLLIPOP")
                        }
                    }
                } else {
                    if (progressBar!!.isShowing) {
                        progressBar.dismiss()
                    }
                    super.shouldInterceptRequest(view, url)
                }
            }
        }
        webView!!.webChromeClient = WebChromeClient()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        //we fake some http url to allow xml http requests
        if (progressBar!!.isShowing) {
            progressBar.dismiss()
        }
        webView!!.loadUrl(baseUrl)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}