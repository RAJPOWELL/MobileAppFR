package com.atharvakale.facerecognition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FaceBoxOverlay extends View {
    private final Paint paint;
    private final List<RectF> faceBoundingBoxes = new ArrayList<>();
    private int boxColor = Color.RED; // Default: Red (for unrecognized faces)

    public FaceBoxOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void setFaceBoxes(List<RectF> boxes, boolean isRecognized) {
        faceBoundingBoxes.clear();
        faceBoundingBoxes.addAll(boxes);
        boxColor = isRecognized ? Color.GREEN : Color.RED;  // Change color based on recognition
        invalidate();  // Redraw the overlay
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(boxColor);
        for (RectF box : faceBoundingBoxes) {
            canvas.drawRect(box, paint);
        }
    }
}
