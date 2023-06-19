package com.example.hw_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserModelAdapter(
    context: Context, private var resource: Int,
    private var objects: MutableList<UserModel>
) :
    ArrayAdapter<UserModel>(
        context,
        resource,
        objects
    ) {
    private var inflater: LayoutInflater = LayoutInflater.from(context)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var localConvertView = convertView
        val viewHolder: ViewHolder
        if (localConvertView == null) {
            localConvertView = inflater.inflate(this.resource, parent, false)
            viewHolder = ViewHolder(localConvertView)
            localConvertView.tag = viewHolder
        } else {
            viewHolder = localConvertView.tag as ViewHolder
        }
        val model = objects[position]
        viewHolder.imageView?.setImageResource(model.image)
        viewHolder.countryView?.text = model.country
        viewHolder.cityView?.text = model.city
        viewHolder.ageText?.text = model.age.toString()
        viewHolder.nameText?.text = model.name
        viewHolder.lastnameView?.text = model.lastname

        return localConvertView!!
    }



    companion object Factory {
        fun build(
            context: Context,
            resource: Int
        ): UserModelAdapter {
            val models = mutableListOf<UserModel>()
            for (x in 1..99) {
                models.add(UserModel.build(context as AppCompatActivity))
                x + 1
            }
            return UserModelAdapter(context, resource, models)
        }
    }

    class ViewHolder {
        var imageView: ImageView? = null
        var ageText: TextView? = null
        var nameText: TextView? = null
        var lastnameView: TextView? = null
        var cityView: TextView? = null
        var countryView: TextView? = null
        var agehint: TextView? = null

        constructor(view: View) {
            this.imageView = view.findViewById(R.id.image)
            this.nameText = view.findViewById(R.id.name)
            this.lastnameView = view.findViewById(R.id.lastname)
            this.ageText = view.findViewById(R.id.age)
            this.cityView = view.findViewById(R.id.city)
            this.countryView = view.findViewById(R.id.country)
            this.agehint = view.findViewById(R.id.agehint)
        }

    }
}