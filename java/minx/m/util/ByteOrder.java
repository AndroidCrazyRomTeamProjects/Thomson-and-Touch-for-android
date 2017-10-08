package minx.m.util;

public class ByteOrder
{
  public ByteOrder() {}
  
  public static int readIntFromBytes(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  public static short readShortFromBytes(byte paramByte1, byte paramByte2)
  {
    paramByte1 = (short)((short)(paramByte1 | 0x0) << 8);
    if (paramByte2 < 0) {}
    for (short s = (short)(paramByte1 | (short)(paramByte2 & 0xFF));; s = (short)(paramByte1 | paramByte2)) {
      return s;
    }
  }
  
  public static void swapBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[paramInt1];
    paramArrayOfByte[paramInt1] = paramArrayOfByte[paramInt2];
    paramArrayOfByte[paramInt2] = i;
  }
  
  public static int writeBytesToInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >>> 24));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >>> 16 & 0xFF));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >>> 8 & 0xFF));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)paramInt2);
    return paramInt1 + 4;
  }
}
