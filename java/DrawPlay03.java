import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DrawPlay03
  implements Drawable
{
  private final int BALLOON_FRAME = 2;
  private final int DEFAULT_LINE = 285;
  private final int DEFAULT_PIXEL = 16;
  private final int DROP_SPEED = 20;
  private final int GUN_AROUND_HEIGHT = 42;
  private final int GUN_AROUND_WIDTH = 42;
  private final int IMPACT_POSITION_X = 120;
  private final int IMPACT_POSITION_Y = 301;
  private final int INIT_ACTIVE_FRAME = 10;
  private final int MAX_OBJECT = 10;
  private final int MAX_PATTERN = 3;
  private final int MAX_STONE = 10;
  private final int MOVE_PIXEL = 3;
  private final int PATTERN_LR = 0;
  private final int PATTERN_LRUD = 2;
  private final int PATTERN_UD = 1;
  private final int SIDE_PILLAR = 58;
  private final int STONE_HEIGHT = 25;
  private final int STONE_MAX_FRAME = 4;
  private final int STONE_WIDTH = 32;
  private final int THROW_MAX_FRAME = 8;
  private final int THROW_MAX_STONE = 3;
  private final int THROW_MAX_TIME = 1000;
  private final int TURN_LIMIT = 6;
  private final int WALK_PIXEL = 4;
  private BaseCanvas cBc;
  private DrawPlay03.Gun cGun;
  private DrawPlay03.Object[] cObj;
  private Point cPoint;
  private DrawPlay03.Stone[] cStone;
  private boolean isDrag;
  private boolean isPressed;
  private boolean isThrowStone;
  private int nFrame;
  private int nThrowPredPixelX;
  private int nThrowPredPixelY;
  private int nThrowStone;
  private int nThrowStoneFrame;
  private long nThrowTime;
  
  public DrawPlay03(BaseCanvas paramBaseCanvas)
  {
    cBc = paramBaseCanvas;
    cPoint = cPoint.getInstance();
    cGun = new DrawPlay03.Gun(null);
    cStone = new DrawPlay03.Stone[10];
    cObj = new DrawPlay03.Object[10];
    for (int i = 0; i < 10; i++) {
      cStone[i] = new DrawPlay03.Stone(null);
    }
    for (i = 0; i < 10; i++) {
      cObj[i] = new DrawPlay03.Object(null);
    }
  }
  
  private void drawBalloon(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((cObj[paramInt3].nTurnCount == 6) && ((cObj[paramInt3].nType == 1) || (cObj[paramInt3].nType == 2) || (cObj[paramInt3].nType == 3)))
    {
      DrawPlay03.Object localObject = cObj[paramInt3];
      nBalloonFrame += 1;
      if (cObj[paramInt3].nBalloonFrame / 2 % 2 == 0)
      {
        paramGraphics.drawImage(cBc.cRes.iEffect[1], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY - 10, 3);
        drawObject(paramGraphics, paramInt1, paramInt2, paramInt3);
      }
    }
    for (;;)
    {
      return;
      drawObject(paramGraphics, paramInt1, paramInt2, paramInt3);
    }
  }
  
  private void drawBoard(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iBG[0], 0, 0, 20);
    paramGraphics.drawImage(cBc.cRes.iBG[1], 0, 224, 20);
  }
  
  private void drawGameOver(Graphics paramGraphics)
  {
    drawPlay(paramGraphics);
    cBc.drawGameOver(paramGraphics);
  }
  
  private void drawGun(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iPlay[0], 120, 301, 3);
    paramGraphics.drawImage(cBc.cRes.iTZone, cGun.nPosX, cGun.nPosY, 3);
    if (isThrowStone)
    {
      nThrowStoneFrame -= 1;
      if (nThrowStoneFrame < 1) {
        nThrowStoneFrame = 1;
      }
    }
    for (int i = 0; i < 3 - nThrowStone; i++)
    {
      int j = cBc.cRes.iPlay[1].getWidth();
      int k = 100 / nThrowStoneFrame;
      paramGraphics.drawImage(cBc.cRes.iPlay[((nThrowStoneFrame + 1) % 4 + 1)], 240 - (j + 2) * i - 20 + 100 - k, 348 - cBc.cRes.iPlay[1].getHeight() / 2, 3);
    }
  }
  
  private void drawGunLine(Graphics paramGraphics)
  {
    paramGraphics.setColor(16777215);
    int i = cGun.nPosY + 12;
    paramGraphics.drawLine(178, 249, cGun.nPosX, i);
    paramGraphics.drawLine(178, 248, cGun.nPosX, i - 1);
    paramGraphics.drawLine(178, 247, cGun.nPosX, i - 2);
    drawStone(paramGraphics, cGun.nPosX, cGun.nPosY, 0);
    paramGraphics.drawLine(62, 249, cGun.nPosX, i);
    paramGraphics.drawLine(62, 248, cGun.nPosX, i - 1);
    paramGraphics.drawLine(62, 247, cGun.nPosX, i - 2);
  }
  
  private void drawObject(Graphics paramGraphics)
  {
    int j;
    int m;
    Object localObject;
    int k;
    for (int i = 0; i < 10; i++) {
      if ((cStone[i].isActive) && (cStone[i].isFall))
      {
        j = cStone[i].nPosX;
        m = cStone[i].nPosY;
        localObject = cStone[i];
        k = nFrame;
        nFrame = (k + 1);
        drawStone(paramGraphics, j, m, k);
      }
    }
    i = 0;
    if (i < 10)
    {
      if (cObj[i].isActive)
      {
        if (!cObj[i].isStar) {
          break label380;
        }
        if (!cObj[i].isDead) {
          break label301;
        }
        if (cObj[i].nWalkFrame / 2 % 2 == 0) {
          paramGraphics.drawImage(cBc.cRes.iStar[cObj[i].nType], cObj[i].nPrevPosX, cObj[i].nPrevPosY, 20);
        }
        if (cObj[i].isHit)
        {
          paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[i].nPosX, cObj[i].nPosY, 20);
          cObj[i].isHit = false;
        }
        localObject = cObj[i];
        nWalkFrame += 1;
        if (cObj[i].nWalkFrame >= 10) {
          initObject(i, 0);
        }
      }
      for (;;)
      {
        i++;
        break;
        label301:
        localObject = cObj[i];
        j = nFrame;
        nFrame = (j + 1);
        j /= 2;
        paramGraphics.drawImage(cBc.cRes.iStar[(j % 3 * 3 + cObj[i].nType)], cObj[i].nPosX, cObj[i].nPosY, 20);
        continue;
        label380:
        drawObjectDetail(paramGraphics, i);
      }
    }
    drawGun(paramGraphics);
    for (i = 0; i < 10; i++) {
      if ((cStone[i].isActive) && (!cStone[i].isFall))
      {
        j = cStone[i].nPosX;
        k = cStone[i].nPosY;
        localObject = cStone[i];
        m = nFrame;
        nFrame = (m + 1);
        drawStone(paramGraphics, j, k, m);
      }
    }
  }
  
  private void drawObject(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt2)
    {
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (paramInt1 == 1)
            {
              paramGraphics.drawImage(cBc.cRes.iObject[0], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
            }
            else if (paramInt1 == 2)
            {
              paramGraphics.drawImage(cBc.cRes.iObject[4], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
              continue;
              paramGraphics.drawImage(cBc.cRes.iObject[14], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
            }
          }
          switch (cObj[paramInt3].nFrame)
          {
          default: 
            paramInt1 = 0;
          }
          for (;;)
          {
            paramGraphics.drawImage(cBc.cRes.iObject[paramInt1], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
            break;
            paramInt1 = 22;
            cObj[paramInt3].nFrame = 1;
            continue;
            paramInt1 = 23;
            cObj[paramInt3].nFrame = 2;
            continue;
            paramInt1 = 22;
            cObj[paramInt3].nFrame = 3;
            continue;
            paramInt1 = 24;
            cObj[paramInt3].nFrame = 0;
          }
          if (paramInt1 == 1)
          {
            if (cObj[paramInt3].nFrame < 4)
            {
              paramGraphics.drawImage(cBc.cRes.iObject[32], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
              paramGraphics.drawImage(cBc.cRes.iObject[38], cObj[paramInt3].nPosX - 30, cObj[paramInt3].nPosY - 3, 20);
            }
            for (;;)
            {
              paramGraphics = cObj[paramInt3];
              nFrame += 1;
              if (cObj[paramInt3].nFrame != 8) {
                break;
              }
              cObj[paramInt3].nFrame = 0;
              break;
              if (cObj[paramInt3].nFrame < 8)
              {
                paramGraphics.drawImage(cBc.cRes.iObject[33], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
                paramGraphics.drawImage(cBc.cRes.iObject[38], cObj[paramInt3].nPosX - 30, cObj[paramInt3].nPosY + 3, 20);
              }
            }
          }
        } while (paramInt1 != 2);
        if (cObj[paramInt3].nFrame < 4)
        {
          paramGraphics.drawImage(cBc.cRes.iObject[35], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
          paramGraphics.drawImage(cBc.cRes.iObject[40], cObj[paramInt3].nPosX + 70, cObj[paramInt3].nPosY - 3, 20);
        }
        for (;;)
        {
          paramGraphics = cObj[paramInt3];
          nFrame += 1;
          if (cObj[paramInt3].nFrame != 8) {
            break;
          }
          cObj[paramInt3].nFrame = 0;
          break;
          if (cObj[paramInt3].nFrame < 8)
          {
            paramGraphics.drawImage(cBc.cRes.iObject[36], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
            paramGraphics.drawImage(cBc.cRes.iObject[40], cObj[paramInt3].nPosX + 70, cObj[paramInt3].nPosY + 3, 20);
          }
        }
        if (paramInt1 == 1)
        {
          switch (cObj[paramInt3].nFrame)
          {
          default: 
            paramInt1 = 0;
          }
          for (;;)
          {
            paramGraphics.drawImage(cBc.cRes.iObject[paramInt1], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
            break;
            paramInt1 = 48;
            cObj[paramInt3].nFrame = 1;
            continue;
            paramInt1 = 49;
            cObj[paramInt3].nFrame = 2;
            continue;
            paramInt1 = 50;
            cObj[paramInt3].nFrame = 0;
          }
        }
      } while (paramInt1 != 2);
      switch (cObj[paramInt3].nFrame)
      {
      default: 
        paramInt1 = 0;
      }
      for (;;)
      {
        paramGraphics.drawImage(cBc.cRes.iObject[paramInt1], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
        break;
        paramInt1 = 52;
        cObj[paramInt3].nFrame = 1;
        continue;
        paramInt1 = 53;
        cObj[paramInt3].nFrame = 2;
        continue;
        paramInt1 = 54;
        cObj[paramInt3].nFrame = 0;
      }
      if (paramInt1 == 1)
      {
        switch (cObj[paramInt3].nFrame)
        {
        default: 
          paramInt1 = 0;
        }
        for (;;)
        {
          paramGraphics.drawImage(cBc.cRes.iObject[paramInt1], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
          break;
          paramInt1 = 56;
          cObj[paramInt3].nFrame = 1;
          continue;
          paramInt1 = 57;
          cObj[paramInt3].nFrame = 2;
          continue;
          paramInt1 = 58;
          cObj[paramInt3].nFrame = 0;
        }
      }
    } while (paramInt1 != 2);
    switch (cObj[paramInt3].nFrame)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      paramGraphics.drawImage(cBc.cRes.iObject[paramInt1], cObj[paramInt3].nPosX, cObj[paramInt3].nPosY, 20);
      break;
      paramInt1 = 60;
      cObj[paramInt3].nFrame = 1;
      continue;
      paramInt1 = 61;
      cObj[paramInt3].nFrame = 2;
      continue;
      paramInt1 = 62;
      cObj[paramInt3].nFrame = 0;
    }
  }
  
  private void drawObjectDetail(Graphics paramGraphics, int paramInt)
  {
    switch (cObj[paramInt].nType)
    {
    }
    for (;;)
    {
      return;
      int i;
      if (cObj[paramInt].nDirect == 1)
      {
        if (cObj[paramInt].isWalk)
        {
          switch (cObj[paramInt].nWalkFrame)
          {
          default: 
            i = 0;
          }
          for (;;)
          {
            paramGraphics.drawImage(cBc.cRes.iObject[i], cObj[paramInt].nPosX, cObj[paramInt].nPosY - 4, 20);
            break;
            i = 8;
            cObj[paramInt].nWalkFrame = 1;
            continue;
            i = 9;
            cObj[paramInt].nWalkFrame = 2;
            continue;
            i = 10;
            cObj[paramInt].nWalkFrame = 0;
          }
        }
        if (cObj[paramInt].isDead)
        {
          paramGraphics.drawImage(cBc.cRes.iObject[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
          if (cObj[paramInt].isHit)
          {
            paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
            cObj[paramInt].isHit = false;
          }
          switch (cObj[paramInt].nWalkFrame)
          {
          case 2: 
          default: 
            break;
          case 0: 
            cObj[paramInt].nWalkFrame = 1;
            break;
          case 1: 
            cObj[paramInt].nWalkFrame = 2;
            break;
          }
        }
        else
        {
          drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
        }
      }
      else if (cObj[paramInt].nDirect == 2)
      {
        if (cObj[paramInt].isWalk)
        {
          switch (cObj[paramInt].nWalkFrame)
          {
          default: 
            i = 0;
          }
          for (;;)
          {
            paramGraphics.drawImage(cBc.cRes.iObject[i], cObj[paramInt].nPosX, cObj[paramInt].nPosY - 4, 24);
            break;
            i = 11;
            cObj[paramInt].nWalkFrame = 1;
            continue;
            i = 12;
            cObj[paramInt].nWalkFrame = 2;
            continue;
            i = 13;
            cObj[paramInt].nWalkFrame = 0;
          }
        }
        if (cObj[paramInt].isDead)
        {
          paramGraphics.drawImage(cBc.cRes.iObject[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
          if (cObj[paramInt].isHit)
          {
            paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
            cObj[paramInt].isHit = false;
          }
          switch (cObj[paramInt].nWalkFrame)
          {
          case 2: 
          default: 
            break;
          case 0: 
            cObj[paramInt].nWalkFrame = 1;
            break;
          case 1: 
            cObj[paramInt].nWalkFrame = 2;
            break;
          }
        }
        else
        {
          drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
          continue;
          if (cObj[paramInt].nDirect == 1)
          {
            if (cObj[paramInt].isWalk)
            {
              switch (cObj[paramInt].nWalkFrame)
              {
              default: 
                i = 0;
              }
              for (;;)
              {
                paramGraphics.drawImage(cBc.cRes.iObject[i], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                break;
                i = 16;
                cObj[paramInt].nWalkFrame = 1;
                continue;
                cObj[paramInt].nWalkFrame = 2;
                i = 17;
                continue;
                i = 18;
                cObj[paramInt].nWalkFrame = 0;
              }
            }
            if (cObj[paramInt].isDead)
            {
              paramGraphics.drawImage(cBc.cRes.iObject[15], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 17);
              if (cObj[paramInt].isHit)
              {
                paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                cObj[paramInt].isHit = false;
              }
            }
            else
            {
              drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
            }
          }
          else if (cObj[paramInt].nDirect == 2)
          {
            if (cObj[paramInt].isWalk)
            {
              switch (cObj[paramInt].nWalkFrame)
              {
              default: 
                i = 0;
              }
              for (;;)
              {
                paramGraphics.drawImage(cBc.cRes.iObject[i], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 24);
                break;
                i = 19;
                cObj[paramInt].nWalkFrame = 1;
                continue;
                cObj[paramInt].nWalkFrame = 2;
                i = 20;
                continue;
                i = 21;
                cObj[paramInt].nWalkFrame = 0;
              }
            }
            if (cObj[paramInt].isDead)
            {
              paramGraphics.drawImage(cBc.cRes.iObject[15], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 17);
              if (cObj[paramInt].isHit)
              {
                paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                cObj[paramInt].isHit = false;
              }
            }
            else
            {
              drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
            }
          }
          else
          {
            drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
            continue;
            if (cObj[paramInt].nDirect == 1)
            {
              if (cObj[paramInt].isWalk)
              {
                switch (cObj[paramInt].nWalkFrame)
                {
                default: 
                  i = 0;
                }
                for (;;)
                {
                  paramGraphics.drawImage(cBc.cRes.iObject[i], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                  break;
                  i = 26;
                  cObj[paramInt].nWalkFrame = 1;
                  continue;
                  i = 27;
                  cObj[paramInt].nWalkFrame = 2;
                  continue;
                  i = 28;
                  cObj[paramInt].nWalkFrame = 0;
                }
              }
              if (cObj[paramInt].isDead)
              {
                paramGraphics.drawImage(cBc.cRes.iObject[25], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 17);
                if (cObj[paramInt].isHit)
                {
                  paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                  cObj[paramInt].isHit = false;
                }
              }
              else
              {
                drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
              }
            }
            else if (cObj[paramInt].nDirect == 2)
            {
              if (cObj[paramInt].isWalk)
              {
                switch (cObj[paramInt].nWalkFrame)
                {
                default: 
                  i = 0;
                }
                for (;;)
                {
                  paramGraphics.drawImage(cBc.cRes.iObject[i], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 24);
                  break;
                  i = 29;
                  cObj[paramInt].nWalkFrame = 1;
                  continue;
                  i = 30;
                  cObj[paramInt].nWalkFrame = 2;
                  continue;
                  i = 31;
                  cObj[paramInt].nWalkFrame = 0;
                }
              }
              if (cObj[paramInt].isDead)
              {
                paramGraphics.drawImage(cBc.cRes.iObject[25], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 17);
                if (cObj[paramInt].isHit)
                {
                  paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                  cObj[paramInt].isHit = false;
                }
              }
              else
              {
                drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
              }
            }
            else
            {
              drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
              continue;
              DrawPlay03.Object localObject;
              if (cObj[paramInt].nDirect == 1)
              {
                if (cObj[paramInt].isWalk)
                {
                  switch (cObj[paramInt].nWalkFrame)
                  {
                  default: 
                    i = 0;
                  }
                  for (;;)
                  {
                    paramGraphics.drawImage(cBc.cRes.iObject[i], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                    break;
                    i = 42;
                    cObj[paramInt].nWalkFrame = 1;
                    continue;
                    i = 43;
                    cObj[paramInt].nWalkFrame = 2;
                    continue;
                    i = 44;
                    cObj[paramInt].nWalkFrame = 0;
                  }
                }
                if (cObj[paramInt].isDead)
                {
                  if (cObj[paramInt].nFrame / 2 % 2 == 0) {
                    paramGraphics.drawImage(cBc.cRes.iObject[34], cObj[paramInt].nPrevPosX, cObj[paramInt].nPrevPosY, 17);
                  }
                  if (cObj[paramInt].isHit)
                  {
                    paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                    cObj[paramInt].isHit = false;
                  }
                  localObject = cObj[paramInt];
                  nFrame += 1;
                  paramGraphics.drawImage(cBc.cRes.iObject[39], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 17);
                }
                else
                {
                  drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
                }
              }
              else if (cObj[paramInt].nDirect == 2)
              {
                if (cObj[paramInt].isWalk)
                {
                  switch (cObj[paramInt].nWalkFrame)
                  {
                  default: 
                    i = 0;
                  }
                  for (;;)
                  {
                    paramGraphics.drawImage(cBc.cRes.iObject[i], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 24);
                    break;
                    i = 45;
                    cObj[paramInt].nWalkFrame = 1;
                    continue;
                    i = 46;
                    cObj[paramInt].nWalkFrame = 2;
                    continue;
                    i = 47;
                    cObj[paramInt].nWalkFrame = 0;
                  }
                }
                if (cObj[paramInt].isDead)
                {
                  if (cObj[paramInt].nFrame / 2 % 2 == 0) {
                    paramGraphics.drawImage(cBc.cRes.iObject[37], cObj[paramInt].nPrevPosX, cObj[paramInt].nPrevPosY, 17);
                  }
                  if (cObj[paramInt].isHit)
                  {
                    paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                    cObj[paramInt].isHit = false;
                  }
                  localObject = cObj[paramInt];
                  nFrame += 1;
                  paramGraphics.drawImage(cBc.cRes.iObject[41], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 17);
                }
                else
                {
                  drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
                  continue;
                  if (cObj[paramInt].nDirect == 1)
                  {
                    if (cObj[paramInt].isDead)
                    {
                      if (cObj[paramInt].nWalkFrame / 2 % 2 == 0) {
                        paramGraphics.drawImage(cBc.cRes.iObject[51], cObj[paramInt].nPrevPosX, cObj[paramInt].nPrevPosY, 20);
                      }
                      if (cObj[paramInt].isHit)
                      {
                        paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                        cObj[paramInt].isHit = false;
                      }
                      paramGraphics = cObj[paramInt];
                      nWalkFrame += 1;
                      if (cObj[paramInt].nWalkFrame >= 10) {
                        initObject(paramInt, 0);
                      }
                    }
                    else
                    {
                      drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
                    }
                  }
                  else if (cObj[paramInt].nDirect == 2) {
                    if (cObj[paramInt].isDead)
                    {
                      if (cObj[paramInt].nWalkFrame / 2 % 2 == 0) {
                        paramGraphics.drawImage(cBc.cRes.iObject[55], cObj[paramInt].nPrevPosX, cObj[paramInt].nPrevPosY, 20);
                      }
                      if (cObj[paramInt].isHit)
                      {
                        paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                        cObj[paramInt].isHit = false;
                      }
                      paramGraphics = cObj[paramInt];
                      nWalkFrame += 1;
                      if (cObj[paramInt].nWalkFrame >= 10) {
                        initObject(paramInt, 0);
                      }
                    }
                    else
                    {
                      drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
                      continue;
                      if (cObj[paramInt].nDirect == 1)
                      {
                        if (cObj[paramInt].isDead)
                        {
                          if (cObj[paramInt].nWalkFrame / 2 % 2 == 0) {
                            paramGraphics.drawImage(cBc.cRes.iObject[59], cObj[paramInt].nPrevPosX, cObj[paramInt].nPrevPosY, 20);
                          }
                          if (cObj[paramInt].isHit)
                          {
                            paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                            cObj[paramInt].isHit = false;
                          }
                          paramGraphics = cObj[paramInt];
                          nWalkFrame += 1;
                          if (cObj[paramInt].nWalkFrame >= 10) {
                            initObject(paramInt, 0);
                          }
                        }
                        else
                        {
                          drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
                        }
                      }
                      else if (cObj[paramInt].nDirect == 2) {
                        if (cObj[paramInt].isDead)
                        {
                          if (cObj[paramInt].nWalkFrame / 2 % 2 == 0) {
                            paramGraphics.drawImage(cBc.cRes.iObject[63], cObj[paramInt].nPrevPosX, cObj[paramInt].nPrevPosY, 20);
                          }
                          if (cObj[paramInt].isHit)
                          {
                            paramGraphics.drawImage(cBc.cRes.iEffect[0], cObj[paramInt].nPosX, cObj[paramInt].nPosY, 20);
                            cObj[paramInt].isHit = false;
                          }
                          paramGraphics = cObj[paramInt];
                          nWalkFrame += 1;
                          if (cObj[paramInt].nWalkFrame >= 10) {
                            initObject(paramInt, 0);
                          }
                        }
                        else
                        {
                          drawBalloon(paramGraphics, cObj[paramInt].nDirect, cObj[paramInt].nType, paramInt);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void drawPanel(Graphics paramGraphics)
  {
    cBc.drawScoreBar(paramGraphics);
  }
  
  private void drawPlay(Graphics paramGraphics)
  {
    proc();
    drawBoard(paramGraphics);
    drawObject(paramGraphics);
    drawGunLine(paramGraphics);
    drawPanel(paramGraphics);
    cBc.drawHeart(paramGraphics);
    cBc.drawCombo(paramGraphics);
    cBc.drawPointAnimation(paramGraphics);
    cBc.drawMark(paramGraphics);
  }
  
  private void drawReady(Graphics paramGraphics)
  {
    drawBoard(paramGraphics);
    drawGun(paramGraphics);
    drawGunLine(paramGraphics);
    drawPanel(paramGraphics);
    cBc.drawReadyStart(paramGraphics);
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
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 145, 132, 20);
      continue;
      paramGraphics.drawImage(cBc.cRes.iResult[1], 120, 213, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 142, 136, 20);
      continue;
      switch (i)
      {
      default: 
        break;
      case 0: 
        paramGraphics.drawImage(cBc.cRes.iResult[2], 123, 213, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 142, 132, 20);
        paramGraphics.drawImage(cBc.cRes.iResult[4], 68, 153, 20);
        paramGraphics.drawImage(cBc.cRes.iResult[5], 90, 123, 20);
        break;
      case 1: 
        paramGraphics.drawImage(cBc.cRes.iResult[3], 123, 213, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 145, 136, 20);
        paramGraphics.drawImage(cBc.cRes.iResult[4], 68, 152, 20);
        paramGraphics.drawImage(cBc.cRes.iResult[5], 90, 124, 20);
      }
    }
  }
  
  private void drawStone(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3)
  {
    paramGraphics.drawImage(cBc.cRes.iPlay[((paramInt3 + 2) % 4 + 1)], paramInt1, paramInt2, 3);
  }
  
  private void initGun()
  {
    cGun.nPosX = 120;
    cGun.nPosY = 295;
    cGun.nPrevPosX = 120;
    cGun.nPrevPosY = 295;
    cGun.nWidth = cBc.cRes.iPlay[0].getWidth();
    cGun.nHeight = cBc.cRes.iPlay[0].getHeight();
    cGun.nMovePixelX = 0;
    cGun.nMovePixelY = 0;
    cGun.nMoveZoneX = 0;
    cGun.nMoveZoneY = 0;
    cGun.nDirect = 0;
    cGun.nAniFrame = 0;
    cGun.isAni = false;
  }
  
  private void initObjPattern(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    cObj[paramInt1].nPosX = paramInt2;
    cObj[paramInt1].nPosY = paramInt3;
    cObj[paramInt1].nSpeed = 8;
    cObj[paramInt1].nTurnCount = 0;
    cObj[paramInt1].isActive = false;
    cObj[paramInt1].isDead = false;
    cObj[paramInt1].nActiveFrame = (cBc.cUtil.getRandomInt(0, 4) + paramInt4);
  }
  
  private void initObject(int paramInt1, int paramInt2)
  {
    cObj[paramInt1].nPattern = cBc.cUtil.getRandomInt(0, 3);
    cObj[paramInt1].nFrame = 0;
    cObj[paramInt1].nWalkFrame = 0;
    cObj[paramInt1].nBalloonFrame = 0;
    cObj[paramInt1].isWalk = false;
    cObj[paramInt1].isHit = false;
    cObj[paramInt1].nPrevPosX = 0;
    cObj[paramInt1].nPrevPosY = 0;
    DrawPlay03.Object localObject;
    label254:
    int j;
    switch (cObj[paramInt1].nPattern)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        return;
        if (cPoint.isStarPoint())
        {
          cObj[paramInt1].nType = cPoint.getType();
          cObj[paramInt1].nWidth = cBc.cRes.iStar[cObj[paramInt1].nType].getWidth();
          cObj[paramInt1].nHeight = cBc.cRes.iStar[cObj[paramInt1].nType].getHeight();
          cObj[paramInt1].isStar = true;
          localObject = cObj[paramInt1];
          if (cBc.cUtil.getRandomInt(0, 2) != 0) {
            break label489;
          }
          i = 2;
          nDirect = i;
          cObj[paramInt1].nDirect2 = cObj[paramInt1].nDirect;
          if (cObj[paramInt1].nDirect != 2) {
            break label494;
          }
        }
        label489:
        label494:
        for (i = -cObj[paramInt1].nWidth;; i = 240)
        {
          j = cBc.cUtil.getRandomInt(0, 3);
          initObjPattern(paramInt1, i, 54 / 2 + j * 54 - cObj[paramInt1].nHeight / 2, paramInt2);
          break;
          cObj[paramInt1].nType = cBc.cUtil.getRandomInt(3, 6);
          if (cObj[paramInt1].nType == 3)
          {
            cObj[paramInt1].nWidth = 85;
            cObj[paramInt1].nHeight = 51;
          }
          for (cObj[paramInt1].nMaxFrame = 2;; cObj[paramInt1].nMaxFrame = 3)
          {
            do
            {
              cObj[paramInt1].isStar = false;
              break;
            } while ((cObj[paramInt1].nType != 4) && (cObj[paramInt1].nType != 5));
            cObj[paramInt1].nWidth = 34;
            cObj[paramInt1].nHeight = 24;
          }
          i = 1;
          break label254;
        }
        if (!cPoint.isStarPoint()) {
          break;
        }
        cObj[paramInt1].nType = cPoint.getType();
        cObj[paramInt1].nWidth = cBc.cRes.iStar[cObj[paramInt1].nType].getWidth();
        cObj[paramInt1].nHeight = cBc.cRes.iStar[cObj[paramInt1].nType].getHeight();
        cObj[paramInt1].isStar = true;
        cObj[paramInt1].nDirect = 4;
        cObj[paramInt1].nDirect2 = cObj[paramInt1].nDirect;
        i = cBc.cUtil.getRandomInt(0, 3);
        initObjPattern(paramInt1, 80 / 2 + i * 80 - cObj[paramInt1].nWidth / 2, -cObj[paramInt1].nHeight, paramInt2);
      }
      cObj[paramInt1].nType = cBc.cUtil.getRandomInt(1, 3);
      if (cObj[paramInt1].nType == 1)
      {
        cObj[paramInt1].nWidth = 41;
        cObj[paramInt1].nHeight = 61;
        cObj[paramInt1].nMaxFrame = 1;
      }
      for (;;)
      {
        cObj[paramInt1].isStar = false;
        break;
        if (cObj[paramInt1].nType == 2)
        {
          cObj[paramInt1].nWidth = 48;
          cObj[paramInt1].nHeight = 55;
          cObj[paramInt1].nMaxFrame = 4;
        }
      }
    }
    if (cPoint.isStarPoint())
    {
      cObj[paramInt1].nType = cPoint.getType();
      cObj[paramInt1].nWidth = cBc.cRes.iStar[cObj[paramInt1].nType].getWidth();
      cObj[paramInt1].nHeight = cBc.cRes.iStar[cObj[paramInt1].nType].getHeight();
      cObj[paramInt1].isStar = true;
      label909:
      localObject = cObj[paramInt1];
      if (cBc.cUtil.getRandomInt(0, 2) != 0) {
        break label1075;
      }
      i = 2;
      label934:
      nDirect = i;
      cObj[paramInt1].nDirect2 = 4;
      if (cObj[paramInt1].nDirect != 2) {
        break label1080;
      }
    }
    label1075:
    label1080:
    for (int i = -cObj[paramInt1].nWidth;; i = 240)
    {
      j = cBc.cUtil.getRandomInt(0, 3);
      initObjPattern(paramInt1, i, 54 / 2 + j * 54 - cObj[paramInt1].nHeight / 2, paramInt2);
      break;
      cObj[paramInt1].nType = 0;
      cObj[paramInt1].nWidth = 48;
      cObj[paramInt1].nHeight = 35;
      cObj[paramInt1].nMaxFrame = 1;
      cObj[paramInt1].isStar = false;
      break label909;
      i = 1;
      break label934;
    }
  }
  
  private void initStone(int paramInt)
  {
    cStone[paramInt].nPosX = 0;
    cStone[paramInt].nPosY = 0;
    cStone[paramInt].nMovePixelX = 0;
    cStone[paramInt].nMovePixelY = 0;
    cStone[paramInt].nFrame = 0;
    cStone[paramInt].isActive = false;
    cStone[paramInt].isFall = false;
  }
  
  private boolean isEventTime(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void moveGun(int paramInt1, int paramInt2)
  {
    cGun.nPosX = (cGun.nMoveZoneX + paramInt1);
    cGun.nPosY = (cGun.nMoveZoneY + paramInt2);
    cGun.nMovePixelX = ((cGun.nPosX - 120) / 3);
    cGun.nMovePixelY = ((cGun.nPosY - 301) / 3);
  }
  
  private void moveStone(int paramInt1, int paramInt2, int paramInt3)
  {
    DrawPlay03.Stone localStone = cStone[paramInt1];
    nPosX += paramInt2;
    localStone = cStone[paramInt1];
    nPosY += paramInt3;
    if (paramInt3 > 0) {
      cStone[paramInt1].isFall = true;
    }
  }
  
  private void proc()
  {
    if (cBc.isLock()) {
      return;
    }
    throwStoneTime();
    int i = 0;
    Object localObject;
    if (i < 10)
    {
      int j;
      if (cStone[i].isActive)
      {
        j = -cStone[i].nMovePixelY;
        moveStone(i, -cStone[i].nMovePixelX, j - 16);
        localObject = cStone[i];
        nMovePixelY -= 1;
        if ((cStone[i].nPosY <= 378) && (cStone[i].nPosX + 32 >= 0) && (cStone[i].nPosX <= 240)) {
          break label138;
        }
        initStone(i);
      }
      for (;;)
      {
        i++;
        break;
        label138:
        for (j = 0; j < 10; j++) {
          if ((cObj[j].isActive) && (!cObj[j].isDead) && (!cStone[i].isFall) && (cStone[i].nPosX != 0) && (cStone[i].nPosY != 0) && (cStone[i].nPosY < cObj[j].nPosY + cObj[j].nHeight) && (cStone[i].nPosY + 25 > cObj[j].nPosY) && (cStone[i].nPosX < cObj[j].nPosX + cObj[j].nWidth) && (cStone[i].nPosX + 32 > cObj[j].nPosX))
          {
            if (!cObj[j].isStar) {
              break label467;
            }
            cObj[j].isDead = true;
            cObj[j].isHit = true;
            cObj[j].nPrevPosX = cObj[j].nPosX;
            cObj[j].nPrevPosY = cObj[j].nPosY;
            cObj[j].nFrame = 0;
            cPoint.increaseComboCount();
            cPoint.increasePointTableStar(cBc.nCurStateSeg, cObj[j].nType);
            cPoint.setPointAnimation(cPoint.nCurPoint, cObj[j].nPrevPosX, cObj[j].nPrevPosY);
            initStone(i);
          }
        }
      }
      label467:
      if (cObj[j].nType == 0) {
        cBc.cSound.playSound(11, 1);
      }
      for (;;)
      {
        cObj[j].isDead = true;
        cObj[j].isHit = true;
        cObj[j].nPrevPosX = cObj[j].nPosX;
        cObj[j].nPrevPosY = cObj[j].nPosY;
        cObj[j].nFrame = 0;
        cPoint.increasePointTable(cBc.nCurStateSeg, cObj[j].nType);
        cPoint.setPointAnimation(cPoint.nCurPoint, cObj[j].nPrevPosX, cObj[j].nPrevPosY);
        if (isEventTime(cObj[j].nType)) {
          cBc.setEvent(true);
        }
        initStone(i);
        break;
        cBc.cSound.playSound(10, 1);
      }
    }
    i = 0;
    label663:
    if (i < 10)
    {
      if (cObj[i].isActive)
      {
        if (!cObj[i].isDead) {
          break label1076;
        }
        if (cObj[i].nPosY + cObj[i].nHeight < 285) {
          break label1008;
        }
        cObj[i].isWalk = true;
        cObj[i].nFrame = 0;
        if (cObj[i].nPosX + cObj[i].nWidth / 2 <= 120) {
          break label884;
        }
        if (cObj[i].nDirect != 1) {
          break label821;
        }
        localObject = cObj[i];
        nPosX -= 4;
        label794:
        if (cObj[i].nPosX > 240) {
          initObject(i, 0);
        }
      }
      for (;;)
      {
        i++;
        break label663;
        label821:
        if (cObj[i].nDirect == 2)
        {
          localObject = cObj[i];
          nPosX += 4;
          break label794;
        }
        cObj[i].nDirect = 2;
        localObject = cObj[i];
        nPosX += 4;
        break label794;
        label884:
        if (cObj[i].nDirect == 1)
        {
          localObject = cObj[i];
          nPosX -= 4;
        }
        for (;;)
        {
          if (cObj[i].nPosX + cObj[i].nWidth >= 0) {
            break label1006;
          }
          initObject(i, 0);
          break;
          if (cObj[i].nDirect == 2)
          {
            localObject = cObj[i];
            nPosX += 4;
          }
          else
          {
            cObj[i].nDirect = 1;
            localObject = cObj[i];
            nPosX -= 4;
          }
        }
        label1006:
        continue;
        label1008:
        localObject = cObj[i];
        nPosY += 20;
        if (cObj[i].nPosY + cObj[i].nHeight > 285)
        {
          cObj[i].nPosY = (285 - cObj[i].nHeight);
          continue;
          label1076:
          if (cObj[i].nTurnCount < 6)
          {
            procDirect(i, cObj[i].nDirect, true);
            if (cObj[i].nPattern == 2) {
              procDirect(i, cObj[i].nDirect2, false);
            }
          }
          else
          {
            procMove(i, cObj[i].nDirect);
            if (cObj[i].nPattern == 2) {
              procMove(i, cObj[i].nDirect2);
            }
            if ((cObj[i].nPosX + cObj[i].nWidth < 0) || (cObj[i].nPosX > 240) || (cObj[i].nPosY + cObj[i].nHeight < 0) || (cObj[i].nPosY > 378)) {
              if (cObj[i].isStar)
              {
                initObject(i, 0);
                cPoint.resetComboCount();
              }
              else
              {
                if ((cObj[i].nType == 1) || (cObj[i].nType == 2) || (cObj[i].nType == 3))
                {
                  cBc.cSound.playSound(24, 1);
                  cBc.setState(2003, 2);
                  break;
                }
                initObject(i, 0);
              }
            }
          }
        }
      }
    }
    i = nFrame % 10;
    if (cObj[i].nActiveFrame == 0) {
      cObj[i].isActive = true;
    }
    for (;;)
    {
      i = nFrame + 1;
      nFrame = i;
      nFrame = (i % 10);
      break;
      localObject = cObj[i];
      nActiveFrame -= 1;
    }
  }
  
  private void procDirect(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      return;
      DrawPlay03.Object localObject;
      if (cObj[paramInt1].nPosX - cObj[paramInt1].nSpeed > 0)
      {
        localObject = cObj[paramInt1];
        nPosX -= cObj[paramInt1].nSpeed;
      }
      else
      {
        cObj[paramInt1].nPosX = 0;
        if (paramBoolean)
        {
          cObj[paramInt1].nDirect = 2;
          localObject = cObj[paramInt1];
          nTurnCount += 1;
        }
        else
        {
          cObj[paramInt1].nDirect2 = 2;
          continue;
          if (cObj[paramInt1].nPosX + cObj[paramInt1].nSpeed + cObj[paramInt1].nWidth < 240)
          {
            localObject = cObj[paramInt1];
            nPosX += cObj[paramInt1].nSpeed;
          }
          else
          {
            cObj[paramInt1].nPosX = (240 - cObj[paramInt1].nWidth);
            if (paramBoolean)
            {
              cObj[paramInt1].nDirect = 1;
              localObject = cObj[paramInt1];
              nTurnCount += 1;
            }
            else
            {
              cObj[paramInt1].nDirect2 = 1;
              continue;
              if (cObj[paramInt1].nPosY - cObj[paramInt1].nSpeed > 0)
              {
                localObject = cObj[paramInt1];
                nPosY -= cObj[paramInt1].nSpeed;
              }
              else
              {
                cObj[paramInt1].nPosY = 0;
                if (paramBoolean)
                {
                  cObj[paramInt1].nDirect = 4;
                  localObject = cObj[paramInt1];
                  nTurnCount += 1;
                }
                else
                {
                  cObj[paramInt1].nDirect2 = 4;
                  continue;
                  if (cObj[paramInt1].nPosY + cObj[paramInt1].nSpeed + cObj[paramInt1].nHeight < 224)
                  {
                    localObject = cObj[paramInt1];
                    nPosY += cObj[paramInt1].nSpeed;
                  }
                  else
                  {
                    cObj[paramInt1].nPosY = (224 - cObj[paramInt1].nHeight);
                    if (paramBoolean)
                    {
                      cObj[paramInt1].nDirect = 3;
                      localObject = cObj[paramInt1];
                      nTurnCount += 1;
                    }
                    else
                    {
                      cObj[paramInt1].nDirect2 = 3;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void procMove(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      return;
      DrawPlay03.Object localObject = cObj[paramInt1];
      nPosX -= cObj[paramInt1].nSpeed;
      continue;
      localObject = cObj[paramInt1];
      nPosX += cObj[paramInt1].nSpeed;
      continue;
      localObject = cObj[paramInt1];
      nPosY -= cObj[paramInt1].nSpeed;
      continue;
      localObject = cObj[paramInt1];
      nTurnCount -= 1;
      localObject = cObj[paramInt1];
      nPosY += cObj[paramInt1].nSpeed;
    }
  }
  
  private void setPressPointer(int paramInt1, int paramInt2)
  {
    cGun.nMoveZoneX = (cGun.nPosX - paramInt1);
    cGun.nMoveZoneY = (cGun.nPosY - paramInt2);
  }
  
  private void throwStone()
  {
    if (nThrowStone >= 3)
    {
      isThrowStone = false;
      if (isThrowStone) {
        break label41;
      }
    }
    label41:
    label173:
    for (;;)
    {
      return;
      nThrowStone += 1;
      nThrowTime = System.currentTimeMillis();
      break;
      for (int i = 0;; i++)
      {
        if (i >= 10) {
          break label173;
        }
        if (!cStone[i].isActive)
        {
          cBc.cSound.playSound(9, 1);
          cStone[i].nPosX = cGun.nPosX;
          cStone[i].nPosY = cGun.nPosY;
          cStone[i].nMovePixelX = cGun.nMovePixelX;
          cStone[i].nMovePixelY = cGun.nMovePixelY;
          cStone[i].isActive = true;
          cStone[i].isFall = false;
          cGun.isAni = true;
          break;
        }
      }
    }
  }
  
  private void throwStoneTime()
  {
    if (System.currentTimeMillis() - nThrowTime > 1000L)
    {
      isThrowStone = true;
      if (nThrowStone != 0) {
        nThrowStoneFrame = 8;
      }
      nThrowStone = 0;
      nThrowTime = System.currentTimeMillis();
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
  
  public void init()
  {
    cBc.setGrade(0);
    cPoint.initPoint();
    cPoint.resetComboCount();
    nFrame = 0;
    isDrag = false;
    isPressed = false;
    isThrowStone = true;
    nThrowStone = 0;
    nThrowStoneFrame = 0;
    initGun();
    for (int i = 0; i < 10; i++) {
      initStone(i);
    }
    for (i = 0; i < 10; i++) {
      initObject(i, i * 10);
    }
  }
  
  public void pointerDragged(int paramInt1, int paramInt2)
  {
    switch (cBc.nCurStateOff)
    {
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        cGun.nPrevPosX = paramInt1;
        cGun.nPrevPosY = paramInt2;
      }
      do
      {
        return;
      } while (!isPressed);
      nThrowPredPixelX = (paramInt1 - cGun.nPrevPosX);
      nThrowPredPixelY = (paramInt2 - cGun.nPrevPosY);
      isDrag = true;
      moveGun(paramInt1, paramInt2);
      if ((nThrowPredPixelX + paramInt1 > 0) && (nThrowPredPixelX + paramInt1 < 240) && (nThrowPredPixelY + paramInt2 > 224) && (nThrowPredPixelY + paramInt2 < 348)) {
        break;
      }
      isDrag = false;
      isPressed = false;
      throwStone();
      initGun();
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
      if (cBc.isPointer(paramInt1, paramInt2, cGun.nPosX - 42, cGun.nPosY - 42, cGun.nPosX + 42, cGun.nPosY + 42))
      {
        isPressed = true;
        setPressPointer(paramInt1, paramInt2);
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
      if (cBc.isPointer(paramInt1, paramInt2, cGun.nPosX - 42, cGun.nPosY - 42, cGun.nPosX + 42, cGun.nPosY + 42))
      {
        if (isDrag)
        {
          isDrag = false;
          throwStone();
          initGun();
        }
      }
      else {
        initGun();
      }
    }
  }
  
  private class Gun
  {
    boolean isAni;
    int nAniFrame;
    int nDirect;
    int nHeight;
    int nMovePixelX;
    int nMovePixelY;
    int nMoveZoneX;
    int nMoveZoneY;
    int nPosX;
    int nPosY;
    int nPrevPosX;
    int nPrevPosY;
    int nWidth;
    
    private Gun() {}
    
    Gun(DrawPlay03.1 param1)
    {
      this();
    }
  }
  
  private class Object
  {
    boolean isActive;
    boolean isDead;
    boolean isHit;
    boolean isStar;
    boolean isWalk;
    int nActiveFrame;
    int nBalloonFrame;
    int nDirect;
    int nDirect2;
    int nFrame;
    int nHeight;
    int nMaxFrame;
    int nPattern;
    int nPosX;
    int nPosY;
    int nPrevPosX;
    int nPrevPosY;
    int nSpeed;
    int nTurnCount;
    int nType;
    int nWalkFrame;
    int nWidth;
    
    private Object() {}
    
    Object(DrawPlay03.1 param1)
    {
      this();
    }
  }
  
  private class Stone
  {
    boolean isActive;
    boolean isFall;
    int nFrame;
    int nMovePixelX;
    int nMovePixelY;
    int nPosX;
    int nPosY;
    
    private Stone() {}
    
    Stone(DrawPlay03.1 param1)
    {
      this();
    }
  }
}
