package uz.gita.noteappgita.presentation.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.noteAppGita.R
import uz.gita.noteAppGita.databinding.DialogDeleteCheckBinding

class DeleteCheckDialog : DialogFragment(R.layout.dialog_delete_check) {
    private val binding by viewBinding(DialogDeleteCheckBinding::bind)
    private var onClickYesBtnListener: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.noBtn.setOnClickListener {
            dismiss()
        }

        binding.yesBtn.setOnClickListener {
            onClickYesBtnListener?.invoke()
        }
    }

    fun setOnclickYesBtnListener(block: () -> Unit) {
        onClickYesBtnListener = block
    }
}