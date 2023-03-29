package com.example.weather_api.fragment

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText

/**
 * Object with fun that will be asking user for GPS activate
 */
object DialogManager {
    /**
     * Add refresh Location
     */
    fun locationSettingDialog(context: Context,listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Enable location ? ")
        dialog.setMessage("Activate in parameters ? ")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"OK"){_,_->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"Cancel"){_,_->
            dialog.dismiss()
        }
        dialog.show()
    }
    /**
     * Add search function
     */
    fun searchByNameDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val edName = EditText(context)
        builder.setView(edName)
        val dialog = builder.create()
        dialog.setTitle("Chose your City:")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"OK"){_,_->
            listener.onClick(edName.text.toString())
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
        fun onClick(name:String?)
    }
}