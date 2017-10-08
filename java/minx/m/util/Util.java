package minx.m.util;

import java.util.Calendar;
import java.util.Random;

public class Util
{
  Random a = new Random();
  
  public Util() {}
  
  public int getRandomInt(int paramInt1, int paramInt2)
  {
    return (a.nextInt() >>> 1) % paramInt2 + paramInt1;
  }
  
  public String getToday()
  {
    Object localObject = Calendar.getInstance();
    int j = ((Calendar)localObject).get(1);
    int k = ((Calendar)localObject).get(2) + 1;
    int i = ((Calendar)localObject).get(5);
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = localStringBuffer1.append(j);
    if (k < 10)
    {
      localObject = "0";
      localStringBuffer2 = localStringBuffer2.append((String)localObject).append(k);
      if (i >= 10) {
        break label103;
      }
    }
    label103:
    for (localObject = "0";; localObject = "")
    {
      localStringBuffer2.append((String)localObject).append(i);
      return localStringBuffer1.toString();
      localObject = "";
      break;
    }
  }
}
