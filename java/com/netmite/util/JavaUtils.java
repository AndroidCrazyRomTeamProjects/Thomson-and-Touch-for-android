package com.netmite.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaUtils
{
  public JavaUtils() {}
  
  public static String dumpObject(Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    Class localClass = paramObject.getClass();
    if (localClass == null)
    {
      localStringBuffer.append("}");
      return localStringBuffer.toString();
    }
    Field[] arrayOfField = localClass.getDeclaredFields();
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfField.length)
      {
        localClass = localClass.getSuperclass();
        break;
      }
      if (localStringBuffer.length() > 1) {
        localStringBuffer.append(",");
      }
      arrayOfField[i].setAccessible(true);
      localStringBuffer.append(arrayOfField[i].getName());
      localStringBuffer.append("=");
      try
      {
        localStringBuffer.append(arrayOfField[i].get(paramObject));
        i++;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;) {}
      }
    }
  }
  
  public static Object getField(Object paramObject, String paramString)
  {
    Object localObject = null;
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = localClass.getField(paramString).get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        Debug.debug(paramObject);
        paramObject = localObject;
      }
    }
  }
  
  /* Error */
  public static Object invokeAPIByMethodName(String paramString, Class paramClass1, Object paramObject1, Class paramClass2, Object paramObject2)
    throws Exception
  {
    // Byte code:
    //   0: ldc 2
    //   2: new 82	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 84
    //   8: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 47
    //   17: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: ldc 47
    //   26: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: ldc 47
    //   35: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: ldc 47
    //   44: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload 4
    //   49: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 97	com/netmite/util/Debug:debug	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   58: aload_3
    //   59: ifnonnull +35 -> 94
    //   62: iconst_0
    //   63: anewarray 34	java/lang/Class
    //   66: astore 5
    //   68: aload_1
    //   69: aload_0
    //   70: aload 5
    //   72: invokevirtual 101	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   75: astore_1
    //   76: aload_3
    //   77: ifnonnull +31 -> 108
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: astore_0
    //   85: aload_1
    //   86: aload_2
    //   87: aload_0
    //   88: invokevirtual 107	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   91: astore_0
    //   92: aload_0
    //   93: areturn
    //   94: iconst_1
    //   95: anewarray 34	java/lang/Class
    //   98: astore 5
    //   100: aload 5
    //   102: iconst_0
    //   103: aload_3
    //   104: aastore
    //   105: goto -37 -> 68
    //   108: iconst_1
    //   109: anewarray 4	java/lang/Object
    //   112: astore_0
    //   113: aload_0
    //   114: iconst_0
    //   115: aload 4
    //   117: aastore
    //   118: goto -33 -> 85
    //   121: astore_0
    //   122: aload_0
    //   123: invokestatic 78	com/netmite/util/Debug:debug	(Ljava/lang/Object;)V
    //   126: aload_0
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   0	128	1	paramClass1	Class
    //   0	128	2	paramObject1	Object
    //   0	128	3	paramClass2	Class
    //   0	128	4	paramObject2	Object
    //   66	35	5	arrayOfClass	Class[]
    // Exception table:
    //   from	to	target	type
    //   68	76	121	java/lang/Exception
    //   80	85	121	java/lang/Exception
    //   85	92	121	java/lang/Exception
    //   108	113	121	java/lang/Exception
  }
  
  public static Object invokeAPIByMethodNameCatch(String paramString, Class paramClass1, Object paramObject1, Class paramClass2, Object paramObject2)
  {
    Object localObject = null;
    try
    {
      paramString = invokeAPIByMethodName(paramString, paramClass1, paramObject1, paramClass2, paramObject2);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      Debug.debug(paramString);
      throw paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Debug.debug(paramString);
        paramString = localObject;
      }
    }
  }
  
  public static Object invokeAPIByMethodNameCatch2(String paramString, Class paramClass, Object paramObject, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject = null;
    try
    {
      paramString = paramClass.getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      Debug.debug(paramString);
      throw paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Debug.debug(paramString);
        paramString = localObject;
      }
    }
  }
}
