package com.netmite.andme.launcher;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.netmite.util.Debug;
import com.netmite.util.JavaUtils;
import java.io.PrintStream;
import java.util.HashMap;

public class Launcher2
  extends Launcher
{
  Context andmecontext;
  ClassLoader clloader;
  public boolean launchinpackageprocess = false;
  Class m_runnerclass;
  Activity m_runnerobj;
  
  public Launcher2()
  {
    int i = Process.myPid();
    Debug.debug(this, "Launcher2, xpid=" + i);
  }
  
  boolean checkRunnerVersion()
  {
    bool2 = true;
    Object localObject1 = getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject1).getPackageInfo("com.netmite.andme", 0);
        localObject2 = (String)parameters.get("launcher_runner_versioncoderequired");
        localObject3 = System.out;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("launcher_runner_runnerversioncoderequired=");
        ((PrintStream)localObject3).println((String)localObject2);
        bool1 = bool2;
        if (localObject2 == null) {}
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Object localObject2;
        Object localObject3;
        int i;
        Debug.debug(localNameNotFoundException);
        downloadJ2MERunner(getParameter("launcher_installer_installmsg"));
        boolean bool1 = false;
        continue;
      }
      try
      {
        i = Integer.parseInt((String)localObject2);
        localObject2 = System.out;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("pkginfo.versionCode=");
        ((PrintStream)localObject2).println(versionCode);
        bool1 = bool2;
        if (versionCode > 0)
        {
          bool1 = bool2;
          if (versionCode < i)
          {
            localObject2 = getParameter("launcher_installer_upgrademsg");
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            localObject3 = ((String)localObject2).replace("{versionCode}", versionCode);
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            downloadJ2MERunner(((String)localObject3).replace("{versionName}", versionName));
            bool1 = false;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Debug.debug(localNumberFormatException);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public String getApkPath()
  {
    return getPackageCodePath();
  }
  
  public String getAppClass()
  {
    return midletclass;
  }
  
  public String getAppName()
  {
    return midletname;
  }
  
  public String getAppUrl()
  {
    return midleturl;
  }
  
  public Resources getResources()
  {
    Debug.debug(this, "getResources()");
    if (andmecontext != null) {}
    for (Resources localResources = andmecontext.getResources();; localResources = super.getResources())
    {
      Debug.debug(this, "getResources()=" + localResources);
      return localResources;
    }
  }
  
  public Resources getResources2()
  {
    return super.getResources();
  }
  
  public void launch(Bundle paramBundle)
  {
    Debug.debug(this, "Launcher2.launch()");
    Intent localIntent = getIntent();
    if (!checkRunnerVersion()) {}
    for (;;)
    {
      return;
      launchinpackageprocess |= localIntent.hasCategory("android.intent.category.ALTERNATIVE");
      Debug.debug(this, "launchinpackageprocess=" + launchinpackageprocess);
      if (launchinpackageprocess) {
        launch2(paramBundle);
      } else {
        super.launch(paramBundle);
      }
    }
  }
  
  public void launch2(Bundle paramBundle)
  {
    Debug.debug(this, "Launcher2.launch2(" + paramBundle);
    try
    {
      andmecontext = createPackageContext("com.netmite.andme", 3);
      paramBundle = new java/lang/StringBuilder;
      paramBundle.<init>("andmecontext=");
      Debug.debug(this, andmecontext);
      clloader = getClassLoader();
      paramBundle = new java/lang/StringBuilder;
      paramBundle.<init>("my clloader=");
      Debug.debug(this, clloader);
      clloader = andmecontext.getClassLoader();
      m_runnerclass = clloader.loadClass("com.netmite.andme.MIDletRunner");
      m_runnerobj = ((Activity)m_runnerclass.newInstance());
      paramBundle = new java/lang/StringBuilder;
      paramBundle.<init>("m_runnerobj=");
      Debug.debug(this, m_runnerobj);
      JavaUtils.invokeAPIByMethodName("setContext", m_runnerclass, m_runnerobj, Context.class, andmecontext);
      JavaUtils.invokeAPIByMethodName("setActivity", m_runnerclass, m_runnerobj, Activity.class, this);
      prepareIntent();
      JavaUtils.invokeAPIByMethodName("setIntent", m_runnerclass, m_runnerobj, Intent.class, intent);
      Debug.debug(this, "before onCreate");
      JavaUtils.invokeAPIByMethodName("onCreate", m_runnerclass, m_runnerobj, Bundle.class, savedInstanceState);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Debug.debug(paramBundle);
        finishAndKill();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Debug.debug(this, "onActivityResult(" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    if (m_runnerobj != null)
    {
      Class localClass1 = Integer.TYPE;
      Class localClass2 = Integer.TYPE;
      Integer localInteger2 = new Integer(paramInt1);
      Integer localInteger1 = new Integer(paramInt2);
      JavaUtils.invokeAPIByMethodNameCatch2("onActivityResult", m_runnerclass, m_runnerobj, new Class[] { localClass1, localClass2, Intent.class }, new Object[] { localInteger2, localInteger1, paramIntent });
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Debug.debug(this, "onConfigurationChanged(" + paramConfiguration);
    if (m_runnerobj != null) {
      m_runnerobj.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    Debug.debug(this, "onContextItemSelected(" + paramMenuItem);
    boolean bool = false;
    if (m_runnerobj != null) {
      bool = m_runnerobj.onContextItemSelected(paramMenuItem);
    }
    return bool;
  }
  
  public void onContextMenuClosed(Menu paramMenu)
  {
    Debug.debug(this, "onContextMenuClosed(" + paramMenu);
    if (m_runnerobj != null) {
      m_runnerobj.onContextMenuClosed(paramMenu);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Process.myPid();
    super.onCreate(paramBundle);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Debug.debug(this, "onCreateContextMenu(" + paramContextMenu + "," + paramView + "," + paramContextMenuInfo);
    if (m_runnerobj != null) {
      m_runnerobj.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    Debug.debug(this, "Launcher2, onCreateDialog(" + paramInt + ")");
    Dialog localDialog = null;
    if (m_runnerobj != null) {
      localDialog = (Dialog)JavaUtils.invokeAPIByMethodNameCatch("onCreateDialog", m_runnerclass, m_runnerobj, Integer.TYPE, new Integer(paramInt));
    }
    return localDialog;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    Debug.debug(this, "onCreateOptionsMenu(" + paramMenu);
    boolean bool = false;
    if (m_runnerobj != null) {
      bool = m_runnerobj.onCreateOptionsMenu(paramMenu);
    }
    return bool;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    Debug.debug(this, "onCreateView(" + paramString + "," + paramContext + "," + paramAttributeSet + ")");
    View localView = null;
    if (m_runnerobj != null) {
      localView = m_runnerobj.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  public void onDestroy()
  {
    Debug.debug(this, "onDestroy()");
    super.onDestroy();
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onDestroy", m_runnerclass, m_runnerobj, null, null);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Debug.debug(this, "onKeyDown(" + paramInt + "," + paramKeyEvent + ")");
    boolean bool1 = false;
    if (m_runnerobj != null)
    {
      boolean bool2 = m_runnerobj.onKeyDown(paramInt, paramKeyEvent);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = super.onKeyDown(paramInt, paramKeyEvent);
        Debug.debug(this, "super.onKeyDown()=" + bool1);
      }
    }
    return bool1;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    Debug.debug(this, "onKeyMultiple(" + paramInt1 + "," + paramInt2 + "," + paramKeyEvent + ")");
    boolean bool1 = false;
    if (m_runnerobj != null)
    {
      boolean bool2 = m_runnerobj.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
      bool1 = bool2;
      if (!bool2) {
        bool1 = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
      }
    }
    return bool1;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    Debug.debug(this, "onKeyUp(" + paramInt + "," + paramKeyEvent + ")");
    boolean bool1 = false;
    if (m_runnerobj != null)
    {
      boolean bool2 = m_runnerobj.onKeyUp(paramInt, paramKeyEvent);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = super.onKeyUp(paramInt, paramKeyEvent);
        Debug.debug(this, "super.onKeyUp()=" + bool1);
      }
    }
    return bool1;
  }
  
  public void onLowMemory()
  {
    Debug.debug(this, "onLowMemory()");
    if (m_runnerobj != null) {
      m_runnerobj.onLowMemory();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Debug.debug(this, "onNewIntent(" + paramIntent);
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onNewIntent", m_runnerclass, m_runnerobj, Intent.class, paramIntent);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Debug.debug(this, "onOptionsItemSelected(" + paramMenuItem);
    boolean bool = false;
    if (m_runnerobj != null) {
      bool = m_runnerobj.onOptionsItemSelected(paramMenuItem);
    }
    return bool;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu)
  {
    Debug.debug(this, "onOptionsMenuClosed(" + paramMenu);
    if (m_runnerobj != null) {
      m_runnerobj.onOptionsMenuClosed(paramMenu);
    }
  }
  
  public void onPause()
  {
    Debug.debug(this, "onPause()");
    super.onPause();
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onPause", m_runnerclass, m_runnerobj, null, null);
    }
  }
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    Debug.debug(this, "onPrepareDialog(" + paramInt + "," + paramDialog);
    if (m_runnerobj != null)
    {
      Class localClass = Integer.TYPE;
      Integer localInteger = new Integer(paramInt);
      JavaUtils.invokeAPIByMethodNameCatch2("onPrepareDialog", m_runnerclass, m_runnerobj, new Class[] { localClass, Dialog.class }, new Object[] { localInteger, paramDialog });
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    Debug.debug(this, "onPrepareOptionsMenu(" + paramMenu);
    boolean bool = false;
    if (m_runnerobj != null) {
      bool = m_runnerobj.onPrepareOptionsMenu(paramMenu);
    }
    return bool;
  }
  
  public void onRestart()
  {
    Debug.debug(this, "onRestart()");
    super.onRestart();
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onRestart", m_runnerclass, m_runnerobj, null, null);
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    Debug.debug(this, "onRestoreInstanceState(" + paramBundle);
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onRestoreInstanceState", m_runnerclass, m_runnerobj, Bundle.class, paramBundle);
    }
  }
  
  public void onResume()
  {
    Debug.debug(this, "onResume()");
    super.onResume();
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onResume", m_runnerclass, m_runnerobj, null, null);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Debug.debug(this, "onSaveInstanceState()");
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onSaveInstanceState", m_runnerclass, m_runnerobj, Bundle.class, paramBundle);
    }
  }
  
  public void onStart()
  {
    Debug.debug(this, "onStart()");
    super.onStart();
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onStart", m_runnerclass, m_runnerobj, null, null);
    }
  }
  
  public void onStop()
  {
    Debug.debug(this, "onStop()");
    super.onStop();
    if (m_runnerobj != null) {
      JavaUtils.invokeAPIByMethodNameCatch("onStop", m_runnerclass, m_runnerobj, null, null);
    }
  }
}
