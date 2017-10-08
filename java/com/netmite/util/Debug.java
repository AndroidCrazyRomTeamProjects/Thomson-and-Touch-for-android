package com.netmite.util;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Vector;

public class Debug
{
  private static final String TAG = "@@@ERR";
  static Hashtable aligns = new Hashtable();
  static StringBuffer buffer;
  static Vector debugMatchVector;
  static int debugMatchVectorlen;
  static String debugThread;
  public static boolean debugon = true;
  static PrintStream outstream;
  
  static
  {
    debugThread = null;
    debugMatchVector = null;
    debugMatchVectorlen = 0;
    buffer = null;
  }
  
  public Debug() {}
  
  public static int addMatchVector(Object paramObject)
  {
    if (debugMatchVector == null) {
      debugMatchVector = new Vector();
    }
    if ((paramObject instanceof Class)) {
      paramObject = ((Class)paramObject).getName();
    }
    for (;;)
    {
      if (!debugMatchVector.contains(paramObject)) {
        debugMatchVector.add(paramObject);
      }
      debugMatchVectorlen = debugMatchVector.size();
      return debugMatchVectorlen;
      if ((paramObject instanceof String)) {
        paramObject = (String)paramObject;
      } else {
        paramObject = paramObject.getClass().getName();
      }
    }
  }
  
  public static void clearMatchVector()
  {
    if (debugMatchVector != null) {
      debugMatchVector.clear();
    }
  }
  
  public static void debug(int paramInt)
  {
    if (!debugon) {}
    for (;;)
    {
      return;
      Thread localThread = Thread.currentThread();
      Object localObject2 = (String)aligns.get(localThread);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramInt = (short)paramInt;
      localObject2 = localObject1;
      if (paramInt > 0) {
        localObject2 = localObject1 + " ";
      }
      log("[" + localThread.getName() + "]:" + (String)localObject2 + paramInt);
      localObject1 = localObject2;
      if (paramInt < 0)
      {
        paramInt = ((String)localObject2).length();
        localObject1 = localObject2;
        if (paramInt > 0) {
          localObject1 = ((String)localObject2).substring(0, paramInt - 1);
        }
      }
      aligns.put(localThread, localObject1);
    }
  }
  
  public static void debug(Object paramObject)
  {
    debug(null, paramObject);
  }
  
  public static void debug(Object paramObject1, Object paramObject2)
  {
    if ((!debugon) && (!(paramObject2 instanceof Throwable))) {
      return;
    }
    for (;;)
    {
      label13:
      String str;
      label22:
      Object localObject1;
      Object localObject2;
      if (paramObject2 == null)
      {
        str = "null";
        localObject1 = "";
        localObject2 = str;
        if (paramObject1 != null)
        {
          if (!(paramObject1 instanceof Class)) {
            break label225;
          }
          localObject1 = ((Class)paramObject1).getName();
          label50:
          i = ((String)localObject1).lastIndexOf('.');
          localObject2 = localObject1;
          if (i > 0) {
            localObject2 = ((String)localObject1).substring(i + 1);
          }
          localObject2 = localObject2 + "::" + str;
        }
        if ((debugMatchVector == null) || (paramObject1 == null)) {}
      }
      label225:
      label303:
      label305:
      label316:
      for (int i = 0;; i++)
      {
        if (i >= debugMatchVectorlen) {
          j = i;
        }
        for (;;)
        {
          if ((j == debugMatchVectorlen) && (!(paramObject2 instanceof Throwable))) {
            break label303;
          }
          if (!(paramObject2 instanceof Throwable)) {
            break label322;
          }
          paramObject1 = (Throwable)paramObject2;
          localObject1 = new ByteArrayOutputStream();
          paramObject2 = new PrintStream((OutputStream)localObject1);
          paramObject1.printStackTrace(paramObject2);
          paramObject2.close();
          paramObject1 = new String(((ByteArrayOutputStream)localObject1).toByteArray());
          log(localObject2 + paramObject1);
          break;
          str = paramObject2.toString();
          break label22;
          if ((paramObject1 instanceof String))
          {
            localObject1 = (String)paramObject1;
            break label50;
          }
          localObject1 = paramObject1.getClass().getName();
          break label50;
          paramObject1 = (String)debugMatchVector.get(i);
          j = i;
          if (!paramObject1.equals("*"))
          {
            if (paramObject1.charAt(0) != '~') {
              break label305;
            }
            if (((String)localObject2).indexOf(paramObject1.substring(1)) < 0) {
              break label316;
            }
            j = debugMatchVectorlen;
          }
        }
        break label13;
        int j = i;
        if (((String)localObject1).indexOf(paramObject1) >= 0) {
          break;
        }
      }
      label322:
      if (debugon) {
        log(localObject2);
      }
    }
  }
  
  public static void flush()
  {
    char[] arrayOfChar;
    if (buffer != null) {
      arrayOfChar = new char['Ȁ'];
    }
    for (;;)
    {
      int j = buffer.length();
      if (j <= 0)
      {
        buffer = new StringBuffer();
        return;
      }
      int i = j;
      if (j > 512) {
        i = 512;
      }
      buffer.getChars(0, i, arrayOfChar, 0);
      buffer.delete(0, i);
      Log.v("@@@ERR", new String(arrayOfChar, 0, i));
    }
  }
  
  public static boolean isDebugOn()
  {
    return debugon;
  }
  
  public static void log(Object paramObject)
  {
    log(null, paramObject);
  }
  
  public static void log(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {}
    for (;;)
    {
      return;
      paramObject2 = paramObject2.toString();
      paramObject1 = Thread.currentThread().getName();
      if ((debugThread == null) || (debugThread.indexOf(paramObject1) >= 0))
      {
        paramObject1 = "[" + paramObject1 + "]:" + paramObject2;
        if (outstream != null)
        {
          outstream.println(paramObject1);
        }
        else if (buffer != null)
        {
          buffer.append(paramObject1);
          buffer.append('\n');
        }
        else
        {
          Log.v("@@@ERR", paramObject1);
        }
      }
    }
  }
  
  public static void printStackTrace(Throwable paramThrowable)
  {
    debug(paramThrowable);
  }
  
  public static void println(String paramString)
  {
    debug(paramString);
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    debugon = paramBoolean;
  }
  
  public static void setOut(PrintStream paramPrintStream)
  {
    outstream = paramPrintStream;
  }
  
  public static boolean toggle()
  {
    if (debugon) {}
    for (boolean bool = false;; bool = true)
    {
      debugon = bool;
      log("debugon=" + debugon);
      return debugon;
    }
  }
}
