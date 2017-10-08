import javax.microedition.lcdui.Graphics;

public class DrawMenu
  implements Drawable
{
  private final int[][] SELECT_POS;
  private BaseCanvas cBc;
  private boolean isActive;
  private int nDetailFrame;
  private int nFaceFrame;
  
  public DrawMenu(BaseCanvas paramBaseCanvas)
  {
    int[] arrayOfInt1 = { 18, 16 };
    int[] arrayOfInt2 = { 64, 14 };
    int[] arrayOfInt3 = { 102, 22 };
    int[] arrayOfInt4 = { 174, 26 };
    int[] arrayOfInt5 = { 18, 76 };
    int[] arrayOfInt6 = { 160, 80 };
    int[] arrayOfInt7 = { 1, 4 };
    int[] arrayOfInt8 = { 52, 5 };
    int[] arrayOfInt9 = { 160, 10 };
    int[] arrayOfInt10 = { 67, 53 };
    int[] arrayOfInt11 = { 137, 63 };
    SELECT_POS = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 86, 81 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 80, 10 }, arrayOfInt9, { 5, 56 }, arrayOfInt10, arrayOfInt11 };
    cBc = paramBaseCanvas;
    init();
  }
  
  private void drawGameDetail(Graphics paramGraphics)
  {
    cBc.drawMenuBG(paramGraphics);
    if (isActive())
    {
      paramGraphics.drawImage(cBc.cRes.iGameDetail[(cBc.nGameIdx * 5 + 0)], 120, 22, 3);
      paramGraphics.drawImage(cBc.cRes.iGameDetail[(cBc.nGameIdx * 5 + 1)], 120, 198, 3);
      if (nDetailFrame < 5)
      {
        paramGraphics.drawImage(cBc.cRes.iGameDetail[(cBc.nGameIdx * 5 + 2)], 16, 46, 20);
        nDetailFrame += 1;
      }
      for (;;)
      {
        paramGraphics.setColor(0, 112, 227);
        for (int i = 0; i < 4; i++) {
          paramGraphics.drawRect(120 - (105 - i), i + 45, cBc.cRes.PREVIEW_WIDTH + 2 - i * 2, cBc.cRes.PREVIEW_HEIGHT + 2 - i * 2);
        }
        if (nDetailFrame < 10)
        {
          paramGraphics.drawImage(cBc.cRes.iGameDetail[(cBc.nGameIdx * 5 + 3)], 16, 46, 20);
          nDetailFrame += 1;
        }
        else if (nDetailFrame < 15)
        {
          paramGraphics.drawImage(cBc.cRes.iGameDetail[(cBc.nGameIdx * 5 + 4)], 16, 46, 20);
          nDetailFrame += 1;
          if (nDetailFrame == 15) {
            nDetailFrame = 0;
          }
        }
      }
      paramGraphics.drawImage(cBc.cRes.iText[0], 70, 156, 20);
      cBc.drawNumber(paramGraphics, cBc.cRes.iBlueNum, cBc.cPoint.nHighPoint[cBc.nGameIdx], 180, 156, 0, 4, true);
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cBc.cRes.iTitle[0], 0, 0, 20);
      paramGraphics.drawImage(cBc.cRes.iTitle[1], 120, 2, 17);
    }
  }
  
  private void drawGameSelect(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iBox[0], 0, 224, 20);
    cBc.drawTouchText(paramGraphics);
    int j;
    int i;
    if (!isActive())
    {
      j = 0;
      if (j < 7)
      {
        if (j != 1)
        {
          if ((j != cBc.nHiddenGameIdx[0]) || (cBc.nHiddenGameActive[0] != 0)) {
            break label122;
          }
          i = 28;
        }
        for (;;)
        {
          paramGraphics.drawImage(cBc.cRes.iMenu[i], SELECT_POS[j][0], SELECT_POS[j][1] + 224, 20);
          j++;
          break;
          label122:
          if ((j == cBc.nHiddenGameIdx[1]) && (cBc.nHiddenGameActive[1] == 0))
          {
            i = 29;
          }
          else
          {
            i = nFaceFrame;
            nFaceFrame = (i + 1);
            i = j * 4 + i / 48 % 2;
          }
        }
      }
    }
    else
    {
      j = 0;
      if (j < 7)
      {
        if ((j != 1) && (cBc.nGameIdx != j))
        {
          if ((j != cBc.nHiddenGameIdx[0]) || (cBc.nHiddenGameActive[0] != 0)) {
            break label275;
          }
          i = 28;
        }
        for (;;)
        {
          paramGraphics.drawImage(cBc.cRes.iMenu[i], SELECT_POS[j][0], SELECT_POS[j][1] + 224, 20);
          j++;
          break;
          label275:
          if ((j == cBc.nHiddenGameIdx[1]) && (cBc.nHiddenGameActive[1] == 0)) {
            i = 29;
          } else {
            i = j * 4;
          }
        }
      }
      for (i = 0; i < 7; i++) {
        if ((i != 1) && (cBc.nGameIdx == i))
        {
          j = cBc.nGameIdx;
          int k = nFaceFrame;
          nFaceFrame = (k + 1);
          k /= 4;
          paramGraphics.drawImage(cBc.cRes.iMenu[(j * 4 + 2 + k % 2)], SELECT_POS[(i + 7)][0], SELECT_POS[(i + 7)][1] + 224, 20);
        }
      }
    }
  }
  
  private void drawMainMenu(Graphics paramGraphics)
  {
    drawGameDetail(paramGraphics);
    drawGameSelect(paramGraphics);
  }
  
  private void setActive(boolean paramBoolean)
  {
    nDetailFrame = 0;
    nFaceFrame = 0;
    isActive = paramBoolean;
  }
  
  public void drawManager(Graphics paramGraphics)
  {
    cBc.drawClear(paramGraphics);
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      cBc.drawBottomButton(paramGraphics);
      return;
      drawMainMenu(paramGraphics);
    }
  }
  
  public void init()
  {
    setActive(false);
  }
  
  public boolean isActive()
  {
    return isActive;
  }
  
  public void pointerDragged(int paramInt1, int paramInt2) {}
  
  public void pointerPressed(int paramInt1, int paramInt2)
  {
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      if (!isActive())
      {
        if (cBc.getPopupState() == 0)
        {
          if (!cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[0], SELECT_POS[0][0], SELECT_POS[0][1])) {
            break label109;
          }
          cBc.setGameIdx(0);
          setActive(true);
        }
        for (;;)
        {
          cBc.setState(1000, 0);
          break;
          label109:
          if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[8], SELECT_POS[2][0], SELECT_POS[2][1]))
          {
            cBc.setGameIdx(2);
            setActive(true);
          }
          else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[12], SELECT_POS[3][0], SELECT_POS[3][1]))
          {
            cBc.setGameIdx(3);
            setActive(true);
          }
          else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[16], SELECT_POS[4][0], SELECT_POS[4][1]))
          {
            if (cBc.nHiddenGameActive[0] == 1)
            {
              cBc.setGameIdx(4);
              setActive(true);
            }
            else if (cBc.isStarCheck())
            {
              cBc.nHiddenGameActive[0] = 1;
              cBc.cRms.saveData(3);
              cBc.cRms.saveData(4);
            }
            else
            {
              cBc.setPopupState(3);
              cBc.setBottomButton(cBc.nCurStateSeg, cBc.nCurStateOff);
            }
          }
          else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[20], SELECT_POS[5][0], SELECT_POS[5][1]))
          {
            cBc.setGameIdx(5);
            setActive(true);
          }
          else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[24], SELECT_POS[6][0], SELECT_POS[6][1]))
          {
            if (cBc.nHiddenGameActive[1] == 1)
            {
              cBc.setGameIdx(6);
              setActive(true);
            }
            else if (cBc.isStarCheck())
            {
              cBc.nHiddenGameActive[1] = 1;
              cBc.cRms.saveData(3);
              cBc.cRms.saveData(4);
            }
            else
            {
              cBc.setPopupState(3);
              cBc.setBottomButton(cBc.nCurStateSeg, cBc.nCurStateOff);
            }
          }
        }
      }
      if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[0], SELECT_POS[0][0], SELECT_POS[0][1]))
      {
        if ((cBc.nGameIdx == 0) && (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[2], SELECT_POS[7][0], SELECT_POS[7][1])))
        {
          cBc.resetHeart();
          cBc.setState(2000, 0);
        }
        else
        {
          cBc.setGameIdx(0);
        }
      }
      else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[8], SELECT_POS[2][0], SELECT_POS[2][1]))
      {
        if ((cBc.nGameIdx == 2) && (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[10], SELECT_POS[9][0], SELECT_POS[9][1])))
        {
          cBc.resetHeart();
          cBc.setState(2002, 0);
        }
        else
        {
          cBc.setGameIdx(2);
        }
      }
      else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[12], SELECT_POS[3][0], SELECT_POS[3][1]))
      {
        if ((cBc.nGameIdx == 3) && (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[14], SELECT_POS[10][0], SELECT_POS[10][1])))
        {
          cBc.resetHeart();
          cBc.setState(2003, 0);
        }
        else
        {
          cBc.setGameIdx(3);
        }
      }
      else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[16], SELECT_POS[4][0], SELECT_POS[4][1]))
      {
        if ((cBc.nGameIdx == 4) && (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[18], SELECT_POS[11][0], SELECT_POS[11][1])))
        {
          cBc.resetHeart();
          cBc.setState(2004, 0);
        }
        else if (cBc.nHiddenGameActive[0] == 1)
        {
          cBc.setGameIdx(4);
        }
        else if (cBc.isStarCheck())
        {
          cBc.setGameIdx(4);
          cBc.nHiddenGameActive[0] = 1;
          cBc.cRms.saveData(3);
          cBc.cRms.saveData(4);
        }
        else
        {
          cBc.setPopupState(3);
          cBc.setBottomButton(cBc.nCurStateSeg, cBc.nCurStateOff);
        }
      }
      else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[20], SELECT_POS[5][0], SELECT_POS[5][1]))
      {
        if ((cBc.nGameIdx == 5) && (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[22], SELECT_POS[12][0], SELECT_POS[12][1])))
        {
          cBc.resetHeart();
          cBc.setState(2005, 0);
        }
        else
        {
          cBc.setGameIdx(5);
        }
      }
      else if (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[24], SELECT_POS[6][0], SELECT_POS[6][1])) {
        if ((cBc.nGameIdx == 6) && (cBc.isPointer(paramInt1, paramInt2, cBc.cRes.iMenu[26], SELECT_POS[13][0], SELECT_POS[13][1])))
        {
          cBc.resetHeart();
          cBc.setState(2006, 0);
        }
        else if (cBc.nHiddenGameActive[1] == 1)
        {
          cBc.setGameIdx(6);
        }
        else if (cBc.isStarCheck())
        {
          cBc.setGameIdx(6);
          cBc.nHiddenGameActive[1] = 1;
          cBc.cRms.saveData(3);
          cBc.cRms.saveData(4);
        }
        else
        {
          cBc.setPopupState(3);
          cBc.setBottomButton(cBc.nCurStateSeg, cBc.nCurStateOff);
        }
      }
    }
  }
  
  public void pointerReleased(int paramInt1, int paramInt2) {}
}
