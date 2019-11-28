package com.example.soapapiexample.adapters.simplexml

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.soapapiexample.R
import com.example.soapapiexample.adapters.BaseRecyclerAdapter
import com.example.soapapiexample.models.simplexml.response.Country
import kotlinx.android.synthetic.main.item_country.view.*


class CountryListAdapter(context:Context) : BaseRecyclerAdapter<Country, CountryListAdapter.CountryViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
       return CountryViewHolder(parent.inflate(R.layout.item_country))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    inner class CountryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindItem(country: Country){
            itemView.name.text = country.name?.let {
                return@let HtmlCompat.fromHtml(it,HtmlCompat.FROM_HTML_MODE_LEGACY)
            }
            itemView.isoCode.text = country.isoCode
        }
    }
}