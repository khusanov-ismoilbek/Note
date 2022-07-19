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
import uz.gita.noteAppGita.databinding.DialogAboutBinding

class AboutDialog : DialogFragment(R.layout.dialog_about) {
    private val binding by viewBinding(DialogAboutBinding::bind)
    private var onCLickGmailListener: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.okBtn.setOnClickListener {
            dismiss()
        }
        binding.gmail.setOnClickListener {
            onCLickGmailListener?.invoke()
        }
    }

    fun setOnCLickGmailListener(block: () -> Unit) {
        onCLickGmailListener = block
    }
}