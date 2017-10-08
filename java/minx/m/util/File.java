package minx.m.util;

public class File
{
  public File() {}
  
  /* Error */
  public byte[] read(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: checkcast 15	[B
    //   10: astore 5
    //   12: aload 6
    //   14: astore 4
    //   16: aload 5
    //   18: astore_3
    //   19: aload 7
    //   21: astore_2
    //   22: aload_0
    //   23: invokevirtual 19	java/lang/Object:getClass	()Ljava/lang/Class;
    //   26: pop
    //   27: aload 6
    //   29: astore 4
    //   31: aload 5
    //   33: astore_3
    //   34: aload 7
    //   36: astore_2
    //   37: aload_1
    //   38: invokestatic 25	javax/microedition/lcdui/Display:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   41: astore_1
    //   42: aload_1
    //   43: astore 4
    //   45: aload 5
    //   47: astore_3
    //   48: aload_1
    //   49: astore_2
    //   50: aload_1
    //   51: invokevirtual 31	java/io/InputStream:available	()I
    //   54: newarray byte
    //   56: astore 5
    //   58: aload_1
    //   59: astore 4
    //   61: aload 5
    //   63: astore_3
    //   64: aload_1
    //   65: astore_2
    //   66: aload_1
    //   67: aload 5
    //   69: invokevirtual 34	java/io/InputStream:read	([B)I
    //   72: pop
    //   73: aload_1
    //   74: astore 4
    //   76: aload 5
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 37	java/io/InputStream:close	()V
    //   85: aload 5
    //   87: astore_3
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 37	java/io/InputStream:close	()V
    //   96: aload_3
    //   97: areturn
    //   98: astore_1
    //   99: aload 4
    //   101: ifnull +8 -> 109
    //   104: aload 4
    //   106: invokevirtual 37	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: athrow
    //   111: astore_2
    //   112: goto -3 -> 109
    //   115: astore_1
    //   116: goto -20 -> 96
    //   119: astore_1
    //   120: aload_2
    //   121: astore_1
    //   122: goto -34 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	File
    //   0	125	1	paramString	String
    //   21	60	2	localObject1	Object
    //   111	10	2	localException	Exception
    //   18	79	3	arrayOfByte1	byte[]
    //   14	91	4	localObject2	Object
    //   10	76	5	arrayOfByte2	byte[]
    //   4	24	6	localObject3	Object
    //   1	34	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   22	27	98	finally
    //   37	42	98	finally
    //   50	58	98	finally
    //   66	73	98	finally
    //   81	85	98	finally
    //   104	109	111	java/lang/Exception
    //   92	96	115	java/lang/Exception
    //   22	27	119	java/lang/Exception
    //   37	42	119	java/lang/Exception
    //   50	58	119	java/lang/Exception
    //   66	73	119	java/lang/Exception
    //   81	85	119	java/lang/Exception
  }
}
