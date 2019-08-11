package com.ibs.lay

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

/** Class for animating views operation showing and hiding with providing onComplete method
*
*/


class DecorateTransition {

    companion object {

        fun alphaHide(view: View,duration:Long=1000,onComplete:()->Unit={}) {
            view.apply {
                visibility=View.VISIBLE
                alpha=1f

                animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            view.visibility = View.GONE
                            onComplete()
                            view.animate().setListener(null)
                        }
                    })
            }
        }
        fun alphaHideTo(view: View,alpha:Float=0f, duration:Long=1000,onComplete:()->Unit={}) {

            view.animate()
                .alpha(alpha)
                .setDuration(duration)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        view.visibility = View.GONE
                        onComplete()
                        view.animate().setListener(null)

                    }
                })
        }
        //show View with opacity animation (except VideoView)
        fun alphaShow(view: View,duration:Long=1000,onComplete:()->Unit={}) {
            view.apply {
                alpha=0f
                visibility=View.VISIBLE
                animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            onComplete()
                            view.animate().setListener(null)
                        }
                    })
            }
        }
        fun alphaShowTo(view: View,alpha:Float=1f,duration:Long=1000,onComplete:()->Unit={}) {

            view.animate()
                .alpha(alpha)
                .setDuration(duration)
//                    .setListener(null)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        view.visibility = View.VISIBLE
                        onComplete()
                        view.animate().setListener(null)
                    }
                })


        }
        //Arbitrary alpha animation
        fun alphaAnimate(view: View,endAlpha:Float=.5f,duration:Long=1000,onComplete:()->Unit={}) {
            view.animate()
                .alpha(endAlpha)
                .setDuration(duration)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        onComplete()
                        view.animate().setListener(null)

                    }
                })
        }


//    //End of companion object
    }

}