package com.example.weather_api.fragment

import android.app.AlertDialog
import android.content.Context

/**
 * Object with fun that will be asking user for GPS activate
 */
object DialogManager {
    fun locationSettingDialog(context: Context,listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Enable location ? ")
        dialog.setMessage("Activate in parameters ? ")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"OK"){_,_->
            listener.onClick()
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"Cancel"){_,_->
            dialog.dismiss()
        }
        dialog.show()
    }

    /**
     *In case BUTTON_POSITIVE do onClick
     */
    interface Listener{
        fun onClick()
    }
}