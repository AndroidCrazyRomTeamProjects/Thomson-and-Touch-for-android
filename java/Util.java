import java.util.Calendar;
import java.util.Random;

public class Util
{
  Random random = new Random();
  
  public Util() {}
  
  public int getBytesToInt(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return (paramByte1 & 0xFF) << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  public int getBytesToInt(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  public byte[] getIntToBytes(int paramInt)
  {
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF00 & paramInt) >> 8), (byte)(paramInt & 0xFF) };
  }
  
  public int getRandomInt(int paramInt1, int paramInt2)
  {
    return (random.nextInt() >>> 1) % (paramInt2 - paramInt1) + paramInt1;
  }
  
  public String getToday()
  {
    Object localObject = Calendar.getInstance();
    int k = ((Calendar)localObject).get(1);
    int i = ((Calendar)localObject).get(2) + 1;
    int j = ((Calendar)localObject).get(5);
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = localStringBuffer1.append(k);
    if (i < 10)
    {
      localObject = "0";
      localStringBuffer2 = localStringBuffer2.append((String)localObject).append(i);
      if (j >= 10) {
        break label103;
      }
    }
    label103:
    for (localObject = "0";; localObject = "")
    {
      localStringBuffer2.append((String)localObject).append(j);
      return localStringBuffer1.toString();
      localObject = "";
      break;
    }
  }
  
  /* Error */
  public byte[] loadResource(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 67	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: pop
    //   5: aload_1
    //   6: invokestatic 73	javax/microedition/lcdui/Display:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_1
    //   10: aload_1
    //   11: invokevirtual 78	java/io/InputStream:available	()I
    //   14: newarray byte
    //   16: astore_2
    //   17: aload_1
    //   18: aload_2
    //   19: invokevirtual 82	java/io/InputStream:read	([B)I
    //   22: pop
    //   23: aload_1
    //   24: invokevirtual 85	java/io/InputStream:close	()V
    //   27: aload_1
    //   28: ifnull +7 -> 35
    //   31: aload_1
    //   32: invokevirtual 85	java/io/InputStream:close	()V
    //   35: aload_2
    //   36: astore_3
    //   37: aload_3
    //   38: areturn
    //   39: astore_1
    //   40: aconst_null
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_1
    //   45: astore_3
    //   46: aload_2
    //   47: ifnull -10 -> 37
    //   50: aload_2
    //   51: invokevirtual 85	java/io/InputStream:close	()V
    //   54: aload_1
    //   55: astore_3
    //   56: goto -19 -> 37
    //   59: astore_2
    //   60: aload_1
    //   61: astore_3
    //   62: goto -25 -> 37
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 85	java/io/InputStream:close	()V
    //   76: aload_2
    //   77: athrow
    //   78: astore_1
    //   79: goto -44 -> 35
    //   82: astore_1
    //   83: goto -7 -> 76
    //   86: astore_2
    //   87: goto -19 -> 68
    //   90: astore_2
    //   91: aload_1
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -51 -> 44
    //   98: astore_3
    //   99: aload_1
    //   100: astore_3
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: astore_2
    //   105: goto -61 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	Util
    //   0	108	1	paramString	String
    //   16	35	2	arrayOfByte	byte[]
    //   59	1	2	localException1	Exception
    //   65	12	2	localObject1	Object
    //   86	1	2	localObject2	Object
    //   90	1	2	localException2	Exception
    //   92	13	2	localObject3	Object
    //   36	26	3	localObject4	Object
    //   98	1	3	localException3	Exception
    //   100	4	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	10	39	java/lang/Exception
    //   50	54	59	java/lang/Exception
    //   0	10	65	finally
    //   31	35	78	java/lang/Exception
    //   72	76	82	java/lang/Exception
    //   10	17	86	finally
    //   17	27	86	finally
    //   10	17	90	java/lang/Exception
    //   17	27	98	java/lang/Exception
  }
  
  public String[] loadScript(String paramString, int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = loadResource(paramString);
    int n = arrayOfByte.length;
    paramString = new String[paramInt];
    int m = 0;
    int j = 0;
    paramInt = i;
    while (paramInt < n)
    {
      int k = m;
      i = j;
      if (arrayOfByte[paramInt] == 10)
      {
        paramString[j] = new String(arrayOfByte, m, paramInt - m);
        i = j + 1;
        k = paramInt;
      }
      paramInt++;
      m = k;
      j = i;
    }
    return paramString;
  }
  
  public void setByteData(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    for (int i = 0; i < paramArrayOfByte2.length; i++) {
      paramArrayOfByte1[(paramInt + i)] = paramArrayOfByte2[i];
    }
  }
}
