package com.netmite.andme.launcher.thomsons_touch;

import android.os.Bundle;
import com.netmite.andme.launcher.Launcher2;

public class Tomsons
  extends Launcher2
{
  public Tomsons() {}
  
  public void onCreate(Bundle paramBundle)
  {
    launchinpackageprocess = false;
    setParameter("launcher_midleturl", "/data/test/2.0/upload/doby.jar");
    setParameter("launcherpackagename", "com.netmite.andme.launcher.thomsons_touch");
    setParameter("launcherclassname", "Tomsons");
    setMidletInfo("http://www.netmite.com/android/srv/2.0/upload/doby.jar", 1, "Thomsons _ Touch", "/icon.png", "Tomsons");
    super.onCreate(paramBundle);
  }
}
