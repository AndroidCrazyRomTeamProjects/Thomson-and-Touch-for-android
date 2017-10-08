package minx.m.image;

import minx.m.util.ByteOrder;
import minx.m.util.File;

public class PngControl
{
  private static final int[] c = new int['Ā'];
  private File a = new File();
  private final String[] b = { "IHDR", "tRNS", "PLTE", "IDAT", "IEND" };
  
  static
  {
    int k;
    int j;
    for (int i = 0;; i++)
    {
      if (i >= 256) {
        return;
      }
      k = 0;
      j = i;
      if (k < 8) {
        break;
      }
      c[i] = j;
    }
    if ((j & 0x1) != 0) {
      j = j >>> 1 ^ 0xEDB88320;
    }
    for (;;)
    {
      k++;
      break;
      j >>>= 1;
    }
  }
  
  public PngControl() {}
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = ByteOrder.readIntFromBytes(paramArrayOfByte, paramInt);
    return ByteOrder.writeBytesToInt(paramArrayOfByte, i + (paramInt + 4 + 4), a(paramArrayOfByte, paramInt + 4, i + 4));
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = -1;
    int[] arrayOfInt = c;
    for (int i = paramInt1;; i++)
    {
      if (i == paramInt1 + paramInt2) {
        return j ^ 0xFFFFFFFF;
      }
      j = j >>> 8 ^ arrayOfInt[((paramArrayOfByte[i] ^ j) & 0xFF)];
    }
  }
  
  private static int a(byte[] paramArrayOfByte, String paramString)
  {
    int i = 8;
    for (;;)
    {
      if ((paramArrayOfByte[(i + 4)] == paramString.charAt(0)) && (paramArrayOfByte[(i + 5)] == paramString.charAt(1)) && (paramArrayOfByte[(i + 6)] == paramString.charAt(2)) && (paramArrayOfByte[(i + 7)] == paramString.charAt(3))) {
        return i;
      }
      i += ByteOrder.readIntFromBytes(paramArrayOfByte, i) + 8 + 4;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    paramInt1 = 0;
    if (paramInt1 >= paramInt3) {
      return;
    }
    int j = i + 1;
    for (i = 0;; i++)
    {
      if (i >= paramInt2 / 2)
      {
        i = j + paramInt2;
        paramInt1++;
        break;
      }
      d(paramArrayOfByte, j + i, j + paramInt2 - 1 - i);
    }
  }
  
  private static void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    paramInt1 = 0;
    if (paramInt1 >= paramInt3) {
      return;
    }
    int j = i + 1;
    for (i = 0;; i++)
    {
      if (i >= paramInt2)
      {
        i = j + paramInt2;
        paramInt1++;
        break;
      }
      paramArrayOfByte2[(j + i)] = paramArrayOfByte1[(j + paramInt2 - 1 - i)];
    }
  }
  
  private static void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j;
    int k;
    switch (paramInt4)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return;
        i = 1;
        paramInt4 = paramInt1;
      } while (i >= paramInt2 + 1);
      j = paramInt4 + 1;
      paramArrayOfByte2[paramInt4] = 0;
      k = 0;
      paramInt4 = j;
      j = k;
      for (;;)
      {
        if (j >= paramInt3)
        {
          i++;
          break;
        }
        paramArrayOfByte2[paramInt4] = paramArrayOfByte1[((paramInt2 + 1) * (paramInt3 - 1 - j) + paramInt1 + i)];
        j++;
        paramInt4++;
      }
    }
    int i = 1;
    paramInt4 = paramInt1;
    label115:
    if (i < paramInt2 + 1)
    {
      k = paramInt4 + 1;
      paramArrayOfByte2[paramInt4] = 0;
      j = 0;
    }
    for (paramInt4 = k;; paramInt4++)
    {
      if (j >= paramInt3)
      {
        i++;
        break label115;
        break;
      }
      paramArrayOfByte2[paramInt4] = paramArrayOfByte1[((paramInt2 + 1) * j + paramInt1 + (paramInt2 + 1 - i))];
      j++;
    }
  }
  
  private byte[] a(String paramString)
  {
    return a(a.read(paramString));
  }
  
  private byte[] a(String paramString, int paramInt)
  {
    return e(a.read(paramString), paramInt);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
    int i = a(paramArrayOfByte, b[0]);
    int j = a(paramArrayOfByte, b[3]);
    a(paramArrayOfByte, arrayOfByte, j + 8 + 2 + 1 + 2 + 2, c(paramArrayOfByte, i), d(paramArrayOfByte, i));
    b(arrayOfByte, j);
    a(arrayOfByte, j);
    return arrayOfByte;
  }
  
  private int b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = ByteOrder.readIntFromBytes(paramArrayOfByte, paramInt);
    return ByteOrder.writeBytesToInt(paramArrayOfByte, i + paramInt + 4, b(paramArrayOfByte, paramInt + 7 + 4 + 4, i - 7 - 4));
  }
  
  private static int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j = 0;
    int k = 1;
    for (;;)
    {
      if (i >= paramInt1 + paramInt2) {
        return j << 16 | k;
      }
      k = (k + (paramArrayOfByte[i] & 0xFF)) % 65521;
      j = (j + k) % 65521;
      i++;
    }
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1;
    int i = 0;
    if (i >= paramInt3 / 2) {
      return;
    }
    int k = j + 1;
    for (j = 0;; j++)
    {
      if (j >= paramInt2)
      {
        j = k + paramInt2;
        i++;
        break;
      }
      d(paramArrayOfByte, k + j, (paramInt2 + 1) * (paramInt3 - 1 - i) + paramInt1 + 1 + j);
    }
  }
  
  private static void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = paramInt1;
    for (;;)
    {
      if (i >= paramInt3) {
        return;
      }
      j++;
      System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte2, (paramInt2 + 1) * (paramInt3 - 1 - i) + paramInt1 + 1, paramInt2);
      j += paramInt2;
      i++;
    }
  }
  
  private byte[] b(String paramString)
  {
    return b(a.read(paramString));
  }
  
  private byte[] b(String paramString, int paramInt)
  {
    byte[] arrayOfByte = a.read(paramString);
    paramString = paramString.substring(0, paramString.indexOf(".png"));
    paramString = a.read(paramString + ".pal");
    int i = a(arrayOfByte, b[2]);
    int j = ByteOrder.readIntFromBytes(paramString, 4);
    System.arraycopy(paramString, j * paramInt + 8, arrayOfByte, i + 8, j);
    a(arrayOfByte, i);
    return arrayOfByte;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    int j = a(paramArrayOfByte, b[0]);
    int i = a(paramArrayOfByte, b[3]);
    a(paramArrayOfByte, i + 8 + 2 + 1 + 2 + 2, c(paramArrayOfByte, j), d(paramArrayOfByte, j));
    b(paramArrayOfByte, i);
    a(paramArrayOfByte, i);
    return paramArrayOfByte;
  }
  
  private static int c(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteOrder.readIntFromBytes(paramArrayOfByte, paramInt + 8);
  }
  
  private static void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = 1;
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 & 0xFF));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramArrayOfByte[(paramInt1 + 1)] ^ 0xFFFFFFFF));
    paramArrayOfByte[(paramInt1 + 4)] = ((byte)(paramArrayOfByte[(paramInt1 + 2)] ^ 0xFFFFFFFF));
  }
  
  private static void c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    int j = 0;
    if (j >= paramInt3) {
      return;
    }
    i++;
    int k = 0;
    for (;;)
    {
      if (k >= paramInt2)
      {
        j++;
        break;
      }
      paramArrayOfByte2[i] = paramArrayOfByte1[((paramInt2 - 1) * (paramInt3 - j) + paramInt1 + (paramInt2 - k) - j * 2)];
      k++;
      i++;
    }
  }
  
  private byte[] c(String paramString)
  {
    return c(a.read(paramString));
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
    int i = a(paramArrayOfByte, b[0]);
    int j = a(paramArrayOfByte, b[3]);
    b(paramArrayOfByte, arrayOfByte, j + 8 + 2 + 1 + 2 + 2, c(paramArrayOfByte, i), d(paramArrayOfByte, i));
    b(arrayOfByte, j);
    a(arrayOfByte, j);
    return arrayOfByte;
  }
  
  private static int d(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteOrder.readIntFromBytes(paramArrayOfByte, paramInt + 12);
  }
  
  private static void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[paramInt1];
    paramArrayOfByte[paramInt1] = paramArrayOfByte[paramInt2];
    paramArrayOfByte[paramInt2] = i;
  }
  
  private byte[] d(String paramString)
  {
    return d(a.read(paramString));
  }
  
  private byte[] d(byte[] paramArrayOfByte)
  {
    int j = a(paramArrayOfByte, b[0]);
    int i = a(paramArrayOfByte, b[3]);
    b(paramArrayOfByte, i + 8 + 2 + 1 + 2 + 2, c(paramArrayOfByte, j), d(paramArrayOfByte, j));
    b(paramArrayOfByte, i);
    a(paramArrayOfByte, i);
    return paramArrayOfByte;
  }
  
  private byte[] e(String paramString)
  {
    return e(a.read(paramString));
  }
  
  private byte[] e(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
    int i = a(paramArrayOfByte, b[0]);
    int j = a(paramArrayOfByte, b[3]);
    c(paramArrayOfByte, arrayOfByte, j + 8 + 2 + 1 + 2 + 2, c(paramArrayOfByte, i), d(paramArrayOfByte, i));
    b(arrayOfByte, j);
    a(arrayOfByte, j);
    return arrayOfByte;
  }
  
  private byte[] e(byte[] paramArrayOfByte, int paramInt)
  {
    int i4 = a(paramArrayOfByte, b[0]);
    int k = a(paramArrayOfByte, b[3]);
    int n = ByteOrder.readIntFromBytes(paramArrayOfByte, k);
    int i3 = a(paramArrayOfByte, b[4]);
    int m = ByteOrder.readIntFromBytes(paramArrayOfByte, i3);
    int i2 = c(paramArrayOfByte, i4);
    int i5 = d(paramArrayOfByte, i4);
    int j = i2 - i5;
    int i1 = paramArrayOfByte.length;
    if (j > 0) {}
    for (int i = j;; i = 0)
    {
      byte[] arrayOfByte = new byte[i1 + i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i3);
      ByteOrder.writeBytesToInt(arrayOfByte, i4 + 4 + 4, i5);
      ByteOrder.writeBytesToInt(arrayOfByte, i4 + 4 + 4 + 4, i2);
      ByteOrder.writeBytesToInt(arrayOfByte, k, n + j);
      c(arrayOfByte, k + 4 + 4 + 2, n + j - 11);
      a(paramArrayOfByte, arrayOfByte, k + 4 + 4 + 2 + 1 + 2 + 2, i2, i5, paramInt);
      System.arraycopy(paramArrayOfByte, i3, arrayOfByte, i3 + j, m + 4 + 4 + 4);
      i = a(arrayOfByte, b[0]);
      j = a(arrayOfByte, b[3]);
      paramInt = a(arrayOfByte, b[4]);
      a(arrayOfByte, i);
      b(arrayOfByte, j);
      a(arrayOfByte, j);
      a(arrayOfByte, paramInt);
      return arrayOfByte;
    }
  }
  
  public byte[] byteImageFlip(String paramString)
  {
    return c(paramString);
  }
  
  public byte[] byteImageFlip(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte);
  }
  
  public byte[] byteImageFlipSwap(String paramString)
  {
    return d(paramString);
  }
  
  public byte[] byteImageFlipSwap(byte[] paramArrayOfByte)
  {
    return d(paramArrayOfByte);
  }
  
  public byte[] byteImageMirror(String paramString)
  {
    return a(paramString);
  }
  
  public byte[] byteImageMirror(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte);
  }
  
  public byte[] byteImageMirrorSwap(String paramString)
  {
    return b(paramString);
  }
  
  public byte[] byteImageMirrorSwap(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte);
  }
  
  public byte[] byteImagePalette(String paramString, int paramInt)
  {
    return b(paramString, paramInt);
  }
  
  public byte[] byteImageRotate(String paramString, int paramInt)
  {
    return a(paramString, paramInt);
  }
  
  public byte[] byteImageRotate(byte[] paramArrayOfByte, int paramInt)
  {
    return e(paramArrayOfByte, paramInt);
  }
  
  public byte[] byteImageRotate180(String paramString)
  {
    return e(paramString);
  }
}
