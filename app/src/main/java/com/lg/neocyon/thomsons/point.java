package com.lg.neocyon.thomsons;

import android.graphics.Point;
import android.graphics.drawable.Animatable;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class point {
    public final int MAX_STAR = 3;
    public final int MAX_PERCENT = 10;
    public final int MIN_PERCENT = 3;
    private final int TYPE_YELLOW = 2;
    public int STAR_INC = 1;
    public final int MAX_POINT_ANI = 5;
    private final int[][] POINT_TABLE = { { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 }, { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 0 } };
    private final int POINT_TABLE_STAR_MAX = 8;
    private final int[][] POINT_TABLE_STAR = { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 10, 11 } };
    public int[] nStarPoint;
    public int[] nHighPoint;
    public int[] nPoint;
    public int nTotPoint;
    public int nComboCount;
    public int nComboFrame;
    public boolean isComboAni;
    public int nCurPoint;
    public BaseCanvas cBc;
    public Point.PointAnimation[] cAni;

    public Point(BaseCanvas paramBaseCanvas)
    {
        int i = 0;
        cBc = paramBaseCanvas;
        cAni = new Point.PointAnimation[5];
        for (i = 0; i < 5; i++) {
            cAni[i] = new Point.PointAnimation();
        }
        nHighPoint = new int[7];
        nPoint = new int[7];
        nStarPoint = new int[1];
        init();
    }

    public Point getInstance()
    {
        return this;
    }

    public void init()
    {
        nComboCount = 0;
        isComboAni = false;
        nCurPoint = 0;
    }

    public void initPoint()
    {
        int i = 0;
        cBc.getClass();
        if (cBc.nHeart == 3) {
            for (i = 0; i < 7; i++) {
                nPoint[i] = 0;
            }
        }
        initPointAnimation();
    }

    public void initPointAnimation()
    {
        int i = 0;
        for (i = 0; i < 5; i++) {
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

    public void setPointAnimation(int paramInt)
    {
        int i = 0;
        if (paramInt == 0) {
            return;
        }
        for (i = 0; i < 5; i++) {
            if (!cAni[i].isActive)
            {
                cAni[i].isActive = true;
                cAni[i].nFrame = 0;
                cAni[i].nPoint = paramInt;
                break;
            }
        }
    }

    public void setPointAnimation(int paramInt1, int paramInt2)
    {
        int i = 0;
        for (i = 0; i < 5; i++) {
            if (!cAni[i].isActive)
            {
                cAni[i].nPosX = paramInt1;
                cAni[i].nPosY = paramInt2;
                break;
            }
        }
    }

    public void setPointAnimation(int paramInt1, int paramInt2, int paramInt3)
    {
        int i = 0;
        if (paramInt1 == 0) {
            return;
        }
        for (i = 0; i < 5; i++) {
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

    public int getType()
    {
        int i = cBc.cUtil.getRandomInt(0, 3);
        return i;
    }

    public boolean isStarPoint()
    {
        boolean bool = cBc.cUtil.getRandomInt(0, 10) < 3;
        return bool;
    }

    public int getComboCount()
    {
        return nComboCount - 1;
    }

    public void increasePoint(int paramInt1, int paramInt2)
    {
        switch (paramInt1)
        {
            case 2000:
                nPoint[0] += paramInt2;
                break;
            case 2001:
                nPoint[1] += paramInt2;
                break;
            case 2002:
                nPoint[2] += paramInt2;
                break;
            case 2003:
                nPoint[3] += paramInt2;
                break;
            case 2004:
                nPoint[4] += paramInt2;
                break;
            case 2005:
                nPoint[5] += paramInt2;
                break;
            case 2006:
                nPoint[6] += paramInt2;
        }
        nCurPoint = paramInt2;
    }

    public void increasePointTable(int paramInt1, int paramInt2)
    {
        if (paramInt2 > 10) {
            paramInt2 = 10;
        }
        switch (paramInt1)
        {
            case 2000:
                nPoint[0] += POINT_TABLE[0][paramInt2];
                break;
            case 2001:
                nPoint[1] += POINT_TABLE[1][paramInt2];
                break;
            case 2002:
                nPoint[2] += POINT_TABLE[2][paramInt2];
                break;
            case 2003:
                nPoint[3] += POINT_TABLE[3][paramInt2];
                break;
            case 2004:
                nPoint[4] += POINT_TABLE[4][paramInt2];
                break;
            case 2005:
                nPoint[5] += POINT_TABLE[5][paramInt2];
                break;
            case 2006:
                nPoint[6] += POINT_TABLE[6][paramInt2];
        }
        switch (paramInt1)
        {
            case 2000:
                nCurPoint = POINT_TABLE[0][paramInt2];
                break;
            case 2001:
                nCurPoint = POINT_TABLE[1][paramInt2];
                break;
            case 2002:
                nCurPoint = POINT_TABLE[2][paramInt2];
                break;
            case 2003:
                nCurPoint = POINT_TABLE[3][paramInt2];
                break;
            case 2004:
                nCurPoint = POINT_TABLE[4][paramInt2];
                break;
            case 2005:
                nCurPoint = POINT_TABLE[5][paramInt2];
                break;
            case 2006:
                nCurPoint = POINT_TABLE[6][paramInt2];
        }
    }

    public void increaseComboCount()
    {
        if (isCombo()) {
            isComboAni = true;
        }
        if (nComboCount >= 8) {
            nComboCount = 8;
        } else {
            nComboCount += 1;
        }
        nComboFrame = 0;
    }

    public void increasePointTableStar(int paramInt1, int paramInt2)
    {
        switch (paramInt1)
        {
            case 2000:
                nPoint[0] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
                break;
            case 2001:
                nPoint[1] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
                break;
            case 2002:
                nPoint[2] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
                break;
            case 2003:
                nPoint[3] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
                break;
            case 2004:
                nPoint[4] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
                break;
            case 2005:
                nPoint[5] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
                break;
            case 2006:
                nPoint[6] += POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
        }
        nCurPoint = POINT_TABLE_STAR[paramInt2][(nComboCount - 1)];
        increaseStar();
    }

    public void increaseStar()
    {
        nStarPoint[0] += STAR_INC;
        if (nStarPoint[0] > 9999) {
            nStarPoint[0] = 0;
        }
    }

    public void resetComboCount()
    {
        nComboCount = 0;
    }

    public boolean isCombo()
    {
        return nComboCount > 0;
    }

    public boolean isNewRecord()
    {
        return nHighPoint[cBc.nGameIdx] < nPoint[cBc.nGameIdx];
    }

    class PointAnimation
    {
        int nPosX;
        int nPosY;
        int nPoint;
        int nFrame;
        boolean isActive;

        PointAnimation() {}
    }
}

}
