import java.lang.reflect.Array;
import java.util.Random;
import javax.microedition.lcdui.Graphics;

public class DrawPlay06
  implements Drawable
{
  static final int BlockType_LRBomb = 6;
  static final int BlockType_LRBomb_fadeout = 16;
  static final int BlockType_LRBomb_small = 26;
  static final int BlockType_UpBomb = 5;
  static final int BlockType_UpBomb_fadeout = 15;
  static final int BlockType_UpBomb_small = 25;
  static final int BlockType_kebin = 2;
  static final int BlockType_kebin_fadeout = 12;
  static final int BlockType_kebin_small = 22;
  static final int BlockType_mery = 4;
  static final int BlockType_mery_fadeout = 14;
  static final int BlockType_mery_small = 24;
  static final int BlockType_mom = 1;
  static final int BlockType_mom_fadeout = 11;
  static final int BlockType_mom_small = 21;
  static final int BlockType_nana = 3;
  static final int BlockType_nana_fadeout = 13;
  static final int BlockType_nana_small = 23;
  static final int BlockType_thomson = 0;
  static final int BlockType_thomson_fadeout = 10;
  static final int BlockType_thomson_small = 20;
  static final int BottomBlockPosY = 230;
  static final int MAX_BOMB_TIME = 10000;
  static final int MAX_MOVE_TIME = 15000;
  static final int ShootBlockListLengthMax = 20;
  static final int StarType_blue = 1;
  static final int StarType_red = 2;
  static final int StarType_yellow = 0;
  public DrawPlay06.Block AddBlockLeft;
  public DrawPlay06.Block AddBlockRight;
  public int BlockLineAddTime;
  public DrawPlay06.BlockList2D BlockMap;
  public DrawPlay06.BottomBlockList BottomBlockMap;
  public DrawPlay06.Block[] ShootBlockList = new DrawPlay06.Block[20];
  public int addScore;
  public boolean b_AddBlockLeftClick;
  public boolean b_AddBlockRightClick;
  public boolean[] b_BottomBlockClick = new boolean[5];
  public boolean b_getCurStar;
  public boolean b_isTouchProcess;
  public long bombTime;
  BaseCanvas cBc;
  public Point cPoint;
  public long currentTime;
  public int nFrame;
  public int nRotate;
  public int nRotateFrame;
  public long prevTime;
  Random random;
  
  public DrawPlay06(BaseCanvas paramBaseCanvas)
  {
    cBc = paramBaseCanvas;
    cPoint = cPoint.getInstance();
    random = new Random();
    BlockLineAddTime = 15000;
  }
  
  private void drawBoard(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iBG[0], 0, 0, 20);
    paramGraphics.drawImage(cBc.cRes.iBG[1], 0, 224, 20);
    if (nRotate == 1) {
      if (nRotateFrame == 0)
      {
        paramGraphics.drawImage(cBc.cRes.iBG[2], 4, 276, 20);
        paramGraphics.drawImage(cBc.cRes.iBG[3], 200, 276, 20);
        if (nRotate != 1) {
          break label376;
        }
        paramGraphics.drawImage(cBc.cRes.iPlay[nRotateFrame], 120, 310, 3);
        nRotateFrame += 1;
        if (nRotateFrame >= 4)
        {
          nRotate = 0;
          nRotateFrame = 0;
        }
      }
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cBc.cRes.iBG[2], 4, 276, 20);
      paramGraphics.drawImage(cBc.cRes.iBG[3], 200, 276, 20);
      break;
      if (nRotate == 2)
      {
        if (nRotateFrame == 0)
        {
          paramGraphics.drawImage(cBc.cRes.iBG[2], 4, 276, 20);
          paramGraphics.drawImage(cBc.cRes.iBG[3], 200, 276, 20);
          break;
        }
        paramGraphics.drawImage(cBc.cRes.iBG[2], 4, 276, 20);
        paramGraphics.drawImage(cBc.cRes.iBG[3], 200, 276, 20);
        break;
      }
      paramGraphics.drawImage(cBc.cRes.iBG[2], 4, 276, 20);
      paramGraphics.drawImage(cBc.cRes.iBG[3], 200, 276, 20);
      break;
      label376:
      if (nRotate == 2)
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[(nRotateFrame + 4)], 120, 310, 3);
        nRotateFrame += 1;
        if (nRotateFrame >= 4)
        {
          nRotate = 0;
          nRotateFrame = 0;
        }
      }
    }
  }
  
  private void drawGameOver(Graphics paramGraphics)
  {
    drawPlay(paramGraphics);
    cBc.drawGameOver(paramGraphics);
  }
  
  private void drawPanel(Graphics paramGraphics) {}
  
  private void drawPlay(Graphics paramGraphics)
  {
    proc();
    drawBoard(paramGraphics);
    BottomBlockMap.draw(paramGraphics);
    AddBlockLeft.draw(paramGraphics);
    AddBlockRight.draw(paramGraphics);
    BlockMap.draw(paramGraphics);
    for (int i = 0; i < 20; i++) {
      if (!ShootBlockList[i].b_deleted) {
        ShootBlockList[i].draw(paramGraphics);
      }
    }
    cBc.drawCombo(paramGraphics);
    cBc.drawPointAnimation(paramGraphics);
    cBc.drawMark(paramGraphics);
    cBc.drawScoreBar(paramGraphics);
  }
  
  private void drawReady(Graphics paramGraphics)
  {
    drawBoard(paramGraphics);
    BottomBlockMap.draw(paramGraphics);
    AddBlockLeft.draw(paramGraphics);
    AddBlockRight.draw(paramGraphics);
    BlockMap.draw(paramGraphics);
    drawPanel(paramGraphics);
    cBc.drawReadyStart(paramGraphics);
    cBc.drawScoreBar(paramGraphics);
  }
  
  private void drawResult(Graphics paramGraphics)
  {
    int i = cBc.getAnimationFrame(cBc.nResultAniFrame, 4, 2);
    BaseCanvas localBaseCanvas = cBc;
    nResultAniFrame += 1;
    cBc.drawGameResultBack(paramGraphics);
    if (cBc.isNewRecord) {
      switch (i)
      {
      }
    }
    for (;;)
    {
      cBc.drawGameResultForward(paramGraphics);
      return;
      paramGraphics.drawImage(cBc.cRes.iResult[0], 120, 213, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 142, 130, 20);
      cBc.drawClipImage(paramGraphics, cBc.cRes.iResult[2], 64, 132, 0, 0, 20, 27, 20);
      cBc.drawClipImage(paramGraphics, cBc.cRes.iResult[2], 145, 184, 20, 0, 20, 27, 20);
      continue;
      paramGraphics.drawImage(cBc.cRes.iResult[1], 120, 213, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 145, 134, 20);
      cBc.drawClipImage(paramGraphics, cBc.cRes.iResult[2], 67, 134, 0, 0, 20, 27, 20);
      cBc.drawClipImage(paramGraphics, cBc.cRes.iResult[2], 145, 189, 20, 0, 20, 27, 20);
      continue;
      switch (i)
      {
      default: 
        break;
      case 0: 
        paramGraphics.drawImage(cBc.cRes.iResult[3], 120, 213, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 140, 130, 20);
        break;
      case 1: 
        paramGraphics.drawImage(cBc.cRes.iResult[4], 120, 213, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 140, 134, 20);
      }
    }
  }
  
  private void proc()
  {
    if (cBc.isLock()) {}
    for (;;)
    {
      return;
      prevTime = currentTime;
      currentTime = cBc.getCurTime();
      int m = (int)(currentTime - prevTime);
      if (b_isTouchProcess)
      {
        int j = 0;
        if (j < 5)
        {
          label82:
          int k;
          if ((!BottomBlockMap.cell[j].b_deleted) && (b_BottomBlockClick[j] != 0))
          {
            i = 0;
            k = i;
            if (!ShootBlockList[i].b_deleted)
            {
              if (!ShootBlockList[i].b_inactivated) {
                break label151;
              }
              k = i;
            }
          }
          for (;;)
          {
            ShootBlockList[k].copy(BottomBlockMap.cell[j]);
            BottomBlockMap.cell[j].delete();
            b_getCurStar = false;
            j++;
            break;
            label151:
            k = i + 1;
            i = k;
            if (k < 20) {
              break label82;
            }
          }
        }
        if ((b_AddBlockLeftClick) && (BottomBlockMap.LeftAddBlock())) {
          AddNewBlockBottomLeft();
        }
        if ((b_AddBlockRightClick) && (BottomBlockMap.RightAddBlock())) {
          AddNewBlockBottomRight();
        }
        for (i = 0; i < 5; i++) {
          b_BottomBlockClick[i] = false;
        }
        b_AddBlockLeftClick = false;
        b_AddBlockRightClick = false;
        b_isTouchProcess = false;
      }
      BlockMap.process(m);
      for (int i = 0; i < 20; i++) {
        if (!ShootBlockList[i].b_deleted)
        {
          ShootBlockList[i].shootMove(m);
          ShootBlockList[i].process(m);
        }
      }
      ShootBlockList_CollisonCheck();
      socreSetting();
    }
  }
  
  public void AddNewBlockBottomLeft()
  {
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt1 = new int[5];
    for (int i = 0; i < 5; i++) {
      arrayOfInt1[i] = (i + 20);
    }
    for (i = 0; i < 5; i++) {
      arrayOfInt2[i] = 0;
    }
    i = 0;
    if (i < 5)
    {
      if (!BottomBlockMap.cell[i].b_deleted) {
        switch (BottomBlockMap.cell[i].type)
        {
        }
      }
      for (;;)
      {
        i++;
        break;
        arrayOfInt2[0] += 1;
        continue;
        arrayOfInt2[1] += 1;
        continue;
        arrayOfInt2[2] += 1;
        continue;
        arrayOfInt2[3] += 1;
        continue;
        arrayOfInt2[4] += 1;
      }
    }
    i = 5;
    int j = 0;
    int k;
    while (j < 5)
    {
      k = i;
      if (arrayOfInt2[j] >= 2)
      {
        arrayOfInt1[j] = -1;
        k = i - 1;
      }
      j++;
      i = k;
    }
    j = 0;
    if (j < 5)
    {
      if (arrayOfInt1[j] == -1) {}
      for (k = j + 1;; k++) {
        if (k < 5)
        {
          if (arrayOfInt1[k] >= 0)
          {
            arrayOfInt1[j] = arrayOfInt1[k];
            arrayOfInt1[k] = -1;
          }
        }
        else
        {
          j++;
          break;
        }
      }
    }
    if ((cBc.cUtil.getRandomInt(0, 9) == 0) && (System.currentTimeMillis() - bombTime > 10000L)) {
      bombTime = System.currentTimeMillis();
    }
    for (j = 1;; j = 0)
    {
      if (j == 0) {}
      for (i = arrayOfInt1[getRandomInt(0, i - 1)];; i = getRandomInt(25, 26))
      {
        AddBlockLeft.setNewBlock(i, 31, 309);
        return;
      }
    }
  }
  
  public void AddNewBlockBottomRight()
  {
    int[] arrayOfInt1 = new int[5];
    int[] arrayOfInt2 = new int[5];
    for (int i = 0; i < 5; i++) {
      arrayOfInt2[i] = (i + 20);
    }
    for (i = 0; i < 5; i++) {
      arrayOfInt1[i] = 0;
    }
    i = 0;
    if (i < 5)
    {
      if (!BottomBlockMap.cell[i].b_deleted) {
        switch (BottomBlockMap.cell[i].type)
        {
        }
      }
      for (;;)
      {
        i++;
        break;
        arrayOfInt1[0] += 1;
        continue;
        arrayOfInt1[1] += 1;
        continue;
        arrayOfInt1[2] += 1;
        continue;
        arrayOfInt1[3] += 1;
        continue;
        arrayOfInt1[4] += 1;
      }
    }
    i = 5;
    int j = 0;
    int k;
    while (j < 5)
    {
      k = i;
      if (arrayOfInt1[j] >= 2)
      {
        arrayOfInt2[j] = -1;
        k = i - 1;
      }
      j++;
      i = k;
    }
    j = 0;
    if (j < 5)
    {
      if (arrayOfInt2[j] == -1) {}
      for (k = j + 1;; k++) {
        if (k < 5)
        {
          if (arrayOfInt2[k] >= 0)
          {
            arrayOfInt2[j] = arrayOfInt2[k];
            arrayOfInt2[k] = -1;
          }
        }
        else
        {
          j++;
          break;
        }
      }
    }
    if ((cBc.cUtil.getRandomInt(0, 9) == 0) && (System.currentTimeMillis() - bombTime > 10000L)) {
      bombTime = System.currentTimeMillis();
    }
    for (j = 1;; j = 0)
    {
      if (j == 0) {}
      for (i = arrayOfInt2[getRandomInt(0, i - 1)];; i = getRandomInt(25, 26))
      {
        AddBlockRight.setNewBlock(i, 172, 309);
        return;
      }
    }
  }
  
  public void ShootBlockList_CollisonCheck()
  {
    int j = -1;
    int m = 0;
    if (m < 20)
    {
      int k = j;
      int n;
      int i;
      if (!ShootBlockList[m].b_inactivated)
      {
        k = j;
        if (!ShootBlockList[m].b_deleted)
        {
          n = (ShootBlockList[m].posX - 3) / 47;
          k = 5;
          i = j;
          if (k >= 0)
          {
            if (!BlockMap.cell[k][n].b_deleted) {
              i = k;
            }
          }
          else
          {
            j = 0;
            label89:
            if (j >= 5) {
              break label348;
            }
            if (!BlockMap.star[j].b_deleted)
            {
              if (ShootBlockList[m].posX != BlockMap.star[j].posX) {
                break label331;
              }
              if (ShootBlockList[m].posY <= BlockMap.star[j].posY)
              {
                cPoint.increaseComboCount();
                switch (BlockMap.star[j].type)
                {
                default: 
                  label204:
                  cPoint.setPointAnimation(cPoint.nCurPoint, BlockMap.star[j].posX + 10, BlockMap.star[j].posY + 10);
                  BlockMap.star[j].delete();
                  b_getCurStar = true;
                }
              }
            }
          }
          for (;;)
          {
            j++;
            break label89;
            k--;
            break;
            cPoint.increasePointTableStar(cBc.nCurStateSeg, 2);
            break label204;
            cPoint.increasePointTableStar(cBc.nCurStateSeg, 1);
            break label204;
            cPoint.increasePointTableStar(cBc.nCurStateSeg, 0);
            break label204;
            label331:
            if (!b_getCurStar) {
              cPoint.resetComboCount();
            }
          }
          label348:
          if (i != -1) {
            break label578;
          }
          k = i;
          if (ShootBlockList[m].posY <= 17)
          {
            ShootBlockList[m].posY = 17;
            if (ShootBlockList[m].type == 6)
            {
              if (!cBc.isSoundLock()) {
                cBc.cSound.playSound(21, 1);
              }
              ShootBlockList[m].doInActivate();
              for (j = 0;; j++)
              {
                k = i;
                if (j >= 5) {
                  break;
                }
                if (!BlockMap.cell[0][j].b_deleted)
                {
                  addScore += 1;
                  BlockMap.cell[0][j].doInActivate();
                }
              }
            }
            if (ShootBlockList[m].type != 5) {
              break label543;
            }
            if (!cBc.isSoundLock()) {
              cBc.cSound.playSound(21, 1);
            }
            ShootBlockList[m].doInActivate();
            k = i;
          }
        }
      }
      for (;;)
      {
        m++;
        j = k;
        break;
        label543:
        BlockMap.AddBlock(ShootBlockList[m].type, n, 0);
        ShootBlockList[m].delete();
        k = i;
        continue;
        label578:
        k = i;
        if (ShootBlockList[m].posY <= BlockMap.cell[i][n].posY + 47)
        {
          ShootBlockList[m].posY = (BlockMap.cell[i][n].posY + 47);
          if (ShootBlockList[m].type == 6)
          {
            if (!cBc.isSoundLock()) {
              cBc.cSound.playSound(21, 1);
            }
            ShootBlockList[m].doInActivate();
            if (!BlockMap.cell[(i + 1)][0].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[(i + 1)][0].doInActivate();
            }
            if (!BlockMap.cell[(i + 1)][1].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[(i + 1)][1].doInActivate();
            }
            if (!BlockMap.cell[(i + 1)][2].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[(i + 1)][2].doInActivate();
            }
            if (!BlockMap.cell[(i + 1)][3].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[(i + 1)][3].doInActivate();
            }
            if (!BlockMap.cell[(i + 1)][4].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[(i + 1)][4].doInActivate();
            }
            cPoint.setPointAnimation(addScore, n * 46 + 20, i * 46 + 20);
            k = i;
          }
          else if (ShootBlockList[m].type == 5)
          {
            if (!cBc.isSoundLock()) {
              cBc.cSound.playSound(20, 1);
            }
            ShootBlockList[m].doInActivate();
            if (!BlockMap.cell[0][n].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[0][n].doInActivate();
            }
            if (!BlockMap.cell[1][n].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[1][n].doInActivate();
            }
            if (!BlockMap.cell[2][n].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[2][n].doInActivate();
            }
            if (!BlockMap.cell[3][n].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[3][n].doInActivate();
            }
            if (!BlockMap.cell[4][n].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[4][n].doInActivate();
            }
            if (!BlockMap.cell[5][n].b_deleted)
            {
              addScore += 1;
              BlockMap.cell[5][n].doInActivate();
            }
            cPoint.setPointAnimation(addScore, n * 46 + 20, i * 46 + 20);
            k = i;
          }
          else
          {
            if (ShootBlockList[m].type == BlockMap.cell[i][n].type)
            {
              ShootBlockList[m].doInActivate();
              if (!BlockMap.cell[i][n].b_deleted)
              {
                if (addScore <= 0) {
                  break label1406;
                }
                addScore += 5;
                cBc.setEvent(true);
              }
              for (;;)
              {
                BlockMap.cell[i][n].doInActivate();
                cPoint.setPointAnimation(addScore, n * 46 + 20, i * 46 + 20);
                k = i;
                break;
                label1406:
                if (!cBc.isSoundLock()) {
                  cBc.cSound.playSound(20, 1);
                }
                addScore += 1;
              }
            }
            BlockMap.AddBlock(ShootBlockList[m].type, n, i + 1);
            ShootBlockList[m].delete();
            k = i;
          }
        }
      }
    }
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
      drawReady(paramGraphics);
      continue;
      drawPlay(paramGraphics);
      continue;
      drawGameOver(paramGraphics);
      continue;
      drawResult(paramGraphics);
    }
  }
  
  public int getRandomInt(int paramInt1, int paramInt2)
  {
    return (random.nextInt() >>> 1) % (paramInt2 - paramInt1 + 1) + paramInt1;
  }
  
  public void init()
  {
    cBc.setGrade(0);
    cPoint.initPoint();
    cPoint.resetComboCount();
    BlockMap = new DrawPlay06.BlockList2D();
    BottomBlockMap = new DrawPlay06.BottomBlockList();
    for (int i = 0; i < 20; i++)
    {
      ShootBlockList[i] = new DrawPlay06.Block(0, 0, 0);
      ShootBlockList[i].delete();
    }
    AddBlockLeft = new DrawPlay06.Block(0, 0, 0);
    AddBlockLeft.delete();
    AddBlockRight = new DrawPlay06.Block(0, 0, 0);
    AddBlockRight.delete();
    AddNewBlockBottomLeft();
    AddNewBlockBottomRight();
    for (i = 0; i < 5; i++) {
      b_BottomBlockClick[i] = false;
    }
    b_AddBlockLeftClick = false;
    b_AddBlockRightClick = false;
    b_isTouchProcess = false;
    addScore = 0;
    b_getCurStar = false;
    currentTime = cBc.getCurTime();
    prevTime = currentTime;
    nFrame = 0;
    BlockLineAddTime = 15000;
    nRotate = 0;
    nRotateFrame = 0;
  }
  
  public void pointerDragged(int paramInt1, int paramInt2)
  {
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      for (int i = 0; i < 5; i++) {
        if ((!BottomBlockMap.cell[i].b_deleted) && (b_BottomBlockClick[i] == 0)) {
          b_BottomBlockClick[i] = cBc.isPointer(paramInt1, paramInt2, BottomBlockMap.cell[i].posX, BottomBlockMap.cell[i].posY, BottomBlockMap.cell[i].posX + 45, BottomBlockMap.cell[i].posY + 45);
        }
      }
      b_AddBlockLeftClick = cBc.isPointer(paramInt1, paramInt2, AddBlockLeft.posX, AddBlockLeft.posY, AddBlockLeft.posX + 37, AddBlockLeft.posY + 37);
      b_AddBlockRightClick = cBc.isPointer(paramInt1, paramInt2, AddBlockRight.posX, AddBlockRight.posY, AddBlockRight.posX + 37, AddBlockRight.posY + 37);
      if (b_AddBlockLeftClick) {
        nRotate = 1;
      } else if (b_AddBlockRightClick) {
        nRotate = 2;
      }
    }
  }
  
  public void pointerPressed(int paramInt1, int paramInt2)
  {
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      for (int i = 0; i < 5; i++) {
        if (!BottomBlockMap.cell[i].b_deleted) {
          b_BottomBlockClick[i] = cBc.isPointer(paramInt1, paramInt2, BottomBlockMap.cell[i].posX, BottomBlockMap.cell[i].posY, BottomBlockMap.cell[i].posX + 45, BottomBlockMap.cell[i].posY + 45);
        }
      }
      b_AddBlockLeftClick = cBc.isPointer(paramInt1, paramInt2, AddBlockLeft.posX, AddBlockLeft.posY, AddBlockLeft.posX + 37, AddBlockLeft.posY + 37);
      b_AddBlockRightClick = cBc.isPointer(paramInt1, paramInt2, AddBlockRight.posX, AddBlockRight.posY, AddBlockRight.posX + 37, AddBlockRight.posY + 37);
      if (b_AddBlockLeftClick) {
        nRotate = 1;
      } else if (b_AddBlockRightClick) {
        nRotate = 2;
      }
    }
  }
  
  public void pointerReleased(int paramInt1, int paramInt2)
  {
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      b_isTouchProcess = true;
    }
  }
  
  public void socreSetting()
  {
    cPoint.increasePoint(cBc.nCurStateSeg, addScore);
    addScore = 0;
    cBc.setGrade(cPoint.nPoint[6]);
    BlockLineAddTime = (15000 - cBc.nGrade * 1000);
  }
  
  class Block
  {
    public int AniId;
    public int AniUpdateTime;
    public boolean b_deleted;
    public boolean b_inactivated;
    public int checkId;
    public int moveTime;
    public int posX;
    public int posY;
    public int type;
    
    public Block(int paramInt1, int paramInt2, int paramInt3)
    {
      posX = paramInt2;
      posY = paramInt3;
      type = paramInt1;
      AniId = 0;
      AniUpdateTime = 0;
      moveTime = 0;
      b_deleted = false;
      b_inactivated = false;
      checkId = 0;
    }
    
    public void copy(Block paramBlock)
    {
      AniId = AniId;
      AniUpdateTime = AniUpdateTime;
      moveTime = moveTime;
      b_deleted = b_deleted;
      b_inactivated = b_inactivated;
      posX = posX;
      posY = posY;
      type = type;
    }
    
    public void delete()
    {
      type = -1;
      posX = 0;
      posY = 0;
      AniId = 0;
      AniUpdateTime = 0;
      b_inactivated = true;
      b_deleted = true;
    }
    
    public void doInActivate()
    {
      if (!b_deleted) {
        b_inactivated = true;
      }
    }
    
    public void draw(Graphics paramGraphics)
    {
      if (!b_deleted) {
        switch (type)
        {
        case 7: 
        case 8: 
        case 9: 
        case 17: 
        case 18: 
        case 19: 
        default: 
          if (b_inactivated) {
            switch (AniId)
            {
            }
          }
          break;
        }
      }
      for (;;)
      {
        return;
        paramGraphics.drawImage(cBc.cRes.iObject[0], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[1], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[14], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[2], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[3], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[15], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[4], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[5], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[16], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[6], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[7], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[17], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[8], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[9], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[18], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[10], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[11], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[19], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[12], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[13], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iObject[20], posX, posY, 0);
        break;
        paramGraphics.drawImage(cBc.cRes.iEffect[0], posX - 1, posY, 0);
        continue;
        paramGraphics.drawImage(cBc.cRes.iEffect[1], posX, posY, 0);
        continue;
        paramGraphics.drawImage(cBc.cRes.iEffect[2], posX, posY, 0);
      }
    }
    
    public void move(int paramInt1, int paramInt2)
    {
      if (!b_deleted)
      {
        posX += paramInt1;
        posY += paramInt2;
      }
    }
    
    public void process(int paramInt)
    {
      if ((!b_deleted) && (b_inactivated))
      {
        AniUpdateTime += paramInt;
        if (AniUpdateTime > 100)
        {
          AniId += 1;
          AniUpdateTime -= 100;
          switch (AniId)
          {
          }
        }
      }
      for (;;)
      {
        return;
        type += 10;
        continue;
        type = -1;
        continue;
        delete();
      }
    }
    
    public void setNewBlock(int paramInt1, int paramInt2, int paramInt3)
    {
      posX = paramInt2;
      posY = paramInt3;
      type = paramInt1;
      AniId = 0;
      AniUpdateTime = 0;
      b_deleted = false;
      b_inactivated = false;
    }
    
    public void shootMove(int paramInt)
    {
      if ((!b_deleted) && (!b_inactivated))
      {
        moveTime += paramInt;
        if (moveTime >= 100)
        {
          posY -= 30;
          moveTime -= 100;
        }
      }
    }
  }
  
  class BlockList2D
  {
    public DrawPlay06.Block[][] cell = (DrawPlay06.Block[][])Array.newInstance(DrawPlay06.Block.class, new int[] { 7, 5 });
    public int moveTime;
    public DrawPlay06.Star[] star = new DrawPlay06.Star[5];
    public int starCnt;
    public int starCreateTime;
    
    public BlockList2D()
    {
      int[] arrayOfInt = new int[5];
      moveTime = 0;
      for (int i = 0; i < 7; i++) {
        for (j = 0; j < 5; j++)
        {
          cell[i][j] = new DrawPlay06.Block(DrawPlay06.this, 0, 0, 0);
          cell[i][j].b_inactivated = true;
          cell[i][j].b_deleted = true;
        }
      }
      for (i = 0; i < 5; i++) {
        arrayOfInt[i] = i;
      }
      int j = 5;
      int k;
      for (i = 0; i < 5; i++)
      {
        k = getRandomInt(0, j - 1);
        AddBlock(arrayOfInt[k], i, 0);
        arrayOfInt[k] = arrayOfInt[(j - 1)];
        arrayOfInt[(j - 1)] = -1;
        j--;
      }
      for (i = 0; i < 5; i++) {
        arrayOfInt[i] = i;
      }
      j = 5;
      for (i = 0; i < 5; i++)
      {
        k = getRandomInt(0, j - 1);
        AddBlock(arrayOfInt[k], i, 1);
        arrayOfInt[k] = arrayOfInt[(j - 1)];
        arrayOfInt[(j - 1)] = -1;
        j--;
      }
      for (i = 0; i < 5; i++)
      {
        star[i] = new DrawPlay06.Star(DrawPlay06.this, 0, 0, 0);
        star[i].delete();
      }
      starCnt = 0;
      starCreateTime = 0;
    }
    
    public void AddBlock(int paramInt1, int paramInt2, int paramInt3)
    {
      if (cell[paramInt3][paramInt2].b_deleted) {
        cell[paramInt3][paramInt2].setNewBlock(paramInt1, paramInt2 * 47 + 3, paramInt3 * 47 + 17);
      }
    }
    
    public void createStar(int paramInt1, int paramInt2)
    {
      for (int i = 0;; i++) {
        if (i < 5)
        {
          if (star[i].b_deleted) {
            star[i].setNewStar(getRandomInt(0, 2), paramInt1, paramInt2);
          }
        }
        else {
          return;
        }
      }
    }
    
    public void draw(Graphics paramGraphics)
    {
      for (int i = 0; i < 2; i++) {
        if (!star[i].b_deleted) {
          star[i].draw(paramGraphics);
        }
      }
      for (i = 0; i < 7; i++) {
        for (int j = 0; j < 5; j++) {
          if (!cell[i][j].b_deleted) {
            cell[i][j].draw(paramGraphics);
          }
        }
      }
    }
    
    public void moveDown()
    {
      Object localObject = new int[5];
      for (int i = 5; i >= 0; i--) {
        for (j = 0; j < 5; j++) {
          if (!cell[i][j].b_deleted)
          {
            cell[(i + 1)][j].copy(cell[i][j]);
            cell[(i + 1)][j].move(0, 47);
            cell[i][j].delete();
          }
        }
      }
      for (i = 0; i < 5; i++) {
        localObject[i] = i;
      }
      int j = 5;
      for (i = 0; i < 5; i++)
      {
        int k = getRandomInt(0, j - 1);
        AddBlock(localObject[k], i, 0);
        localObject[k] = localObject[(j - 1)];
        localObject[(j - 1)] = -1;
        j--;
      }
      for (i = 0; i < 5; i++) {
        if (!star[i].b_deleted)
        {
          localObject = star[i];
          posY += 47;
        }
      }
    }
    
    public void process(int paramInt)
    {
      int[] arrayOfInt = new int[5];
      for (int i = 0; i < 5; i++) {
        arrayOfInt[i] = i;
      }
      int j;
      for (i = 1; i < 6; i++) {
        for (j = 0; j < 5; j++) {
          if ((!cell[i][j].b_deleted) && (cell[(i - 1)][j].b_deleted))
          {
            cell[(i - 1)][j].setNewBlock(cell[i][j].type, j * 47 + 3, (i - 1) * 47 + 17);
            cell[i][j].delete();
          }
        }
      }
      moveTime += paramInt;
      if (moveTime >= BlockLineAddTime)
      {
        moveDown();
        moveTime = 0;
        if (!cBc.isSoundLock()) {
          cBc.cSound.playSound(19, 1);
        }
      }
      starCreateTime += paramInt;
      if (starCreateTime >= 2000)
      {
        starCreateTime = 0;
        i = 5;
        j = 0;
        int k;
        while (j < 5)
        {
          k = i;
          if (!star[j].b_deleted)
          {
            arrayOfInt[((star[j].posX - 3) / 47)] = -1;
            k = i - 1;
          }
          j++;
          i = k;
        }
        for (j = 0; j < 4; j++) {
          if (arrayOfInt[j] == -1) {
            for (k = j + 1; k < 5; k++) {
              if (arrayOfInt[k] != -1)
              {
                arrayOfInt[(k - 1)] = arrayOfInt[k];
                arrayOfInt[k] = -1;
              }
            }
          }
        }
        if (i > 0)
        {
          j = arrayOfInt[getRandomInt(0, i - 1)];
          i = 5;
          if (i < 0) {
            break label591;
          }
          if ((cell[i][j].b_inactivated) || (cell[i][j].b_deleted)) {
            break label472;
          }
        }
      }
      for (;;)
      {
        if (i < 5)
        {
          createStar(j * 47 + 3, (i + 1) * 47 + 17);
          starCnt += 1;
        }
        for (i = 0;; i++)
        {
          if (i >= 7) {
            break label484;
          }
          j = 0;
          for (;;)
          {
            if (j < 5)
            {
              if (!cell[i][j].b_deleted) {
                cell[i][j].process(paramInt);
              }
              j++;
              continue;
              label472:
              i--;
              break;
            }
          }
        }
        label484:
        for (i = 0; i < 5; i++) {
          if (!star[i].b_deleted) {
            star[i].process(paramInt);
          }
        }
        for (paramInt = 0;; paramInt++) {
          if (paramInt < 5)
          {
            if ((!cell[4][paramInt].b_deleted) && (!cell[4][paramInt].b_inactivated))
            {
              cBc.cSound.playSound(24, 1);
              cBc.setState(2006, 2);
            }
          }
          else {
            return;
          }
        }
        label591:
        i = -1;
      }
    }
  }
  
  class BottomBlockList
  {
    public DrawPlay06.Block[] cell = new DrawPlay06.Block[5];
    
    public BottomBlockList()
    {
      int[] arrayOfInt = new int[5];
      for (int i = 0; i < 5; i++) {
        arrayOfInt[i] = i;
      }
      int j = 5;
      for (i = 0; i < 5; i++)
      {
        int k = getRandomInt(0, j - 1);
        cell[i] = new DrawPlay06.Block(DrawPlay06.this, arrayOfInt[k], i * 47 + 3, 230);
        arrayOfInt[k] = arrayOfInt[(j - 1)];
        arrayOfInt[(j - 1)] = -1;
        j--;
      }
    }
    
    public int GetBlankBlockIdLeft()
    {
      int i = 0;
      if (i < 5) {
        if (!cell[i].b_deleted) {}
      }
      for (;;)
      {
        return i;
        i++;
        break;
        i = -1;
      }
    }
    
    public int GetBlankBlockIdRight()
    {
      int i = 4;
      if (i >= 0) {
        if (!cell[i].b_deleted) {}
      }
      for (;;)
      {
        return i;
        i--;
        break;
        i = -1;
      }
    }
    
    public boolean LeftAddBlock()
    {
      int j = GetBlankBlockIdLeft();
      int i = j;
      DrawPlay06.Block localBlock;
      if (j == -1)
      {
        for (i = 4; i > 0; i--)
        {
          cell[i].copy(cell[(i - 1)]);
          localBlock = cell[i];
          posX += 47;
        }
        cell[0].setNewBlock(AddBlockLeft.type - 20, 3, 230);
        AddBlockLeft.delete();
      }
      for (;;)
      {
        return true;
        while (i > 0)
        {
          cell[i].copy(cell[(i - 1)]);
          localBlock = cell[i];
          posX += 47;
          i--;
        }
        cell[0].setNewBlock(AddBlockLeft.type - 20, 3, 230);
        AddBlockLeft.delete();
      }
    }
    
    public boolean RightAddBlock()
    {
      int j = GetBlankBlockIdRight();
      int i = j;
      DrawPlay06.Block localBlock;
      if (j == -1)
      {
        for (i = 0; i < 4; i++)
        {
          cell[i].copy(cell[(i + 1)]);
          localBlock = cell[i];
          posX -= 47;
        }
        cell[4].setNewBlock(AddBlockRight.type - 20, 191, 230);
        AddBlockRight.delete();
      }
      for (;;)
      {
        return true;
        while (i < 4)
        {
          cell[i].copy(cell[(i + 1)]);
          localBlock = cell[i];
          posX -= 47;
          i++;
        }
        cell[4].setNewBlock(AddBlockRight.type - 20, 191, 230);
        AddBlockRight.delete();
      }
    }
    
    public void draw(Graphics paramGraphics)
    {
      int i = 0;
      if (i < 5)
      {
        if (cell[i].b_deleted) {
          paramGraphics.drawImage(cBc.cRes.iObject[21], i * 47 + 3 + 2, 232, 20);
        }
        for (;;)
        {
          i++;
          break;
          cell[i].draw(paramGraphics);
        }
      }
    }
  }
  
  class Star
  {
    public int AliveTime;
    public int AniId;
    public int AniUpdateTime;
    public boolean b_deleted;
    public boolean isFall;
    public int posX;
    public int posY;
    public int type;
    
    public Star(int paramInt1, int paramInt2, int paramInt3)
    {
      type = paramInt1;
      posX = paramInt2;
      posY = paramInt3;
      AniId = 0;
      AniUpdateTime = 0;
      AliveTime = 3000;
      b_deleted = false;
    }
    
    public void delete()
    {
      posX = 0;
      posY = 0;
      AniId = 0;
      AniUpdateTime = 0;
      AliveTime = 0;
      isFall = false;
      b_deleted = true;
    }
    
    public void draw(Graphics paramGraphics)
    {
      if (!b_deleted) {
        paramGraphics.drawImage(cBc.cRes.iStar[(type + AniId * 3)], posX + 1, posY + 1, 0);
      }
    }
    
    public void process(int paramInt)
    {
      if (!b_deleted)
      {
        AniUpdateTime += paramInt;
        if (AniUpdateTime >= 100)
        {
          AniId = ((AniId + 1) % 3);
          AliveTime -= paramInt;
          if (AliveTime <= 0) {
            delete();
          }
          if (posY > 252) {
            delete();
          }
        }
      }
    }
    
    public void setNewStar(int paramInt1, int paramInt2, int paramInt3)
    {
      type = paramInt1;
      posX = paramInt2;
      posY = paramInt3;
      AniId = 0;
      AniUpdateTime = 0;
      AliveTime = 3000;
      b_deleted = false;
    }
  }
}
