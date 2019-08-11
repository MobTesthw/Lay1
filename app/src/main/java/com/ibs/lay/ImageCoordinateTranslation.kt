package com.ibs.lay

import android.graphics.Matrix
import android.widget.ImageView

class ImageCoordinateTranslation {
    companion object {
        fun globalScreenToOriginX(imageView: ImageView, globalX:Int, originWidth:Int):Int{
            val values = FloatArray(9)
            imageView.imageMatrix.getValues(values)
            val width=imageView.drawable.intrinsicWidth * values[Matrix.MSCALE_X]

            return ( (globalX-values[Matrix.MTRANS_X]-imageView.left) * originWidth/width ).toInt()
        }
//        fun screenToRelativeY(imageView: ImageView, globalY:Float):Float{
//            val values = FloatArray(9)
//            imageView.imageMatrix.getValues(values)
//            val height=imageView.drawable.intrinsicHeight * values[Matrix.MSCALE_Y]
//
//            return (globalY-values[Matrix.MTRANS_Y]-imageView.top) * RELATIVE_H/height
//        }
        fun originToGlobalScreenX(imageView: ImageView, originX:Int,originWidth:Int):Int{
            return originToLocalScreenX(imageView,originX,originWidth) + imageView.left
        }
        fun originToLocalScreenX(imageView: ImageView, originX:Int,originWidth:Int):Int{
            val values = FloatArray(9)
            imageView.imageMatrix.getValues(values)
            val width=imageView.drawable.intrinsicWidth * values[Matrix.MSCALE_X]

            return (originX * width/originWidth + values[Matrix.MTRANS_X]).toInt()
        }
//        fun relativeToScreenY(imageView: ImageView, relY:Float):Float{
//            val values = FloatArray(9)
//            imageView.imageMatrix.getValues(values)
//            val height=imageView.drawable.intrinsicHeight * values[Matrix.MSCALE_Y]
//
//            return relY * height/RELATIVE_H + values[Matrix.MTRANS_Y] + imageView.top
//        }
    }
}