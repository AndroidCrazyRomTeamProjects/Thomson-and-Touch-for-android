public class Point
{
  public final int MAX_PERCENT = 10;
  public final int MAX_POINT_ANI = 5;
  public final int MAX_STAR = 3;
  public final int MIN_PERCENT = 3;
  private final int[][] POINT_TABLE;
  private final int[][] POINT_TABLE_STAR;
  private final int POINT_TABLE_STAR_MAX;
  public int STAR_INC = 1;
  private final int TYPE_YELLOW = 2;
  public Point.PointAnimation[] cAni;
  public BaseCanvas cBc;
  public boolean isComboAni;
  public int nComboCount;
  public int nComboFrame;
  public int nCurPoint;
  public int[] nHighPoint;
  public int[] nPoint;
  public int[] nStarPoint;
  public int nTotPoint;
  
  public Point(BaseCanvas paramBaseCanvas)
  {
    int[] arrayOfInt = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 };
    POINT_TABLE = new int[][] { { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, arrayOfInt, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 } };
    POINT_TABLE_STAR_MAX = 8;
    arrayOfInt = new int[] { 4, 5, 6, 7, 8, 9, 10, 11 };
    POINT_TABLE_STAR = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 2, 3, 4, 5, 6, 7, 8, 9 }, arrayOfInt };
    cBc = paramBaseCanvas;
    cAni = new Point.PointAnimation[5];
    for (int i = 0; i < 5; i++) {
      cAni[i] = new Point.PointAnimation();
    }
    nHighPoint = new int[7];
    nPoint = new int[7];
    nStarPoint = new int[1];
    init();
  }
  
  public int getComboCount()
  {
    return nComboCount - 1;
  }
  
  public Point getInstance()
  {
    return this;
  }
  
  public int getType()
  {
    return cBc.cUtil.getRandomInt(0, 3);
  }
  
  public void increaseComboCount()
  {
    if (isCombo()) {
      isComboAni = true;
    }
    if (nComboCount >= 8) {}
    for (nComboCount = 8;; nComboCount += 1)
    {
      nComboFrame = 0;
      return;
    }
  }
  
  public void increasePoint(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      nCurPoint = paramInt2;
      return;
      int[] arrayOfInt = nPoint;
      arrayOfInt[0] += paramInt2;
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[1] += paramInt2;
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[2] += paramInt2;
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[3] += paramInt2;
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[4] += paramInt2;
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[5] += paramInt2;
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[6] += paramInt2;
    }
  }
  
  public void increasePointTable(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 10) {
      paramInt2 = 10;
    }
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        switch (paramInt1)
        {
        }
        break;
      }
      for (;;)
      {
        return;
        int[] arrayOfInt = nPoint;
        arrayOfInt[0] += POINT_TABLE[0][paramInt2];
        break;
        arrayOfInt = nPoint;
        arrayOfInt[1] += POINT_TABLE[1][paramInt2];
        break;
        arrayOfInt = nPoint;
        arrayOfInt[2] += POINT_TABLE[2][paramInt2];
        break;
        arrayOfInt = nPoint;
        arrayOfInt[3] += POINT_TABLE[3][paramInt2];
        break;
        arrayOfInt = nPoint;
        arrayOfInt[4] += POINT_TABLE[4][paramInt2];
        break;
        arrayOfInt = nPoint;
        arrayOfInt[5] += POINT_TABLE[5][paramInt2];
        break;
        arrayOfInt = nPoint;
        arrayOfInt[6] += POINT_TABLE[6][paramInt2];
        break;
        nCurPoint = POINT_TABLE[0][paramInt2];
        continue;
        nCurPoint = POINT_TABLE[1][paramInt2];
        continue;
        nCurPoint = POINT_TABLE[2][paramInt2];
        continue;
        nCurPoint = POINT_TABLE[3][paramInt2];
        continue;
        nCurPoint = POINT_TABLE[4][paramInt2];
        continue;
        nCurPoint = POINT_TABLE[5][paramInt2];
        continue;
        nCurPoint = POINT_TABLE[6][paramInt2];
      }
    }
  }
  
  public void increasePointTableStar(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      nCurPoint = POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
      increaseStar();
      return;
      int[] arrayOfInt = nPoint;
      arrayOfInt[0] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[1] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[2] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[3] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[4] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[5] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
      continue;
      arrayOfInt = nPoint;
      arrayOfInt[6] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
    }
  }
  
  public void increaseStar()
  {
    int[] arrayOfInt = nStarPoint;
    arrayOfInt[0] += STAR_INC;
    if (nStarPoint[0] > 9999) {
      nStarPoint[0] = 0;
    }
  }
  
  public void init()
  {
    nComboCount = 0;
    isComboAni = false;
    nCurPoint = 0;
  }
  
  public void initPoint()
  {
    int i = cBc.nHeart;
    cBc.getClass();
    if (i == 3) {
      for (i = 0; i < 7; i++) {
        nPoint[i] = 0;
      }
    }
    initPointAnimation();
  }
  
  public void initPointAnimation()
  {
    for (int i = 0; i < 5; i++) {
      initPointAnimation(i);
    }
  }
  
  public void initPointAnimation(int paramInt)
  {
    cAni[paramInt].isActive = false;
    cAni[paramInt].nFrame = 0;
    cAni[paramInt].nPoint = 0;
    cAni[paramInt].nPosX = 0;
    cAni[paramInt].nPosY = 0;
  }
  
  public boolean isCombo()
  {
    if (nComboCount > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isNewRecord()
  {
    if (nHighPoint[cBc.nGameIdx] < nPoint[cBc.nGameIdx]) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isStarPoint()
  {
    if (cBc.cUtil.getRandomInt(0, 10) < 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void resetComboCount()
  {
    nComboCount = 0;
  }
  
  public void setPointAnimation(int paramInt)
  {
    if (paramInt == 0) {}
    label61:
    for (;;)
    {
      return;
      for (int i = 0;; i++)
      {
        if (i >= 5) {
          break label61;
        }
        if (!cAni[i].isActive)
        {
          cAni[i].isActive = true;
          cAni[i].nFrame = 0;
          cAni[i].nPoint = paramInt;
          break;
        }
      }
    }
  }
  
  public void setPointAnimation(int paramInt1, int paramInt2)
  {
    for (int i = 0;; i++) {
      if (i < 5)
      {
        if (!cAni[i].isActive)
        {
          cAni[i].nPosX = paramInt1;
          cAni[i].nPosY = paramInt2;
        }
      }
      else {
        return;
      }
    }
  }
  
  public void setPointAnimation(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {}
    label89:
    for (;;)
    {
      return;
      for (int i = 0;; i++)
      {
        if (i >= 5) {
          break label89;
        }
        if (!cAni[i].isActive)
        {
          cAni[i].isActive = true;
          cAni[i].nFrame = 0;
          cAni[i].nPoint = paramInt1;
          cAni[i].nPosX = paramInt2;
          cAni[i].nPosY = paramInt3;
          break;
        }
      }
    }
  }
  
  class PointAnimation
  {
    boolean isActive;
    int nFrame;
    int nPoint;
    int nPosX;
    int nPosY;
    
    PointAnimation() {}
  }
}
