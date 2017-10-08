package com.netmite.andme.launcher;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.netmite.util.Debug;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Launcher
  extends Activity
{
  Intent intent;
  String midletclass = "";
  String midleticon = "";
  String midletname = "Midlet";
  int midletnum = 1;
  String midleturl = "";
  HashMap<String, String> parameters = new HashMap();
  Bundle savedInstanceState;
  
  public Launcher()
  {
    parameters.put("launcher_installer_title", "NOTE");
    parameters.put("launcher_installer_installmsg", "This application requires J2ME Runner.Please download J2ME Runner First (Required only the very first time).");
    parameters.put("launcher_installer_upgrademsg", "J2ME Runner version [{versionCode}/{versionName}] too old to run this Application.Please upgrade J2ME Runner.");
    parameters.put("launcher_installer_url-1", "http://www.netmite.com/android/andme_signed.apk");
    parameters.put("launcher_installer_buttontext-1", "Get from Netmite (Suggested)");
    parameters.put("launcher_installer_url-2", "market://search?q=pname:com.netmite.andme");
    parameters.put("launcher_installer_buttontext-2", "Get from Android Market");
  }
  
  void downloadJ2MERunner(String paramString)
  {
    DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        startGetRunner(paramAnonymousInt);
        finishAndKill();
      }
    };
    Object localObject = new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        finish();
      }
    };
    localObject = new AlertDialog.Builder(this).setTitle(getParameter("launcher_installer_title")).setOnCancelListener((DialogInterface.OnCancelListener)localObject).setMessage(paramString).create();
    int[] arrayOfInt = new int[3];
    int[] tmp58_56 = arrayOfInt;
    tmp58_56[0] = -1;
    int[] tmp62_58 = tmp58_56;
    tmp62_58[1] = -2;
    int[] tmp67_62 = tmp62_58;
    tmp67_62[2] = -3;
    tmp67_62;
    for (int i = 0;; i++)
    {
      if (i >= arrayOfInt.length)
      {
        ((AlertDialog)localObject).show();
        return;
      }
      int j = arrayOfInt[i];
      paramString = "launcher_installer_buttontext" + j;
      String str = getParameter(paramString);
      Debug.debug(this, "key=" + paramString);
      Debug.debug(this, "text=" + str);
      if (str != null) {
        ((AlertDialog)localObject).setButton(j, str, local1);
      }
    }
  }
  
  public void finishAndKill()
  {
    finish();
    Process.killProcess(Process.myPid());
  }
  
  public String getParameter(String paramString)
  {
    return (String)parameters.get(paramString);
  }
  
  void launch(Bundle paramBundle)
  {
    try
    {
      startRunner(paramBundle);
      finish();
      return;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      for (;;)
      {
        Debug.debug(paramBundle);
        downloadJ2MERunner(getParameter("launcher_installer_installmsg"));
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Debug.debug(paramBundle);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    savedInstanceState = paramBundle;
    getIntent().getExtras();
    launch(paramBundle);
  }
  
  public void prepareIntent()
  {
    intent = new Intent();
    intent.setAction("android.intent.action.MAIN");
    intent.addCategory("android.intent.category.LAUNCHER");
    intent.setClassName("com.netmite.andme", "com.netmite.andme.MIDletRunner");
    Object localObject1 = getPackageCodePath();
    Object localObject2 = Uri.parse((String)localObject1);
    intent.setData((Uri)localObject2);
    intent.setType("application/vnd.android.package-archive");
    intent.putExtra("midleturl", midleturl);
    intent.putExtra("midletapkpath", (String)localObject1);
    if (midletclass != null) {
      intent.putExtra("midletclass", midletclass);
    }
    localObject1 = parameters.keySet();
    Debug.debug("parameters.size=" + parameters.size());
    localObject2 = ((Set)localObject1).iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        return;
      }
      String str = (String)((Iterator)localObject2).next();
      localObject1 = (String)parameters.get(str);
      Debug.debug("   (" + str + "," + (String)localObject1 + ")");
      intent.putExtra(str, (String)localObject1);
    }
  }
  
  public void setMidletInfo(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    midleturl = paramString1;
    midletnum = paramInt;
    midletname = paramString2;
    midleticon = paramString3;
    midletclass = paramString4;
  }
  
  public void setParameter(String paramString1, String paramString2)
  {
    parameters.put(paramString1, paramString2);
  }
  
  public void startGetRunner(int paramInt)
  {
    intent = new Intent("android.intent.action.VIEW");
    Uri localUri = Uri.parse(getParameter("launcher_installer_url" + paramInt));
    intent.setData(localUri);
    startActivity(intent);
  }
  
  void startRunner(Bundle paramBundle)
    throws Exception
  {
    prepareIntent();
    startActivity(intent);
  }
}
