package uz.gita.note.presentation.ui.adapter


import android.text.SpannableString
import android.text.style.StrikethroughSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.note.R
import uz.gita.note.data.model.CheckData
import uz.gita.note.databinding.ItemCheckBinding

class CheckPageAdapter : ListAdapter<CheckData, CheckPageAdapter.MyViewHolder>(MyDiffUtil) {
    private var onClickItemListener: ((CheckData) -> Unit)? = null
    private var onClickCheckBoxListener: ((CheckData) -> Unit)? = null

    inner class MyViewHolder(private val binding: ItemCheckBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.checkBox.setOnClickListener {
                if (getItem(absoluteAdapterPosition).state == 0) {
                    onClickCheckBoxListener?.invoke(
                        CheckData(
                            getItem(absoluteAdapterPosition).id,
                            getItem(absoluteAdapterPosition).checkText,
                            getItem(absoluteAdapterPosition).time,
                            getItem(absoluteAdapterPosition).isDeleted,
                            getItem(absoluteAdapterPosition).isPinned,
                            1
                        )
                    )
                } else {
                    onClickCheckBoxListener?.invoke(
                        CheckData(
                            getItem(absoluteAdapterPosition).id,
                            getItem(absoluteAdapterPosition).checkText,
                            getItem(absoluteAdapterPosition).time,
                            getItem(absoluteAdapterPosition).isDeleted,
                            getItem(absoluteAdapterPosition).isPinned,
                            0
                        )
                    )
                }
            }
            itemView.setOnClickListener {
                onClickItemListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun bind() {
            binding.checkText.text = if (getItem(absoluteAdapterPosition).state == 1) {
                binding.checkBox.isChecked = true
                val content = getItem(absoluteAdapterPosition).checkText
                val spannableString = SpannableString(content)
                spannableString.setSpan(StrikethroughSpan(), 0, content?.length!!, 0)
                Log.d("TTT", "spannableString")
                spannableString
            } else {
                binding.checkBox.isChecked = false
                getItem(absoluteAdapterPosition).checkText
            }
            binding.time.text = getItem(absoluteAdapterPosition).time
        }
    }

    object MyDiffUtil : DiffUtil.ItemCallback<CheckData>() {
        override fun areItemsTheSame(oldItem: CheckData, newItem: CheckData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CheckData, newItem: CheckData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_check, parent, false)
        return MyViewHolder(ItemCheckBinding.bind(view))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    fun setOnClickItemListener(block: ((CheckData) -> Unit)) {
        onClickItemListener = block
    }

    fun setOnClickCheckBoxListener(block: (CheckData) -> Unit) {
        onClickCheckBoxListener = block
    }
}