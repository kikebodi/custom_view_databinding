package com.kikebodi.databindingexample

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.*
import com.kikebodi.databindingexample.databinding.AmountSelectorViewBinding
import kotlin.properties.ObservableProperty


class AmountSelectorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0, defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    val selectedAmount = ObservableInt(0)

    private val layoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val viewBinding = AmountSelectorViewBinding.inflate(layoutInflater, this, true).apply {
        this.view = this@AmountSelectorView
    }

    fun onMinusClicked() = selectedAmount.set(selectedAmount.get() - 1)

    fun onPlusClicked() = selectedAmount.set(selectedAmount.get() + 1)

    companion object{
        @BindingAdapter("amount")
        @JvmStatic fun setAmount(view: AmountSelectorView, newAmount: Int) {
            if(view.selectedAmount.get() != newAmount){
                view.selectedAmount.set(newAmount)
            }
        }


        @InverseBindingAdapter(attribute = "amount")
        @JvmStatic fun getAmount(view: AmountSelectorView): Int {
            return view.selectedAmount.get()
        }

        @BindingAdapter("amountAttrChanged")
        @JvmStatic fun setListeners(view: AmountSelectorView, attrChange: InverseBindingListener?){
            view.selectedAmount.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    attrChange?.onChange()
                }
            })
        }
    }
}