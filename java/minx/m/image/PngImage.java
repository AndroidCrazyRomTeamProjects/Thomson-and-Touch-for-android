package minx.m.image;

import javax.microedition.lcdui.Image;

public class PngImage
  extends PngControl
{
  public static final int ANGLE_180 = 1;
  public static final int ANGLE_270 = 2;
  public static final int ANGLE_90 = 0;
  private boolean a1000 = false;
  
  public PngImage() {}
  
  public Image createImageFlip(String paramString)
  {
    if (a1000) {}
    for (paramString = byteImageFlipSwap(paramString);; paramString = byteImageFlip(paramString)) {
      return Image.createImage(paramString, 0, paramString.length);
    }
  }
  
  public Image createImageFlip(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = byteImageFlipSwap(paramString);; paramString = byteImageFlip(paramString)) {
      return Image.createImage(paramString, 0, paramString.length);
    }
  }
  
  public Image createImageFlip(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramArrayOfByte = byteImageFlipSwap(paramArrayOfByte);; paramArrayOfByte = byteImageFlip(paramArrayOfByte)) {
      return Image.createImage(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  public Image createImageMirror(String paramString)
  {
    if (a1000) {}
    for (paramString = byteImageMirrorSwap(paramString);; paramString = byteImageMirror(paramString)) {
      return Image.createImage(paramString, 0, paramString.length);
    }
  }
  
  public Image createImageMirror(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = byteImageMirrorSwap(paramString);; paramString = byteImageMirror(paramString)) {
      return Image.createImage(paramString, 0, paramString.length);
    }
  }
  
  public Image createImageMirror(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramArrayOfByte = byteImageMirrorSwap(paramArrayOfByte);; paramArrayOfByte = byteImageMirror(paramArrayOfByte)) {
      return Image.createImage(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  public Image createImagePalette(String paramString, int paramInt)
  {
    paramString = byteImagePalette(paramString, paramInt);
    return Image.createImage(paramString, 0, paramString.length);
  }
  
  public Image createImageRotate(String paramString, int paramInt)
  {
    byte[] arrayOfByte = (byte[])null;
    switch (paramInt)
    {
    default: 
      paramString = arrayOfByte;
    }
    for (;;)
    {
      return Image.createImage(paramString, 0, paramString.length);
      paramString = byteImageRotate(paramString, paramInt);
      continue;
      paramString = byteImageRotate180(paramString);
      continue;
      paramString = byteImageRotate(paramString, paramInt);
    }
  }
  
  public Image createImageRotate270(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = byteImageRotate(paramArrayOfByte, 2);
    return Image.createImage(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Image createImageRotate90(String paramString)
  {
    paramString = byteImageRotate(paramString, 0);
    return Image.createImage(paramString, 0, paramString.length);
  }
  
  public Image createImageRotate90(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = byteImageRotate(paramArrayOfByte, 0);
    return Image.createImage(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void setSwap(boolean paramBoolean)
  {
    a1000 = paramBoolean;
  }
}
