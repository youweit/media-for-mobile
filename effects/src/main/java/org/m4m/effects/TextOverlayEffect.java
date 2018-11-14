/*
 * Copyright 2014-2016 Media for Mobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.m4m.effects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;

import org.m4m.domain.graphics.IEglUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TextOverlayEffect extends OverlayEffect {

    private Paint paint;

    float defaultWidth = 720;
    float defaultHeight = 1280;

    private Bitmap bitmap;

    ArrayList<Long> lst = new ArrayList<Long>();

    public TextOverlayEffect(int angle, IEglUtil eglUtil, Bitmap bitmap) {
        super(angle, eglUtil);
        this.bitmap = bitmap;
        paint = new Paint();
    }

    @Override
    protected void drawCanvas(Canvas canvas) {
        float width = canvas.getWidth();
        float height = canvas.getHeight();

        // draw a full screen logo in the center
        Rect src = new Rect(0,0, bitmap.getWidth(), bitmap.getHeight());
        Rect dest = new Rect(0,(int)(height - width) / 2, (int)width, (int)(height - width) / 2 + (int)width);

        canvas.drawBitmap(bitmap, src, dest, paint);
    }

}
