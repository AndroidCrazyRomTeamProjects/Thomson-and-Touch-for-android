package com.netmite.andme.test;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.netmite.util.Debug;

public class TestContact
{
  public TestContact()
  {
    int i = Process.myPid();
    Debug.debug("TestContact, pid=" + i);
  }
  
  public void testAddContact2(Context paramContext)
  {
    Debug.debug("testAddContact2(" + paramContext);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.netmite.andme.launcher.pdapdemo", "com.netmite.andme.launcher.Launcher2");
    Debug.debug("intent=" + localIntent);
    paramContext.startActivity(localIntent);
  }
}
