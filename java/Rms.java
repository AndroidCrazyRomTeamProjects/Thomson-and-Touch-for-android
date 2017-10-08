import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreNotOpenException;

public class Rms
{
  private final String DB_NAME = "thomsons";
  private final int GAME_DATA_SIZE = 8;
  private final int POINT_DATA_SIZE = 28;
  private final int SETUP_DATA_SIZE = 20;
  private final int STAR_DATA_SIZE = 4;
  private BaseCanvas cBc;
  private RecordStore rs;
  
  public Rms(BaseCanvas paramBaseCanvas)
  {
    cBc = paramBaseCanvas;
    init();
  }
  
  public void closeRms()
  {
    try
    {
      rs.closeRecordStore();
      rs = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean existRms()
  {
    openRms();
    try
    {
      if (rs.getNumRecords() != 0) {
        break label24;
      }
      closeRms();
      bool = false;
    }
    catch (RecordStoreNotOpenException localRecordStoreNotOpenException)
    {
      for (;;)
      {
        boolean bool = true;
      }
    }
    return bool;
  }
  
  public void init()
  {
    openRms();
    try
    {
      if (rs.getNumRecords() == 0)
      {
        rs.addRecord(makeData(1), 0, 20);
        rs.addRecord(makeData(2), 0, 28);
        rs.addRecord(makeData(3), 0, 8);
        rs.addRecord(makeData(4), 0, 4);
      }
      closeRms();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int[] loadData(int paramInt)
  {
    byte[] arrayOfByte = loadRms(paramInt);
    int i = arrayOfByte.length / 4;
    int[] arrayOfInt = new int[i];
    for (paramInt = 0; paramInt < i; paramInt++) {
      arrayOfInt[paramInt] = cBc.cUtil.getBytesToInt(arrayOfByte, paramInt * 4);
    }
    return arrayOfInt;
  }
  
  public byte[] loadRms(int paramInt)
  {
    Object localObject = null;
    openRms();
    try
    {
      byte[] arrayOfByte = rs.getRecord(paramInt);
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    closeRms();
    return localObject;
  }
  
  public byte[] makeData(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localObject;
      byte[] arrayOfByte = new byte[20];
      int i = 0;
      for (paramInt = 0;; paramInt++)
      {
        localObject = arrayOfByte;
        if (paramInt >= 5) {
          break;
        }
        cBc.cUtil.setByteData(arrayOfByte, i, cBc.cUtil.getIntToBytes(cBc.nSetup[paramInt]));
        i += 4;
      }
      arrayOfByte = new byte[28];
      i = 0;
      for (paramInt = 0;; paramInt++)
      {
        localObject = arrayOfByte;
        if (paramInt >= 7) {
          break;
        }
        cBc.cUtil.setByteData(arrayOfByte, i, cBc.cUtil.getIntToBytes(cBc.cPoint.nHighPoint[paramInt]));
        i += 4;
      }
      localObject = new byte[8];
      cBc.cUtil.setByteData((byte[])localObject, 0, cBc.cUtil.getIntToBytes(cBc.nHiddenGameActive[0]));
      cBc.cUtil.setByteData((byte[])localObject, 0 + 4, cBc.cUtil.getIntToBytes(cBc.nHiddenGameActive[1]));
      continue;
      localObject = new byte[4];
      cBc.cUtil.setByteData((byte[])localObject, 0, cBc.cUtil.getIntToBytes(cBc.cPoint.nStarPoint[0]));
    }
  }
  
  public boolean openRms()
  {
    try
    {
      rs = RecordStore.openRecordStore("thomsons", true);
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public void saveData(int paramInt)
  {
    saveRms(paramInt, makeData(paramInt));
  }
  
  public void saveRms(int paramInt, byte[] paramArrayOfByte)
  {
    openRms();
    try
    {
      rs.setRecord(paramInt, paramArrayOfByte, 0, paramArrayOfByte.length);
      closeRms();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
  }
}
